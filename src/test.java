package src;

import java.util.Arrays;

public class test {
    public static  void main( String []args){
        int []arr={1,2,3,4};
        dfs(0,arr);
        System.out.println(Arrays.toString(arr));
    }

    static void dfs(int index, int[] arr){
        if(index==4) return;
        arr[index]+=1;
        dfs(index+1,arr);
    }
}
