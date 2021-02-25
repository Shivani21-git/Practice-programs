package interview;

import java.util.HashMap;

class Node
{
    int key;
    int value;
    Node prev;
    Node next;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;

    }

}

public class LruCache {
    int capacity;
    HashMap<Integer,Node> map = new HashMap<>();
    Node head = null;
    Node end = null;
    public LruCache(int capacity) {
        this.capacity = capacity;
    }

    public void set(int key, int value)
    {
        if(map.containsKey(key))
        {
            //update the old value
            Node old = map.get(key);
            old.value = value;
            delete(old);
            setHead(old);

        }
        else
        {
            Node node = new Node(key,value);
            if(map.size()>=capacity)
            {
                map.remove(end.key);
                delete(end);
                setHead(node);

            }
            else
            {
                setHead(node);
            }
            map.put(key,node);
        }


    }

    private void setHead(Node node) {
        node.next = head;
        node.prev = null;
        if(head!= null)
        {
            head.prev=node;
        }
        head = node;
        if(end == null)
        {
            end = head;
        }
    }


    private void delete(Node node) {
        if (node.prev != null) {
            node.prev.next = node.next;
        } else {
            head = node.next;
        }
        if (node.next != null) {
            node.next.prev = node.prev;
        } else {
            end = node.prev;
        }
    }

        private int get(int key)
        {
            if(map.containsKey(key))
            {
                Node n = map.get(key);
                delete(n);
                setHead(n);
                return n.value;
            }
            return -1;

        }
        public static void main(String[] args) {
            LruCache cache = new LruCache(4);
            cache.set(1, 100);
            cache.set(3, 2);
            cache.set(9, 400);
            cache.set(5, 20);
            cache.set(6, 30);
            cache.set(7, 40);
            cache.set(8, 60);

            System.out.println(cache.get(5));
            System.out.println(cache.get(9));
            System.out.println(cache.get(8));
        }

}
