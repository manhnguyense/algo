package core;

import java.util.*;
import java.util.concurrent.*;

public class RunnableExecute {

    private static <K, V> Map<K, V> executeThreads(final int threads,
                                                   final String step,
                                                   final Collection<Callable<Map<K, V>>> callables,
                                                   final CountDownLatch countDownLatch) {
        final Map<K, V> results = new HashMap<>();
        final ExecutorService executorService = Executors.newFixedThreadPool(threads);
        final List<Future<Map<K, V>>> futures = new ArrayList<>();
        try {
            for (final Callable<Map<K, V>> callable : callables) {
                futures.add(executorService.submit(callable));
            }
            countDownLatch.await();
            for (final Future<Map<K, V>> future : futures) {
                if (future.isDone()) {
                    results.putAll(future.get());
                }
            }
            return results;
        } catch (final Exception e) {
            return Collections.emptyMap();
        } finally {
            executorService.shutdown();
        }
    }
}
