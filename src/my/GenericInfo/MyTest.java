package my.GenericInfo;


import java.util.*;

public class MyTest {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] arrt = {0, 0, 0, 0, 0};
        System.arraycopy(arr, 2, arrt, 2, 3);
        for (int i : arrt) {
            System.out.println(i);
        }
    }

}
