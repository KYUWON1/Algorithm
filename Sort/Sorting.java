package Sort;// 알고리즘 - 정렬_1

import java.util.Arrays;

public class Sorting {
    // 오름차순 기준 정렬 알고리즘

    // 버블 정렬
    public static void bubbleSort(int[] arr) {
        for (int i = 1; i < arr.length-1; i++) { //반복횟수 지정한다고 생각
            for (int j = 0; j < arr.length-i; j++) { // 비교는 여기서
                if(arr[j] > arr[j+1]){
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp; // 교환
                }
            }
        }
    }
    
    // 삽입 정렬
    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if(arr[j] < arr[j-1]){ // 앞에값이 더 크면
                    int tmp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = tmp;
                } else { // 앞에 값이 크지 않으면, 즉 이미 앞쪽은 정렬이 끝났음으로
                    break;
                }
            }
        }
    }

    // 선택 정렬
    private static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length-1; i++) {
            int minidx = i;
            for (int j = i+1; j < arr.length; j++) {
                if(arr[j] < arr[minidx]){ // minidx는 j 끼리 비교해서도 교체되야하기때문에, i로 넣으면 안댐
                    minidx = j;
                }
            }
            int tmp = arr[i];
            arr[i] = arr[minidx];
            arr[minidx] = tmp;
        }
    }

    public static void main(String[] args) {
        // Test code
        int[] arr = {3, 5, 2, 7, 1, 4};
        bubbleSort(arr);
        System.out.println("버블 정렬: " + Arrays.toString(arr));

        arr = new int[]{3, 5, 2, 7, 1, 4};
        insertionSort(arr);
        System.out.println("삽입 정렬: " + Arrays.toString(arr));

        arr = new int[]{3, 5, 2, 7, 1, 4};
        selectionSort(arr);
        System.out.println("선택 정렬: " + Arrays.toString(arr));

    }
}
