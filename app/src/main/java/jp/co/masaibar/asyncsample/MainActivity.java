package jp.co.masaibar.asyncsample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AsyncGet asyncGet = new AsyncGet(new AsyncCallback() {
            @Override
            public void onPreExecute() {
                //do something
            }

            @Override
            public void onPostExecute(@Nullable String result) {
                if (result != null) {
                    Log.d("onPostExecute", result);
                } else {
                    Log.d("onPostExecute", "nulllllllllllllllllllll");
                }
            }

            @Override
            public void onProgressUpdate(int progress) {
                Log.d("onProgressUpdate", progress+"%");
            }

            @Override
            public void onCancelled() {

            }
        });
        asyncGet.execute("http://my.yahoo.co.jp/");
    }
}
