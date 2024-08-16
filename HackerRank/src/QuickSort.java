import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


public class QuickSort {
    public static void start() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = quickSort1(arr);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining(" "))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }

    /*
     * Complete the 'quickSort' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

     public static List<Integer> quickSort1(List<Integer> arr) {
    // Write your code here
        int p = arr.get(0);
        ArrayList<Integer> left = new ArrayList<Integer>();
        ArrayList<Integer> right = new ArrayList<Integer>();
        for(int i = 1; i < arr.size(); i++) {
            int n = arr.get(i);
            if(n < p) left.add(n);
            else right.add(n);
        }
        left.add(p);
        left.addAll(right);
        return left;
    }
    
    private static void printArr(List<Integer> arr) {
        for(int i = 0; i < arr.size()-1; i++) {
            System.out.print(String.valueOf(arr.get(i)) + " ");
        }
        System.out.println(arr.get(arr.size()-1));
    }

    public static int partition(List<Integer> list, int begin, int end) {
        int p = begin;
        int pivot = list.get(begin);
        for(int i = p+1; i < end+1; i++) {
            if(list.get(i) < pivot) {
                list.add(p, list.get(i));
                list.remove(i+1);
                p++;
            }
        }
        return p;
    }

    public static void quickSort2(List<Integer> list, int begin, int end) {
        if(begin >= end) return;
        int p = partition(list, begin, end);
        quickSort2(list, begin, p - 1);
        quickSort2(list, p + 1, end);
        printArray(list, begin, end);
    }

    static void printArray(List<Integer> list, int begin, int end) {
        for (int i = begin; i <= end; i++)
            System.out.print(list.get(i) + " ");
        System.out.println("");
    }
}
