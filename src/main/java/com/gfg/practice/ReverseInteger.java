package com.gfg.practice;

import java.util.Scanner;

/**
 * Created by Ravi on 15-03-2018.
 */
public class ReverseInteger {
    static int reverseInt(int num) {

        boolean flag = false;
        if (num < 0)
        {
            flag = true;
            num = -num ;
        }

        int previous_reverse_num = 0, reverse_num = 0;
        while (num != 0)
        {
            int current_digit = num%10;
            reverse_num = (reverse_num*10) + current_digit;

            if ((reverse_num - current_digit)/10 != previous_reverse_num)
            {
                System.out.println("Overflow !!!");
                return 0;
            }
            previous_reverse_num = reverse_num;
            num = num/10;
        }

        return (flag == true)? -reverse_num : reverse_num;

    }

    public static void main(String[] args) {
        System.out.print("Enter a decimal number: ") ;
        Scanner in = new Scanner(System.in);
        int res;
        int _num;
        _num = Integer.parseInt(in.nextLine());

        res = reverseInt(_num);
        System.out.println(res);

    }
}
