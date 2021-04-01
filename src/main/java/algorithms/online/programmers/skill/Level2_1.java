package algorithms.online.programmers.skill;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * 캐시 (O)
 * https://programmers.co.kr/learn/courses/30/lessons/17680
 */
public class Level2_1 {

    public static void main(String[] args) {
        Level2_1 level21 = new Level2_1();
        System.out.println(level21.solution(3, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"}));
        System.out.println(level21.solution(2, new String[]{"Jeju", "Pangyo", "NewYork", "newyork"}));
        System.out.println(level21.solution(5, new String[]{"aa", "aa", "aa"}));
    }

    public int solution(int cacheSize, String[] cities) {

        if (cacheSize == 0) {
            return cities.length * 5;
        }

        int answer = 0;
        Map<String, Integer> caches = new HashMap<>();
        for (String city : cities) {
            city = city.toLowerCase(Locale.ROOT);
            for (Map.Entry<String, Integer> entry : caches.entrySet()) {
                String key = entry.getKey();
                Integer value = entry.getValue() - 1;
                caches.put(key, value);
            }

            if (caches.size() != cacheSize) {

                if (caches.containsKey(city)) {
                    caches.put(city, cacheSize);
                    answer += 1;
                    continue;
                }

                caches.put(city, cacheSize);
                answer += 5;
                continue;
            }

            if (caches.containsKey(city)) {
                caches.put(city, cacheSize);
                answer += 1;
            } else {
                String lowKey = null;
                Integer lowValue = Integer.MAX_VALUE;
                for (Map.Entry<String, Integer> entry : caches.entrySet()) {
                    if (entry.getValue() < lowValue) {
                        lowValue = entry.getValue();
                        lowKey = entry.getKey();
                    }
                }
                caches.remove(lowKey);
                caches.put(city, cacheSize);
                answer += 5;
            }
        }

        return answer;
    }
}
