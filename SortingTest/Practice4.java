package SortingTest;// Practice4
// 정수 배열 nums 가 주어졌을 때
// 오름차순으로 정렬하기 위해 배열 내에서 정렬이 필요한 구간의 길이를 출력하는 프로그램을 작성하세요.

// 입출력 예시
// 입력: 2, 6, 4, 8, 5, 3, 9, 10
// 출력: 5

// 입력: 1, 3, 1
// 출력: 2

public class Practice4 {
    public static int solution(int[] nums) {
        int idx1 = -1;
        int idx2 = -1;
        for (int i = 1; i < nums.length; i++) {
            if(idx1 == -1 && nums[i] < nums[i-1]){ // 6 4  일때, 2 저장
                //가장 앞쪽 idx를 저장
                idx1 = i-1;
            }
            if(idx1 != -1 && nums[i] < nums[i-1]){ // 이미 idx1은 저장, 5 3, 5저장
                idx2 = i;
            }
        }
        if(idx1 == -1 ){
            return 0;
        }
        if(idx2 == -1){
            return 2;
        }
        // 길이를 구해서 return
        return -idx1 + idx2 + 1;
    }

    public static void main(String[] args) {
        // Test code
        int[] nums = {2, 6, 4, 8, 5, 3, 9, 10};
        System.out.println(solution(nums));

        nums = new int[]{1, 3, 1};
        System.out.println(solution(nums));

        nums = new int[]{1, 9, 3, 4, 5};
        System.out.println(solution(nums));

        nums = new int[]{1, 2, 3, 4, 5};
        System.out.println(solution(nums));
    }
}
