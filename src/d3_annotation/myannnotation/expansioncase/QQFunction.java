package d3_annotation.myannnotation.expansioncase;

//qq功能类
public class QQFunction {
    @Anno("publishlog")
    public void publishlog(){
        System.out.println("发表了一篇日志....");
    }
    @Anno("publishTalk")
    public void publishTalk(){
        System.out.println("发表了一个说说....");
    }
    @Anno("lookPhoto")
    public void lookPhoto(){
        System.out.println("查看了相册....");
    }
    @Anno("lookMessage")
    public void lookMessage(){
        System.out.println("查看美女的留言板....");
    }
    @Anno("deleteLook")
    public void deleteLook(){
        System.out.println("删除空间浏览记录....");
    }

}
