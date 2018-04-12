package com.cyborgcity.practice;

/**
 * Created by Ravi on 21-09-2017.
 */
public class MergeSort {

    static int arr[];
    static int tempMerArr[];

    static void sort(int inputArr[]){
        arr = inputArr;
        tempMerArr = new int[inputArr.length];
        sort(0, arr.length - 1);
    }

    static void sort(int low, int high){
        if(low < high) {
            int mid = low + (high - low) / 2;
            sort(low, mid);
            sort(mid + 1, high);

            merge(low, mid, high);
        }
    }

    static void merge(int low, int mid, int high){
        for(int i = low; i <= high; i++){
            tempMerArr[i] = arr[i];
        }
        int i = low;
        int j = mid + 1;
        int k = low;
        while (i <= mid && j <= high){
            if(tempMerArr[i] <= tempMerArr[j]){
                arr[k] = tempMerArr[i];
                i++;
            }else{
                arr[k] = tempMerArr[j];
                j++;
            }
            k++;
        }
        while (i <= mid){
            arr[k] = tempMerArr[i];
            i++;
            k++;
        }
    }

    public static void main(String[] args) {
        int inputArr[] = {12,45,7,5,85,14,55,2};
        sort(inputArr);
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
    }
}
