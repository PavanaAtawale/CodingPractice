// https://www.hackerrank.com/challenges/the-quickest-way-up/problem
//Note: Honestly I did look up an algo for this

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

public class SnakesLadders {
    public static void start() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<List<Integer>> ladders = new ArrayList<>();

                IntStream.range(0, n).forEach(i -> {
                    try {
                        ladders.add(
                            Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                        );
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });

                int m = Integer.parseInt(bufferedReader.readLine().trim());

                List<List<Integer>> snakes = new ArrayList<>();

                IntStream.range(0, m).forEach(i -> {
                    try {
                        snakes.add(
                            Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                        );
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });

                int result = quickestWayUp(ladders, snakes);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }

    /*
     * Complete the 'quickestWayUp' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. 2D_INTEGER_ARRAY ladders
     *  2. 2D_INTEGER_ARRAY snakes
     */

     public static int quickestWayUp(List<List<Integer>> ladders, List<List<Integer>> snakes) {
        // Write your code here
        int[] board = new int[101];
        for(List<Integer> ladder: ladders) {
            board[ladder.get(0)] = ladder.get(1) - ladder.get(0);
        }
        for(List<Integer> snake: snakes) {
            board[snake.get(0)] = snake.get(1) - snake.get(0);
        }
        
        boolean[] visited = new boolean[101];
        visited[1] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{1, 0});
        
        while(queue.size() != 0) {
            int curr = queue.peek()[0];
            int moves = queue.peek()[1];
            queue.remove();
            
            for(int roll = 1; roll <= 6; roll++) {
                int next = curr + roll;
                if(next <= 100) {
                    next += board[next];
                    if(next == 100) return moves+1;
                }
                if(!visited[next]) {
                    visited[next] = true;
                    queue.add(new int[]{next, moves+1});
                }
            }
        }
        
        return -1;
    }
}

