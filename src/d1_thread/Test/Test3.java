package d1_thread.Test;

public class Test3 implements Runnable {


    /*请按要求编写多线程应用程序，模拟多个人通过一个山洞：
    1.这个山洞每次只能通过一个人，每个人通过山洞的时间为5秒；
    2.随机生成10个人，同时准备过此山洞，并且定义一个变量用于记录通过隧道的人数。显示每次通过山洞人的姓名，和通过顺序；*/

   /* public static int people = 100;//人数
    int count = 0;

    @Override
    public void run() {
            while (true) {
                synchronized (this) {
                if (people > 0) {
                    try {

                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    count++;
                    System.out.println(Thread.currentThread().getName() + "第" + count + "通过山洞");
                    people--;
                }else {
                    break;
                }
            }
        }
    }*/

   int count=1;
    @Override
    public void run() {
        synchronized (this) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "第" + count + "通过隧道");
            count++;
        }
    }

    public static void main(String[] args) {
        Test3 home3 = new Test3();
       /* Thread thread = new Thread(home3);
        thread.setName("zhangshan");
        thread.start();
        Thread thread2 = new Thread(home3);
        thread2.setName("liso");
        thread2.start();
        Thread thread3 = new Thread(home3);
        thread3.setName("wangwu");
        thread3.start();*/
        for (int i = 0; i < 10; i++) {
            new Thread(home3,"people"+i).start();
        }
    }
}
