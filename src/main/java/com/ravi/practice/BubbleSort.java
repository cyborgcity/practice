package com.ravi.practice;

/**
 * Created by Ravi on 26-09-2017.
 */
public class BubbleSort {

    void sort(int arr[], int n){
        for(int i = 0; i < n-1; i++){
            for(int j = 0; j < n-i-1; j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    void printArray(int arr[]){
        for (int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        int arr[] = {45,89,10,2,1,89,41};
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.sort(arr, arr.length);
        bubbleSort.printArray(arr);
    }
}
