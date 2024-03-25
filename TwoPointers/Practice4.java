package TwoPointers;// Practice
// 주어진 nums 배열에서 3 개의 합이 0이 되는 모든 숫자들을 출력하세요.
// 중복된 숫자 셋은 제외하고 출력하세요.

// 입출력 예시
// nums: {-1, 0, 1, 2, -1, -4};
// 출력: [[-1, -1, 2], [-1, 0, 1]]

// nums: {1, -7, 6, 3, 5, 2}
// 출력: [[-7, 1, 6], [-7, 2, 5]]


import java.util.ArrayList;
import java.util.Arrays;

public class Practice4 {
    public static ArrayList<ArrayList<Integer>> solution(int[] nums) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // 우선 정렬

        for (int i = 0; i < nums.length-2; i++) {
            //0일때 index에러가 발생함으로, 왼쪽은 항상 참
            // &&가 먼저 평가되고 || 가 나중에 평가됨 
            // &&의 특성은 앞쪽 논리가 false면 뒤에는 그냥 보지도않음
            if(i == 0 || i > 0 && nums[i] != nums[i-1]){ // 여기서 연속된 숫자는 제외됨
                int p1 = i+1; // 작은값
                int p2 = nums.length-1; // 큰값
                while(p1 < p2){
                    if(nums[i]+nums[p1]+nums[p2] == 0){
                        result.add(new ArrayList<>(Arrays.asList(nums[i],nums[p1],nums[p2])));
                        while(p1 < p2 && nums[p1] == nums[p1+1]){
                            p1++;
                        }
                        while(p1 < p2 && nums[p2] == nums[p2-1]){
                            p2--;
                        }
                        p1++;
                        p2--;
                    }else if(nums[i]+nums[p1]+nums[p2] < 0){
                        p1++;
                    }else{
                        p2--;
                    }
                }
            }

        }
        return result;
    }

    public static void main(String[] args) {
        // Test code
        int[] nums = {-1, 0, 1, 2, -1, -4};     // [[-1, -1, 2], [-1, 0, 1]]
        System.out.println(solution(nums));

        nums = new int[] {1, -7, 6, 3, 5, 2};   // [[-7, 1, 6], [-7, 2, 5]]
        System.out.println(solution(nums));
    }
}
