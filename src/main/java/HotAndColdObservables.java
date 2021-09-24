import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.observables.ConnectableObservable;

/**
 * @author vranjan
 * created 24/09/2021
 */
public class HotAndColdObservables {
    public static void main(String[] args) {
        createColdObservables();
        createHotObservableViaConnectedObservables();
    }

    private static void createHotObservableViaConnectedObservables() {
        ConnectableObservable<Integer> observable = ConnectableObservable.just(1, 2, 3, 4, 5).publish();
        System.out.println("Printing hot observable");
        observable.subscribe(integer -> System.out.println("Observer 1 " + integer));
        observable.connect(); // Nothing happens, if connect is not done. Also, as soon as connect is done,
        // it doesn't wait for observer to receive. This can be verified by making the main thread sleep.

    }

    private static void createColdObservables() {
        System.out.println("Printing numbers with cold observables");
        Observable<Integer> observable = Observable.just(1, 2, 3, 4, 5);
        observable.subscribe(System.out::println);
    }
}
