package d1_thread;

public class ThreadDemo extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(getName()+"---------------"+i);
           // System.out.println(Thread.currentThread().getName()+"-------"+i);
        }
    }


    public static void main(String[] args) {
        ThreadDemo threadDemo = new ThreadDemo();
        threadDemo.setName("jingge");
        threadDemo.start();
        ThreadDemo threadDemo2 = new ThreadDemo();
        threadDemo2.start();
        System.out.println(Thread.currentThread().getName());
    }
}
