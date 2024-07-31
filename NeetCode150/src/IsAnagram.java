import java.util.*;
import static org.junit.Assert.*;
import org.junit.Test;

public class IsAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        HashMap<Character, Integer> s_chars = new HashMap<Character, Integer>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(s_chars.get(c) != null) s_chars.replace(c, s_chars.get(c) + 1);
            else s_chars.put(c, 1);
        }

        for(int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if(s_chars.get(c) != null) {
                if(s_chars.get(c) == 0) return false;
                s_chars.replace(c, s_chars.get(c) - 1);
            }
            else return false;
        }

        return true;
    }

    public boolean solution(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] store = new int[26];

        for (int i = 0; i < s.length(); i++) {
            store[s.charAt(i) - 'a']++;
            store[t.charAt(i) - 'a']--;
        }

        for (int n : store) if (n != 0) return false;

        return true;
    }

    @Test
    public void test() {
        assertEquals(isAnagram("racecar", "carrace"), true);
        assertEquals(isAnagram("jar", "jam"), false);
    }
    
}
