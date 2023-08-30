import java.util.*;
/**
 * Write a description of class Sorting here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Sorting
{
    
    public void testMethod() {
        int[] test = {0, 8, 4, 5, 6};
        selectionSort(test);
        System.out.println(Arrays.toString(test));
    }
    
    public void bubbleSort(int[] input) {
        for (int j = 0; j < input.length - 1; j++) {
            for (int i = 0; i < input.length - 1; i++) {
                if (input[i] > input[i+1]) {
                    int temp = input[i];
                    input[i] = input[i+1];
                    input[i+1] = temp;
                }
            }
        }
    }
    
    public void selectionSort(int[] input) {
        //int[] sorted = new int[input.length];
        int start = 0;
        for (int j = 0; j < input.length; j++) {
            int min = start;
            for (int i = start; i < input.length; i++) {
                if (input[i] < input[min]) {
                    min = i;
                }
            }
            //System.out.println(Arrays.toString(input));
            int temp = input[min];
            input[min] = input[start];
            input[start] = temp;
            start++;
        }
    }
    
    public void insertionSort(int[] input) {
        
    }
}
