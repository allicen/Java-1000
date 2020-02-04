package simple_numbers_two;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class SimpleNumbersTwo {

    /**
     * @param divider Делитель числа
     * @return true, если делитель простое число, false в противном случае
     * */
    private static boolean isSimple(int divider){
        if(divider == 2) return true;
        if (divider % 2 == 0) return false;
        for(int i = 3; i < divider / 2; i += 2){
            if(divider % i == 0){
                return false;
            }
        }
        return true;
    }


    /**
     * @param number Проверяемое число из исходных данных
     * @return Массив с количеством простых делителей и исходным числом
     * */
    private static int [] getDividers(int number){
        int numberCopy = number;
        Set<Integer> dividers = new HashSet<>();

        int index = 2;
        while (numberCopy != 1){
            if(numberCopy % index == 0){
                if(isSimple(index)){
                    dividers.add(index);
                }
                numberCopy /= index;
            }else index++;
        }
        return new int[]{dividers.size(), number};
    }

    public static void main(String[] args) throws IOException {
        ArrayList<Integer> array = new ArrayList<>();
        TreeMap<Integer, Integer> dividers = new TreeMap<>();

        Scanner sc = new Scanner(new FileReader("input.txt"));
        while (sc.hasNextLine()){
            String[] arr = sc.nextLine().split(" ");
            for(String elem : arr){
                array.add(Integer.valueOf(elem));
            }
        }
        array.remove(0);

        for(int number : array){
            int[] dividersSimple = getDividers(number);
            if(dividers.containsKey(dividersSimple[0])){
                if(dividers.get(dividersSimple[0]) > dividersSimple[1]){
                    dividers.put(dividersSimple[0], dividersSimple[1]);
                }
            }else {
                dividers.put(dividersSimple[0], dividersSimple[1]);
            }

        }

        String[] resultArr = String.valueOf(dividers.pollLastEntry()).split("=");
        String result = resultArr[1];

        FileWriter out = new FileWriter("output.txt");
        out.write(result);
        out.close();
    }
}
