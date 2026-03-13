import java.util.*;

public class TwoSumTransactions {

    public static void findTwoSum(int[] arr,int target){

        HashMap<Integer,Integer> map=new HashMap<>();

        for(int i=0;i<arr.length;i++){

            int complement=target-arr[i];

            if(map.containsKey(complement)){
                System.out.println("Pair: "+arr[i]+" + "+complement);
                return;
            }

            map.put(arr[i],i);
        }

        System.out.println("No pair found");
    }

    public static void main(String[] args){

        int[] arr={500,300,200};

        findTwoSum(arr,500);
    }
}
