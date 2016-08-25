
package com.example.ashish.speakingtree_android.Model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.HashMap;
import java.util.Map;


public class Todwod implements Parcelable{

    private String contentid;
    private Integer contenttype;
    private String title;
    private String description;
    private String created;
    private Author author;
    private String authorId;
    private String views;
    private String seourl;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    protected Todwod(Parcel in) {
        contentid = in.readString();
        title = in.readString();
        description = in.readString();
        created = in.readString();
        authorId = in.readString();
        views = in.readString();
        seourl = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(contentid);
        dest.writeString(title);
        dest.writeString(description);
        dest.writeString(created);
        dest.writeString(authorId);
        dest.writeString(views);
        dest.writeString(seourl);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Todwod> CREATOR = new Creator<Todwod>() {
        @Override
        public Todwod createFromParcel(Parcel in) {
            return new Todwod(in);
        }

        @Override
        public Todwod[] newArray(int size) {
            return new Todwod[size];
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
     *     The contenttype
     */
    public Integer getContenttype() {
        return contenttype;
    }

    /**
     * 
     * @param contenttype
     *     The contenttype
     */
    public void setContenttype(Integer contenttype) {
        this.contenttype = contenttype;
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
     *     The description
     */
    public String getDescription() {
        return description;
    }

    /**
     * 
     * @param description
     *     The description
     */
    public void setDescription(String description) {
        this.description = description;
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
     *     The authorId
     */
    public String getAuthorId() {
        return authorId;
    }

    /**
     * 
     * @param authorId
     *     The author_id
     */
    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    /**
     * 
     * @return
     *     The views
     */
    public String getViews() {
        return views;
    }

    /**
     * 
     * @param views
     *     The views
     */
    public void setViews(String views) {
        this.views = views;
    }

    /**
     * 
     * @return
     *     The seourl
     */
    public String getSeourl() {
        return seourl;
    }

    /**
     * 
     * @param seourl
     *     The seourl
     */
    public void setSeourl(String seourl) {
        this.seourl = seourl;
    }



}
