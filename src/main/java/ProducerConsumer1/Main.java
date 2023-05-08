package ProducerConsumer1;


import java.util.LinkedList;

public class Main {
    public static void main(String[]args){
        LinkedList<Integer> buffer = new LinkedList<>();
        ProducerConsumer producerConsumer = new ProducerConsumer();

        Thread producer1 =new Thread(){
            @Override
            public void run() {
                while (true) {
                    producerConsumer.produce(buffer);
                }            }
        };
        Thread producer2 =new Thread(){
            @Override
            public void run() {
                while (true) {
                    producerConsumer.produce(buffer);
                }
            }
        };
        Thread consumer =new Thread(){
            @Override
            public void run() {
                while (true) {
                    producerConsumer.consume(buffer);
                }
            }
        };

        producer1.start();
        producer2.start();
        consumer.start();




    }

}
