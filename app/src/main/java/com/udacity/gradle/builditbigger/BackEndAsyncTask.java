package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.preference.PreferenceManager;
import android.support.v4.util.Pair;

import com.example.manoj2prabhakar.builitbigger.backend.myApi.MyApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;

import java.io.IOException;

/**
 * Created by manoj2prabhakar on 16/10/16.
 */

public class BackEndAsyncTask extends AsyncTask<Pair<Context, String>, Void, String> {
    private static MyApi myApiService = null;
    private Context context;

    @Override
    public String doInBackground(Pair<Context, String>...params) {
        if(myApiService == null) {  // Only do this once
            /*MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    // options for running against local devappserver
                    // - 10.0.2.2 is localhost's IP address in Android emulator
                    // - turn off compression when running against local devappserver
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });*/

            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                    .setRootUrl("https://builditbigge-manoj.appspot.com/_ah/api/");
            myApiService = builder.build();



        }
        context = params[0].first;
        String name = params[0].second;
        try {
            String joke=myApiService.getJokes(name).execute().getData();
            return joke;
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {
        SharedPreferences prefs= PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor edit=prefs.edit();
        edit.putString(com.example.jokedisplayer.MainActivity.JOKE,result);
        edit.commit();
    }
}
