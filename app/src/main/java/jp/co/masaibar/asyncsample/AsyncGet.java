package jp.co.masaibar.asyncsample;

import android.os.AsyncTask;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.ByteArrayOutputStream;

/**
 * Created by masaibar on 2015/06/23.
 */
public class AsyncGet extends AsyncTask<String, Integer, String>{
    private AsyncCallback _asyncCallback = null;

    public AsyncGet(AsyncCallback asyncCallback) {
        _asyncCallback = asyncCallback;
    }

    @Override
    protected String doInBackground(String... urls) {
        HttpClient httpClient = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet(urls[0]);

        try {
            HttpResponse httpResponse = httpClient.execute(httpGet);
            if (httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                httpResponse.getEntity().writeTo(outputStream);
                return outputStream.toString();
            }
        } catch (Exception e) {
            return null;
        }

        return null;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        _asyncCallback.onPreExecute();
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        _asyncCallback.onProgressUpdate(values[0]);
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        _asyncCallback.onPostExecute(result);
    }

    @Override
    protected void onCancelled() {
        super.onCancelled();
        _asyncCallback.onCancelled();
    }
}
