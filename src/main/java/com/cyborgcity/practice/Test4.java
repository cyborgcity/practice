package com.cyborgcity.practice;

/**
 * Created by Ravi on 30-06-2017.
 */
public final class Test4 {
    class Inner{
        void test(){
            if(Test4.this.flag){
                sample();
            }
        }
    }
    private boolean flag = true;
    public void sample(){
        System.out.println("Sample");
    }
    public Test4(){
        (new Inner()).test();
    }

    public static void main(String[] args) {
        new Test4();

        String s1 = "abc";
        String s2 = "def";
        String s3 = s1.concat(s2.toUpperCase());
        System.out.println(s1+s2+s3);

        System.out.println(Character.getNumericValue('a'));
        System.out.println(Character.getNumericValue('z'));
        System.out.println(Character.getNumericValue('A'));
        System.out.println(Character.getNumericValue('Z'));

        int a = 'a';
        int z = 'z';
        int A = 'A';
        int Z = 'Z';
        System.out.println(a);
        System.out.println(z);
        System.out.println(A);
        System.out.println(Z);
    }
}
