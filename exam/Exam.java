package exam;

import java.util.*;
import java.io.*;

public class Exam {
    private static ArrayList<Long> data = new ArrayList<>();
    private static void getData() throws IOException{ // Получение данных
        FileReader file = new FileReader("input.txt");
        Scanner sc = new Scanner(file);
        StringTokenizer st = new StringTokenizer(sc.nextLine(), " ");
        while (st.hasMoreTokens()){
            data.add(Long.valueOf(st.nextToken()));
        }
    }

    public static void main(String[] argv) throws IOException{
        getData();
        long entrantCount = data.get(0);
        long mathIsSuccsess = data.get(1);
        long chemistryIsSuccsess = data.get(2);
        long examIsFailure = data.get(3);

        long isOneExam = entrantCount - examIsFailure;
        long twoExamSuccsess = (isOneExam >= mathIsSuccsess + chemistryIsSuccsess) ? 0 :
                mathIsSuccsess + chemistryIsSuccsess - isOneExam;

        long mathOnly = mathIsSuccsess - twoExamSuccsess;
        long chemistryOnly = chemistryIsSuccsess - twoExamSuccsess;

        StringBuilder result = new StringBuilder();
        result.append(twoExamSuccsess).append(" ").append(mathOnly).append(" ").append(chemistryOnly);

        PrintWriter pw = new PrintWriter(new File("output.txt"));
        pw.print(result);
        pw.close();
    }
}
