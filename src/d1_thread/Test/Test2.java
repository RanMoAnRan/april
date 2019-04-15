package d1_thread.Test;

public class Test2 extends Thread {
    public static void main(String[] args) throws InterruptedException {

        Test2 home2 = new Test2();
        home2.start();

        for (int i = 0; i < 20; i++) {
            Thread.sleep(100);

            System.out.println(Thread.currentThread().getName()+"第"+i+"次执行");
        }

    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            try {
                Thread.sleep(100);
                System.out.println(getName()+"第"+i+"次执行");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
