package Sorting2;// 알고리즘 - 정렬_2
// 합병 정렬

import java.util.Arrays;

public class Merge {
    
    public static void mergeSort(int[] arr, int[] tmp, int left, int right) {
        //재귀 호출을 통해, 절반으로 쪼갠 배열과, 해당 배열의 양끝값 중간값 전달
        if(left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr,tmp,left,mid);
            mergeSort(arr,tmp,mid+1,right);
            //배열이 더이상 쪼개지지 않을때, 사이즈2 배열부터 merge가 호출되기 시작.
            merge(arr,tmp,left,right,mid);
        }

    }

    public static void merge(int[] arr, int[] tmp, int left, int right, int mid) {
        int idx = left;  // tmp에 배열을 넣을 초기 인덱스
        int p = left; //왼쪽 시작부분
        int q = mid + 1; // 갈라진 오른쪽의 시작부분
        /* p 가 중간지점에 오기전과, q가 마지막 부분에 가기 전까지, p 와 q 를 비교하면서 정렬시작
        p와 q를 비교해서, 작은값을 tmp에 넣고, 해당 p나 q의 값을 증가시킨다.
        p와 q중 둘중하나라도 이미 mid나 right에 도착했다면, 이미 해당 부분의 정렬은 끝난것이기 때문에
        남아있는 부분을 tmp에 넣어준다.
        */
        while(p <= mid || q <= right){
            if(p <= mid && q <= right){
                if(arr[p] <= arr[q]){
                    tmp[idx++] = arr[p++];
                }else{
                    tmp[idx++] = arr[q++];
                }
            }else if(p <= mid && q > right){
                tmp[idx++] = arr[p++];
            }else{
                tmp[idx++] = arr[q++];
            }
        }
        //tmp에 정렬된값을 arr에 추가
        for(int i = left; i <= right; i++){
            arr[i] = tmp[i];
        }
    }

    public static void main(String[] args) {
        // Test code
        int[] arr = {3, 5, 2, 7, 1, 4, 6};
        int[] tmp = new int[arr.length];
        mergeSort(arr, tmp, 0, arr.length - 1);
        System.out.println("합병 정렬: " + Arrays.toString(arr));
    }
}
