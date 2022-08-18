package org.example.array;

public class Test03 {
    public static void main(String[] args) {
        int arr[] = {8,9,5,2,1,3,4,6};
        sort(arr);
    }
    
    // 排序，从大到小
    public static void sort(int[] a) {
        for (int i = a.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (a[j] > a[j + 1]) {
                    int temp;
                    temp = a[j];
                    a[j] = a[j + 1];
                    a[j+1] = temp;
                }
            }
        }
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }
    // 交换
    public static void swap(int[] arr,int start,int end) {
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }
}
