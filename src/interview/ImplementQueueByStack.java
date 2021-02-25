package interview;

import java.util.Queue;
import java.util.Stack;

// Implement Queue data structure with help of stack and write dry code on pen and paper
// Refer https://www.geeksforgeeks.org/queue-using-stacks/
public class ImplementQueueByStack {
    static class MyQueue {
        Stack<Integer> stack1;
        Stack<Integer> stack2;
    }
    static void push(Stack<Integer> stack1 , int data)
    {
        stack1.push(data);
    }
    static int pop(Stack<Integer> stack1) throws Exception
    {
        if(stack1.isEmpty())
        {
            throw new Exception("Stack is empty");
        }
        else {
             return stack1.pop();
        }

    }
    static void enQueue(MyQueue queue,int data)
    {
        push(queue.stack1,data);
    }
    static int deQueue(MyQueue queue) throws Exception
    {
        int x;
        if(queue.stack1.isEmpty() && queue.stack2.isEmpty())
        {
            throw new Exception("Queue is empty");
        }
        if(queue.stack2.isEmpty())
        {
            while (!queue.stack1.isEmpty())
            {
                x=pop(queue.stack1);
                push(queue.stack2,x);

            }
        }
       return x =pop(queue.stack2);
    }
    public static void main(String[] args)
    {
        MyQueue q = new MyQueue();
        q.stack1 = new Stack<>();
        q.stack2 = new Stack<>();
        enQueue(q,8);
        enQueue(q,10);
        enQueue(q,67);
        try {
            System.out.println(deQueue(q));
            System.out.println(deQueue(q));
            System.out.println(deQueue(q));
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

    }
}
