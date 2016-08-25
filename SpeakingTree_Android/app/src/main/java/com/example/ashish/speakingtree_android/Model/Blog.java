
package com.example.ashish.speakingtree_android.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class Blog implements Parcelable {

    private String contentid;
    private String title;
    private String description;
    private String created;
    private String thumbnail;
    private String wapimage;
    private String bigimage;
    private Author author;
    private String authorId;
    private String views;
    private String commentCount;
    private String seourl;

    protected Blog(Parcel in) {
        contentid = in.readString();
        title = in.readString();
        description = in.readString();
        created = in.readString();
        thumbnail = in.readString();
        wapimage = in.readString();
        bigimage = in.readString();
        authorId = in.readString();
        views = in.readString();
        commentCount = in.readString();
        seourl = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(contentid);
        dest.writeString(title);
        dest.writeString(description);
        dest.writeString(created);
        dest.writeString(thumbnail);
        dest.writeString(wapimage);
        dest.writeString(bigimage);
        dest.writeString(authorId);
        dest.writeString(views);
        dest.writeString(commentCount);
        dest.writeString(seourl);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Blog> CREATOR = new Creator<Blog>() {
        @Override
        public Blog createFromParcel(Parcel in) {
            return new Blog(in);
        }

        @Override
        public Blog[] newArray(int size) {
            return new Blog[size];
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
     *     The commentCount
     */
    public String getCommentCount() {
        return commentCount;
    }

    /**
     * 
     * @param commentCount
     *     The comment_count
     */
    public void setCommentCount(String commentCount) {
        this.commentCount = commentCount;
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
