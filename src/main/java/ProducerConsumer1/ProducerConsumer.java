package ProducerConsumer1;

import java.util.LinkedList;

public class ProducerConsumer {
    public void produce( LinkedList<Integer> buffer){
        int item =0;
        buffer.add(item);
        System.out.println(  Thread.currentThread() +  "Producer is producing an item "+item);
        item++;
        notify();
    }
    public void consume(LinkedList<Integer> buffer)   {
            int item = buffer.removeLast();
            System.out.println("[" + Thread.currentThread() + " Consumer is consuming an item " + item);
            notify();
        }
    }



