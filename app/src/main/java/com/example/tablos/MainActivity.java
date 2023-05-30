package com.example.tablos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Integer zenit = 0;
    private Integer spartak = 0;
    private TextView zenitTextView;
    private TextView spartakTextView;
    private static final String TAG = "MainActivity";

    @Override
    protected void onResume() {
        super.onResume();
        resetUI();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        zenitTextView = findViewById(R.id.num_1);
        spartakTextView = findViewById(R.id.num_2);

    }

    public void onClickAddMeteor(View view) {
        zenit++;
        zenitTextView.setText(zenit.toString());
    }

    public void onClickAddPennant(View view) {
        spartak++;
        spartakTextView.setText(spartak.toString());
    }

    public void onClickButtonDropping(View view) {
        zenit = 0;
        spartak = 0;
        resetUI();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("meteor", zenit);
        outState.putInt("pennant", spartak);

        TextView counterView = findViewById(R.id.num_1);
        counterView.setText(zenit.toString());

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState != null && savedInstanceState.containsKey("meteor")) {
            zenit = savedInstanceState.getInt("meteor");
        }
        if ((savedInstanceState != null && savedInstanceState.containsKey("pennant"))) {
            spartak = savedInstanceState.getInt("pennant");
        }
        TextView counterView = findViewById(R.id.num_1);
        counterView.setText(zenit.toString());

    }
    private void resetUI() {
        zenitTextView.setText(zenit.toString());
        spartakTextView.setText(spartak.toString());

    }

}