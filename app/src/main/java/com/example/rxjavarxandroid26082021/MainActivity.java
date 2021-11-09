package com.example.rxjavarxandroid26082021;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class MainActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        List<String> list = new ArrayList<>(Arrays.asList("A","B","C","D","E"));

        // iterator đại diện cho phần tử
        // iterable đại diện cho list
        Iterable<String> iterable = list;

        iterable.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                Log.d("BBB",s);
            }
        });
    }
}