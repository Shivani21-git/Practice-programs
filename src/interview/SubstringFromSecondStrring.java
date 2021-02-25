package interview;

import java.util.*;

public class SubstringFromSecondStrring {
    public static void main(String... args) {
        SubstringFromSecondStrring s = new SubstringFromSecondStrring();
        Map map = s.getSubStrings("this is a test string","tist");
        System.out.println(map.keySet());
        LinkedList list = new LinkedList(map.entrySet());
        Collections.sort(list,
                new Comparator<Map.Entry>() {

                    @Override
                    public int compare(Map.Entry o1, Map.Entry o2) {
                        int x = (Integer)o1.getValue();
                        int y = (Integer)o2.getValue();
                        return x < y ? -1 : x == y ? 0 : 1;
                    }
                });
        System.out.println(((Map.Entry)list.get(0)).getKey());
    }
    //first = "This is a test string"
    //second = "tist"
    public Map<String, Integer> getSubStrings(String first, String second) {
        int l1 = first.length();
        int l2 = second.length();
        Map<String, Integer>  substringsMap = new HashMap<>();
        for(int j = 0; j <= l1-l2; j++) {
            Map<Character,Integer> recordOccurrence = getOccurrenceMap(second);
            int occurrenceCount = l2;
            int startIndex = 0;
            int endIndex = 0;
            for(int i = j ; i < l1; i++) {
                Character key = first.charAt(i);
                if(recordOccurrence.containsKey(key) && occurrenceCount>0 && recordOccurrence.get(key)>0) {
                    if(occurrenceCount == l2) {startIndex = i;}

                    recordOccurrence.put(key, recordOccurrence.get(key) - 1);

                    occurrenceCount--;
                    endIndex=i;
                    if(occurrenceCount == 0) break;
                }
            }
            if(occurrenceCount == 0) {
                String sub = first.substring(startIndex, endIndex + 1);
                substringsMap.put(sub, sub.length());
            }
        }

        return substringsMap;
    }

    private Map<Character,Integer> getOccurrenceMap(String second) {
        //********** Creating Second String Occurrence in map

        Map<Character,Integer> recordOccurrence = new HashMap<>();
        int l2 = second.length();
        for(int i = 0; i < l2; i++) {
            Character key = second.charAt(i);
            if(recordOccurrence.containsKey(key)) {
                recordOccurrence.put(key,recordOccurrence.get(key)+1);
            } else {
                recordOccurrence.put(key,1);
            }
        }
        return recordOccurrence;
    }
}
