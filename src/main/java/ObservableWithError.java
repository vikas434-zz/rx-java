import io.reactivex.rxjava3.core.Observable;

/**
 * @author vranjan
 * created 24/09/2021
 */
public class ObservableWithError {
    public static void main(String[] args) {
        observableError();
        observableErrorWithCallable();
    }

    private static void observableErrorWithCallable() {
        System.out.println("With callable");
        Observable observable = Observable.error(() -> new Exception("A new exception"));
        observable.subscribe(System.out::println,
                             error -> System.out.println("Error 1" + error.hashCode()));
        observable.subscribe(System.out::println,
                             error -> System.out.println("Error 2" + error.hashCode()));
    }

    private static void observableError() {
        System.out.println("Without callable");
        Observable observable = Observable.error(new Exception("A new exception"));
        observable.subscribe(System.out::println,
                             error -> System.out.println("Error 1" + error.hashCode()));
        observable.subscribe(System.out::println,
                             error -> System.out.println("Error 2" + error.hashCode()));
    }
}
