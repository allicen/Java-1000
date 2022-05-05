package _other_tasks_.big_add_one;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class BigAddOne {

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

    public static int[] addOne(int[] num) {
        ArrayList<Integer> tmp = new ArrayList<>();
        int carry = 1;
        for (int j : num) {
            int sum = carry + j;
            tmp.add(sum % 10);
            carry = sum / 10;
        }
        if (carry != 0) {
            tmp.add(carry);
        }
        int[] res = new int[tmp.size()];
        for (int i = 0; i < tmp.size(); i++) {
            res[i] = tmp.get(i);
        }

        return res;
    }

    public static void main(String[] args) throws FileNotFoundException {

        Scanner sc = new Scanner(new FileReader("input.txt"));
        PrintWriter out = new PrintWriter(System.out);
        String[] a = sc.nextLine().split("");

        int[] aArr = new int[a.length];

        int j = a.length - 1;
        for (int i = 0; i < a.length; i++) {
            aArr[i] = Integer.parseInt(a[j]);
            j--;
        }

        int[] res = normalize(addOne(aArr));

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
