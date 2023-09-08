import java.util.*;
/**
 * Write a description of class Sorting here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Sorting
{
    
    public static long compsM = 0;
    public static long swapsM = 0;
    
    public static void testMethod() {
        int[] test = {9, 8, 4, 5, 6};
        insertionSort(test);
        System.out.println(Arrays.toString(test));
    }
    
    public static void bubbleSort(int[] input) {
        long comps = 0;
        long swaps = 0;
        for (int j = 0; j < input.length - 1; j++) {
            for (int i = 0; i < input.length - 1; i++) {
                comps++;
                if (input[i] > input[i+1]) {
                    int temp = input[i];
                    input[i] = input[i+1];
                    input[i+1] = temp;
                    swaps++;
                }
            }
        }
        System.out.print(", " + comps + ", " + swaps);
    }
    
    public static void selectionSort(int[] input) {
        long comps = 0;
        long swaps = 0;
        int start = 0;
        for (int j = 0; j < input.length; j++) {
            int min = start;
            for (int i = start; i < input.length; i++) {
                comps++;
                if (input[i] < input[min]) {
                    min = i;
                }
            }
            //System.out.println(Arrays.toString(input));
            int temp = input[min];
            input[min] = input[start];
            input[start] = temp;
            swaps++;
            start++;
        }
        System.out.print(", " + comps + ", " + swaps);
    }
    
    public static void insertionSort(int[] input) {
        long comps = 0;
        long swaps = 0;
        for (int i = 1; i < input.length; i++) {
            int j = i - 1;
            int temp = input[i];
            comps++;
            while (j >= 0 && temp < input[j]) {
                comps++;
                input[j+1] = input[j];
                swaps++;
                j--;
            }
            input[j+1] = temp;
            swaps++;
        }
        System.out.print(", " + comps + ", " + (swaps / 3));
    }
    
    public static void mergeSort(int[] input) {
        mergeSort(0, input.length - 1, input);
        System.out.print(", " + compsM + ", " + (swapsM / 3));
    }
    
    public static void mergeSort(int beg, int end, int[] input) {
        
        if (end == beg) {
            return;
        }
        else {
            int mid = (end + beg) / 2;
            mergeSort(beg, mid, input);
            mergeSort(mid + 1, end, input);
            merge(beg, mid, end, input);
        }
    }
    
    public static void merge(int beg, int mid, int end, int input[]) {
        int[] temp = new int[(end - beg) + 1];
        int firstPos = beg;
        int secondPos = mid + 1;
        int insertPos = 0;
        compsM++;
        while (firstPos <= mid && secondPos <= end) {
            compsM++;
            compsM++;
            if (input[firstPos] < input[secondPos]) {
                temp[insertPos] = input[firstPos];
                swapsM++;
                insertPos++;
                firstPos++;
            } else {
                temp[insertPos] = input[secondPos];
                swapsM++;
                insertPos++;
                secondPos++;
            }
        }
        compsM++;
        while (firstPos <= mid) {
            compsM++;
            swapsM++;
            temp[insertPos] = input[firstPos];
            insertPos++;
            firstPos++;
        }
        compsM++;
        while (secondPos <= end) {
            compsM++;
            swapsM++;
            temp[insertPos] = input[secondPos];
            insertPos++;
            secondPos++;
        }
        int tempIndex = 0;
        for (int i = beg; i <= end; i++) {
            input[i] = temp[tempIndex];
            swapsM++;
            tempIndex++;
        }
    }
}
