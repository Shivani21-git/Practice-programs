package interview;

import java.util.LinkedList;

public class Coordinates {
    public static void main(String[] args)
    {
        LinkedList<Integer> llist = new LinkedList<>();
       /* llist.add(341);
        llist.add(373);
        llist.add(375);
        llist.add(450);
        llist.add(453);
        llist.add(480);
        llist.add(560);
        llist.add(561);
        llist.add(703); */
        boolean flag = true;


        llist.add(452);
        llist.add(455);
        llist.add(480);
        llist.add(483);
        llist.add(502);
        llist.add(504);
        llist.add(600);
        llist.add(630);
        llist.add(720);


        logic(llist,4,flag);
        System.out.println(llist);


    }
    public static LinkedList<Integer> logic (LinkedList<Integer> llist , int threshold , boolean flag )
    {
        for(int i=0; i< llist.size()-1; i++)
        {
            if(llist.get(i + 1) - llist.get(i) <= threshold)
            {
                if(flag)
                {
                    llist.remove(i);
                }
                else
                {
                    llist.remove(i+1);
                }
            }
        }
        return llist;
    }


}
