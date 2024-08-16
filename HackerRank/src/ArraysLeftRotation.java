import java.util.*;

// https://www.hackerrank.com/challenges/ctci-array-left-rotation/problem

public class ArraysLeftRotation {
    public static List<Integer> rotLeft(List<Integer> a, int d) {
        // Write your code here
        List<Integer> list = new ArrayList<Integer>();
        int n = d;
        for(int i = 0; i < a.size(); i++) {
            list.add(a.get(n));
            n++;
            if(n >= a.size()) n = 0;
        }
        return list;
    }

    public static List<Integer> solution(List<Integer> a, int d) {
        for(int i=0;i<d;i++){
            a.add(a.get(0));
            a.remove(0);
        }
        return a;
    }
}
