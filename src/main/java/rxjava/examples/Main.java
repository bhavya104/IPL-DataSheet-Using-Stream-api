package rxjava.examples;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.Disposable;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Observable<Long> longObservable = Observable.interval(1, TimeUnit.SECONDS);
        Disposable disposable = longObservable.subscribe(System.out::println);
        Thread.sleep(5000);
        disposable.dispose();
        Thread.sleep(5000);

    }

}
