import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

// https://www.hackerrank.com/challenges/insertionsort1/problem
// https://www.hackerrank.com/challenges/insertionsort2/problem

public class InsertionSort {
    public static void start() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        insertionSort1(n, arr);

        bufferedReader.close();
    }

    /*
     * Complete the 'insertionSort1' function below.
     *
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER_ARRAY arr
     */

     public static void insertionSort1(int n, List<Integer> arr) {
        // Write your code here
            int i = arr.size() - 1;
            int val = arr.get(i);
            i--; 
            while(i >= 0 && arr.get(i) > val) {
                arr.set(i+1, arr.get(i));
                i--;
                printArr(arr);
            }
            arr.set(i+1, val);
            printArr(arr);
        }

        /*
        * Complete the 'insertionSort2' function below.
        *
        * The function accepts following parameters:
        *  1. INTEGER n
        *  2. INTEGER_ARRAY arr
        */

        public static void insertionSort2(int size, List<Integer> arr) {
        // Write your code here
            int n = 0;
            while (n < size-1) {
                int i = n + 1;
                int val = arr.get(i);
                i--; 
                while(i >= 0 && arr.get(i) > val) {
                    arr.set(i+1, arr.get(i));
                    i--;
                }
                arr.set(i+1, val);
                printArr(arr);
                n++;
            }
        }
        
        private static void printArr(List<Integer> arr) {
            for(int i = 0; i < arr.size()-1; i++) {
                System.out.print(String.valueOf(arr.get(i)) + " ");
            }
            System.out.println(arr.get(arr.size()-1));
        }
}

