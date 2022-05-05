package _other_tasks_.big_difference_numbers;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class BigDifferenceNumbers {

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

    public static int[] minus(int[] a, int[] b) {
        ArrayList<Integer> tmp = new ArrayList<>();
        int carry = 0;
        for (int i = 0; i < b.length; i++) {
            int cur_diff = a[i] - b[i] - carry;
            if (cur_diff < 0) {
                cur_diff += 10;
                carry = 1;
            }
            else {
                carry = 0;
            }
            tmp.add(cur_diff);
        }
        for (int i = b.length; i < a.length; i++) {
            if (a[i] - carry < 0) {
                tmp.add(a[i] + 10 - carry);
                carry = 1;
            }
            else {
                tmp.add(a[i] - carry);
                carry = 0;
            }
        }

        int[] res = new int[tmp.size()];
        for (int i = 0; i < tmp.size(); i++) {
            res[i] = tmp.get(i);
        }
        return normalize(res);
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

        int[] res = minus(aArr, bArr);

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
