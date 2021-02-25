package interview;

public class SpecialIntegerArray {
    static int[] array = {22,121,21};
    public static void main(String[] args)
    {

        for(int i=0; i<array.length;i++)
        {
            int k=0;
            for(int j=1;j<=array[i]/2;j++) {
                k = j;
               // System.out.println(k);
                StringBuilder sb = new StringBuilder();
                while (k > 0) {
                    int mod = k % 10;
                    k = k / 10;
                    sb.append(mod);

                }
                int reversek = Integer.parseInt(sb.toString());
               // System.out.println(reversek);

                if(j + reversek == array[i])
                {
                    System.out.println("Special Integer is : "+ array[i] + " a : "+j+" b : "+ reversek);
                    break;
                }

            }
        }
    }
}

/* same code
public class SpecialInteger {
    static int[] array = {22,121, 21};
    public static void main(String[] args)
    {
        for(int num : array) {
            for (int i = 1; i <= num / 2; i++) {
                StringBuilder sb = new StringBuilder();
                int j = i;
                while (j > 0) {
                    //System.out.print(j % 10 + " ");
                    sb.append(j % 10);
                    j = j / 10;
                }
                if (i + Integer.valueOf(sb.toString()) == num) {
                    System.out.println("saala meelgaya dekho iska "+ num + " yeh meela "+ i + " : " + Integer.valueOf(sb.toString()));
                    break;
                }
                //System.out.println();
            }
        }

    }


}
 */
