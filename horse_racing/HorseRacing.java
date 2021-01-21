package horse_racing;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class HorseRacing {


    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new FileReader("input.txt"));
        String[] firstLine = sc.nextLine().split(" ");
        int n = Integer.parseInt(firstLine[0]);
        int k = Integer.parseInt(firstLine[1]);

        Map<Integer, Set<Integer>> data = new TreeMap<>();

        while (sc.hasNextLine()){
            String[] line = sc.nextLine().split(" ");
            if (line.length == 2) {
                int winner = Integer.parseInt(line[0]);
                int looser = Integer.parseInt(line[1]);
                Set<Integer> losersHorse = new HashSet<>();

                if (data.get(winner) != null) {
                    losersHorse = data.get(winner);
                }
                losersHorse.add(looser);
                data.put(winner, losersHorse);

            }
        }

        PrintWriter out = new PrintWriter(System.out);

        if (data.size() == 0) {
            out.println("Yes");
        } else if (data.get(k) == null) {
            out.println("No");
        } else {
            // проверяем только интересующую нас лошадь
            Set<Integer> losers = data.get(k);
            Set<Integer> losersResult = new HashSet<>(losers);

            for (int loser : losers) {
                losersResult.addAll(findAllLosers(data, new HashSet<>(), new int[n+1], loser));
            }

            if (losersResult.size() == n-1) {
                out.println("Yes");
            } else {
                out.println("No");
            }
        }

        out.flush();
    }

    /**
     * Получить всех проигравших лоошадей
     * @param data Начальные данные
     * @param losers Програвшие для конкретной лошади
     * @param checked Уже проверенные лошади
     * @param horseNumber Номер лошади
     * @return Список всех програвших
     * */
    public static Set<Integer> findAllLosers(Map<Integer, Set<Integer>> data, Set<Integer> losers, int[] checked, int horseNumber) {
        if (data.get(horseNumber) != null && checked[horseNumber] == 0) {
            checked[horseNumber] = 1;
            Set<Integer> tmp = data.get(horseNumber);
            losers.addAll(data.get(horseNumber));
            for (int loser : tmp) {
                losers.addAll(findAllLosers(data, losers, checked, loser));
            }
        }

        return losers;
    }
}
