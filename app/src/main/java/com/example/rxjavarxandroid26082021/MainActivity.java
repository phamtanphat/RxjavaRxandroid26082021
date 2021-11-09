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
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.function.Consumer;

public class MainActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//        List<String> list = new ArrayList<>(Arrays.asList("A","B","C","D","E"));
//
//        // iterator đại diện cho phần tử
//        // iterable đại diện cho list
//        Iterable<String> iterable = list;
//
//        iterable.forEach(new Consumer<String>() {
//            @Override
//            public void accept(String s) {
//                Log.d("BBB",s);
//            }
//        });
//        Log.d("BBB","Tiếp tục");

        try {
            int[]result = handleData().get();
            int[]result2 = handleData1().get();
            Log.d("BBB",result[0] + "");
            Log.d("BBB",result2[0] + "");
        } catch (ExecutionException e) {
            e.printStackTrace();
            Log.d("BBB",e.getMessage());
        } catch (InterruptedException e) {
            e.printStackTrace();
            Log.d("BBB",e.getMessage());
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private Future<int[]> handleData() {
        ExecutorService executor = Executors.newFixedThreadPool(1);
        int[] a = {0};
        Future<int[]> future = executor.submit(new Runnable() {
            @Override
            public void run() {
                Log.d("BBB",Thread.currentThread().getName());
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                a[0] = 10;
            }
        },a);
        return future;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private Future<int[]> handleData1() {
        ExecutorService executor = Executors.newFixedThreadPool(1);
        int[] a = {0};
        Future<int[]> future = executor.submit(new Runnable() {
            @Override
            public void run() {
                Log.d("BBB",Thread.currentThread().getName());
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                a[0] = 10;
            }
        },a);
        return future;
    }
}