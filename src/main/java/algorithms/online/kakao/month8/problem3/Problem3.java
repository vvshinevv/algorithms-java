package algorithms.online.kakao.month8.problem3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import static java.util.stream.Collectors.toList;

/**
 * 서버 개발자 어피치는 아주 어려운 수학방적식을 풀 수 있는 웹 어플리케이션 서버 만들었습니다.
 * 이 서버에는 많은 요청이 들어오기 때문에 어피치는 서버 여러 대 구성해서 요청을 분산하여 처리하기로 하였습니다.
 * 들어온 요청은 다음과 같이 처리됩니다.
 * - 여러개의 요청이 동시에 (같은 시간에) 들어오지 않습니다.
 * - 요청은 첫 번째 서버부터 시작하여 라운드 로빈 방식으로 서버에 할당됩니다.
 * - 서버가 사용 중이면 건너뜁니다.
 * - 사용 가능한 서버가 없다면 처리되지 않고 파기 됩니다.
 * <p>
 * 매일 자정에 어피치는 그날 가장 바빴던 서버를 점검해야 합니다. 어피치가 점검할 서버를 구하는 함수를 만들어 주세요.
 * 점검해야할 서버가 여러 대일 수 있으니, 서버 ID 배열을 오름차순으로 정렬하여 반환하세요.
 * <p>
 * 예시
 * 예를 들어, k = 3대의 서버와 n = 5 개의 수신된 요청이 있습니다.
 * 수신 사각(arrivals)은 1, 2, 3, 4, 5 그리고 각 요청에 대한 작업량(load)는 6, 3, 4, 4, 4입니다.
 * <p>
 * Request Arrival Load Finish Server
 * 1       1       6    6      1
 * 2       2       3    4      2
 * 3       3       4    6      3
 * 4       4       4    7      dropped
 * 5       5       4    8      2
 * <p>
 * 처음엔 모든 서버를 사용할 수 있습니다. 요청은 라운드 로빈으로 할당되기 때문에, 처음 3개 요청은 3대의 서버에 순서대로 할당됩니다.
 * 4번째 요청이 들어왔을 때, 모든 서버는 사용 중이기 때문에 파기됩니다. 이후 5번째 요청이 들어왔을 땐 2번 서버는 사용 가능하기때문에,
 * 2번 서버에 요청이 할당됩니다. 다섯개의 요청이 모두 처리되었을때, 서버가 처리한 작업량은 아래와 같습니다.
 * <p>
 * - 1번 : 6
 * - 2번 : 3 + 4 = 7
 * - 3번 : 4
 * 2번 서버가 7로 가장 바빳던 서버가 됩니다. 어피치가 이날 점검해야할 서버는 2번입니다.
 * <p>
 * 제약 조건
 * 1 <= n <= 10^5
 * 1 <= k <= 10^5
 * 1 <= arrival[i] <= 10^9
 * 1 <= load[i] <= 10^9
 * <p>
 * 입력
 * 3 - 첫 번째 줄의 k = 3은 서버 수 입니다.
 * 7 - 다음 줄인 정수 n = 7은 들어오는 요청의 개수 입니다.
 * 1 - 다음 n개의 줄 ( 0 <= i <= 7 )은 i 번째 요청의 수신 시각을 나타냅니다.
 * 2
 * 12
 * 5
 * 6
 * 30
 * 32
 * 7 - 다음 줄의 n = 7은 처리량의 개수 입니다.
 * 15 - 다음 n개의 줄 ( 0 <= i <= 7 )은 i 번째 요청의 처리량을 나타냅니다.
 * 10
 * 10
 * 10
 * 10
 * 15
 * 10
 * <p>
 * 출력 예시
 * 1
 * 3
 * <p>
 * 설명
 * k = 3개의 서버와 n = 7개의 요청이 있습니다.
 * Request Arrival Load Finish Server
 * 1       1       15   15     1
 * 2       2       10   11     2
 * 3       12      10   21     2
 * 4       5       10   14     3
 * 5       6       10   15     dropped
 * 6       30      15   44     3
 * 7       32      10   41     1
 * <p>
 * Servers Requests Load
 * 1       2        15 + 10 = 25
 * 2       2        10 + 10 = 20
 * 3       2        10 + 15 = 25
 * <p>
 * 1번과 3번이 작업량이 가장 많았습니다.
 */
public class Problem3 {

    public static void main(String[] args) {
        List<Integer> inputs1 = Arrays.asList(
                3,
                7,
                1,
                2,
                12,
                5,
                6,
                30,
                32,
                7,
                15,
                10,
                10,
                10,
                10,
                15,
                10);
        System.out.println(solve(inputs1));

        List<Integer> inputs2 = Arrays.asList(
                3,
                5,
                1,
                2,
                3,
                4,
                5,
                5,
                6,
                3,
                4,
                4,
                4
        );
        System.out.println(solve(inputs2));

        List<Integer> inputs3 = Arrays.asList(
                3,
                3,
                1,
                10,
                100,
                3,
                5,
                5,
                5
        );
        System.out.println(solve(inputs3));
    }

    private static List<Integer> solve(List<Integer> inputs) {
        Map<Integer, Server> servers = new TreeMap<>();
        for (int i = 1; i <= inputs.get(0); i++) {
            servers.put(i, new Server(i));
        }

        Map<Integer, Integer> requests = new TreeMap<>();
        int requestCnt = inputs.get(1);
        for (int i = 0; i < requestCnt; i++) {
            requests.put(inputs.get(2 + i), inputs.get(requestCnt + i + 3));
        }

        for (Map.Entry<Integer, Integer> requestEntry : requests.entrySet()) {
            int arrival = requestEntry.getKey();
            int load = requestEntry.getValue();
            int minEndTimeServer = getMinEndTimeServer(servers);
            Server server = servers.get(minEndTimeServer);

            if (arrival > server.endTime) {
                server.load += load;
                server.endTime = arrival + load - 1;
            }
        }

        int maxLoad = servers.values().stream().max(Comparator.comparingInt(o -> o.load)).get().load;
        return servers.values().stream().filter(server -> server.load == maxLoad).map(server -> server.name).collect(toList());
    }

    private static int getMinEndTimeServer(Map<Integer, Server> servers) {
        return servers.values().stream().min(Comparator.comparingInt(o -> o.endTime)).get().name;
    }
}

class Server {
    int name;
    int load;
    int endTime;

    Server(int name) {
        this.name = name;
        this.load = 0;
        this.endTime = 0;
    }
}