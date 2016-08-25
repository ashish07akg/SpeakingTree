package com.example.ashish.speakingtree_android.Model;

/**
 * Created by Ashish on 8/25/2016.
 */
public class SignUpModel {

    private String result;
    private String error;
    private Boolean activationRequired;

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
     * The error
     */
    public String getError() {
        return error;
    }

    /**
     *
     * @param error
     * The error
     */
    public void setError(String error) {
        this.error = error;
    }

    /**
     *
     * @return
     * The activationRequired
     */
    public Boolean getActivationRequired() {
        return activationRequired;
    }

    /**
     *
     * @param activationRequired
     * The activation_required
     */
    public void setActivationRequired(Boolean activationRequired) {
        this.activationRequired = activationRequired;
    }
}
