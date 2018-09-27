package datasource;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by biwei on 2018/6/5.
 */
public class VideoSource implements Serializable {
    private String video_catelog;
    private String url;



    public VideoSource(String video_catelog, String url) {
        this.video_catelog = video_catelog;
        this.url = url;
    }

    public VideoSource(String video_catelog) {
        this.video_catelog = video_catelog;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getVideo_catelog() {
        return video_catelog;
    }

    public void setVideo_catelog(String video_catelog) {
        this.video_catelog = video_catelog;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof VideoSource)) return false;

        VideoSource that = (VideoSource) o;

        if (getVideo_catelog() != null ? !getVideo_catelog().equals(that.getVideo_catelog()) : that.getVideo_catelog() != null)
            return false;
        return getUrl() != null ? getUrl().equals(that.getUrl()) : that.getUrl() == null;

    }

    @Override
    public int hashCode() {
        int result = getVideo_catelog() != null ? getVideo_catelog().hashCode() : 0;
        result = 31 * result + (getUrl() != null ? getUrl().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "VideoSource{" +
                "video_catelog='" + video_catelog + '\'' +
                ", url='" + url + '\'' +
                '}';
    }

   // @Override
   // public int describeContents() {
   //     return 0;
   // }

   // @Override
   // public void writeToParcel(Parcel dest, int flags) {
   //     dest.writeString(video_catelog);
   //     dest.writeString(url);

   // }
}
