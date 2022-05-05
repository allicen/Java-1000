package _other_tasks_.big_multiplication;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class BigMultiplication {
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
        }
        return true;
    }


    public static int[] multi (int[] a, int[] b) {
        int[] res = new int[a.length * b.length + 1];
        for (int i = 0; i < a.length; i++) {
            int carry = 0;
            for (int j = 0; j < b.length; j++) {
                int tmp = res[i + j] + a[i] * b[j] + carry;
                carry = tmp / 10;
                res[i + j] = tmp % 10;
            }

            int tmp = b.length;
            while (carry > 0) {
                res[i + tmp] = carry % 10;
                tmp++;
                carry /= 10;
            }
        }

        return res;
    }

    public static int[] divide (int[] a, int[] b) {
        int[] res = new int[a.length - b.length + 1];

        for (int i = res.length - 1; i >= 0; i--) {
            while (aSmaller(multi(b, res), a)) {
                res[i]++;
            }
            res[i]--;
        }

        if (res[res.length - 1] == 0) {
            int[] resNew = new int[res.length - 1];
            System.arraycopy(res, 0, resNew, 0, res.length - 1);
            return resNew;
        }
        return res;
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

        int[] res = multi(aArr, bArr);

        StringBuilder resStr = new StringBuilder();
        boolean start = true;
        for (int i = res.length - 1; i >= 0; i--) {
            if (start && res[i] == 0) {
                continue;
            }
            if (start && res[i] != 0) {
                start = false;
            }
            resStr.append(res[i]);
        }

        if (resStr.length() == 0) {
            resStr.append("0");
        }

        out.println(resStr);
        out.flush();
    }
}
