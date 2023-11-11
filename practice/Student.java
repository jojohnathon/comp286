package practice;

import java.util.Arrays;

public class Student {
    public static void doubleSelectionSort(int[] list) {

        for (int i = 0; i < list.length; i++) {
            int minIndex = getMinIndex(list, i);
            int maxIndex = getMaxIndex(list, i);
            
            if (minIndex != i) {
                swap(list, i, minIndex);
            } else if (maxIndex != i) {
                swap(list, i, maxIndex);
            }
        }
    }

    public static void selectionSort(int[] list) {
        for (int i = 0; i < list.length; i++) {
            int minIndex = getMinIndex(list, i);
            if (minIndex != i) {
                swap(list, i, minIndex);
            }
        }
    }

    private static int getMinIndex(int[] list, int startIndex){
        int minIndex = startIndex;
        for (int i=startIndex; i<list.length; i++ ) {
            if (list[i] < list[minIndex])
                minIndex = i;
        }
        return minIndex;
    }

    private static int getMaxIndex(int[] list, int startIndex){
        int maxIndex = startIndex;
        for (int i=startIndex; i<list.length; i++ ) {
            if (list[i] > list[maxIndex])
                maxIndex = i;
        }
        return maxIndex;
    }

    public static void swap (int[] list, int i , int j) {
        int temp = list[i];
        list[i] = list[j];
        list[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 0, -9, 10};
        System.out.println(Arrays.toString(arr));
        doubleSelectionSort(arr);
        System.out.println("double selection sorted: " + Arrays.toString(arr));
        selectionSort(arr);
        System.out.println("selection sort: " + Arrays.toString(arr));
    }
}

