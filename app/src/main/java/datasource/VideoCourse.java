package datasource;

import android.provider.ContactsContract;
import android.widget.ImageView;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by biwei on 2018/5/2.
 */
public class VideoCourse implements Serializable{

    private String vcourseName;
    private String vc_price;
    private int icon;
    private String content;
    private ArrayList<VideoSource> catelog;
    private ArrayList<String> askquestion;
    //评论功能

    public VideoCourse(String vcourseName, String vc_url) {
        this.vcourseName = vcourseName;
    }

    public VideoCourse(String vcourseName, String vc_url, String vc_price, int icon, String content, ArrayList<VideoSource> catelog, ArrayList<String> askquestion) {
        this.vcourseName = vcourseName;
        this.vc_price = vc_price;
        this.icon=icon;
        this.content=content;
        this.catelog=catelog;
        this.askquestion=askquestion;
    }

    public VideoCourse(String vcourseName,  String vc_price, int icon,String content,ArrayList<VideoSource> catelog,ArrayList<String> asks) {
        this.vcourseName = vcourseName;
        this.vc_price = vc_price;
        this.icon=icon;
        this.content=content;
        this.catelog=catelog;
        this.askquestion=asks;
    }


    public String getVc_price() {
        return vc_price;
    }

    public void setVc_price(String vc_price) {
        this.vc_price = vc_price;
    }

    public String getVcourseName() {
        return vcourseName;
    }

    public void setVcourseName(String vcourseName) {
        this.vcourseName = vcourseName;
    }

    public int getIcon(){return icon;}

    public void setIcon(int icon){this.icon=icon;}

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content=content;
    }

    public ArrayList<VideoSource> getCatelog() {
        return this.catelog;
    }

    public void setCatelog(ArrayList<VideoSource> catelog) {
        this.catelog=catelog;
    }

    public ArrayList<String> getAskquestion(){return this.askquestion;}

    public void setAskquestion(ArrayList askquestion){
        this.askquestion=askquestion;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof VideoCourse)) return false;

        VideoCourse that = (VideoCourse) o;

        if (getIcon() != that.getIcon()) return false;
        if (!getVcourseName().equals(that.getVcourseName())) return false;
        if (!getVc_price().equals(that.getVc_price())) return false;
        if (!getContent().equals(that.getContent())) return false;
        if (!getCatelog().equals(that.getCatelog())) return false;
        return getAskquestion().equals(that.getAskquestion());

    }

    @Override
    public int hashCode() {
        int result = getVcourseName().hashCode();
        result = 31 * result + getVc_price().hashCode();
        result = 31 * result + getIcon();
        result = 31 * result + getContent().hashCode();
        result = 31 * result + getCatelog().hashCode();
        result = 31 * result + getAskquestion().hashCode();
        return result;
    }


    @Override
    public String toString() {
        return "VideoCourse{" +
                "vcourseName='" + vcourseName + '\'' +
                ", vc_price='" + vc_price + '\'' +
                ", icon=" + icon +
                ", content='" + content + '\'' +
                ", catelog=" + catelog +
                ", askquestion=" + askquestion +
                '}';
    }
}
