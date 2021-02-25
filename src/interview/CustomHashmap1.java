package interview;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class CustomHashmap1<K,V> {
    int bucket_default_size = 16;
    //Array of bucket
    Entry<K,V>[] buckets = new Entry[bucket_default_size];
    //Index can be said as bucket number as well.
    public V add(K key, V value) throws Exception
    {
        isKeyNull(key);
       if(isImmutable(key)) throw new Exception("Key should not be immutable");
        if(isImmutable(value)) throw new Exception("Value should not be immutable");
        int index = key.hashCode() % bucket_default_size;
        Entry<K,V> entry = buckets[index];
        V prevalue = null;
        if(entry!=null)
        {
           if(key.equals(entry.getKey()))
            {
               prevalue   = entry.getValue();
                entry.setValue(value);
                return prevalue;
            }
            while (entry.getNext()!=null) {
                entry = entry.getNext();
                if (key.equals(entry.getKey())) {
                    prevalue = entry.getValue();
                    entry.setValue(value);
                    return prevalue;
                }
            }
            entry.setNext(new Entry(key,value));

            }
        else
        {
            buckets[index] = new Entry<>(key, value);
        }
        return null;

    }

    private boolean isImmutable(Object key) throws Exception {
       Class obj = key.getClass();
       Class superclass = obj.getSuperclass();
       if(Modifier.isFinal(obj.getModifiers())){
           return true;
       }
       else if (!Modifier.isFinal(obj.getModifiers()))
       {
           return false;
       }
       Field[] fields = obj.getDeclaredFields();
       for(int i=0;i<fields.length;i++)
       {
           System.out.println(fields[i].toString());
           if(!Modifier.isFinal(fields[i].getModifiers()))
           {
               return false;
           }

       }
       return true;
    }

    public V get(K key) throws Exception
    {
        isKeyNull(key);
        int index = key.hashCode() % bucket_default_size;
        Entry<K,V> entry = buckets[index];
        if(entry!=null)
        {
            while (entry.getNext()!=null)
            {
                entry = entry.getNext();
                if(key.equals(entry.getKey()))
                {
                    return entry.getValue();
                }
            }
            if(key.equals(entry.getKey()))
            {
                return entry.getValue();
            }

        }
        else {
            throw new Exception("Key doesn't exist");
        }
        return null;

    }

    public void remove(K key) throws Exception
    {
        isKeyNull(key);
        int index = key.hashCode() % bucket_default_size;
        Entry<K,V> entry = buckets[index];
        if(entry!=null)
        {
            while (entry.getNext()!=null)
            {
                entry = entry.getNext();
                if(key.equals(entry.getKey()))
                {
                    entry.setKey(null);
                    entry.setValue(null);
                }
            }
            if(key.equals(entry.getKey()))
            {
                entry.setKey(null);
                entry.setValue(null);
            }

        }
        else {
            throw new Exception("Key doesn't exist");
        }

    }
    public void  isKeyNull(K key) throws Exception
    {
        if(key==null) throw new Exception("Key cannot be null");
    }

    class Entry<K,V>
    {
        K key;
        V value;
        Entry next;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public Entry getNext() {
            return next;
        }

        public void setNext(Entry next) {
            this.next = next;
        }




    }

}
