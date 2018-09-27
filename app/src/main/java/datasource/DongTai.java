package datasource;

import android.widget.ImageView;

/**
 * Created by biwei on 2018/5/3.
 */
public class DongTai {
    private String userID;
    private ImageView userIcon;
    private String text;

    public DongTai(String userID, ImageView userIcon, String text) {
        this.userID = userID;
        this.userIcon = userIcon;
        this.text = text;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public ImageView getUserIcon() {
        return userIcon;
    }

    public void setUserIcon(ImageView userIcon) {
        this.userIcon = userIcon;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
