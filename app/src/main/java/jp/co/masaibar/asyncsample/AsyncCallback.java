package jp.co.masaibar.asyncsample;

public interface AsyncCallback {

    void onPreExecute();
    void onPostExecute(String result);
    void onProgressUpdate(int progress);
    void onCancelled();
}
