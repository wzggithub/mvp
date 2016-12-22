package com.project.wechat.home.home;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Button;
import com.project.wechat.home.bean.ComBody;
import com.project.wechat.home.home.adapter.ComRecyclerAdapter;
import java.util.ArrayList;
import java.util.List;
import appframework.com.mvpprojet.R;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class HomeActivity extends AppCompatActivity {


    private RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home2);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        recyclerView.setLayoutManager(new LinearLayoutManager(HomeActivity.this));

        ComBody body1 = new ComBody();
        body1.title = "测试标题1";
        body1.content = "测试内容1";
        ComBody body2 = new ComBody();
        body2.title = "测试标题2";
        body2.content = "测试内容2";
        ComBody body3 = new ComBody();
        body3.title = "测试标题3";
        body3.content = "测试内容4";

        List<ComBody> list = new ArrayList<ComBody>();
        list.add(body1);
        list.add(body2);
        list.add(body3);

        ComRecyclerAdapter comRecyclerAdapter = new ComRecyclerAdapter(HomeActivity.this, list);
        recyclerView.setAdapter(comRecyclerAdapter);

        Button button = (Button) findViewById(R.id.click_button);


        Observable<Integer> observable = Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {


                Log.i("rxjava","Thread :" + Thread.currentThread().getName());
                Log.i("rxjava","耗时操作");

                emitter.onNext(1);
            }
        });

        Observer<Integer> observer = new Observer<Integer>() {

            private Disposable mDisposable;
            private int i;

            @Override
            public void onSubscribe(Disposable d) {
                Log.i("rxjava","onSubscribe");

                mDisposable = d;


            }

            @Override
            public void onNext(Integer value) {


                Log.i("rxjava","onNext " + value);

//                i++;
//                if (i==2) {
//                    Log.i("rxjava","dispose " + value);
//                    mDisposable.dispose();
//                    Log.i("rxjava","isDisposed = " + mDisposable.isDisposed());
//                }


            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {
                Log.i("rxjava","onComplete");
            }
        };

//        observable.subscribe(observer);

        Consumer<Integer> consumer = new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {

                Log.i("rxjava","accept Thread :" + Thread.currentThread().getName());
                Log.i("rxjava","耗时操作结果处理 accept " + integer);
            }
        };

        observable.subscribeOn(Schedulers.newThread())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .observeOn(Schedulers.io())
                .subscribe(consumer);
    }



}
