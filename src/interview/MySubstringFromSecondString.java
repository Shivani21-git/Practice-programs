package interview;

import java.util.*;

public class MySubstringFromSecondString {
    public static void main(String... args)
    {
        String s1 = "this is a test string";
        String s2 = "tist";
        MySubstringFromSecondString obj = new MySubstringFromSecondString();
         Map<Character,Integer> map = obj.getLettersOccurrence(s2);
         Map<String,Integer> totalsubstring = obj.getSubString(s1,s2);
         System.out.println(totalsubstring.keySet());
        LinkedList list = new LinkedList(totalsubstring.entrySet());
        Collections.sort(list, new Comparator<Map.Entry>() {

            @Override
            public int compare(Map.Entry ob1, Map.Entry ob2) {
                int x = (Integer) ob1.getValue();
                int y = (Integer) ob2.getValue();
             return   x==y?0:x<y?-1:1;


            }
        });
        System.out.println(((Map.Entry) list.getFirst()).getKey());



    }
    private Map<Character,Integer> getLettersOccurrence(String s2)
    {
        int l2 = s2.length();
        Map<Character,Integer> map = new HashMap<>();
        for(int i=0;i<l2;i++)
        {
             Character key = s2.charAt(i);
            if(map.containsKey(key))
            {
                map.put(key,(map.get(key))+1);
            }
           else {
                map.put(key, 1);
            }

        }
        return map;
    }
    private Map<String,Integer> getSubString(String s1, String s2)
    {
        int l1 = s1.length();
        int l2= s2.length();
        Map<String,Integer> totalsubstring = new HashMap<>();

        for(int j =0; j<=l1-l2;j++)
        {
            int countoccurrence = l2;
            Map<Character,Integer> map = getLettersOccurrence(s2);
            int startindex =0;
            int endindex =0;
            for(int i=j;i<l1;i++)
            {
                Character key = s1.charAt(i);
                if(map.containsKey(key) && countoccurrence>0 && map.get(key)>0 )
                {
                    if(countoccurrence==l2)
                    {
                        startindex = i;
                    }

                    map.put(key,(map.get(key))-1);
                    countoccurrence--;
                    endindex= i;
                    if(countoccurrence==0)
                    {
                        break;
                    }
                }

            }
            if(countoccurrence==0) {
                String sub = s1.substring(startindex, endindex + 1);
                totalsubstring.put(sub, sub.length());
            }

        }
        return totalsubstring;
    }
}
