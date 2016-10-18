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
import android.widget.ProgressBar;
import java.util.concurrent.ExecutionException;
import android.content.Intent;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View root = inflater.inflate(R.layout.fragment_main, container, false);
        Button button=(Button) root.findViewById(R.id.buttonTellJoke);
        final ProgressBar bar=(ProgressBar) root.findViewById(R.id.progressBar1);
        bar.setVisibility(View.GONE);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RetrieveJoke retrieveJoke=new RetrieveJoke();
                try {
                    bar.setVisibility(View.VISIBLE);
                    new BackEndAsyncTask().execute(new Pair<Context, String>(getContext(), " ")).get();
                    bar.setVisibility(View.GONE);
                    Intent intent=new Intent(getContext(), com.example.jokedisplayer.MainActivity.class);
                    startActivity(intent);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }
        });

        return root;
    }

}
