package interview;

import java.util.ArrayList;
import java.util.ListIterator;

public class ReverseArrayList {
    public static void main(String[] args)
    {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(9);
        list.add(5);
        list.add(4);
        System.out.println(list);
        ArrayList<Integer> reverselist = new ArrayList<>();
  // This is not the efficient way
    /*     ListIterator iterator = list.listIterator();
         while (iterator.hasNext())
         {
             System.out.println(iterator.next());

         }
         System.out.println("Moved cursor to the end");
        while (iterator.hasPrevious())
         {
             reverselist.add((Integer) iterator.previous());
         }
         System.out.println(reverselist);  */
        // Below can be the efficient way
        for(int i = list.size()-1;i>=0;i--)
        {
            reverselist.add(list.get(i));
        }
        System.out.println(reverselist);

    }


}
