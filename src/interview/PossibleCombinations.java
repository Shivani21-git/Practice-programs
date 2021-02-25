package interview;

// Program to find the maximum possible sum combinations to form the given digit.
public class PossibleCombinations
{
    public static void main(String[] args){
        int givendigit = 34;
       // int count =0;
        int i=1;
        for(i=1; i<=givendigit/2; i++)
        {
            int b= (givendigit-i);
            System.out.println(i +" + "+ b);
           // count ++;
        }
      //  System.out.println("The count of possible combinations are "+ count);
        System.out.println("The count of possible combinations are "+ (i-1));
    }

}
