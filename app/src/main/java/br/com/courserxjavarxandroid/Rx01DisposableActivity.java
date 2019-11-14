package br.com.courserxjavarxandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class Rx01DisposableActivity extends AppCompatActivity {

    private Disposable disposable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx01_disposable);

        Observable<String> numbersObservable =
                Observable.just("1", "2", "3", "4", "5", "6", "7", "8", "9", "10");

        Observer<String> numbersObserver = new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                disposable = d;
                Log.d("TAG1", "onSubscribe" + " Thread: " + Thread.currentThread().getName());
            }

            @Override
            public void onNext(String numero) {
                Log.d("TAG1", "onNext - Number: " + numero + " Thread: " + Thread.currentThread().getName());
            }

            @Override
            public void onError(Throwable e) {
                Log.d("TAG1", "onError" + " Thread: " + Thread.currentThread().getName());
            }

            @Override
            public void onComplete() {
                Log.d("TAG1", "onComplete: All data has been issued" + " Thread: " + Thread.currentThread().getName());
            }
        };

        numbersObservable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(numbersObserver);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        disposable.dispose();
        Log.d("TAG1", "onDestroy: discard the subscription" + " Thread: " + Thread.currentThread().getName());
    }
}