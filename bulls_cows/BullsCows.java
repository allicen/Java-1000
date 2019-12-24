package bulls_cows;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class BullsCows {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new FileReader("input.txt"));
        StringTokenizer st = new StringTokenizer(sc.nextLine(), " ");
        String oneNumber = "", twoNumber = "";
        int index = 0;
        while (st.hasMoreTokens()){
            if(index == 0){
                oneNumber = st.nextToken();
            }else {
                twoNumber = st.nextToken();
            }
            index++;
        }

        int bulls = 0, cows = 0;

        char[] oneArr = oneNumber.toCharArray();
        char[] twoArr = twoNumber.toCharArray();

        for(int i = 0; i < oneArr.length; i++){
            if(oneArr[i] == twoArr[i]){
                bulls++;
            }else {
                for (char anOneArr : oneArr) {
                    if (twoArr[i] == anOneArr) {
                        cows++;
                        break;
                    }
                }
            }
        }

        String result = bulls + " " + cows;

        FileWriter out = new FileWriter("output.txt");
        out.write(result);
        out.close();
    }
}
