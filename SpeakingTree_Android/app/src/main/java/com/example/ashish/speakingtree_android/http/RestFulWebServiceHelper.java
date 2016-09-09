package com.example.ashish.speakingtree_android.http;

import android.os.Build;
import android.os.Environment;

import com.example.ashish.speakingtree_android.Utils.ConvertStreamIntoString;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.URL;

/**
 * Created by Ashish on 8/25/2016.
 */
public class RestFulWebServiceHelper {
    private static final int CONNECTION_TIMEOUT = 1500;
    private static final int DATARETRIEVAL_TIMEOUT = 1500;

    public static ServerResponse requestWebService(URL serviceUrl) {

        disableConnectionReuseIfNecessary();
        HttpURLConnection urlConnection = null;
        ServerResponse serverResponse = new ServerResponse();
        try {
            urlConnection = (HttpURLConnection) serviceUrl.openConnection();
            urlConnection.setConnectTimeout(CONNECTION_TIMEOUT);
            urlConnection.setReadTimeout(DATARETRIEVAL_TIMEOUT);
            int statusCode = urlConnection.getResponseCode();
            if (statusCode == HttpURLConnection.HTTP_UNAUTHORIZED) {
            } else if (statusCode != HttpURLConnection.HTTP_OK) {
            }

            InputStream inputStream = new BufferedInputStream(urlConnection.getInputStream());
            String k = ConvertStreamIntoString.getResponseText(inputStream);
            serverResponse.setStatusCode(statusCode);
            serverResponse.setInputStream(inputStream);
            serverResponse.setResponse(k);
            return serverResponse;
        } catch (Exception e) {
            serverResponse.setStatusCode(404);
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
        }

        return null;
    }
    /**
     * required in order to prevent issues in earlier Android version.
     */
    private static void disableConnectionReuseIfNecessary() {
        // see HttpURLConnection API doc
        if (Integer.parseInt(Build.VERSION.SDK)
                < Build.VERSION_CODES.FROYO) {
            System.setProperty("http.keepAlive", "false");
        }
    }

    public static String requestWebService(String url, String postParameters) {
        disableConnectionReuseIfNecessary();
        HttpURLConnection urlConnection = null;
        try {
            // create connection
            URL urlToRequest = new URL(url);
            urlConnection = (HttpURLConnection) urlToRequest.openConnection();
            urlConnection.setConnectTimeout(CONNECTION_TIMEOUT);
            urlConnection.setReadTimeout(DATARETRIEVAL_TIMEOUT);
            // handle POST parameters
            if (postParameters != null) {
                urlConnection.setDoOutput(true);
                urlConnection.setRequestMethod("POST");
                urlConnection.setFixedLengthStreamingMode(
                        postParameters.getBytes().length);
                urlConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                //send the POST out
                PrintWriter out = new PrintWriter(urlConnection.getOutputStream());
                out.print(postParameters);
                out.close();
            }
            // handle issues
            int statusCode = urlConnection.getResponseCode();
            if (statusCode == HttpURLConnection.HTTP_UNAUTHORIZED) {
                // handle unauthorized (if service requires user login)
            } else if (statusCode != HttpURLConnection.HTTP_OK) {
                // handle any other errors, like 404, 500,..
            }
            // read output (only for GET)
            if (postParameters != null) {
                return null;
            } else {
                InputStream in =
                        new BufferedInputStream(urlConnection.getInputStream());
                return ConvertStreamIntoString.getResponseText(in);
            }
        } catch (MalformedURLException e) {
            // handle invalid URL
        } catch (SocketTimeoutException e) {
            // hadle timeout
        } catch (IOException e) {
            // handle I/0
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
        }
        return null;
    }


    /*public static void writeFileinFolder(InputStream stream) {
        String urlPath = "http://www.mediacollege.com/audio/tone/files/100Hz_44100Hz_16bit_30sec.wav";
        String fileName = "Song.wav";
        File output = new File(Environment.getExternalStorageDirectory(),
                fileName);
        if (output.exists()) {
            output.delete();
        }
        URL urlToRequest = null;
        try {
            urlToRequest = new URL(urlPath);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        FileOutputStream fos = null;

        try {

            InputStreamReader reader = new InputStreamReader(stream);
            fos = new FileOutputStream(output.getPath());


            byte[] buf = new byte[1024];
            int len;

            while ((len = stream.read(buf)) > 0) {

                fos.write(buf, 0, len);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (stream != null) {
                try {
                    stream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        // Successful finished
    }*/
}
