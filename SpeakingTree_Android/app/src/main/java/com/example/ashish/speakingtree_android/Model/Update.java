
package com.example.ashish.speakingtree_android.Model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.HashMap;
import java.util.Map;

public class Update implements Parcelable {

    private String id;
    private Author author;
    private String updatetext;
    private String created;
    private String wapimage;
    private String thumbnail;
    private String bigimage;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    protected Update(Parcel in) {
        id = in.readString();
        updatetext = in.readString();
        created = in.readString();
        wapimage = in.readString();
        thumbnail = in.readString();
        bigimage = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(updatetext);
        dest.writeString(created);
        dest.writeString(wapimage);
        dest.writeString(thumbnail);
        dest.writeString(bigimage);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Update> CREATOR = new Creator<Update>() {
        @Override
        public Update createFromParcel(Parcel in) {
            return new Update(in);
        }

        @Override
        public Update[] newArray(int size) {
            return new Update[size];
        }
    };

    /**
     * 
     * @return
     *     The id
     */
    public String getId() {
        return id;
    }

    /**
     * 
     * @param id
     *     The id
     */
    public void setId(String id) {
        this.id = id;
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
     *     The updatetext
     */
    public String getUpdatetext() {
        return updatetext;
    }

    /**
     * 
     * @param updatetext
     *     The updatetext
     */
    public void setUpdatetext(String updatetext) {
        this.updatetext = updatetext;
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

    /**
     * 
     * @return
     *     The thumbnail
     */
    public String getThumbnail() {
        return thumbnail;
    }

    /**
     * 
     * @param thumbnail
     *     The thumbnail
     */
    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
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



}
