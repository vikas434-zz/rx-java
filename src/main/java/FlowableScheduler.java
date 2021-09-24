import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.schedulers.Schedulers;

/**
 * @author vranjan
 * created 24/09/2021
 */
public class FlowableScheduler {
    public static void main(String[] args) {
        Flowable.range(1, 10).observeOn(Schedulers.computation()).
                map(v -> v * v).subscribe(System.out::println);
    }
}
