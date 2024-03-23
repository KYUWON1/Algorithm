package Sorting3;// 셸 정렬

import java.util.Arrays;

public class ShellSort {

    public static void shellSort(int[] arr) {
        int gap = arr.length / 2;

        // gap을 절반씩 줄여가면서 반복, 요 부분 어려움
        for (int g = gap; g > 0; g /= 2) {
            // i기준 gap 만큼 뺀 index에서 값비교후 교체부분
            for (int i = g; i < arr.length; i ++) {
                int tmp = arr[i]; // gap값 저장

                // j 는 i에서 gap만큼 뺀값
                int j =0;
                //i는 하나씩 증가함으로 4 0 , 5 1, 6 2 이런식으로 비교가됨
                for (j = i - g; j>= 0;j-=g){
                    if(arr[j] > tmp){
                        // 기존 i 자리와 gap만큼 뺀값 교체 
                        arr[j+g] = arr[j];
                    }else{
                        break;
                    }
                }
                // 마지막으로 교채된 index에서 gap만큼 뺀값에 
                // tmp에 저장해 두었던 가장 작은 값 저장
                arr[j+g] =tmp;
            }
        }
    }

    public static void main(String[] args) {
        // Test code
        int[] arr = {10, 32, 52, 27, 48, 17, 99, 56};
        shellSort(arr);
        System.out.println("셸 정렬: " + Arrays.toString(arr));
    }
}
