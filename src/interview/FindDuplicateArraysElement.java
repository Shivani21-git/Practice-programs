package interview;

import java.util.HashSet;
import java.util.Set;

//Find duplicate arrays integer present without using sorting mechanism.
public class FindDuplicateArraysElement {
    static int[] array = {1,3,2,2,1,5,6,5,4};
    public static void main(String[] args)
    {
        Set s1 = new HashSet();
        Set s2 = new HashSet();

        for(int i : array)
        {
            if(!s1.add(i))
            {
                s2.add(i);
            }

        }
        System.out.println(s2);
        System.out.println(s1);
    }


}
