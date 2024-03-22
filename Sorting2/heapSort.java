package Sorting2;// 힙 정렬

import java.util.Arrays;

public class heapSort {
    
    public static void heapSort(int[] arr) {
        // 힙구조에서 부모노드를 가지고, Maxheap 구조로 변경
        for (int i = arr.length /2 -1; i >= 0; i--) {
            heapify(arr,i,arr.length);
        }
        // 가장 앞쪽에 큰수가 있을테니까, 가장 뒤에와 Swap 후 Size를 감소해가면서
        // heapfify 정렬후, 다시 스왑 과정을 반복한다
        for (int i = arr.length-1; i > 0; i--) {
            swap(arr,0,i);
            heapify(arr,0,i);
        }
    }

    public static void heapify(int[] arr, int parentIdx, int size) {
        //일단 부모를 max로 두고, 자식인덱스의 값 가지고 옴 
        int leftidx = 2 * parentIdx + 1;
        int rightidx = 2 * parentIdx + 2;
        int maxidx = parentIdx;

        //만약 왼쪽자식보다 부모가 작다면, max인덱스를 바꿔줌
        if(leftidx < size && arr[maxidx] < arr[leftidx]){
            maxidx =leftidx;
        }
        //만약 오른쪽자식보다 부모가 작다면, max인덱스를 바꿔줌
        if(rightidx < size && arr[maxidx] < arr[rightidx]){
            maxidx =rightidx;
        }
        //만약 인덱스의 변동이 있었다면, 해당 자식과 부모의 위치를 바꿔주고
        //만약 maxidx의 자리가 부모노드라면, 다시한번 heafify를 진행한다.
        if(parentIdx != maxidx) {
            swap(arr,maxidx,parentIdx);
            heapify(arr,maxidx,size);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        // Test code
        int[] arr = {3, 5, 2, 7, 1, 4, 6};
        heapSort(arr);
        System.out.println("힙 정렬: " + Arrays.toString(arr));
    }
}
