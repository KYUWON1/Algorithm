package Sorting3;// 알고리즘 - 정렬_3
// 기수 정렬

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class RadixSort {
    public static void radixSort(int[] arr) {
        //초기 테이블 설정 작업
        ArrayList<Queue<Integer>> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(new LinkedList<>());
        }

        int idx = 0;  // 다시 인덱스에 추가할 인덱스
        int div = 1;  // 몫을 나눌 값 
        int maxLen = getMaxLen(arr);

        //최대 자리수 만큼 반복 ex) 10의 자리면 2번
        for (int i = 0; i < maxLen; i++) {
            // list에서 원하는 나머지의 큐를 가져오고, 해당 데이터 저장 부분
            for (int j = 0; j < arr.length; j++) {
                list.get((arr[j] / div) % 10).offer(arr[j]);
            }
            // list에서 큐를 가져와서, 데이터가 없을때까지, arr에 대입하는 과정
            for (int j = 0; j < 10; j++) {
                Queue<Integer> que = list.get(j);
                while(que.size() != 0) {
                    arr[idx++] = que.poll();
                }
            }
            //첫번째 연산이 끝나고 index초기화 및 자릿수증가
            idx = 0;
            div *= 10;
        }


    }

    // 밑이 10인 로그를 통해 자릿수를 구하는 방법
    public static int getMaxLen(int[] arr){
        int maxLen = 0;
        for (int i = 0; i < arr.length; i++) {
            int len = (int)Math.log10(arr[i]) + 1;
            if(maxLen < len){
                maxLen = len;
            }
        }
        return maxLen;
    }


    public static void main(String[] args) {
        // Test code
        int[] arr = {10, 32, 52, 27, 48, 17, 99, 56};
        radixSort(arr);
        System.out.println("기수 정렬: " + Arrays.toString(arr));
    }
}
