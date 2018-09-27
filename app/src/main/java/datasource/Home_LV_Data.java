package datasource;

import java.io.Serializable;

/**
 * Created by biwei on 2018/5/3.
 */
public class Home_LV_Data implements Serializable {
    private int icon;
    private String price;
    private String  name;

    public Home_LV_Data(int icon, String price, String name) {
        this.icon = icon;
        this.price = price;
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    @Override
    public String toString() {
        return "Home_LV_Data{" +
                "icon=" + icon +
                ", price='" + price + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
