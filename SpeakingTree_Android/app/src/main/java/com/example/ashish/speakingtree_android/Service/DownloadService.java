package com.example.ashish.speakingtree_android.Service;

import android.app.Activity;
import android.app.IntentService;
import android.content.Intent;
import android.os.Environment;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


/**
 * Created by Ashish on 8/31/2016.
 */
public class DownloadService extends IntentService {

    private int result = Activity.RESULT_CANCELED;
    public static final String URL = "http://www.mediacollege.com/audio/tone/files/100Hz_44100Hz_16bit_30sec.wav";
    public static final String FILENAME = "androidsong.wav";
    public static final String FILEPATH = "/storage/emulated/0/Download/";
    public static final String RESULT = "result";
    public static final String NOTIFICATION = "service receiver";
    private static final int CONNECTION_TIMEOUT = 1500;
    private static final int DATARETRIEVAL_TIMEOUT = 1500;

    public DownloadService() {
        super("DownloadService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        String urlPath = intent.getStringExtra(URL);
        String fileName = intent.getStringExtra(FILENAME);
        HttpURLConnection urlConnection = null;
        File output = new File(Environment.getExternalStorageDirectory(),
                fileName);
        if (output.exists()) {
            output.delete();
        }
        URL urlToRequest = null;
        try {
            urlToRequest = new URL(URL);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        FileOutputStream fos = null;
        try {
            urlConnection = (HttpURLConnection) urlToRequest.openConnection();
            urlConnection.setConnectTimeout(CONNECTION_TIMEOUT);
            urlConnection.setReadTimeout(DATARETRIEVAL_TIMEOUT);
            int statusCode = urlConnection.getResponseCode();
            if (statusCode == HttpURLConnection.HTTP_UNAUTHORIZED) {
            } else if (statusCode != HttpURLConnection.HTTP_OK) {
            }

            InputStream inputStream = new BufferedInputStream(urlConnection.getInputStream());
            fos = new FileOutputStream(output.getPath());
            byte[] buf = new byte[1024];
            int len;
            while ((len = inputStream.read(buf)) > 0) {
                fos.write(buf, 0, len);
            }
            // Successful finished
            result = Activity.RESULT_OK;
            publishResults(output.getAbsolutePath(), result);
        } catch (Exception e) {

        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
        }

    }


    private void publishResults(String outputPath, int result) {
        Intent intent = new Intent(NOTIFICATION);
        intent.putExtra(FILEPATH, outputPath);
        intent.putExtra(RESULT, result);
        sendBroadcast(intent);
    }


}
