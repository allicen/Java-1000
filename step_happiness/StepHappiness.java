package step_happiness;

import java.io.*;
import java.util.*;

public class StepHappiness {
    private static int numberCount;
    private static String number;
    private static int numberLeftNext;
    private static int numberLeftPrev;
    private static int numberRightNext;
    private static int numberRightPrev;

    private static void numberTicketPlus(String line){ // Проверка следующего билета
        numberCount = Integer.valueOf(line) + 1;
        number = String.valueOf(numberCount);
        number = (number.length() == 1) ? "00000"+number: // Дописываем нули вперед
                (number.length() == 2) ? "0000" + number:
                        (number.length() == 3) ? "000" + number:
                                (number.length() == 4) ? "00" + number:
                                        (number.length() == 5) ? "0" + number : number;

        char[] ch = number.toCharArray();
        numberLeftNext = (ch[0] - '0') + (ch[1] - '0') + (ch[2] - '0');
        numberRightNext = (ch[3] - '0') + (ch[4] - '0') + (ch[5] - '0');
    }

    private static void numberTicketMinus(String line){ // Проверка предыдущего билета
        numberCount = Integer.valueOf(line) - 1;
        number = String.valueOf(numberCount);
        number = (number.length() == 1) ? "00000"+number: // Дописываем нули вперед
                (number.length() == 2) ? "0000" + number:
                        (number.length() == 3) ? "000" + number:
                                (number.length() == 4) ? "00" + number:
                                        (number.length() == 5) ? "0" + number : number;

        char[] ch2 = number.toCharArray();
        numberLeftPrev = (ch2[0] - '0') + (ch2[1] - '0') + (ch2[2] - '0');
        numberRightPrev = (ch2[3] - '0') + (ch2[4] - '0') + (ch2[5] - '0');
    }

    public static void main(String[] args) throws IOException {
        ArrayList<String> data = new ArrayList<>();
        ArrayList<String> happiniessTicket = new ArrayList<>();
        String result;
        FileReader file = new FileReader("input.txt");
        Scanner sc = new Scanner(file);
        while (sc.hasNextLine()){
            data.add(sc.nextLine());
        }
        for(String line : data){
            numberCount =  line.length(); // Определить длину данных в коллекции
            if(numberCount == 6){ // Если это номер билета
                numberTicketPlus(line);
                numberTicketMinus(line);
                if (numberLeftNext == numberRightNext || numberLeftPrev == numberRightPrev) { // Если предыдущий или следующий билет счастливый
                    happiniessTicket.add("Yes");
                } else {
                    happiniessTicket.add("No");
                }
            }
        }
        result = String.valueOf(happiniessTicket).replaceAll(", ", "\n").replaceAll("^\\[|]$", "");
        FileWriter fileOut = new FileWriter("output.txt");
        fileOut.write(result);
        fileOut.close();
    }
}
