package com.cyborgcity.practice;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by Ravi on 19-09-2017.
 */
public class SumOfKSubArray {

    static int getSumKSubArray(int arr[], int n, int k){
        int sum = 0;
        Deque<Integer> s = new LinkedList<>(); //stores min
        Deque<Integer> g = new LinkedList<>(); // stores max

        int i = 0;
        for (i = 0; i < k; i++){
           while (!s.isEmpty() && arr[s.peekLast()] >= arr[i] )
               s.removeLast();
           while (!g.isEmpty() && arr[g.peekLast()] <= arr[i]){
               g.removeLast();
           }
            s.addLast(i);
            g.addLast(i);
        }
        for( ; i < n; i++){
            sum += arr[s.peekFirst()] + arr[g.peekFirst()];
            while (!s.isEmpty() && s.peekFirst() < i-k){
                s.removeFirst();
            }
            while (!g.isEmpty() && g.peekFirst() < i-k){
                g.removeFirst();
            }
            while (!s.isEmpty() && arr[s.peekLast()] >= arr[i] )
                s.removeLast();
            while (!g.isEmpty() && arr[g.peekLast()] <= arr[i]){
                g.removeLast();
            }
            g.addLast(i);
            s.addLast(i);
        }
        sum += arr[s.peekFirst()] + arr[g.peekFirst()];
        return sum;
    }

    public static void main(String[] args) {
        int arr[] = {2, 5, -1, 7, -3, -1, -2} ;
        System.out.println(getSumKSubArray(arr, arr.length, 3));
    }
}
