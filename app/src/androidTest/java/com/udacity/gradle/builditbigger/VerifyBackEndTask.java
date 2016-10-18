package com.udacity.gradle.builditbigger;

import android.support.test.runner.AndroidJUnit4;
import android.test.AndroidTestCase;

import com.example.manoj2prabhakar.builitbigger.backend.myApi.MyApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;

import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by manoj2prabhakar on 19/10/16.
 */

@RunWith(AndroidJUnit4.class)
public class VerifyBackEndTask extends AndroidTestCase{
    @Test
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
        } catch (Exception e) {
            if (e.getMessage()==null | e.getMessage().equals("")){
                fail();
            }
            assertTrue(true);
        }
    }
}
