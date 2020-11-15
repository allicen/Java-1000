package java_vs_pcc;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class JavaVsPcc {
    private static boolean isUpperCase(char symbol) {
        return String.valueOf(symbol).equals(String.valueOf(symbol).toUpperCase());
    }

    public static void main(String[] args) throws IOException {
        String command = new Scanner(new FileReader("input.txt")).nextLine();
        StringBuilder newCommand = new StringBuilder();

        if (command.contains("_") && command.charAt(0) != '_' && command.charAt(command.length()-1) != '_' && !command.contains("__") ) {

            String[] tmp = command.split("_");
            for (String path: tmp) {
                if (path.length() == 0) {
                    break;
                }
                String upperCase = String.valueOf(path.charAt(0)).toUpperCase();

                if (upperCase.equals(String.valueOf(path.charAt(0))) || !path.toLowerCase().equals(path)) {
                    newCommand = new StringBuilder();
                    newCommand.append("Error!");
                    break;
                }

                if (newCommand.length() == 0) {
                    newCommand.append(path);
                } else {
                    newCommand.append(upperCase);
                    if (path.length() >= 2) {
                        newCommand.append(path.substring(1));
                    }
                }
            }
        } else if (!command.contains("_")) {
            char[] tmp = command.toCharArray();
            for (char symbol: tmp) {
                if (newCommand.length() == 0 && isUpperCase(symbol)) {
                    newCommand.append("Error!");
                    break;
                }

                if (newCommand.length() == 0) {
                    newCommand.append(symbol);
                } else if (isUpperCase(symbol)) {
                    newCommand.append("_");
                    newCommand.append(String.valueOf(symbol).toLowerCase());
                } else {
                    newCommand.append(symbol);
                }
            }
        }

        if (newCommand.length() == 0) {
            newCommand.append("Error!");
        }

        PrintWriter out = new PrintWriter(System.out);
        out.print(newCommand);
        out.flush();
    }
}
