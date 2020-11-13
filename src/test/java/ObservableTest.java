import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.operators.observable.ObservableAnySingle;
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
    Integer result;
    @Test
    public void should_start_observable() {

        Stream<Integer> boxed = Arrays.stream(IntStream.range(1, 100).toArray()).boxed();
        ArrayList<Integer> ints = (ArrayList<Integer>) boxed.collect(Collectors.toList());
//        Observable<Integer> observable = Observable.just(20);
        SingleSource<Integer> observable = ObservableAnySingle.just(10);

        observable.subscribe(new SingleObserver<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                logger.info("onSubscribe");
            }

            @Override
            public void onSuccess(Integer integer) {
                logger.info("single event: " + integer);
            }

            @Override
            public void onError(Throwable e) {
                logger.info("onError");
            }
        });


    }
}


