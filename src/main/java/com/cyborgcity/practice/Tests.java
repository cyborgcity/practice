package com.cyborgcity.practice;

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
        Tests t = new Tests();
        t.permutation("abcdefg");
    }
}
