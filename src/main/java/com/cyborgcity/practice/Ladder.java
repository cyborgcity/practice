package com.cyborgcity.practice;

import java.util.Scanner;

/**
 * Created by Ravi on 11-04-2017.
 */
public class Ladder {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int num  = Integer.parseInt(sc.nextLine());
        for(int j=0;j<num;j++){
            for(int i=1;i<=num;i++){
                System.out.print(i<num-j?" ":"#");
            }
            System.out.println("");
        }



    }
}