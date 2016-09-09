package com.example.ashish.speakingtree_android.Model;

/**
 * Created by Ashish on 9/2/2016.
 */
public class UserInfo {

    private String result;
    private Integer userid;
    private String loginhash;
    private User user;
    /**
     *
     * @return
     * The result
     */
    public String getResult() {
        return result;
    }

    /**
     *
     * @param result
     * The result
     */
    public void setResult(String result) {
        this.result = result;
    }

    /**
     *
     * @return
     * The userid
     */
    public Integer getUserid() {
        return userid;
    }

    /**
     *
     * @param userid
     * The userid
     */
    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    /**
     *
     * @return
     * The loginhash
     */
    public String getLoginhash() {
        return loginhash;
    }

    /**
     *
     * @param loginhash
     * The loginhash
     */
    public void setLoginhash(String loginhash) {
        this.loginhash = loginhash;
    }

    /**
     *
     * @return
     * The user
     */
    public User getUser() {
        return user;
    }

    /**
     *
     * @param user
     * The user
     */
    public void setUser(User user) {
        this.user = user;
    }

}
