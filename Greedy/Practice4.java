package Greedy;// Practice
// 원형 루트 상에 n 개의 주유소가 있다.
// 각 주유소의 가스 보유량은 gas 배열에 주어지고,
// 해당 주유소에서 다음 주유소로의 이동 비용은 cost 배열에 주어진다.

// 어떤 위치에서 차량이 가스를 채워 출발하면 모든 주유소를 방문하고 원래의 위치로 돌아올 수 있는지
// 계산하는 프로그램을 작성하세요.

// 입출력 예시
// gas: 1, 2, 3, 4, 5
// cost: 3, 4, 5, 1, 2
// 출력: 3

// gas: 2, 3, 4
// cost: 3, 4, 3
// 출력: -1

/*
gas - cost 를 통해, 기름량을 우선 계산하고, 음수와 양수의 구분점을 기준으로 계산하는 방식으로
구하면 된다.
 */
public class Practice4 {
    public static int solution(int[] gas, int[] cost) {
        // 현재 주유소에서의 가스량, 총 가스량, 출발 주유소를 저장할 변수 
        int curGas = 0;
        int totalGas = 0;
        int startPos = 0;

        // 배열을 돌면서, totalGas에는 계속 주유 사용량을 계산한다
        for (int i = 0; i < gas.length; i++) {
            curGas += gas[i] -cost[i];
            totalGas += gas[i] -cost[i];

            //만약 해당 주유소에서 curGas가 양수면 출발 가능 지점임으로 스타트 지점으로 표시
            //curGas가 최초로 양수가 되는 지점이 출발 지점이고, 가스 사용량 계속 추가
            if(curGas < 0){
                startPos = i+1;
                curGas = 0;
            }
        }
        // 토탈 가스가 0보다 크면 해당 위치값 출력
        return totalGas >= 0 ? startPos : -1;
    }

    public static void main(String[] args) {
        // Test code
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};
        System.out.println(solution(gas, cost));

        gas = new int[]{2, 3, 4};
        cost = new int[]{3, 4, 3};
        System.out.println(solution(gas, cost));
    }
}
