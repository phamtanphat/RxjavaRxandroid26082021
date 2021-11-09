package com.example.rxjavarxandroid26082021;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);

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


        Observable<String> stringObservable = Observable.just("Teo","Ti","Tun","Tuan","Hoa");

        stringObservable
                .subscribeOn(Schedulers.io())
                .map(new Function<String, String>() {
                    @Override
                    public String apply(String s) throws Throwable {
                        Log.d("BBB",Thread.currentThread().getName());
                        return "Hello " + s;
                    }
                })
//                .subscribeOn(AndroidSchedulers.mainThread())
//                .map(new Function<String, String>() {
//                    @Override
//                    public String apply(String s) throws Throwable {
//                        Log.d("BBB",Thread.currentThread().getName());
//                        Toast.makeText(MainActivity.this, s, Toast.LENGTH_SHORT).show();
//                        return "Hello main " + s;
//                    }
//                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Throwable {
                        Log.d("BBB",s);
                    }
                });


    }

}