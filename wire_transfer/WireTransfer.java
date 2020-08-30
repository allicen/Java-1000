package wire_transfer;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class WireTransfer {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new FileReader("input.txt"));

        int sum = sc.nextInt();

        int fee = 7;
        int feeSum = 100;

        int hundredCount = sum/feeSum;

        if (sum % feeSum != 0) {
            hundredCount++;
        }

        int resultSum = 0;
        int resultFee = 0;

        for (int i = 1; i <= hundredCount; i++) {
            int feeCount = i * fee;
            int translation = sum - feeCount;

            if (translation > feeSum * i) {
                translation = feeSum * i;
            }

            if (translation > resultSum) {
                resultSum = translation;
                resultFee = feeCount;
            }
        }

        PrintWriter out = new PrintWriter(System.out);
        out.println(resultSum + " " + resultFee);
        out.flush();
    }
}
