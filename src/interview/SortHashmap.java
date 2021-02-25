package interview;

import java.util.Comparator;
import java.util.Map;

public class SortHashmap implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        Map.Entry ob = (Map.Entry) o1;
        Map.Entry ob2 = (Map.Entry) o2;
     //   return ( (Integer)ob.getValue()).compareTo((Integer) ob2.getValue());
        return ( (Integer)ob2.getValue()).compareTo((Integer) ob.getValue());
    }
}
