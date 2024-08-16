import java.util.HashSet;

// https://algorithms.tutorialhorizon.com/colorful-numbers/

public class ColorfulNumbers {
    public static boolean isColorful(int num) {
        HashSet<Integer> set = new HashSet<>();
        String val = String.valueOf(num);
        for(int i = 0; i < val.length(); i++) {
            for(int j = i+1; j <= val.length(); j++) {
                int prod = getProduct(Integer.parseInt(val.substring(i, j)));
                if(set.contains(prod)) return false;
                else set.add(prod);
            }
        }
        return true;
    }

    private static int getProduct(int digits) {
        int prod = 1;
        while(digits > 0) {
            prod *= digits % 10;
            digits = digits / 10;
        }
        return prod;
    }

    public static void start() {
        System.out.println(" 326 Colorful- " + isColorful(326));
        System.out.println(" 3245 Colorful- " + isColorful(3245));
        System.out.println(" 32458 Colorful- " + isColorful(32458));
    }
}
