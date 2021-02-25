package interview;


/*write your own hashmap which will take add and remove method only and you have
to write your hashcode and equals method keeping
in mind that it should take care of collisions properly and
map’s add method should not take immutable objects as key or value.*/

import jdk.nashorn.internal.ir.annotations.Immutable;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class CustomHashmap<k,v> {
    int BUCKET_DEFAULT_SIZE=10;

    Entry<k,v>[] buckets = new Entry[BUCKET_DEFAULT_SIZE];

    public v get(k key) throws Exception {
        isKeyNull(key);

        int index = getIndex(key);

        Entry<k,v> entry = buckets[index];

        if(entry != null){

            while(entry.getNext() != null){
                if(key.equals(entry.getKey())){
                    return entry.getValue();
                }
            }
            //this check is for first and last entry
            if(key.equals(entry.getKey())){
                return entry.getValue();
            }
        }else {
            throw new Exception("key nai hai mere map mein ");
        }

        return  null;
    }

    public Iterator<Entry> getIterator(){

        class Iterator implements java.util.Iterator<Entry>{
            int index = -1;
            int counter = 0;
            @Override
            public boolean hasNext() {
                    if(index == -1) {
                        int nullCounter = 0;
                        for(int i = 0 ; i < buckets.length; i++){
                            if(buckets[i] == null ) {
                                nullCounter++;
                                if (nullCounter == buckets.length)
                                    return false;
                            }
                        }
                    } else {
                        Entry e = buckets[index];
                        if(e == null) {
                            return false;
                        }else {
                            if(counter == 0) {
                                return true;
                            } else {
                                int internalCount = 0;
                                while (e.getNext() != null) {
                                     if(counter < internalCount++) return true;
                                }
                                return false;
                            }
                        }

                    }

                return false;
            }

            @Override
            public Entry next() {
                counter++;
                return null;
            }

            @Override
            public void remove() {

            }
        }

        return new Iterator();
    }

    public void put(k key, v value) throws Exception {
        isKeyNull(key);

        if(isImmutable(key)) throw new Exception("Key object is immutable");

        int index = getIndex(key);

        Entry entry = buckets[index];

        if(entry != null) {
            if(key.equals(entry.getKey()))
            {
                entry.setValue(value);
            }
            else {
                while (entry.getNext()!= null)
                {
                    entry = entry.getNext();
                    if(key.equals(entry.getKey()))
                    {
                        entry.setValue(value);
                    }
                }
                entry.setNext(new Entry(key,value));
            }

        }else {
            buckets[index] = new Entry(key,value);
        }
    }

    private void isKeyNull(Object key) throws Exception {
        if(key == null) throw new Exception("Key should not be null");
    }

    private int getIndex(Object key) {
        return key.hashCode() % BUCKET_DEFAULT_SIZE;
    }


    private boolean isImmutable(Object obj) {
        //Reflection ka story yhi se suru hota hai.. kisi object ke class ka object nikal liye matlab phir uss class ka pura detail nikal jayega
        Class<?> objClass = obj.getClass();

        // Class of the object must be a direct child class of the required class
        Class<?> superClass = objClass.getSuperclass();
        /*if (!Immutable.class.equals(superClass)) {
            return false;
        }*/

        // Class must be final
        if (!Modifier.isFinal(objClass.getModifiers())) {
            return false;
        }

        // Check all fields defined in the class for type and if they are final
        Field[] objFields = objClass.getDeclaredFields();
        for (int i = 0; i < objFields.length; i++) {
            if (!Modifier.isFinal(objFields[i].getModifiers())
                    || !isValidFieldType(objFields[i].getType())) {
                return false;
            }
        }

        // Lets hope we didn't forget something
        return true;
    }

    static boolean isValidFieldType(Class<?> type) {
        // Check for all allowed property types...
        return type.isPrimitive() || String.class.equals(type);
    }

}

class Entry<k,v>{
    k key;
    v value;
    Entry next;

    public Entry(k key, v value) {
        this.key = key;
        this.value = value;
    }

    public k getKey() {
        return key;
    }

    public void setKey(k key) {
        this.key = key;
    }

    public v getValue() {
        return value;
    }

    public void setValue(v value) {
        this.value = value;
    }

    public Entry getNext() {
        return next;
    }

    public void setNext(Entry next) {
        this.next = next;
    }
}
