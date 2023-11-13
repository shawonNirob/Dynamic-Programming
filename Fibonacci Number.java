package dp;

import java.util.Arrays;

public class Fibonacci {

    /*
    //Normal recursion
    public int fib(int n){
        if(n==0) return 0;
        if(n==1) return 1;


        return fib(n-1)+fib(n-2);
    }

    public static void main(String[] args) {
        Fibonacci fibo = new Fibonacci();
        System.out.println(fibo.fib(6));
    }
     */

    /*
    //memoization - Top-down approach
    public int fib(int n, int[] arr){
        if(n==0) return 0;
        if(n==1) return 1;
        if(arr[n] != -1) return arr[n];

        arr[n] = fib(n-1, arr)+fib(n-2, arr);

        return arr[n];
    }

    public static void main(String[] args) {
        int n = 6;
        int[] arr = new int[n+1];
        Arrays.fill(arr, -1);
        Fibonacci fibo = new Fibonacci();
        System.out.println(fibo.fib(n, arr));
    }
     */

    //Tabulation - Bottom-Up approach
    //No stack space needed
    public int fib(int n){
        int[] arr = new int[n+1];
        arr[0] = 0;
        arr[1] = 1;

        for(int i=2; i<=n; i++){
            arr[i] = arr[i-1]+arr[i-2];
        }
        return arr[n];
    }

    public static void main(String[] args) {
        int n = 6;
        Fibonacci fibo = new Fibonacci();
        System.out.println(fibo.fib(n));
    }
}

//Dynamic Programming Recursive
///Top Down DP
//MemoiZation (DP)
class Solution {
    Map<Integer, Integer> map;
    public int fib(int n) {
        map = new HashMap();
        
        return dpFib(n);
        
    }
    private int dpFib(int n){
        if(n==0) return 0;
        if(n==1) return 1;
        if(map.containsKey(n)) return map.get(n);
        
        map.put(n, dpFib(n-1) + dpFib(n-2));
        
        return map.get(n);
    }
}
//
class Solution {
    public int fib(int n) {
        int[] arr = new int[n+1];
        for(int i=0; i<arr.length; i++){
            arr[i] = -1;
        }
        return fibo(n,arr);
    }
    public int fibo(int n, int[] arr){
        if(n==0) return 0;
        if(n==1) return 1;
        if(arr[n] != -1) return arr[n];
        arr[n] = fibo(n-1, arr) + fibo(n-2, arr);
        return arr[n];
    }
}

//

//Dynamic Programming Iterative
//Bottom Up DP
class Solution {
    public int fib(int n) {
        if(n==0) return 0;
        
        int[] Fib = new int[n+1];
        Fib[0] = 0;
        Fib[1] = 1;

        for(int i=2; i<=n; i++){
            Fib[i] = Fib[i-1] + Fib[i-2];
        }
        return Fib[n];
    }
}
//
class Solution {
    public int fib(int n) {
        Map<Integer, Integer> map = new HashMap();
        
        map.put(0, 0);
        map.put(1, 1);
        
        for(int i=2; i<=n; i++){
            map.put(i, map.get(i-1)+ map.get(i-2));
        }
        
        return map.get(n);
    }
}
