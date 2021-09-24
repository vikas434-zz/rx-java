import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;

/**
 * @author vranjan
 * created 24/09/2021
 */
public class ObservableWithObserver {
    public static void main(String[] args) {
        Observable<Integer> observable = Observable.just(1, 2, 3, 4, 5);

        Observer<Integer> observer = new Observer<Integer>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                System.out.println("Subscribed");
                System.out.println(d.isDisposed());
            }

            @Override
            public void onNext(@NonNull Integer integer) {
                System.out.println("On Next");
                System.out.println(integer);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                System.out.println("On Next");
                System.out.println(e.getLocalizedMessage());
            }

            @Override
            public void onComplete() {
                System.out.println("Completed");
            }
        };

        observable.subscribe(observer);
    }
}
