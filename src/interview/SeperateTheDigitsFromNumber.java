package interview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class SeperateTheDigitsFromNumber {

    public static void main(String... a) {
        int num = 26;
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            System.out.print(num % 10 + " ");
            sb.append(num%10);
            num = num/10;
        }
        System.out.println(Integer.valueOf(sb.toString()));

    }
}
