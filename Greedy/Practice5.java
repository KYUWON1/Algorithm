package Greedy;// Practice
// 정수 num 이 주어졌을 때,
// num 숫자에서 두 자리를 최대 한번만 교체하여 얻을 수 있는 최대값을 출력하세요.

// 입출력 예시
// num: 2736
// 출력: 7236

// 입력: 7116
// 출력: 7611

/*
배열의 뒤에서부터
 */
public class Practice5 {
    public static int solution(int num) {
        // 배열의 비교를 쉽게하기위해 cArr를 생성 
        char[] cArr = String.valueOf(num).toCharArray();
        int[] maxArr = new int[cArr.length];

        //maxArr에 cArr의 뒤에서부터, max와 비교하면서, max값을 maxArr에 대입
        // 2736 을 예시로 들면 7766이 들어오겟지 
        int max = 0;
        for (int i = cArr.length-1; i >= 0; i--) {
            max = Math.max(max,cArr[i]-'0');
            maxArr[i] = max;
        }
        
        //cArr의 값과 maxArr의 값을 비교하면서
        for (int i = 0; i < cArr.length-1; i++) {
            //만약 cArr의 값이 maxArr의 i+1의 값보다 작다면
            //2736 7766 상태면 , 2와 7에서 차이가 발생
            if(cArr[i]-'0' < maxArr[i+1]){
                // cArr에서 뒤에서 부터 순회를 하면서, maxArr의 값과 같은 값을 찾으면
                // cArr에서의 max값과 cArr[i]의 위치를 스왑해주고 배열로 리턴해줌 
                for (int j = cArr.length-1; j >= i+1; j--) {
                    if(cArr[j]-'0' == maxArr[i+1]){
                        char tmp = cArr[j];
                        cArr[j] = cArr[i];
                        cArr[i] = tmp;
                        return Integer.parseInt(String.valueOf(cArr));
                    }
                }
            }
        }
        
        return num;
    }

    public static void main(String[] args) {
        // Test code
        System.out.println(solution(2736));
        System.out.println(solution(7116));
        System.out.println(solution(91));
    }
}
