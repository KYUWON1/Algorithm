package SortingTest;// Practice2
// 문자열 배열 strs 가 주어졌을 때 anagram 으로 묶어서 출력하는 프로그램을 작성하세요.
// anagram 은 철자 순서를 바꾸면 같아지는 문자를 의미한다.
// 예) elvis <-> lives
// anagram 그룹 내에서 출력 순서는 상관 없다.

// 입출력 예시
// 입력: "eat", "tea", "tan", "ate", "nat", "bat"
// 출력: [[eat, tea, ate], [bat], [tan, nat]]

// 풀이방법, 정렬을 해서 같으면 anagram이겟지
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Practice2 {
    public static ArrayList<ArrayList<String>> solution(String[] strs) {
        if(strs.length == 0 || strs == null){
            return new ArrayList<>();
        }

        HashMap<String,ArrayList<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            // String을 가지고와서 정렬
            char[] sArr = strs[i].toCharArray();
            sort(sArr);
            String key = String.valueOf(sArr);

            // 아직 해당 String이 없으면 해당 키값으로 추가
            if(!map.containsKey(key)){
                map.put(key,new ArrayList<>());
            }
            // key값으로 기존 String을 list에 add
            map.get(key).add(strs[i]);
        }

        // 맵의 리스트를 가져와서 retrun, 여러개의 리스트가 하나로 묵여서 반환됨
        return new ArrayList<>(map.values());
    }

    public static void sort(char[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if(arr[j] < arr[j-1]){
                    char tmp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = tmp;
                }
            }
        }
    }

    public static void main(String[] args) {
        // Test code
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(solution(strs));

        strs = new String[]{"abc", "bac", "bca", "xyz", "zyx", "aaa"};
        System.out.println(solution(strs));
    }
}
