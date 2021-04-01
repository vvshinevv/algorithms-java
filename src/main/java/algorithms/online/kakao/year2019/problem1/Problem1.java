package algorithms.online.kakao.year2019.problem1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 무지 먹방 라이브 (O)
 * https://programmers.co.kr/learn/courses/30/lessons/42891
 */
public class Problem1 {

    public static void main(String[] args) {
        System.out.println(new Problem1().solution(new int[]{3, 5, 1, 6, 5, 3}, 20L));
        System.out.println(new Problem1().solution(new int[]{3, 1, 2}, 5L));
    }

    static class Table {
        int food_number;
        long food_time;

        Table(int food_number, long food_time) {
            this.food_number = food_number;
            this.food_time = food_time;
        }
    }

    public int solution(int[] food_times, long k) {
        long time = k;
        List<Table> tables = new ArrayList<>();
        for (int i = 0; i < food_times.length; i++) {
            tables.add(new Table(i + 1, food_times[i]));
        }

        List<Table> sorted = tables.stream().sorted(Comparator.comparingLong(t -> t.food_time)).collect(Collectors.toList());
        int answer = -1;
        long preTime = 0;
        for (int i = 0, j = food_times.length; i < food_times.length; i++, j--) {

            long food_time = sorted.get(i).food_time;
            if (food_time == preTime) {
                continue;
            }

            long spend = j * (food_time - preTime);

            if (time - spend >= 0) {
                time -= spend;
                preTime = food_time;
            } else {

                List<Table> sub = sorted.subList(i, food_times.length);
                sub = sub.stream().sorted(Comparator.comparingInt(t -> t.food_number)).collect(Collectors.toList());
                long left = time % sub.size();
                answer = sub.get((int)left).food_number;
                break;
            }

        }

        return answer;
    }


}
