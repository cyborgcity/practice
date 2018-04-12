package com.cyborgcity.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Ravi on 26-04-2017.
 */
public class SuperStack {
    private static List<Integer> list = new ArrayList<Integer>();


    private static int index = 0;

    public static boolean isEmpty() {
        return index==0;
    }
    public static void push(int i) throws Exception {
        if(index > 100)
            throw new Exception();
        list.add(index, i);
        index++;
    }
    public static int pop() throws Exception{
        if (isEmpty())
            throw new Exception();
        int b = list.remove(index -1);
        index--;
        return b;
    }
    public static void inc(int i, int j) throws Exception{
        if (isEmpty())
            throw new Exception();
//        int count = Math.min(list.size(), i);
        for(int k = 0; k < i; k++){
            int v = list.get(k);
            v += j;
            list.set(k, v);
        }
    }
    public static void printTop(){
        if(isEmpty()){
            System.out.println("EMPTY");
        }else{
            System.out.println(list.get(index-1));
        }
    }

    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner in =  new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 0; i <=n; i++){
            String s = in.nextLine();
            String cmd[] = s.split(" ");
            if(cmd[0].equals("push")){
                push(Integer.parseInt(cmd[1]));
                printTop();
            }
            if(cmd[0].equals("pop")){
                pop();
                printTop();
            }
            if(cmd[0].equals("inc")){
                inc(Integer.parseInt(cmd[1]), Integer.parseInt(cmd[2]));
                printTop();
            }
        }

    }
}
