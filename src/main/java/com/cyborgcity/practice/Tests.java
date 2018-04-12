package com.cyborgcity.practice;

import java.util.Hashtable;

/**
 * Created by Ravi on 09-03-2017.
 */
public class Tests {
    static int k =0;
    void permutation(String str){
        permutation(str,"");
    }

    void permutation (String str, String prefix){
        if(str.length() == 0){
            k++;
            System.out.println(k + " -> " +prefix);
        }else {
            for (int i=0; i < str.length() ; i++){
                String rem = str.substring( 0, i) + str.substring(i+1);
//                System.out.println("rem --> " + rem);
                String str1 = prefix + str.charAt(i);
                permutation(rem,prefix + str.charAt(i));
            }
        }
    }
    public static void main(String[] args) {
        Hashtable hashtable = new Hashtable();
        String str = "abcdefg";
//        System.out.println(str.charAt(0));
//        System.out.println(str.substring(0, 1));
//        System.out.println(str.substring(1));
        Tests t = new Tests();
        t.permutation(str);
//        for (int i=0; i < str.length() ; i++){
//
//            System.out.println( i + " -> " + str.substring(0,i) + " -> " + str.substring(i+1));
//
//        }
//        char[] arr = str.toCharArray();
//        for(int i=0; i < arr.length ; i++){
//            System.out.println("------");
//            System.out.println(arr[i]);
//        }
        String s = "TimeIncIndia";
        s.concat(".com");
        s = s.toUpperCase();
        s.replace("INC", "Inc");
        System.out.println(s);

//        String sr = new String(new char[]{'a','p','e'});
        String sr = new String("ape");
        System.out.println(sr);

        byte x = 64;
        int i;
        byte y;
        i = x<<2;
        y = (byte)(x<<2);
        System.out.println(i + " " + y);

        int var1 = 5;
        int var2 = 6;
        if((var2=1) == var1)
            System.out.println(var2);
        else
            System.out.println(+var2);
    }
}
