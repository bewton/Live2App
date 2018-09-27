package datasource;

import android.graphics.drawable.Icon;

/**
 * Created by biwei on 2018/6/5.
 */
public class Remarker {
    private String name;
    private String number;
    private String content;
    private Icon icon;


    public Remarker(String name, String number, String content, Icon icon) {
        this.name = name;
        this.number = number;
        this.content = content;
        this.icon = icon;
    }


    public Remarker(String name, String number, String content) {
        this.name = name;
        this.number = number;
        this.content = content;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Remarker)) return false;

        Remarker remarker = (Remarker) o;

        if (!getName().equals(remarker.getName())) return false;
        if (!getNumber().equals(remarker.getNumber())) return false;
        if (!getContent().equals(remarker.getContent())) return false;
        return getIcon().equals(remarker.getIcon());

    }

    @Override
    public int hashCode() {
        int result = getName().hashCode();
        result = 31 * result + getNumber().hashCode();
        result = 31 * result + getContent().hashCode();
        result = 31 * result + getIcon().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Remarker{" +
                "name='" + name + '\'' +
                ", number='" + number + '\'' +
                ", content='" + content + '\'' +
                ", icon=" + icon +
                '}';
    }
}
