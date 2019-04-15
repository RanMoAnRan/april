package d1_thread;

public class RunnableDemo implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + "-------" + i);
        }
    }

    public static void main(String[] args) {
        RunnableDemo r1 = new RunnableDemo();
        new Thread(r1).start();
        Thread t1 = new Thread(r1);
        t1.start();
        System.out.println(Thread.currentThread().getName());
    }
}
