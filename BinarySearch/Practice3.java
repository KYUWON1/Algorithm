package BinarySearch;// Practice3
// 2차원 행렬에서 이진 탐색으로 데이터 찾기
// row x col 행렬 데이터가 주어졌을 때, target 을 이진 탐색으로 찾는 프로그램을 작성하세요.
// 각 행의 데이터는 오름차순으로 정렬 상태

// 입출력 예시
// 행렬: {{1, 3, 7, 8}, {10, 11, 15, 20}, {21, 30, 35, 60}}

// target: 3
// 출력: true

// target: 13
// 출력: false

public class Practice3 {
    public static boolean solution(int[][] matrix, int target) {
        int left = 0;
        int rows = matrix.length;
        int cols = matrix[0].length;
        int right = rows * cols - 2;

        while(left <= right){
            int mid = (left + right) /2;
            // mid는 5, cols는 4, [1][1] 이 중앙값임. 중앙보다 작다면
            // mid는 2, [0][2] 그다음 중앙값,
            if(matrix[mid / cols][mid % cols] == target){
                return true;
            }else if(matrix[mid / cols][mid % cols] < target){
                left = mid + 1;
            }else {
                right = mid -1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // Test code
        int[][] matrix = {{1, 3, 7, 8}, {10, 11, 15, 20}, {21, 30, 35, 60}};
        System.out.println(solution(matrix, 3));    // true
        System.out.println(solution(matrix, 13));   // false
        System.out.println(solution(matrix, 35));   // true
    }
}
