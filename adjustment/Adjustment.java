package adjustment;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Adjustment {
    public static void main(String[] args) throws IOException {
        FileReader file = new FileReader("input.txt");
        Scanner sc = new Scanner(file);
        String data = sc.nextLine();

        char[] ch = data.toCharArray();
        int xPosition = 0;
        int a = 0, b = 0, c = 0;
        boolean plus = true;

        for(int i = 0; i < ch.length; i++){
            switch (i){
                case (0):
                    if(String.valueOf(ch[i]).equals("x")){
                        xPosition = 1;
                    }else {
                        a = ch[i] - '0';
                    }
                    break;
                case (1):
                    if(String.valueOf(ch[i]).equals("-")){
                        plus = false;
                    }
                    break;
                case(2):
                    if(String.valueOf(ch[i]).equals("x")){
                        xPosition = 2;
                    }else {
                        b = ch[i] - '0';
                    }
                    break;
                case (4):
                    if(String.valueOf(ch[i]).equals("x")){
                        xPosition = 3;
                    }else {
                        c = ch[i] - '0';
                    }
            }
        }

        int result = (xPosition == 3 && plus) ? a + b :
                (xPosition == 3) ? a - b :
                        (xPosition == 2 && plus) ? c - a :
                                (xPosition == 2) ? a - c :
                                        (xPosition == 1 && plus) ? c - b : b - c;

        FileWriter out = new FileWriter("output.txt");
        out.write(String.valueOf(result));
        out.close();
    }
}
