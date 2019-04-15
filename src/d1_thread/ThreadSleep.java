package d1_thread;


import java.text.SimpleDateFormat;
import java.util.Date;

public class ThreadSleep extends Thread{
    @Override
    public void run() {

        try {

            while (true) {
                Date d = new Date();
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:MM:ss");
                simpleDateFormat.format(d);
                System.out.println(d);

                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ThreadSleep threadSleep = new ThreadSleep();
        threadSleep.start();
    }
}

