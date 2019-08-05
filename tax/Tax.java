package tax;

import java.util.*;
import java.io.*;

public class Tax {
    private static ArrayList<String> dataAll = new ArrayList<>(); // Данные построчно
    private static ArrayList<Double> profit = new ArrayList<>(); // Прибыль
    private static ArrayList<Double> taxPercent = new ArrayList<>(); // Процент от прибыли
    private static ArrayList<Double> taxSumm = new ArrayList<>(); // Сумма налога
    private static void getData() throws IOException{ // Получение данных
        FileReader file = new FileReader("input.txt");
        Scanner sc = new Scanner(file);
        while (sc.hasNextLine()){
            dataAll.add(sc.nextLine());
        }
        for(int i = 0; i < dataAll.size(); i++){
            if(i == 1){
                StringTokenizer st = new StringTokenizer(dataAll.get(i), " ");
                while (st.hasMoreTokens()){
                    profit.add(Double.valueOf(st.nextToken()));
                }
            }
            if(i == 2){
                StringTokenizer st = new StringTokenizer(dataAll.get(i), " ");
                while (st.hasMoreTokens()){
                    taxPercent.add(Double.valueOf(st.nextToken()));
                }
            }
        }
    }

    public static void main(String[] argv) throws IOException{
        getData();

        for(int j = 0; j < profit.size(); j++){
            double tax = profit.get(j) * taxPercent.get(j) / 100.0;
            taxSumm.add(tax);
        }

        int numberOfFirm = 0;
        double maxTax = 0;

        for(int k = 0; k < taxSumm.size(); k++){
            if(maxTax < taxSumm.get(k)){
                maxTax = taxSumm.get(k);
                numberOfFirm = k;
            }
        }
        numberOfFirm++;

        PrintWriter pw = new PrintWriter(new File("output.txt"));
        pw.print(String.valueOf(numberOfFirm));
        pw.close();
    }
}
