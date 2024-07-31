import java.util.*;
import static org.junit.Assert.*;
import org.junit.Test;

public class AnagramGroups {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> anagrams = new ArrayList<List<String>>();
        
        anagrams.add(new ArrayList<String>());
        anagrams.get(0).add(strs[0]);
        
        if(strs.length == 1) return anagrams;

        for(int i = 1; i < strs.length; i++) {
            boolean temp = true;
            for(int j = 0; j < anagrams.size(); j++) {
                if(isAnagram(strs[i], anagrams.get(j).get(0))) {
                    anagrams.get(j).add(strs[i]);
                    j = anagrams.size();
                    temp = false;
                }
            }
            if(temp) {
                anagrams.add(new ArrayList<String>());
                anagrams.get(anagrams.size() - 1).add(strs[i]);
            }
            
        }
        return anagrams;
    }

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] store = new int[26];

        for (int i = 0; i < s.length(); i++) {
            store[s.charAt(i) - 'a']++;
            store[t.charAt(i) - 'a']--;
        }

        for (int n : store) if (n != 0) return false;

        return true;
    }

    public List<List<String>> solution(String[] strs) {
        Map<String, List<String>> ans = new HashMap<>();

        for (String s : strs) {
            int[] count = new int[26];
            for (char c : s.toCharArray()) {
                count[c - 'a']++;
            }

            String key = Arrays.toString(count);
            if (!ans.containsKey(key)) {
                ans.put(key, new ArrayList<>());
            }

            ans.get(key).add(s);
        }

        return new ArrayList<>(ans.values());
    }

    @Test
    public void test() {
        String[] strs = {"act","pots","tops","cat","stop","hat"};
        List<List<String>> output = Arrays.asList(Arrays.asList("act","cat"), Arrays.asList("pots","tops","stop"), Arrays.asList("hat"));
        assertEquals(groupAnagrams(strs), output);

        String[] strs2 = {"x"};
        List<List<String>> output2 = Arrays.asList(Arrays.asList("x"));
        assertEquals(groupAnagrams(strs2), output2);
    }
}
