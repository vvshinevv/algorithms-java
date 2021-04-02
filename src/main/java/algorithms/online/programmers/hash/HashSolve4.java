package algorithms.online.programmers.hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 베스트 앨범
 * https://programmers.co.kr/learn/courses/30/lessons/42579
 */
public class HashSolve4 {

    public static void main(String[] args) {
        HashSolve4 hashSolve4 = new HashSolve4();
        System.out.println(Arrays.toString(hashSolve4.solution(new String[]{"classic", "pop", "classic", "classic","jazz","pop", "Rock", "jazz"}, new int[]{500, 600, 150, 800, 1100, 2500, 100, 1000})));
        System.out.println(Arrays.toString(hashSolve4.solution(new String[]{"classic", "pop", "classic", "classic", "pop"}, new int[]{500, 600, 150, 800, 2500})));
        System.out.println(Arrays.toString(hashSolve4.solution(new String[]{"A", "A", "B", "A", "B", "B", "A", "A", "A", "A"}, new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1})));
    }

    static class Album implements Comparable<Album> {
        int idx;
        String genres;
        int plays;

        public Album(int idx, String genres, int plays) {
            this.genres = genres;
            this.plays = plays;
            this.idx = idx;
        }

        @Override
        public int compareTo(Album o) {
            return o.plays;
        }
    }

    static class Total implements Comparable<Total> {
        String genres;
        int plays;

        public Total(String genres, int plays) {
            this.genres = genres;
            this.plays = plays;
        }

        @Override
        public int compareTo(Total o) {
            return o.plays;
        }
    }

    public int[] solution(String[] genres, int[] plays) {

        List<Album> albums = new ArrayList<>();
        List<Total> totals = new ArrayList<>();
        Map<String, Integer> totalCount = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            if (totalCount.containsKey(genres[i])) {
                int count = totalCount.get(genres[i]) + plays[i];
                totalCount.put(genres[i], count);
            } else {
                totalCount.put(genres[i], plays[i]);
            }

            albums.add(new Album(i, genres[i], plays[i]));
        }

        for (Map.Entry<String, Integer> entry : totalCount.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();

            totals.add(new Total(key, value));
        }

        Map<String, List<Album>> albumMaps = albums.stream()
                .collect(Collectors.groupingBy(i -> i.genres, LinkedHashMap::new, Collectors.toList()));


        List<String> orders = totals.stream().sorted((o1, o2) -> o2.plays - o1.plays).map(i -> i.genres).collect(Collectors.toList());


        List<Integer> ansList = new ArrayList<>();
        for (String order : orders) {

            List<Album> als = albumMaps.get(order);
            als = als.stream().sorted((o1, o2) -> o2.plays - o1.plays).collect(Collectors.toList());
            ansList.add(als.get(0).idx);
            if (als.size() == 1) {
                continue;
            }
            ansList.add(als.get(1).idx);
        }

        return ansList.stream().mapToInt(i -> i).toArray();
    }
}
