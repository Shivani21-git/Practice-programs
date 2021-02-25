package interview;

import java.util.Iterator;
import java.util.TreeMap;

public class IterateTreeMap {
    public static void main(String[] args)
    {
        TreeMap<Integer,Integer> map = new TreeMap<>();
        map.put(1,10);
        map.put(5,12);
        map.put(10,13);
        map.put(6,23);
        Iterator itr =map.keySet().iterator();
        while (itr.hasNext())
        {
            Integer key = (Integer) itr.next();
            System.out.println("Key is " + key + "Value is " + map.get(key));
        }
    }

}
