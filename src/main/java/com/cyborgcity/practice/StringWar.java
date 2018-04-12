package com.cyborgcity.practice;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Ravi on 26-04-2017.
 */
public class StringWar {

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        String s1 = in.next();
        String s2 = in.next();
        if(s1.length() != s2.length()){
            throw new Exception();
        }
        int n = s1.length();
        int s1Arr[] = new int[n];
        int s2Arr[] = new int[n];
//        for(int i =0; i < n; i++){
//            s1Arr[i] = 0;
//            s2Arr[i] = 0;
//        }
        for(int i =0; i < n; i++){
            s1Arr[i] = s1.charAt(i);
            System.out.println(s1Arr[i]);
            s2Arr[i] = s2.charAt(i);
            System.out.println(s2Arr[i]);
        }
        Arrays.sort(s1Arr);
        Arrays.sort(s2Arr);
        boolean won = false;
        for (int i =0; i < n; i++){
            if(s1Arr[i] >= s2Arr[i]){
                won = true;
            }else{
                won = false;
                break;
            }
        }
        if(!won){
            for (int i =0; i < n; i++){
                if(s2Arr[i] >= s1Arr[i]){
                    won = true;
                }else{
                    won = false;
                    break;
                }
            }
        }
        System.out.println(won);
    }

}
