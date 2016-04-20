package cn.edu.csuft.lkdapp.bean;

/**
 * Created by nangua on 2016/4/7 0007.
 */
public class Communitybean {
    //暂时的类
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    private String title;

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    private String info;

    public Communitybean(String titlem,String info) {
        this.title = title;
        this.info = info;
    }

    @Override
    public String toString() {
        return "Communitybean{" +
                "title='" + title + '\'' +
                ", info='" + info + '\'' +
                '}';
    }
}
