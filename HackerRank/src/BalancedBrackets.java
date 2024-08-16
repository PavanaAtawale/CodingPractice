import java.io.*;
import java.util.*;
import java.util.stream.*;

// https://www.hackerrank.com/challenges/balanced-brackets/problem

public class BalancedBrackets {
    public static void start() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String s = bufferedReader.readLine();

                String result = isBalanced(s);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }

    /*
     * Complete the 'isBalanced' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

     public static String isBalanced(String s) {
        // Write your code here
            Stack<Character> stack = new Stack<>();
            for(int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if(c == '{' || c == '(' || c == '[') stack.push(c);
                else {
                    if(stack.isEmpty()) return "NO";
                    if(c == '}' && stack.peek() == '{') stack.pop();
                    else if(c == ')' && stack.peek() == '(') stack.pop();
                    else if(c == ']' && stack.peek() == '[') stack.pop();
                    else return "NO";
                }
            }
            if(stack.isEmpty()) return "YES";
            return "NO";
        }
}
