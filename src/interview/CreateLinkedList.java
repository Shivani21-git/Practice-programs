package interview;

import java.util.TreeMap;

public class CreateLinkedList {
    public  Node head;
  //   TreeMap map = new TreeMap();

     class Node{
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
        }
    }
    public void add(int data)
    {
        Node linkedlist = new Node(data);
        if(head==null)
        {
           head =  linkedlist;
         //  linkedlist.next = null;
        }
        else if (head!=null)
        {
            linkedlist.next=head;
           head = linkedlist;
        }

    }
    public void detectLoop(Node head)
    {
        Node slow_point= head, fast_point = head;
        while(slow_point!= null && fast_point != null && fast_point.next!= null)
        {
            slow_point = slow_point.next;
            fast_point= fast_point.next.next;
            if(slow_point==fast_point)
            {
                System.out.println("Loop found");
                System.out.println(slow_point.next.data);
                removeLoop(head,slow_point);
                break;
            }

        }
       //System.out.println("Loop not found");
        //return 0;
    }
    public void removeLoop(Node head, Node slow_point)
    {
       Node pntr1 = head;
       Node pntr2= slow_point;
       while(pntr1.next!=pntr2.next)
       {
           pntr1=pntr1.next;
           pntr2=pntr2.next;
       }

       pntr2.next=null;
       System.out.println("Loop has been broken");
    }
    public void sort(Node head)
    {
        Node cur = head;
        while(cur!=null)
        {
            Node index = cur.next;
            while(index != null) {
                if(cur.data > index.data)
                {
                    //20 >> 10 >> 8 >> 22
                    int temp = cur.data;
                    cur.data = index.data;
                    index.data = temp;
                    //10 >> 20 >> 8 >> 22
                    //head = temp;
                }
                index = index.next;
            }
            cur = cur.next;
        }

    }
    public void insert(Node head, int element)
    {
        Node newNode = new Node(element);
        Node cur = head;
        if(cur.data > element) {
            newNode.next = cur;
            this.head = newNode;
        }else {
            while(cur.next != null)
            {
                if(cur.next.data>element) {
                    newNode.next = cur.next;
                    cur.next = newNode;
                    break;
                }
                if(cur.next.next == null) {
                    cur.next.next = newNode;
                    break;
                }
                cur = cur.next;
            }
        }
    }
    public void printNode(Node head)
    {
        Node cur = head;
        while(cur.next!=null)
        {
          //  map.put(head.data,null);
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
        if(cur.next==null)
        {
          //  map.put(head.data,null);
            System.out.println(cur.data);
        }
     //   System.out.println(map);
    }
    public static void main(String[] args)
    {
        CreateLinkedList ob = new CreateLinkedList();
        ob.add(20);
        ob.add(5);
        ob.add(15);
        //ob.sort(ob.head);
        ob.printNode(ob.head);
        System.out.println(" After Sort");
        ob.sort(ob.head);
        ob.printNode(ob.head);
        System.out.println(" After Insert");
        ob.insert(ob.head,12);
        ob.printNode(ob.head);
        System.out.println(" After Insert");
        ob.insert(ob.head,4);
        ob.printNode(ob.head);
        System.out.println(" After Insert");
        ob.insert(ob.head,25);
        ob.printNode(ob.head);
        System.out.println(" After Insert");
        ob.insert(ob.head,30);
        ob.printNode(ob.head);
        ob.head.next.next.next.next.next.next.next = ob.head.next.next;
        ob.detectLoop(ob.head);
        ob.printNode(ob.head);



    }

}
