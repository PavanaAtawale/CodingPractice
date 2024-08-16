import java.util.*;

//https://www.hackerrank.com/challenges/a-very-big-sum/problem

public class VeryBigSum {

    /*
     * Complete the 'aVeryBigSum' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts LONG_INTEGER_ARRAY ar as parameter.
     */

    public static long aVeryBigSum(List<Long> ar) {
    // Write your code here
    long result = 0;
    for(int i = 0; i < ar.size(); i++) {
        result += ar.get(i);
    }
    return result;
    }

}
