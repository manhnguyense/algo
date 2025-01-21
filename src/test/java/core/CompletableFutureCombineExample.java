package core;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureCombineExample {
    public static void main(String[] args) {
        // Tạo và chạy hai tác vụ bất đồng bộ
        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 10;
        });

        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 20;
        });

        // Kết hợp kết quả của hai CompletableFuture
        CompletableFuture<Integer> combinedFuture = future1.thenCombine(future2, Integer::sum);

        // Chờ kết quả của tác vụ kết hợp
        try {
            System.out.println("Kết quả kết hợp: " + combinedFuture.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
