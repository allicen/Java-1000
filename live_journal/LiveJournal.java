package live_journal;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class LiveJournal {

    private static void printFriends(PrintWriter out, ArrayList<String> friends) {
        for (int i = 0; i < friends.size(); i++) {
            out.print(friends.get(i));
            if (i + 1 < friends.size()) {
                out.print(", ");
            }
        }
        out.print('\n');
    }

    public static void main(String[] args) throws IOException {
        ArrayList<String> firstFriendList = new ArrayList<>();
        ArrayList<String> commonFriend = new ArrayList<>();
        ArrayList<String> variousFriendList = new ArrayList<>();

        Scanner sc = new Scanner(new FileReader("input.txt"));

        int firstListCount = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < firstListCount; i++) {
            firstFriendList.add(sc.nextLine());
        }

        int secondListCount = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < secondListCount; i++) {
            String friend = sc.nextLine();
            if (firstFriendList.contains(friend)) {
                commonFriend.add(friend);
            } else {
                variousFriendList.add(friend);
            }
        }

        Collections.sort(firstFriendList);
        Collections.sort(commonFriend);
        Collections.sort(variousFriendList);

        PrintWriter out = new PrintWriter(System.out);
        out.print("Friends: " );
        printFriends(out, firstFriendList);
        out.print("Mutual Friends: " );
        printFriends(out, commonFriend);
        out.print("Also Friend of: " );
        printFriends(out, variousFriendList);
        out.flush();
    }
}
