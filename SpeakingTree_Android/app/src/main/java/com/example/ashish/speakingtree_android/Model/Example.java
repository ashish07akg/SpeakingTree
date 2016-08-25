
package com.example.ashish.speakingtree_android.Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class Example implements Serializable {

    private List<Stpick> stpicks = new ArrayList<Stpick>();
    private List<Satsang> satsang = new ArrayList<Satsang>();
    private List<Update> updates = new ArrayList<Update>();
    private List<Object> seekerUpdate = new ArrayList<Object>();
    private List<Todwod> todwod = new ArrayList<Todwod>();
    private List<Object> thread = new ArrayList<Object>();
    private List<Blog> blog = new ArrayList<Blog>();
    private List<Article> article = new ArrayList<Article>();

    /**
     * 
     * @return
     *     The stpicks
     */
    public List<Stpick> getStpicks() {
        return stpicks;
    }

    /**
     * 
     * @param stpicks
     *     The stpicks
     */
    public void setStpicks(List<Stpick> stpicks) {
        this.stpicks = stpicks;
    }

    /**
     * 
     * @return
     *     The satsang
     */
    public List<Satsang> getSatsang() {
        return satsang;
    }

    /**
     * 
     * @param satsang
     *     The satsang
     */
    public void setSatsang(List<Satsang> satsang) {
        this.satsang = satsang;
    }

    /**
     * 
     * @return
     *     The updates
     */
    public List<Update> getUpdates() {
        return updates;
    }

    /**
     * 
     * @param updates
     *     The updates
     */
    public void setUpdates(List<Update> updates) {
        this.updates = updates;
    }

    /**
     * 
     * @return
     *     The seekerUpdate
     */
    public List<Object> getSeekerUpdate() {
        return seekerUpdate;
    }

    /**
     * 
     * @param seekerUpdate
     *     The seeker_update
     */
    public void setSeekerUpdate(List<Object> seekerUpdate) {
        this.seekerUpdate = seekerUpdate;
    }

    /**
     * 
     * @return
     *     The todwod
     */
    public List<Todwod> getTodwod() {
        return todwod;
    }

    /**
     * 
     * @param todwod
     *     The todwod
     */
    public void setTodwod(List<Todwod> todwod) {
        this.todwod = todwod;
    }

    /**
     * 
     * @return
     *     The thread
     */
    public List<Object> getThread() {
        return thread;
    }

    /**
     * 
     * @param thread
     *     The thread
     */
    public void setThread(List<Object> thread) {
        this.thread = thread;
    }

    /**
     * 
     * @return
     *     The blog
     */
    public List<Blog> getBlog() {
        return blog;
    }

    /**
     * 
     * @param blog
     *     The blog
     */
    public void setBlog(List<Blog> blog) {
        this.blog = blog;
    }

    /**
     * 
     * @return
     *     The article
     */
    public List<Article> getArticle() {
        return article;
    }

    /**
     * 
     * @param article
     *     The article
     */
    public void setArticle(List<Article> article) {
        this.article = article;
    }



}
