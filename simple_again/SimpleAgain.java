package simple_again;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class SimpleAgain {

    private static boolean simple(long number){
        double sqrt = Math.sqrt(number);

        if(number == 1 || number == 2) return true;
        if(number % 2 == 0) return false;

        for(long i = 3; i <= sqrt; i += 2){
            if(number % i == 0) return false;
        }
        return true;
    }

    private static long sum(long number){
        long sum = 0;
        while (number > 0){
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new FileReader("input.txt"));
        StringTokenizer st = new StringTokenizer(sc.nextLine()," ");
        long start = Integer.valueOf(st.nextToken());
        long finish = Long.valueOf(st.nextToken());

        long maxSum = -1;
        long maxSimpleNumber = -1;

        for(long i = start+1; i <= finish; i++){
            if(simple(i)){
                long sum = sum(i);
                if(sum > maxSum){
                    maxSimpleNumber = i;
                    maxSum = sum;
                }
                if(sum == maxSum){
                    maxSimpleNumber = (i > maxSimpleNumber) ? i : maxSimpleNumber;
                }
            }
        }

        FileWriter out = new FileWriter("output.txt");
        out.write(String.valueOf(maxSimpleNumber));
        out.close();
    }
}
