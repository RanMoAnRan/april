package d1_thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//模仿买票
public class SynchronizedDemo implements Runnable {

    public static int num = 100;//定义为静态表示共享100张票

    @Override
    public void run() {
        while (true) {
            //方式一  加同步锁  如果是继承Thread 则不能用this
            /*synchronized (this) {//this是同一个对象    同步锁
                if (num > 0) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "卖了第" + num + "张票");
                    num--;
                }
                else {
                    break;
                }
            }*/

            //调用同步方法
            tickes();
            if (num == 0) {
                break;
            }

        }
    }

    //同步方法
    public static synchronized void tickes() {//用runnable接口同步方法可以不使用static修饰（继承Thread 同步方法必须使用static）
        //将需要加锁的代码封装到方法中
        if (num > 0) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "卖了第" + num + "张票");
            num--;
        }

    }

    public static void main(String[] args) {

        //普通创建线程对象的方式
        /*SynchronizedDemo sd = new SynchronizedDemo();
        new Thread(sd).start();
        new Thread(sd).start();
        new Thread(sd).start();*/


        //线程池
        //好处：每次线程执行完任务以后，线程不会销毁，会放回线程池中，
        // 每次在执行任务的时候又会到线程池中去取线程。这样会提高效率。
        /*使用线程池中线程对象的步骤：
        A：自定义一个类，作为任务类并实现Runnable接口；
        B：实现Runnable接口中的run方法；
        C：创建任务类的对象；
        D：获取线程池对象；
        E：直接执行任务；*/

        // 创建任务对象
        SynchronizedDemo sd = new SynchronizedDemo();
        //获取线程池对象； 获取3个线程
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        //从线程池中获取3个线程对象,然后调用SellTicketTask中的run()
        executorService.execute(sd);
        executorService.execute(sd);
        executorService.execute(sd);
        //关闭线程池
        executorService.shutdown();

    }
}
