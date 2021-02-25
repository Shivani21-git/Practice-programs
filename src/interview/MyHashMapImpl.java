package interview;

public class MyHashMapImpl  {

    public static void  main(String... s) {
        CustomHashmap<CarFormap,Integer> map = new CustomHashmap<>();
        try{
        /*map.put("first",1);
        map.put("second",2);
        map.put("third",3);*/
        map.put(new CarFormap("baleno","black"),4);
        map.put(new CarFormap("baleno","black"),5);
        map.put(new CarFormap("maruti","black"),6);
        //map.put(new CarImmutableObject("name"),7);
        //Object value = map.get("second");
        Object value1 = map.get(new CarFormap("baleno","black"));
        System.out.println(value1);
        //System.out.println(value);
        }catch (Exception e) {
            e.getStackTrace();
            System.out.println(e.getMessage());
        }


    }

}
