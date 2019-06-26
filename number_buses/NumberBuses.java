package number_buses;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class NumberBuses {
    private static ArrayList<String> data = new ArrayList<>();
    private static ArrayList<String> resultCheck = new ArrayList<>();
    private static int flag = 0;

    private static void check(){
        for(int i = 0; i < data.size(); i++){
            if(i != 0){
                String str = data.get(i).replaceAll("[^\\d+][^\\w+]", ""); // Вырезаем из строки все символы кроме цифр и букв
                int len = str.length();
                Character[] ch = new Character[len];
                for(int a = 0; a < len; a++){
                    ch[a] = str.charAt(a);
                }
                String line = "ABCEHKMOPTXY";
                String numbers = "0123456789";
                if(ch.length == 6){
                    if(ch[0] != null){
                        // 1 символ
                        Pattern patternOne = Pattern.compile(String.valueOf(ch[0]));
                        Matcher matcherOne = patternOne.matcher(line);
                        if(matcherOne.find()){
                            flag++;
                        }
                    }
                    if(ch[1] != null){
                        // 2 символ
                        Pattern patternTwo = Pattern.compile(Character.toString(ch[1]));
                        Matcher matcherTwo = patternTwo.matcher(numbers);
                        if(matcherTwo.find()){
                            flag++;
                        }
                    }
                    if(ch[2] != null){
                       // 3 символ
                        Pattern patternThree = Pattern.compile(Character.toString(ch[2]));
                        Matcher matcherThree = patternThree.matcher(numbers);
                        if(matcherThree.find()){
                            flag++;
                        }
                    }
                    if(ch[3] != null){
                       // 4 символ
                        Pattern patternFour = Pattern.compile(Character.toString(ch[3]));
                        Matcher matcherFour = patternFour.matcher(numbers);
                        if(matcherFour.find()){
                            flag++;
                        }
                    }

                    if(ch[4] != null){
                      // 5 символ
                        Pattern patternFive = Pattern.compile(Character.toString(ch[4]));
                        Matcher matcherFive = patternFive.matcher(line);
                        if(matcherFive.find()){
                            flag++;
                        }
                    }

                    if(ch[5] != null){
                        // 6 символ
                        Pattern patternSix = Pattern.compile(Character.toString(ch[5]));
                        Matcher matcherSix = patternSix.matcher(line);
                        if(matcherSix.find()){
                            flag++;
                        }
                    }
                }
                resultCheck.add(String.valueOf(flag));
                flag = 0;
            }
        }
    }

    private static void symbolChange(){
        if(!resultCheck.isEmpty()){
            for(int j = 0; j < resultCheck.size(); j++){
                if(resultCheck.get(j).equals("6")){
                    resultCheck.set(j, "Yes");
                }else{
                    resultCheck.set(j, "No");
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        FileReader file = new FileReader("input.txt");
        Scanner sc = new Scanner(file);
        while (sc.hasNextLine()){
            data.add(sc.nextLine());
        }

        check();
        symbolChange();

        String result = String.valueOf(resultCheck).replaceAll(", ", "\n").replaceAll("^\\[|]$", "");
        FileWriter fileOut = new FileWriter("output.txt");
        fileOut.write(result);
        fileOut.close();
    }
}
