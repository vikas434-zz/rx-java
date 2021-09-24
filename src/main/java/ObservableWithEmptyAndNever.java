import io.reactivex.rxjava3.core.Observable;

/**
 * @author vranjan
 * created 24/09/2021
 */
public class ObservableWithEmptyAndNever {
    public static void main(String[] args) {
        emptyObservable();
        neverObservable();
    }

    private static void neverObservable() {
        // Never emits object, subscriber always waiting.
        System.out.println("Never observable");
        Observable observable = Observable.never();
        observable.subscribe(System.out::println, System.out::println, () -> System.out.println("completed"));
    }

    private static void emptyObservable() {
        // Doesn't emit anything and gets competed.
        System.out.println("Empty observable");
        Observable observable = Observable.empty();
        observable.subscribe(System.out::println);
    }
}
