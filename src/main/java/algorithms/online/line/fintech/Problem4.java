package algorithms.online.line.fintech;

import java.math.BigDecimal;
import java.util.Scanner;

public class Problem4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(calc(s).stripTrailingZeros().toPlainString());
    }

    public static BigDecimal calc(String input) {
        int idx;
        idx = input.indexOf('+');

        if (idx != -1) {
            return calc(input.substring(0, idx)).add(calc(input.substring(idx + 1)));
        } else {
            idx = input.indexOf('-');
            if (idx != -1) {
                return calc(input.substring(0, idx)).subtract(calc(input.substring(idx + 1)));
            }
            else {
                idx = input.indexOf('*');
                if (idx != -1) {
                    return calc(input.substring(0, idx)).multiply(calc(input.substring(idx + 1))) ;
                }
                else {
                    idx = input.indexOf('/');
                    if (idx != -1) {
                        return calc(input.substring(0, idx)).divide(calc(input.substring(idx + 1)));
                    }
                }
            }
        }

        String data = input.trim();
        if (data.isEmpty()) {
            return BigDecimal.valueOf(0);
        }

        return BigDecimal.valueOf(Double.parseDouble(data));
    }
}
