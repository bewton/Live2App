package datasource;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by biwei on 2018/5/2.
 */
public class LiveCourse implements Serializable{
    private String courseName;
    private String url;
    private String price;
    private int icon;
    private String content;
    private ArrayList<String> comments;

    public LiveCourse(String courseName, String url, String price, int icon, String content, ArrayList comments) {
        this.courseName = courseName;
        this.url = url;
        this.price = price;
        this.icon = icon;
        this.content = content;
        this.comments = comments;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public ArrayList<String> getComments() {
        return comments;
    }

    public void setComments(ArrayList<String> comments) {
        this.comments = comments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LiveCourse)) return false;

        LiveCourse that = (LiveCourse) o;

        if (getIcon() != that.getIcon()) return false;
        if (getCourseName() != null ? !getCourseName().equals(that.getCourseName()) : that.getCourseName() != null)
            return false;
        if (getUrl() != null ? !getUrl().equals(that.getUrl()) : that.getUrl() != null)
            return false;
        if (getPrice() != null ? !getPrice().equals(that.getPrice()) : that.getPrice() != null)
            return false;
        if (getContent() != null ? !getContent().equals(that.getContent()) : that.getContent() != null)
            return false;
        return getComments() != null ? getComments().equals(that.getComments()) : that.getComments() == null;

    }

    @Override
    public int hashCode() {
        int result = getCourseName() != null ? getCourseName().hashCode() : 0;
        result = 31 * result + (getUrl() != null ? getUrl().hashCode() : 0);
        result = 31 * result + (getPrice() != null ? getPrice().hashCode() : 0);
        result = 31 * result + getIcon();
        result = 31 * result + (getContent() != null ? getContent().hashCode() : 0);
        result = 31 * result + (getComments() != null ? getComments().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "LiveCourse{" +
                "courseName='" + courseName + '\'' +
                ", url='" + url + '\'' +
                ", price='" + price + '\'' +
                ", icon=" + icon +
                ", content='" + content + '\'' +
                ", comments=" + comments +
                '}';
    }
}
