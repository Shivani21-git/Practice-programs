package interview;

import java.lang.reflect.Field;
import java.util.Arrays;

public class MyHashMapImpl1 {
    public static void main(String[] args)
    {
        CustomHashmap1<CarForMap1,CarForMap1> map = new CustomHashmap1<>();
        try{
           map.add(new CarForMap1("Shivani", "Suman"),new CarForMap1("Nishanti","vicky"));
            map.add(new CarForMap1("Shivanii", "Sumann"),new CarForMap1("Nishantii","vickyy"));
            map.remove(new CarForMap1("Shivani", "Suman"));
            System.out.println(map.get(new CarForMap1("Shivani", "Suman")).toString());
        /*    map.add(2,3);
            map.add(3,4);
            map.add(4,5);
            Integer value1 = map.get(1);
            System.out.println(value1);
            Integer value =map.add(2,6);
            System.out.println(value);
            Integer value3 =map.get(4);
            System.out.println(value3);
            System.out.println(map.get(2));
            map.remove(2);
            System.out.println(map.get(2)); */

   //     map.add(new CarImmutableObject("fgfhj"),new String("Sumnan"));
        //map.add(new CarForMap1("Ford","Black"),new String("Shivani"));
        //System.out.println(map.get(new CarForMap1("Ford","Black")));




        }
        catch (Exception e)
        {
            e.getStackTrace();
            System.out.println(e.getMessage());
        }




    }


 }
