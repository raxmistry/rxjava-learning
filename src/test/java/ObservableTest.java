import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.operators.observable.ObservableAnySingle;
import io.reactivex.observables.ConnectableObservable;
import io.reactivex.observers.DisposableObserver;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ObservableTest {

    private Logger logger = Logger.getLogger("blah");

    @Test
    public void should_start_observable() {

        Stream<Integer> boxed = Arrays.stream(IntStream.range(1, 100).toArray()).boxed();
        ArrayList<Integer> ints = (ArrayList<Integer>) boxed.collect(Collectors.toList());
        ConnectableObservable<Integer> observable = ConnectableObservable.fromIterable(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 11, 12, 13, 14, 15, 16, 17)).publish();

        observable.subscribe(value -> logger.info("A:" + value));
        observable.subscribe(value -> logger.info("B:" + value));

        observable.connect();
    }

    @Test
    void observable_with_strings() {
        List<String> strings = new ArrayList<String>(
                Arrays.asList("Hello", "world")
        );

        Observable<String> observable = Observable.fromIterable(strings);
        observable.subscribe(s -> System.out.println(s));
    }
}


