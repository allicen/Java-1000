package _other_tasks_.big_comparing_numbers;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class BigComparingNumbers {

    public static int[] normalize(int[] nums) {
        int correct = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == 0) {
                correct++;
            } else break;
        }

        int arrSize = nums.length - correct;
        if (arrSize == 0) {
            arrSize = 1;
        }

        int[] newNums = new int[arrSize];
        System.arraycopy(nums, 0, newNums, 0, newNums.length);

        return newNums;
    }

    public static boolean aSmaller (int[] a, int[] b) {

        if (a.length < b.length) {
            return true;
        } else if (a.length > b.length) {
            return false;
        } else {
            for (int i = a.length - 1; i >= 0; i--) {
                if (a[i] > b[i]) {
                    return false;
                }
                if (a[i] < b[i]) {
                    return true;
                }
            }
            return false;
        }
    }


    public static void main(String[] args) throws FileNotFoundException {

        Scanner sc = new Scanner(new FileReader("input.txt"));
        PrintWriter out = new PrintWriter(System.out);
        String[] a = sc.nextLine().split("");
        String[] b = sc.nextLine().split("");

        int[] aArr = new int[a.length];
        int[] bArr = new int[b.length];

        int j = a.length - 1;
        for (int i = 0; i < a.length; i++) {
            aArr[i] = Integer.parseInt(a[j]);
            j--;
        }

        j = b.length - 1;
        for (int i = 0; i < b.length; i++) {
            bArr[i] = Integer.parseInt(b[j]);
            j--;
        }

        boolean itentic = aArr.length == bArr.length;

        if (itentic) {
            int maxSize = Math.max(aArr.length, bArr.length);
            for (int i = 0; i < maxSize; i++) {
                if (aArr[i] != bArr[i]) {
                    itentic = false;
                    break;
                }
            }
        }

        boolean res = aSmaller(aArr, bArr);

        if (itentic) {
            out.println("=");
        } else if (res) {
            out.println("<");
        } else {
            out.println(">");
        }

        out.flush();
    }
}
