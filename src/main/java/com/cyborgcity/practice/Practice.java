package com.cyborgcity.practice;

import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;

/**
 * Created by Ravi on 21-04-2017.
 */
public class Practice {

//    static int[] solve(int[] grades){
//        // Complete this function
//        int result[] = new int[grades.length];
//        for (int i =0; i < grades.length; i++ ){
//            if(grades[i] < 38){
//                result[i] = grades[i];
//                continue;
//            }
//            int rem = grades[i] % 5;
//            if(rem >= 3){
//                result[i] = grades[i] +(5-rem);
//            }else{
//                result[i] = grades[i];
//            }
//        }
//        return result;
//    }
//
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        int[] grades = new int[n];
//        for(int grades_i=0; grades_i < n; grades_i++){
//            grades[grades_i] = in.nextInt();
//        }
//        int result[] = solve(grades);
//        for(int i =0; i < result.length; i++){
//            System.out.println(result[i]);
//        }
//
//    }

//    static void minMax(long min, long max, long temp){
//        if(min > temp)
//            min = temp;
//        if(max < temp)
//            max = temp;
//    }
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        long a = in.nextLong();
//        long b = in.nextLong();
//        long c = in.nextLong();
//        long d = in.nextLong();
//        long e = in.nextLong();
//        long max = 0;
//        long min = 0;
//
//        long temp1 = b+c+d+e;
//        long temp2 = a+c+d+e;
//        if(temp1 < temp2){
//            min = temp1;
//            max = temp2;
//        }else{
//            min = temp2;
//            max = temp1;
//        }
//        temp1 = a+b+d+e;
//        minMax(min, max, temp1);
//        temp1 = a+b+c+e;
//        minMax(min, max, temp1);
//        temp1 = a+b+c+d;
//        minMax(min, max, temp1);
//        System.out.println(min + " " + max);
//
//    }
//public static void main(String[] args) {
//        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
//    Scanner in = new Scanner(System.in);
//    int n = in.nextInt();
//    for (int i =0; i < n; i++){
//        long v1 = in.nextLong();
//        long v2 = in.nextLong();
//        long res = v1;
//        while(v1 <= v2){
//            res = res & v1++;
//
//        }
//        System.out.println(res);
//    }
//}

    //    public static void main(String[] args) {
//        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        if(n < 1 || n > 200){
//            return;
//        }
//
//        for (int i =0; i < n; i++){
//            long v1 = in.nextLong();
//            long v2 = in.nextLong();
//            long res = v1;
//            while(v1 <= v2){
//                res = res & v1++;
//
//            }
//            System.out.println(res);
//        }
//    }
    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int t=in.nextInt();
//        while(t-->0){
//            long a=in.nextLong();
//            long b=in.nextLong();
//            long res=a&(a+1);
//            int i=1;
//            while(a+(long)Math.pow(2,i)<=b){
//                res = (a+(long)Math.pow(2,i))&res;
//                ++i;
//            }
//            System.out.println(res&b);
//        }

        int arr[] = new int[10];
        Arrays.fill(arr, -10);
        for (int i = 0; i < arr.length; i++)
        System.out.println(arr[i]);
        ThreadLocal td = new ThreadLocal();

        ConcurrentSkipListMap<String, String> map = new ConcurrentSkipListMap<>();
        map.put("one","1");
        map.put("two","2");
        map.put("three", "3");
        map.put("four","4");
        System.out.println(map.headMap("one"));
        System.out.println(map.floorEntry("two"));

        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE);

        System.out.println(10%20);
    }
}
