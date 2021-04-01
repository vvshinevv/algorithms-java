package algorithms.online.kakao.year2019.problem3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 오픈채팅방 (O)
 * https://programmers.co.kr/learn/courses/30/lessons/42888
 */
public class Problem3 {

    public static void main(String[] args) {
        System.out.println(
                Arrays.toString(new Problem3().solution(new String[]{"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 " +
                        "Prodo", "Change uid4567 Ryan"}))
        );
    }

    Map<String, String> messages = new HashMap<String, String>() {{
        put("Enter", "님이 들어왔습니다.");
        put("Leave", "님이 나갔습니다.");
    }};

    static class Act {
        String act;
        String id;

        Act(String act, String id) {
            this.act = act;
            this.id = id;
        }
    }

    public String[] solution(String[] record) {
        Map<String, String> users = new HashMap<>();
        List<Act> acts = new ArrayList<>();

        for (String message : record) {
            String[] split = message.split(" ");

            if (split.length == 3) {
                String id = split[1];
                String name = split[2];

                users.put(id, name);
                acts.add(new Act(split[0], id));
            } else {
                String id = split[1];
                acts.add(new Act(split[0], id));
            }
        }

        List<String> result = new ArrayList<>();
        for (Act act : acts) {
            String action = act.act;
            String id = act.id;

            if (!action.equals("Change")) {
                result.add(users.get(id) + messages.get(action));
            }
        }

        return result.toArray(new String[0]);
    }
}
