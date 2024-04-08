package Greedy;// Practice
// 정수형 nums 배열이 주어졌다.
// 각 원소의 값은 해당 위치에서 오른쪽으로 이동할 수 있는 최대 값이다.
// 첫 번째 위치에서 시작해서 가장 끝까지 이동이 가능한지 판별하는 프로그램을 작성하세요.
// 이동이 가능하면 true, 불가능하면 false 를 반환하세요.

// 입출력 예시
// nums: 2, 3, 0, 1, 4
// 출력: true

// nums: 3, 0, 0, 1, 1
// 출력: true

// nums: 3, 2, 1, 0, 4 // 마지막 인덱스 4
// 출력: false

//각 자리에서 갈수있는 최대 거리를 찝어놓고, 해당 거리를 넘어 갈 수 있나를
//체크하는 방식으로 그리디 알고리즘 진행
public class Practice1 {
    public static boolean solution(int[] nums) {
        //갈수 있는 최대 지점을 체크할 변수
        int pos = 0;
        //배열을 돌면서 pos가 i보다 작으면, 최대치를 넘어갈 수 없으면 false
        // pos가 배열의 끝이나 넘어서면 true 반환
        for (int i = 0; i < nums.length; i++) {
            if(pos < i){
                return false;
            }else if(pos >= nums.length-1){
                return true;
            }
            //조건문에 걸리지않으면, 갈 수 있는 최대거리를 갱신
            pos = Math.max(pos,i+nums[i]);
        }

        return true;
    }

    public static void main(String[] args) {
        // Test code
        int[] nums = {2, 3, 0, 1, 4};
        System.out.println(solution(nums));

        nums = new int[]{3, 0, 0, 1, 1};
        System.out.println(solution(nums));

        nums = new int[]{3, 2, 1, 0, 4};
        System.out.println(solution(nums));
    }
}
