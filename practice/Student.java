package practice;

public class Student {
    public static void doubleSelectionSort(int[] list) {
        int max = list[0];
        int min = list[0];
        for (int i = 0; i < list.length; i++) {
            if (i > max) {
                max = list[i];
            } else if (i < min) {
                min = list[i];
            }
            if (min != i) {
                swap(list, i, min);
            }
        }
    }

    public static void swap (int[] list, int i , int j) {
        int temp = list[i];
        list[i] = list[j];
        list[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 0, -12, 5, 6, 7};
        System.out.println(arr.toString());
        doubleSelectionSort(arr);
        System.out.println("sorted: " + arr.toString());
    }
}

