package BinarySearch;// Practice4
// 정수형 배열 weights 와 정수 days 가 주어졌다.
// weights 에는 각 상품의 무게들의 정보가 들어있고, days 는 운송 납기일이다.
// 상품들은 weights 에 적혀있는 순서대로 실어서 운송해야 하는데,
// days 이내에 운송을 하기 위한 차량의 최소한의 적재량을 계산하는 프로그램을 작성하세요.

// 입출력 예시
// weights: 1, 2, 3, 4, 5, 6, 7, 8, 9, 10
// days: 5
// 출력: 15

// weights: 3, 2, 2, 4, 1, 4
// days: 3
// 출력: 6


import java.util.Arrays;

public class Practice4 {
    public static int solution(int[] weights, int days) {
        int min = Arrays.stream(weights).max().getAsInt(); // 하루에 1개씩 최소비용
        int max = Arrays.stream(weights).sum(); // 하루에 모두 최대비용

        while(min <= max){
            int mid = (min + max) / 2; // 최조 중간값
            int sum = 0;
            int cnt = 1;
            // days 계산하기
            for (int i = 0; i < weights.length; i++) {
                if(sum + weights[i] > mid){
                    cnt++;
                    sum = 0;
                }
                sum += weights[i];
            }
            if(cnt > days){
                min = mid +1;
            }else{
                max = mid -1;
            }

        }

        return min;
    }

    public static void main(String[] args) {
        // Test code
        int[] weights = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(solution(weights, 5));   // 15

        weights = new int[]{3, 2, 2, 4, 1, 4};
        System.out.println(solution(weights, 3));   // 6
    }
}
