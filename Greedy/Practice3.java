package Greedy;// Practice
// 양의 정수 n 이 주어지고 다음의 연산을 수행할 수 있을 때,
//    1. n 이 짝수인 경우, 2로 나누기 연산
//    2. n 이 홀수일 때는 1 을 더하거나 1을 빼는 연산
// 주어진 n 이 1 이 되는데 필요한 최소한의 연산 횟수를 반환하세요.

// 입출력 예시
// n: 8
// 출력: 3

// n: 7
// 출력: 4

// n: 9
// 출력: 4

// 짝수일때는 그냥 2로 나누어주면 된다.
/*
홀수일대, 3이면 3-2-1 또는 3-4-2-1 방법이있고
5이면 5-4-2-1 또는 5-6-3-2-1
7이면 8-4-2-1 또는 6-3-2-1 방법이 있는데 가만 보면 4의 배수로 가는 방향이 가장 효율적이다
이런식으로 구현해보자
 */
public class Practice3 {
    public static int solution(int n) {
        int cnt = 0;
        while(n != 1){
            //3일땐 3-2-1 로 break;
            if (n == 3){
                cnt += 2;
                break;
            }
            //2일땐 그냥 2로 나누고 4의 배수가 되는 방향으로 n을 증가시키는 코드
            if(n % 2 == 0){
                n /= 2;
                cnt++;
            }else if((n+1) % 4 ==0){
                n += 1;
                cnt++;
            }else if((n-1) % 4 ==0 ){
                n -= 1;
                cnt++;
            }
        }

        return cnt;
    }

    public static void main(String[] args) {
        // Test code
        System.out.println(solution(8));    // 3
        System.out.println(solution(7));    // 4
        System.out.println(solution(9));    // 4
        System.out.println(solution(6));    // 3
    }
}
