package com.udacity.gradle.builditbigger;

import android.test.AndroidTestCase;

import com.example.manoj2prabhakar.builitbigger.backend.myApi.MyApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;

import java.io.IOException;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends AndroidTestCase {
    public ApplicationTest() {
    }
    public void verifyBackEnd(){
        MyApi myApiService = null;
        if(myApiService == null) {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                    .setRootUrl("https://builditbigge-manoj.appspot.com/_ah/api/");
            myApiService = builder.build();
        }
        try {
            String joke=myApiService.getJokes(" ").execute().getData();
            if (joke==null | joke.equals("")){
                fail();
            }
            assertTrue(true);
        } catch (IOException e) {
            if (e.getMessage()==null | e.getMessage().equals("")){
                fail();
            }
        }
    }
}