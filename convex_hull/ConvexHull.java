package convex_hull;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class ConvexHull {
    private static StringBuilder result = new StringBuilder();
    private static ArrayList<int[]> data = new ArrayList<>();
    private static int column = 0, row = 0;
    private static Map<String, Integer> emptyRows = new HashMap<>();

    private static void getData() throws IOException{
        emptyRows.put("top", -1);
        emptyRows.put("bottom", -1);

        Scanner scanner = new Scanner(new FileReader("input.txt"));
        int i = -1;
        boolean emptyTop = true, emptyBottom = false;
        while (scanner.hasNextLine()){
            String line = scanner.nextLine();
            if(i > -1){
                int left = -1, right = -1;
                char[] ch = line.toCharArray();
                for(int j = 0; j < ch.length; j++){
                    if(ch[j] == '*'){
                        emptyTop = false;
                        emptyBottom = false;
                        emptyRows.put("bottom", -1);

                        if(left == -1){ // Считываем крайнюю левую заполненную клетку
                            left = j;
                        }else { // Считываем крайнюю правую заполненную клетку
                            right = j;
                        }
                        if(right == -1){
                            right = left;
                        }
                    }
                }
                if(emptyTop){  // Считаем пустые строки сверху
                    emptyRows.put("top", i);
                }else if(!emptyBottom && left == -1){ // Считаем пустые строки снизу
                    emptyRows.put("bottom", i);
                    emptyBottom = true;
                }
                data.add(new int[]{left, right});
            }else {
                String[] arr = line.split(" ");
                column = Integer.valueOf(arr[1]);
                row = Integer.valueOf(arr[0]);
            }
            i++;
        }
    }

    private static void fillArray(){
        int farLeft = column, farRight = 0, countRow = 0;
        for(int j = 0; j < data.size(); j++){
            if(emptyRows.get("top") != -1 && j <= emptyRows.get("top") || emptyRows.get("bottom") != -1 && j >= emptyRows.get("bottom")){
                for(int k = 0; k < column; k++){
                    result.append(".");
                }
                result.append("\n");
            }else {
                countRow++;
                int left = data.get(j)[0];
                int right = data.get(j)[1];

                if(left != -1 && left < farLeft){ // Получаем самую левую крайнюю клетку
                    farLeft = left;
                }
                if(right != -1 && right > farRight){ // Получаем самую правую крайнюю клетку
                    farRight = right;
                }

                if(j == row-1 || emptyRows.get("bottom") != -1 && j+1 == emptyRows.get("bottom")){
                    for (int m =0; m < countRow; m++){
                        for(int k = 0; k < column; k++){
                            if(k < farLeft || k > farRight){
                                result.append(".");
                            }else {
                                result.append("*");
                            }
                        }
                        result.append("\n");
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        getData();
        fillArray();

        FileWriter out = new FileWriter("output.txt");
        out.write(String.valueOf(result));
        out.close();
    }
}
