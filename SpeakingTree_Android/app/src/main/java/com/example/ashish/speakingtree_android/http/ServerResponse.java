package com.example.ashish.speakingtree_android.http;

import java.io.InputStream;

/**
 * Created by Ashish on 8/30/2016.
 */
public class ServerResponse {
    private int statusCode ;
    private InputStream inputStream;
    private String response ;

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public InputStream getInputStream() {
        return inputStream;
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}
