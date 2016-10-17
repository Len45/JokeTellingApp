package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.example.RetrieveJoke;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);
        Button button=(Button) root.findViewById(R.id.buttonTellJoke);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RetrieveJoke retrieveJoke=new RetrieveJoke();
                new BackEndAsyncTask().execute(new Pair<Context, String>(getContext(), " "));
            }
        });

        return root;
    }
}
