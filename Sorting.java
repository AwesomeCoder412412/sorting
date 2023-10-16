import java.util.Arrays;
/**
 * Contains 4 sorting algorithims.
 *
 * @author Jack Segil
 * @version 1.0
 */
public class Sorting
{
    
    public static long compsM = 0;
    public static long assignsM = 0;
    
    // Tests whatever sort needs to be tested at the time
    public static void testMethod() {
        int[] test = {1,2};
        
        mergeSort(test);
        System.out.println();
        System.out.println(Arrays.toString(test));
    }
    
    // Sorts the given array in ascending order using bubble sort
    public static void bubbleSort(int[] input) {
        long comps = 0;
        long swaps = 0;
        boolean sorted = true;
        
        for (int i = 0; i < input.length - 1; i++) {
            for (int j = 0; j < input.length - 1; j++) {
                comps++;
                
                if (input[j] > input[j+1]) {
                    int temp = input[j];
                    input[j] = input[j+1];
                    input[j+1] = temp;
                    swaps++;
                    sorted = false;
                }
            }
            if (sorted) {
                return;
            }
        }
        System.out.print(", " + comps + ", " + swaps);
    }
    
    // Sorts the given array in ascending order using selection sort
    public static void selectionSort(int[] input) {
        long comps = 0;
        long swaps = 0;
        
        for (int i = 0; i < input.length; i++) {
            int minIndex = i;
            for (int j = i; j < input.length; j++) {
                comps++;
                if (input[j] < input[minIndex]) {
                    minIndex = j;
                }
            }
            if (i != minIndex) {
                int temp = input[minIndex];
                input[minIndex] = input[i];
                input[i] = temp;
                swaps++;
            }
        }
        System.out.print(", " + comps + ", " + swaps);
    }
    
    // Sorts the given array in ascending order using insertion sort
    public static void insertionSort(int[] input) {
        long comps = 0;
        long swaps = 0;
        
        for (int i = 0; i < input.length; i++) {
            int j = i;
            int temp = input[j];
            comps++;
            while (j > 0 && temp < input[j - 1]) {
                comps++;
                input[j] = input[j - 1];
                swaps++;
                j--;
            }
            input[j] = temp;
            swaps++;
        }
        System.out.print(", " + comps + ", " + (swaps / 3));
    }
    
    // External-facing method for mergeSort()
    public static void mergeSort(int[] input) {
        mergeSort(0, input.length - 1, input);
        System.out.print(", " + compsM + ", " + (assignsM / 3));
    }
    
    // Sorts the given array in ascending order using merge sort
    public static void mergeSort(int beg, int end, int[] input) {
        compsM++;
        if (end - beg == 1) { // base case
            compsM++;
            if (input[beg] > input[end]) {
                assignsM += 3;
                int temp = input[end];
                input[end] = input[beg];
                input[beg] = temp;
            }
        } else if (beg == end) { // base case
            compsM++;
            return;
        } else {          // recursive case
            int mid = (beg + end) / 2;
            mergeSort(beg, mid, input);
            mergeSort(mid + 1, end, input);
            merge(beg, mid, end, input);
        }
    }
    
    // Merges the two partitions of the provided array
    public static void merge(int beg, int mid, int end, int input[]) {
        int[] temp = new int[(end - beg) + 1];
        int leftPos = beg;
        int rightPos = mid + 1;
        int insertPos = 0;
        
        compsM++;
        
        // Runs through both partitions simultaneously.
        while (leftPos <= mid && rightPos <= end) {
            compsM++;
            compsM++;
            
            if (input[leftPos] < input[rightPos]) {
                temp[insertPos] = input[leftPos];
                assignsM++;
                insertPos++;
                leftPos++;
            } else {
                temp[insertPos] = input[rightPos];
                assignsM++;
                insertPos++;
                rightPos++;
            }
        }
        compsM++;
        
        // Finishes the 1st partition if the 2nd partition finished first.
        while (leftPos <= mid) {
            compsM++;
            assignsM++;
            temp[insertPos] = input[leftPos];
            insertPos++;
            leftPos++;
        }
        compsM++;
        
        // Finishes the 2nd partition if the 1st partition finished first.
        while (rightPos <= end) {
            compsM++;
            assignsM++;
            temp[insertPos] = input[rightPos];
            insertPos++;
            rightPos++;
        }
        
        for (int i = 0; i < temp.length; i++) {
            input[i + beg] = temp[i];
            assignsM++;
        }
    }
}
