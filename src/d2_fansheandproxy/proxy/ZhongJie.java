package d2_fansheandproxy.proxy;

//代理类中介
public class ZhongJie implements StudyClass {
    @Override
    public void sing(int money) {
        System.out.println("学习唱歌"+money+"元");
    }

    @Override
    public void dance(int money) {
        System.out.println("学习跳舞"+money+"元");
    }

    @Override
    public void lol(int money) {
        System.out.println("学习打LOL"+money+"元");
    }

    public void eat(){
        System.out.println("吃饭");
    }

    public void sleep(){
        System.out.println("睡觉");
    }

}
