/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Endpoints Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
*/

package com.example.manoj2prabhakar.builitbigger.backend;

import com.example.RetrieveJoke;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

import javax.inject.Named;

/**
 * An endpoint class we are exposing
 */
@Api(
        name = "myApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "backend.builitbigger.manoj2prabhakar.example.com",
                ownerName = "backend.builitbigger.manoj2prabhakar.example.com",
                packagePath = ""
        )
)
public class JokesEndpoint {

    /**
     * A simple endpoint method that takes a name and says Hi back
     */
    @ApiMethod(name = "getJokes")
    public JokesBean getJokes(@Named("name") String name) {
        JokesBean response = new JokesBean();
        RetrieveJoke joke=new RetrieveJoke();
        String joke1 =joke.getJoke();
        response.setData(joke1);
        return response;
    }

}
