package coin;

import java.io.*;
import java.util.*;

public class Coin {
    public static void main(String[] args) throws IOException {
        ArrayList<Integer> coinsAll = new ArrayList<>();
        int zero = 0, one = 0;
        int out;
        String str;
        FileReader file = new FileReader("input.txt"); // Считывание данных из файла
        Scanner sc = new Scanner(file);
        while (sc.hasNextLine()){
            str = sc.nextLine();
            coinsAll.add(Integer.valueOf(str));
        }
        for(int i = 0; i < coinsAll.size(); i++){ // Считаем нули и единицы
            if(i > 0){ // Пропускаем 1 число из файла
                if(coinsAll.get(i) == 0){
                    zero++;
                }else {
                    one++;
                }
            }
        }
        if(zero < one){ // Каких монет меньше
            out = zero;
        }else if(one < zero){
            out = one;
        }else{
            out = one;
        }
        FileWriter fileOut = new FileWriter("output.txt");
        fileOut.write(String.valueOf(out));
        fileOut.close();
    }
}
