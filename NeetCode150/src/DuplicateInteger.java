import java.util.*;
import static org.junit.Assert.*;
import org.junit.Test;

public class DuplicateInteger {
    public boolean hasDuplicate(int[] nums) {
        HashSet<Integer> hash = new HashSet<>();

        for(int i = 0; i < nums.length; i++) {
            if(hash.contains(nums[i])) return true;
            else hash.add(nums[i]);
        }

        return false;
    }

    public boolean solution(int[] nums) {
        Set<Integer> uniques = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (uniques.contains(nums[i])) {
                return true;
            }
            uniques.add(nums[i]);
        }
        return false;
    }

    @Test
    public void test() {
        int[] nums = {1,2,3,3};
        assertEquals(hasDuplicate(nums), true);
        
    }
}
