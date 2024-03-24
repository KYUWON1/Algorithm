package SortingTest;// Practice3
// intervals 라는 구간으로 이루어진 배열이 주어졌을 때,
// 오버랩 되는 구간을 합치는 프로그램을 작성하세요.

// 입출력 예시
// 입력: [2, 6], [1, 3], [15, 18], [8, 10]
// 출력: [1, 6] [8, 10] [15, 18]

import java.util.ArrayList;
import java.util.Arrays;

public class Practice3 {

    public static ArrayList<int[]> solution(int[][] intervals) {
        if(intervals == null || intervals.length < 2){
            return new ArrayList<>();
        }

        sort(intervals);

        ArrayList<int[]> list = new ArrayList<>();
        int[] curinterval = intervals[0];
        list.add(curinterval);
        for (int i = 1; i < intervals.length; i++) {
            // 첫번째 구간의 뒤에값이 뒤에 구간의 앞에 값보다 크거나 같다면
            if(curinterval[1] >= intervals[i][0]){
                //구간 변경 및 합체, curinterval에 주소값에 접근해서 변경하는거라
                //이미 리스트에 있는 값을 변경하는것임.
                curinterval[1] = intervals[i][1];
            } else {
                //구간이 겹치지 않는다면,
                curinterval = intervals[i];
                list.add(curinterval);
            }
        }
        return list;
    }

    //퀵 소트로 구현해보기
    public static void sort(int[][] intervals) {
        quickSort(intervals,0,intervals.length-1);
    }
    public static void quickSort(int[][] arr,int left,int right){
        if(left >= right){
            return;
        }

        int pivot = partition(arr,left,right);

        quickSort(arr,left,pivot-1);
        quickSort(arr,pivot+1,right);
    }
    public static int partition(int[][] arr,int left,int right) {
        int pivot = arr[left][0];
        int i = left;
        int j = right;

        while (i < j) {
            while (arr[j][0] > pivot && i < j) {
                j--;
            }
            while (arr[i][0] <= pivot && i < j) {
                i++;
            }
            swap(arr, i, j);
        }
        swap(arr, left, i);

        return i;
    }
    public static void swap(int[][] arr,int i,int j){
        int[] tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        // Test code
        int[][] intervals = {{2, 6}, {1, 3}, {15, 18}, {8, 10}};

        for (int[] item: solution(intervals)) {
            System.out.print(Arrays.toString(item) + " ");
        }
        System.out.println();

    }
}
