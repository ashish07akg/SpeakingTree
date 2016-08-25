
package com.example.ashish.speakingtree_android.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class Satsang implements Parcelable {

    private String contentid;
    private String title;
    private String body;
    private String created;
    private Author author;
    private String videoFile;
    private String thumburl;
    private String bigimage;
    private String wapimage;

    protected Satsang(Parcel in) {
        contentid = in.readString();
        title = in.readString();
        body = in.readString();
        created = in.readString();
        videoFile = in.readString();
        thumburl = in.readString();
        bigimage = in.readString();
        wapimage = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(contentid);
        dest.writeString(title);
        dest.writeString(body);
        dest.writeString(created);
        dest.writeString(videoFile);
        dest.writeString(thumburl);
        dest.writeString(bigimage);
        dest.writeString(wapimage);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Satsang> CREATOR = new Creator<Satsang>() {
        @Override
        public Satsang createFromParcel(Parcel in) {
            return new Satsang(in);
        }

        @Override
        public Satsang[] newArray(int size) {
            return new Satsang[size];
        }
    };

    /**
     * 
     * @return
     *     The contentid
     */
    public String getContentid() {
        return contentid;
    }

    /**
     * 
     * @param contentid
     *     The contentid
     */
    public void setContentid(String contentid) {
        this.contentid = contentid;
    }

    /**
     * 
     * @return
     *     The title
     */
    public String getTitle() {
        return title;
    }

    /**
     * 
     * @param title
     *     The title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 
     * @return
     *     The body
     */
    public String getBody() {
        return body;
    }

    /**
     * 
     * @param body
     *     The body
     */
    public void setBody(String body) {
        this.body = body;
    }

    /**
     * 
     * @return
     *     The created
     */
    public String getCreated() {
        return created;
    }

    /**
     * 
     * @param created
     *     The created
     */
    public void setCreated(String created) {
        this.created = created;
    }

    /**
     * 
     * @return
     *     The author
     */
    public Author getAuthor() {
        return author;
    }

    /**
     * 
     * @param author
     *     The author
     */
    public void setAuthor(Author author) {
        this.author = author;
    }

    /**
     * 
     * @return
     *     The videoFile
     */
    public String getVideoFile() {
        return videoFile;
    }

    /**
     * 
     * @param videoFile
     *     The video_file
     */
    public void setVideoFile(String videoFile) {
        this.videoFile = videoFile;
    }

    /**
     * 
     * @return
     *     The thumburl
     */
    public String getThumburl() {
        return thumburl;
    }

    /**
     * 
     * @param thumburl
     *     The thumburl
     */
    public void setThumburl(String thumburl) {
        this.thumburl = thumburl;
    }

    /**
     * 
     * @return
     *     The bigimage
     */
    public String getBigimage() {
        return bigimage;
    }

    /**
     * 
     * @param bigimage
     *     The bigimage
     */
    public void setBigimage(String bigimage) {
        this.bigimage = bigimage;
    }

    /**
     * 
     * @return
     *     The wapimage
     */
    public String getWapimage() {
        return wapimage;
    }

    /**
     * 
     * @param wapimage
     *     The wapimage
     */
    public void setWapimage(String wapimage) {
        this.wapimage = wapimage;
    }


}
