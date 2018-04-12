package com.cyborgcity.practice;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Ravi on 28-07-2017.
 */
public class InterpolationSearch {
//    public int Isearch(int a[], int x)
//    {
//        int l=0;
//        int h=a.length;
//        while(l<h)
//        {
//            int i=l+((x-a[l])*(h-l)/(a[h-1]-a[l]));
//            if(a[i]==x) return i;
//            else if(a[i]<x) l=i+1;
//            else h=i;
//        }
//        return -1;
//    }

    // largest value <= key
    // Invariant: A[l] <= key and A[r] > key
    // Boundary: |r - l| = 1
    // Input: A[l .... r-1]
    // Precondition: A[l] <= key <= A[r]
    static int search(int quantity[], int l, int r, int key){
        int m;
        while( l <= r )
        {
            m = l + (r - l)/2;

            if( quantity[m] == key || (quantity[m] < key && key < quantity[m+1] ))
                return m;
            if( quantity[m] < key)
                l = m+1;
            else
                r = m-1;
        }
        return quantity[l];
    }

    static double search(int quantity[], int size, int key, double[] price){
        // Add error checking if key < A[0]
        int j;
        if( key < quantity[0] )
            j = -1;
        else
        {
            if(key > quantity[size])
                j = size;
            else
                j =  search(quantity, 0, size, key);
        }

        if(j >= 0 && quantity[j] == key)
            return price[j];

        int first = 0;
        int second = 0;

        if(j == -1)
        {
            j++;
            while(price[j] == 0.0) {
                j++;
            }
            if(j == size){
                first = j - 1;
                second = j;
            }else{
                first = j;
                second = j+1;
            }
        }
        else
        {
            if(j == quantity.length-1)
            {
                first = quantity.length-2;
                second = quantity.length-1;
            }
            else
            {
                first = j;
                second = j+1;
            }
        }
        double q = Math.abs(quantity[first] - quantity[second]);
        double p = price[first] - price[second];
        double key_First = Math.abs(key - quantity[first]);
        double keyRes = key_First/q;
        double result = price[first] - keyRes*p;
        return Math.round(result * 100.0)/100.0;

    }


    public static void main(String[] args) {
        // TODO Auto-generated method stub
//        Scanner sc=new Scanner(System.in);
//        System.out.println("Enter the number of elements");
//        int n=sc.nextInt();
//        int a[]=new int[n];
//        System.out.println("Enter the elements");
//        for(int i=0;i<n;i++)
//        {
//            a[i]=sc.nextInt();
//        }
//        double ucost[] = new double[n];
//        for(int i=0;i<n;i++)
//        {
//            ucost[i]=sc.nextDouble();
//        }
//        Arrays.sort(a);
//        System.out.println("Enter the element to be searched");
//        int k=sc.nextInt();
//        InterpolationSearch b=new InterpolationSearch();
//        //		int j=b.Isearch(a, k);
//        double j = b.search(a, a.length-1, k, ucost);
//        //		System.out.println("The position of the number is "+(j+1));
//        System.out.println("The position of the number is "+j);


        Scanner in  = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine().trim());
        int m = Integer.parseInt(in.nextLine().trim());

        int[] q = new int[m];
        double[] p= new double[m];
        for (int i =0; i<m; i++){
            q[i] = Integer.parseInt(in.nextLine().trim());
            p[i] = Double.parseDouble(in.nextLine().trim());
        }
        System.out.println(String.valueOf(search(q, q.length - 1, n, p)));
    }

}
