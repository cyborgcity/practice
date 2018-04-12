package com.cyborgcity.practice;

import java.util.Scanner;

/**
 * Created by Ravi on 09-08-2017.
 */
public class MatrixRotation {

    static void rotateMatrix(int matrix[][]){
        int n = matrix.length;
        for (int layer = 0; layer < n/2; layer++){
            int first = layer;
            int last = n -1 - layer;
        }

    }
    static void printMatrix(int matrix[][]){
        int n = matrix.length;
        for(int i =0; i<n; i++){
            for(int j =0; j<n; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Dimension :");
        int n = sc.nextInt();
        int matrix[][] = new int[n][n];
        System.out.println("Insert Values : ");
        for(int i =0; i<n; i++){
            for(int j =0; j<n; j++){
                System.out.println("Insert at [" + i + "][" + j + "]");
                matrix[i][j] = sc.nextInt();
            }
        }
        printMatrix(matrix);
    }
}
