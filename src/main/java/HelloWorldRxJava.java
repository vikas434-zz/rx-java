import io.reactivex.rxjava3.core.Flowable;

/**
 * @author vranjan
 * created 24/09/2021
 */
public class HelloWorldRxJava {
    public static void main(String[] args) {
        Flowable.just("Hello world").subscribe(System.out::println);
    }
}
