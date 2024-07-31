import java.util.*;
import static org.junit.Assert.*;
import org.junit.Test;

public class TwoIntegerSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> indices = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++) {
            if(indices.get(target - nums[i]) != null)
                return new int[]{indices.get(target - nums[i]), i};
            else {
                indices.put(nums[i], i);
            }
        }

        return null;
    }

    public int[] solution(int[] nums, int target) {
        HashMap<Integer, Integer> prevMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int diff = target - num;

            if (prevMap.containsKey(diff)) {
                return new int[] { prevMap.get(diff), i };
            }

            prevMap.put(num, i);
        }

        return new int[] {};
    }

    @Test
    public void test() {
        int[] nums = {3,4,5,6};
        int[] output = {0, 1};
        assertArrayEquals(twoSum(nums, 7), output);
        int[] nums2 = {4,5,6};
        int[] output2 = {0, 2};
        assertArrayEquals(twoSum(nums2, 10), output2);
    }
}
