package interview;

import java.util.HashMap;

/* You have a given array of special integers if that integer can be formed by calculating the sum of a number and its reverse.
Find how many integers are special in the arrays

INPUT : {22,121}

OUTPUT:  2

Explanation :  22= 11+11  , 121= 29+92

 */
public class SpecialInteger {
    static int[] array = {22};
    static HashMap<Integer, Integer> combinationOfSum = new HashMap<>();
    public static void main(String[] args)
    {
        //for(int i : array)
        //{
           // int mid = array[0]/2;
            //for (int j=2; j <= mid; j++) {
                //int diff = i-j;
                //combinationOfSum.put(j,diff);
                int k = 1;
                for(int i = 0; i <= array[0]/2; i++){
                    System.out.print(i + " \n ");
                    while (k > 0) {
                        System.out.print( k % 10 + " ");
                        k = k / 10;
                    }
                }
                System.out.println();
                while (k > 0) {
                    System.out.print( k % 10 + " ");
                    k = k / 10;
                }
                //System.out.println("");
          //  }
        //}
        //System.out.println(combinationOfSum);


    }


}
