package Greedy;// 거스름돈 문제

import java.util.HashMap;
import java.util.Map;

public class Main2 {
    public static void getChangeCoins(int receivedMoney, int price) {
        final int[] coins = {500,100,50,10,5,1};

        HashMap<Integer,Integer> map = new HashMap<>();

        int change = receivedMoney - price;
        int cnt = 0;

        for (int i = 0; i < coins.length; i++) {
            if(change < coins[i]){
                continue;
            }
            int q = change / coins[i];
            map.put(coins[i],map.getOrDefault(coins[i],0)+q);

            change = change % coins[i];
            cnt += q;
        }

        System.out.println("동전 갯수:"+cnt);
        for(Map.Entry<Integer,Integer> cur : map.entrySet()){
            System.out.println(cur.getKey()+": "+cur.getValue());
        }
    }

    public static void main(String[] args) {
        // Test code
        getChangeCoins(1000, 100);
        getChangeCoins(1234, 500);
    }
}
