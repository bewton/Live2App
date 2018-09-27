package datasource;

import android.graphics.drawable.Icon;

/**
 * Created by biwei on 2018/5/3.
 */
public class DiscussPaper {
    private String title;
    private String name;
    private String number;
    private String content;
    private Icon icon;



    public DiscussPaper(String title, String name, String number, String content, Icon icon) {
        this.title = title;
        this.name = name;
        this.number = number;
        this.content = content;
        this.icon = icon;
    }

    public DiscussPaper(String title, String name, String number) {
        this.title = title;
        this.name = name;
        this.number = number;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Icon getIcon() {
        return icon;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }

    @Override
    public String toString() {
        return "DiscussPaper{" +
                "title='" + title + '\'' +
                ", name='" + name + '\'' +
                ", number='" + number + '\'' +
                ", content='" + content + '\'' +
                ", icon=" + icon +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DiscussPaper)) return false;

        DiscussPaper that = (DiscussPaper) o;

        if (getTitle() != null ? !getTitle().equals(that.getTitle()) : that.getTitle() != null)
            return false;
        if (getName() != null ? !getName().equals(that.getName()) : that.getName() != null)
            return false;
        if (getNumber() != null ? !getNumber().equals(that.getNumber()) : that.getNumber() != null)
            return false;
        if (getContent() != null ? !getContent().equals(that.getContent()) : that.getContent() != null)
            return false;
        return getIcon() != null ? getIcon().equals(that.getIcon()) : that.getIcon() == null;

    }

    @Override
    public int hashCode() {
        int result = getTitle() != null ? getTitle().hashCode() : 0;
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getNumber() != null ? getNumber().hashCode() : 0);
        result = 31 * result + (getContent() != null ? getContent().hashCode() : 0);
        result = 31 * result + (getIcon() != null ? getIcon().hashCode() : 0);
        return result;
    }
}
