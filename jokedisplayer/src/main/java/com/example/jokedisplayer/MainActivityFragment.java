package com.example.jokedisplayer;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView=inflater.inflate(R.layout.fragment_jokedisplay, container, false);
        TextView textView=(TextView) rootView.findViewById(R.id.displayJoke);
        SharedPreferences preferences= PreferenceManager.getDefaultSharedPreferences(getContext());
        String joke=preferences.getString(MainActivity.JOKE,"not retrieved");
        textView.setText(joke);

        return rootView;
    }
}
