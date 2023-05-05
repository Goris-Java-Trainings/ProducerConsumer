package org.example;

public class Main {
    public static void main(String[] args) {

        ProducerConsumer producerConsumer = new ProducerConsumer();

        Thread producer1 = new Thread() {
            @Override
            public void run() {

                try {
                    while (true) {
                        producerConsumer.produce();
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        Thread producer2 = new Thread() {
            @Override
            public void run() {

                try {
                    while (true) {
                        producerConsumer.produce();
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        Thread producer3 = new Thread() {
            @Override
            public void run() {

                try {
                    while (true) {
                        producerConsumer.produce();
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        Thread consumer = new Thread() {
            @Override
            public void run() {

                try {
                    while (true) {
                        producerConsumer.consume();
                        Thread.sleep(2000);
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        producer1.start();
        producer1.setPriority(8);
        producer2.start();
        producer3.start();
        consumer.start();
    }
}