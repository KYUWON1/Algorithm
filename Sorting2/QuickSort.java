package Sorting2;// 퀵 정렬

import java.util.Arrays;

public class QuickSort {

    
    public static void quickSort(int[] arr, int left, int right) {
        //사이즈가 1이 될때까지 수행된다
        if(left >= right){
            return;
        }
        // left와 right가 만난 지점을 pivot으로 받음
        int pivot = partition(arr,left,right);

        //pivot 기준으로 다시 퀵정렬 시행
        quickSort(arr,left,pivot-1); // pivot중심으로 분할하고 다시 퀵소트
        quickSort(arr,pivot+1,right);
    }

    public static int partition(int[] arr, int left, int right) {
        //우선 pivot을 배열의 가장 앞쪽으로 설정한다
        int pivot = arr[left];
        int i = left;
        int j = right;
        /*left와 right가 만날때까지 반복을 실행하면서, 
          pivot 보다 큰 i의 값을 찾고, pivot보다 작은 j의 값을 찾는다
          찾은 i 와 j의 자리를 교체해준다. 
          마지막으로 pivot과 i와 j가 만난 index와 값을 교체해주고, 해당 i를 pivot으로 전달
        */
        while(i < j) { 
            while(arr[j] > pivot && i < j){
                j--;
            }
            while(arr[i] <= pivot && i < j){
                i++;
            }
            swap(arr,i,j);
        }
        swap(arr,left,i);

        return i;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {6, 2, 7, 9, 4, 5, 8};
        quickSort(arr, 0, arr.length - 1);
        System.out.println("퀵 정렬: " + Arrays.toString(arr));
    }
}
