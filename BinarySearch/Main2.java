package BinarySearch;// 자바 기본 binarySearch

import java.util.ArrayList;
import java.util.Arrays;

public class Main2 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 5, 10, 20, 30, 40, 50, 60};

        System.out.println("데이터가 있는 경우");
        System.out.println(Arrays.binarySearch(arr,1));
        System.out.println(Arrays.binarySearch(arr,10));
        System.out.println(Arrays.binarySearch(arr,30));

        System.out.println("데이터가 없는 경우");
        //반환 값은 원래 있었다면, 존재해야할 자리의 index에 + 1을 하고 음수로 바꾼 값
        System.out.println(Arrays.binarySearch(arr,3));
        System.out.println(Arrays.binarySearch(arr,11));
        System.out.println(Arrays.binarySearch(arr,35));

    }
}
