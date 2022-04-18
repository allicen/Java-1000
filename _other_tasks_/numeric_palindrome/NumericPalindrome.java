package _other_tasks_.numeric_palindrome;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class NumericPalindrome {
    public static void main(String[] args) throws IOException {
        FileReader file = new FileReader("input.txt");
        PrintWriter out = new PrintWriter(System.out);
        Scanner sc = new Scanner(file);
        sc.nextLine();
        String nums = sc.nextLine();
        String[] chArr = nums.split("");
        ArrayList<Integer> numArr = new ArrayList<>();

        for (String ch: chArr) {
            numArr.add(Integer.parseInt(ch));
        }

        numArr.sort(Comparator.reverseOrder());

        int maxMidNumber = 0;
        ArrayList<Integer> numPrint = new ArrayList<>();

        if (numArr.size() == 1) {
            maxMidNumber = numArr.get(0);
        }

        for (int i = 1; i < numArr.size(); i++) {

            if (numArr.get(i-1) > maxMidNumber && !numArr.get(i).equals(numArr.get(i - 1))) {
                maxMidNumber = numArr.get(i-1);
            }

            if (numArr.get(i).equals(numArr.get(i - 1))) {
                numPrint.add(numArr.get(i));

                if (i+1 < numArr.size()) {
                    i++;
                }
            }
        }

        if (numArr.size() > 1) {
            int last = numArr.get(numArr.size() - 1);
            int prevLast = numArr.get(numArr.size() - 2);

            if (numArr.size() % 2 == 1 && last == prevLast && maxMidNumber < last || last != prevLast && maxMidNumber < last) {
                maxMidNumber = last;
            }
        }

        for (Integer integer : numPrint) {
            out.print(integer);
        }

        if (maxMidNumber > 0) {
            out.print(maxMidNumber);
        }

        for (int i = numPrint.size()-1; i >= 0 ; i--) {
            out.print(numPrint.get(i));
        }

        out.println();
        out.flush();
    }
}
