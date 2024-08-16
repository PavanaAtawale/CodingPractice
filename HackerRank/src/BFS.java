import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

// https://www.hackerrank.com/challenges/bfsshortreach/problem
//Note: failed 6/8 test cases :(

public class BFS {
    public static void start() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int n = Integer.parseInt(firstMultipleInput[0]);

                int m = Integer.parseInt(firstMultipleInput[1]);

                List<List<Integer>> edges = new ArrayList<>();

                IntStream.range(0, m).forEach(i -> {
                    try {
                        edges.add(
                            Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                        );
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });

                int s = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> result = bfs(n, m, edges, s);

                bufferedWriter.write(
                    result.stream()
                        .map(Object::toString)
                        .collect(joining(" "))
                    + "\n"
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }

    /*
     * Complete the 'bfs' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER m
     *  3. 2D_INTEGER_ARRAY edges
     *  4. INTEGER s
     */

     public static List<Integer> bfs(int n, int m, List<List<Integer>> edges, int s) {
        // Write your code here
            ArrayList<Integer> nodes = new ArrayList<Integer>();
            for(int i = 1; i <= n; i++) {
                System.out.println("index " + i);
                if(i != s) nodes.add(i);
            }
            
            ArrayList<Integer> dist = new ArrayList<Integer>();
            for(int i = 0; i < n-1; i++) {
                dist.add(0);
            }
            
            System.out.println(nodes);
            System.out.println(edges);
            for(int i = 0; i < edges.size(); i++) {
                int begin = edges.get(i).get(0);
                int end = edges.get(i).get(1);
                // System.out.println(begin + " , " + end);
                int ind = nodes.indexOf(end);
                if(ind == -1) continue;
                int d;
                if(begin == s) d = 0;
                else d = dist.get(nodes.indexOf(begin));
                dist.set(ind, d+6);
            }
            for(int i = 0; i < n-1; i++) {
                if(dist.get(i) == 0) dist.set(i, -1);
            }
            System.out.println(dist);
            return dist;
        }
}
