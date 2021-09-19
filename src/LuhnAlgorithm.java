import java.util.ArrayList;
import java.util.List;

public class LuhnAlgorithm {
    private final StringBuilder credCardDigits;

    public LuhnAlgorithm(String credCardDigits){
        this.credCardDigits = new StringBuilder(credCardDigits).reverse();
    }

    public LuhnAlgorithm(long credCardDigits){
        this.credCardDigits = new StringBuilder(String.valueOf(credCardDigits)).reverse();
    }

    public boolean isValid() {
        List<String> digitsList = new ArrayList<>();
        for (int i = 0; i < credCardDigits.length(); i++) {
            int digit = Integer.parseInt(credCardDigits.substring(i, i + 1));
            if (i % 2 == 1) {
                digitsList.add(String.valueOf(digit * 2));
            } else {
                digitsList.add(credCardDigits.substring(i, i + 1));
            }
            String d = digitsList.get(i);
            if (d.length() >= 2) {
                digitsList.remove(i);
                for (int j = 0; j < d.length(); j++) {
                    digitsList.add(d.substring(j, j + 1));
                }
            }
        }

        int total = 0;
        for (String digits : digitsList) {
            int d = Integer.parseInt(digits);
            total += d;
        }
        return total % 10 == 0;
    }
}
