package _other_tasks_.b_robot_secretary;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class RobotSecretary {
    private static boolean isSmallRegister(char symbol) {
        return String.valueOf(symbol).equals(String.valueOf(symbol).toLowerCase());
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new FileReader("input.txt"));
        char[] symbols = sc.nextLine().toCharArray();

        boolean isSmallRegister = true;
        int count = 0;
        for (int i = 0; i < symbols.length; i++) {

            if (symbols[i] == ' ') {
                count++;
            } else if (i+1 < symbols.length) {
                if (isSmallRegister && !isSmallRegister(symbols[i]) && !isSmallRegister(symbols[i + 1])
                        || !isSmallRegister && isSmallRegister(symbols[i]) && isSmallRegister(symbols[i + 1])) { // переключить регистр
                    count += 3;
                    isSmallRegister = !isSmallRegister;
                } else if (isSmallRegister && !isSmallRegister((symbols[i])) || !isSmallRegister && isSmallRegister((symbols[i]))) { // не переключать регистр
                    count += 2;
                } else {
                    count++;
                }

            } else {
                if (isSmallRegister && isSmallRegister((symbols[i])) || !isSmallRegister && !isSmallRegister((symbols[i]))) {
                    count++;
                } else {
                    count += 2;
                }
            }
        }

        PrintWriter out = new PrintWriter(System.out);
        out.println(count);
        out.flush();
    }
}

