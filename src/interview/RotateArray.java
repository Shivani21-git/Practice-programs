package interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
// you can refer this but not necessary https://www.geeksforgeeks.org/array-rotation/
// Rotate an Array by given k number
public class RotateArray {
    static int[] array = new int[]{22,23,24,25,26,27};

    /*   6 1 2 3 4 5    5 6 1 2 3 4    4 5 6 1 2 3
       rotation = 1     rotation = 2    rotation = 3
       L-2              L-3            L-4
       1 + 5 = 6        1 + 4 = 5      1 + 3 = 4

       2 - 1 = 1        2 + 4 = 6      2 + 3 = 5

       3 - 1 = 2        3 - 2 = 1      3 + 3 = 6

       4 - 1 = 3        4 - 2 = 2      4 - 3 = 1

       5 - 1 = 4        5 - 2 = 3      5 - 3 = 2

       6 - 1 = 5        6 - 2 = 4      6 - 3 = 3
   */
    public static void main(String... arg) {
        //rotateByPattern();
        int num =2;
        while(num > 0) {
            int i = 0;
            int temp = array[0];
            for (i = 0; i < array.length - 1; i++) {
                array[i] = array[i + 1];
            }
            array[i] = temp;
            Arrays.stream(array).forEach(System.out::print);
            System.out
                    .println();
            num--;
        }
    }

}
