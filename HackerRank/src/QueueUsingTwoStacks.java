import java.io.*;
import java.util.*;
import java.util.stream.*;

// https://www.hackerrank.com/challenges/queue-using-two-stacks/problem

public class QueueUsingTwoStacks {

    public static void start() throws IOException{
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());
        
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
                
        IntStream.range(0, t).forEach(tItr -> {
            try {
                String s = bufferedReader.readLine();
                s = s.trim();
                String[] splitStr = s.split("\\s+");
                int type = Integer.parseInt(splitStr[0]);
                
                
                
                if(type == 1) {
                    s1.push(Integer.parseInt(splitStr[1]));
                } else {
                    if(s2.isEmpty()) {
                        while(!s1.isEmpty()) s2.push(s1.pop());
                    }
                    if(type == 2) s2.pop();
                    else {
                        bufferedWriter.write(String.valueOf(s2.peek()));
                        bufferedWriter.newLine();
                    }
                }

                
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
