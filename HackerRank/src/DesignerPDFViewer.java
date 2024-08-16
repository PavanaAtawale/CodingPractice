import java.util.*;

//https://www.hackerrank.com/challenges/designer-pdf-viewer/problem

public class DesignerPDFViewer {
    public static int designerPdfViewer(List<Integer> h, String word) {
        // Write your code here
        int max = 0;
        for(int i = 0; i < word.length(); i++) {
            int  n = (int) word.charAt(i);
            n = n - 97;
            if(h.get(n) > max) max = h.get(n);
        }
        return max * word.length();
    }
}
