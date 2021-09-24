import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.core.Observable;

/**
 * @author vranjan
 * created 24/09/2021
 */
public class CreateObservables {
    public static void main(String[] args) {
        createObservableWithJust();
        createObservableWithIterable();
        createObservableWithCreateAndEmit();
    }

    private static void createObservableWithCreateAndEmit() {
        Observable<Integer> observable = Observable.create(emitter -> {
            emitter.onNext(1);
            emitter.onNext(2);
            emitter.onNext(null);
            emitter.onComplete();
        });
        System.out.println("Printing with emit");
        observable.subscribe(item -> System.out.println(item),
                             error -> System.out.println(error),
                             () -> System.out.println("On completed."));
    }

    private static void createObservableWithIterable() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        Observable<Integer> observable = Observable.fromIterable(list);
        System.out.println("Printing with iterables");
        observable.subscribe(System.out::println);
    }

    private static void createObservableWithJust() {
        System.out.println("Printing with numbers");
        Observable<Integer> observable = Observable.just(1, 2, 3, 4, 5);
        observable.subscribe(System.out::println);
    }
}
