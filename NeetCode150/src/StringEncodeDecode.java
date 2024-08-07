import java.util.*;
import static org.junit.Assert.*;
import org.junit.Test;

public class StringEncodeDecode {
    public String encode(List<String> strs) {
        String str = "";
        String s = "";
        for(int i = 0; i < strs.size(); i++) {
            s += strs.get(i);
            str += s;
            char c = (char) s.length();
            s = "";
            str += c;
        }
        System.out.println(str);
        return str;
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList();
        int prev = 0;
        for(int i = 0; i < str.length(); i++) {
            char c = (char) (i - prev);
            if(str.charAt(i) == c) {
                result.add(str.substring(prev, i));
                prev = i+1;
            }
        }
        return result;
    }

    public String encode_solution(List<String> strs) {
        StringBuilder encodedString = new StringBuilder();
        for (String str : strs) {
            encodedString.append(str.length()).append("#").append(str);
        }
        return encodedString.toString();
    }

    public List<String> decode_solution(String str) {
        List<String> list = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            int j = i;
            while (str.charAt(j) != '#') j++;

            int length = Integer.valueOf(str.substring(i, j));
            i = j + 1 + length;
            list.add(str.substring(j + 1, i));
        }
        return list;
    }

    @Test
    public void test() {
        List<String> input = Arrays.asList("neet","code","love","you");
        assertEquals(decode(encode(input)), input);

        List<String> input2 = Arrays.asList("we","say",":","yes");
        assertEquals(decode(encode(input2)), input2);
    }
}
