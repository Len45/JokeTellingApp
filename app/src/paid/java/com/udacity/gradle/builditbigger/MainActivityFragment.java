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
import android.support.v4.content.LocalBroadcastManager;
import android.content.Intent;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;



/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    public static ProgressBar bar;
    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        IntentFilter statusIntentFilter = new IntentFilter(
                BackEndAsyncTask.BROADCAST_ACTION);
        ReceiveStartIntent startIntent =
                new ReceiveStartIntent();
        LocalBroadcastManager.getInstance(getContext()).registerReceiver(
                startIntent, statusIntentFilter );



        final View root = inflater.inflate(R.layout.fragment_main, container, false);
        Button button=(Button) root.findViewById(R.id.buttonTellJoke);
        bar=(ProgressBar) root.findViewById(R.id.progressBar1);
        bar.setVisibility(View.GONE);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RetrieveJoke retrieveJoke=new RetrieveJoke();
                    bar.setVisibility(View.VISIBLE);
                    new BackEndAsyncTask().execute(new Pair<Context, String>(getContext(), " "));
                    //bar.setVisibility(View.GONE);

            }
        });

        return root;
    }

    public static class ReceiveStartIntent extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals(BackEndAsyncTask.BROADCAST_ACTION)){
                bar.setVisibility(View.GONE);
                Intent intent1=new Intent(context, com.example.jokedisplayer.MainActivity.class);
                intent1.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent1);
            }

        }
    }



}


