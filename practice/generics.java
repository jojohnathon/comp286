package practice;

import java.util.Arrays;

public class generics {
    
    public static <T> void printArray(T[] input) {
        for (T element : input) {
            System.out.println(element);
        }
    }
}
