import java.util.*;
import static org.junit.Assert.*;
import org.junit.Test;

public class TopKElementsInList {
    public int[] topKFrequent(int[] nums, int k) {
        List<Integer> vals = new ArrayList<Integer>();
        List<Integer> count = new ArrayList<Integer>();

        for(int i = 0; i < nums.length; i++) {
            int n = nums[i];
            if(vals.contains(n)) count.set(vals.indexOf(n), count.get(vals.indexOf(n))+1);
            else {
                vals.add(n);
                count.add(1);
            }
        }

        int[] arr = new int[k];

        for(int i = 0; i < k; i++) {
            int index = count.indexOf(Collections.max(count));
            arr[i] = vals.get(index);
            vals.remove(index);
            count.remove(index);
        }

        return arr;
    }

    public int[] solution(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        List<Integer>[] freq = new List[nums.length + 1];

        for (int i = 0; i < freq.length; i++) {
            freq[i] = new ArrayList<>();
        }

        for (int n : nums) {
            count.put(n, count.getOrDefault(n, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            freq[entry.getValue()].add(entry.getKey());
        }

        int[] res = new int[k];
        int index = 0;
        for (int i = freq.length - 1; i > 0 && index < k; i--) {
            for (int n : freq[i]) {
                res[index++] = n;
                if (index == k) {
                    return res;
                }
            }
        }
        return res;
    }

    @Test
    public void test() {
        int[] nums = {1,2,2,3,3,3};
        int[] output = {3, 2};
        assertArrayEquals(topKFrequent(nums, 2), output);

        int[] nums2 = {7 ,7};
        int[] output2 = {7};
        assertArrayEquals(topKFrequent(nums2, 1), output2);
    }
}
