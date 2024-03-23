package Sorting3;// 계수 정렬

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class CountingSort {
    public static void countingSort(int[] arr) {
        int size = getMax(arr);
        //int max = Arrays.stream(arr).max().getAsInt(); 로 가능

        int[] result = new int[size+1]; // 사이즈+1 해서 배열 생성
        int idx = 0; // arr에 대입을 위한 index
        // 배열을 순회하면서, 해당 값에 index를 찾아서 Counting
        for (int i = 0; i < arr.length; i++) {
            result[arr[i]]++;
        }
        // Counting이 되어있다면, 0이 될때 까지, 해당 index를 arr에 처음부터 대입
        for (int i = 0; i < result.length; i++) {
            if(result[i] != 0){
                while(result[i] != 0){
                    arr[idx++] = i;
                    result[i]--;
                }
            }
        }

        //아래에 방법으로도 가능하다
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int item: arr){
            map.put(item,map.getOrDefault(item,0)+1);
        }
        int idx2 = 0;
        ArrayList<Integer> list = new ArrayList<>(map.keySet());
        Collections.sort(list);

        for (int i = 0; i < list.size(); i++) {
            int cnt = map.get(list.get(i));
            while(cnt > 0){
                arr[idx2++] = list.get(i);
                cnt--;
            }
        }
    }

    //최대값 반환 메소드
    public static int getMax(int[] arr){
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if(max < arr[i]){
                max = arr[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        // Test code
        int[] arr = {10, 32, 10, 27, 32, 17, 99, 56};
        countingSort(arr);
        System.out.println("계수 정렬: " + Arrays.toString(arr));
    }
}
