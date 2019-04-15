package d1_thread;

//模仿买票
public class SynchronizedDemo implements Runnable{

    public static int num=100;//定义为静态表示共享100张票

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
            if (num==0) {
                break;
            }

        }
    }


    public static void main(String[] args) {
        SynchronizedDemo sd = new SynchronizedDemo();
        new Thread(sd).start();
        new Thread(sd).start();
        new Thread(sd).start();

    }


    //同步方法
    public static synchronized void tickes(){//用runnable接口同步方法可以不使用static修饰（继承Thread 同步方法必须使用static）
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

}
