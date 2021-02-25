package interview;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;

public class SortHashMapByValues {
    public static void main(String[] args)
    {
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(1,21);
        map.put(2,12);
        map.put(9,3);
        map.put(8,6);
        System.out.println(map);
        LinkedList list = new LinkedList(map.entrySet());
        Collections.sort(list,new SortHashmap());
        System.out.println(list);
    }



}
