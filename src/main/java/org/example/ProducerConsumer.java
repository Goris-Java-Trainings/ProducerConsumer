package org.example;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class ProducerConsumer {

    private int limit = 10;
    private List<Integer> buffer = new LinkedList<>();

    public void produce() throws InterruptedException {
        synchronized (this) {
            while (buffer.size() == limit) {
                System.out.println("[" + Thread.currentThread() + "]: is waiting");
                wait();
            }

            System.out.println("[" + Thread.currentThread() + "]: Producer is producing an item");
            Random random = new Random();
            int item = random.nextInt();
            buffer.add(item);

            System.out.println("[" + Thread.currentThread() + "]: + Just Produced an item: " + item);

            notify();
        }
    }

    public void consume() throws InterruptedException {
        synchronized (this) {
            while (buffer.isEmpty()) {
                wait();
            }

            System.out.println("[" + Thread.currentThread() + "]: + Consumer is consuming an item");
            int item = buffer.remove(0);

            System.out.println("[" + Thread.currentThread() + "]: + Just consumed an item: " + item);

            notifyAll();
        }
    }
}
