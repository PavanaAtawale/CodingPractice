import java.util.*;
import static org.junit.Assert.*;
import org.junit.Test;

public class ProductOfArray {
    public int[] productExceptSelf(int[] nums) {
        int prod = 1;
        int zero = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) zero++;
            else prod *= nums[i];
        }
        if(zero == nums.length) prod = 0;

        int[] output = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0 && zero == 1) output[i] = prod;  
            else if(zero != 0) output[i] = 0;
            else output[i] = prod / nums[i];
        }

        return output;
    }

    public int[] solution(int[] nums) {
        int[] arr = new int[nums.length];
        int right = 1, left = 1;
        for (int i = 0; i < nums.length; i++) {
            arr[i] = left;
            left *= nums[i];
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            arr[i] *= right;
            right *= nums[i];
        }
        return arr;
    }

    @Test
    public void test() {
        int[] input = {1, 2, 4, 6};
        int[] output = {48, 24, 12, 8};
        assertArrayEquals(productExceptSelf(input), output);

        int[] input2 = {-1, 0, 1, 2, 3};
        int[] output2 = {0, -6, 0, 0, 0};
        assertArrayEquals(productExceptSelf(input2), output2);

        int[] input3 = {0, 8, 0};
        int[] output3 = {0, 0, 0};
        assertArrayEquals(productExceptSelf(input3), output3);
    }
}
