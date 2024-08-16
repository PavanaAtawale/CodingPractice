import java.util.*;
import static org.junit.Assert.*;
import org.junit.Test;

public class ValidSudoko {
    public boolean isValidSudoku(char[][] board) {
        boolean row = true;
        HashSet<Character> nums = new HashSet<Character>();
        char c;
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                c = board[i][j];
                if(nums.contains(c) && c != '.') row = false;
                else nums.add(c);
            }
            nums.clear();
        }

        boolean col = true;
        nums.clear();
        for(int j = 0; j < 9; j++) {
            for(int i = 0; i < 9; i++) {
                c = board[i][j];
                if(nums.contains(c) && c != '.') col = false;
                else nums.add(c);
            }
            nums.clear();
        }

        boolean boxes = true;
        nums.clear();
        int r = -3;
        int co = 0;
        for(int k = 0; k < 9; k++) {
            if(k % 3 == 0) {
                r += 3;
                co = 0;
            } else co += 3;
            for(int i = r; i < r+3 ; i++) {
                for(int j = co; j < co+3; j++) {
                    c = board[i][j];
                    if(nums.contains(c) && c != '.') row = false;
                    else nums.add(c);
                }
            }
            nums.clear();
            
        }


        return row && col && boxes;
    }

    @Test
    public void test() {
        char[][] input = {{'1', '2', '.', '.', '3', '.', '.', '.', '.'},
        {'4', '.', '.', '5', '.', '.', '.', '.', '.'},
        {'.', '9', '8', '.', '.', '.', '.', '.', '3'},
        {'5', '.', '.', '.', '6', '.' , '.', '.', '4'},
        {'.', '.', '.', '8', '.', '3', '.', '.', '5'},
        {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
        {'.', '.', '.', '.', '.', '.', '2', '.', '.'},
        {'.', '.', '.', '4', '1', '9', '.', '.', '8'},
        {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        assertEquals(isValidSudoku(input), true);

        char[][] input2 = {{'1', '2', '.', '.', '3', '.', '.', '.', '.'},
        {'4', '.', '.', '5', '.', '.', '.', '.', '.'},
        {'.', '9', '1', '.', '.', '.', '.', '.', '3'},
        {'5', '.', '.', '.', '6', '.' , '.', '.', '4'},
        {'.', '.', '.', '8', '.', '3', '.', '.', '5'},
        {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
        {'.', '.', '.', '.', '.', '.', '2', '.', '.'},
        {'.', '.', '.', '4', '1', '9', '.', '.', '8'},
        {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        assertEquals(isValidSudoku(input2), false);
    }
}
