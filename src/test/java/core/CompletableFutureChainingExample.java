package core;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureChainingExample {
    public static void main(String[] args) {
        // Tạo và chạy một tác vụ bất đồng bộ
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Tác vụ 1 đã hoàn thành!");
        }).thenRunAsync(() -> { // Chuỗi hóa với tác vụ thứ hai
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Tác vụ 2 đã hoàn thành!");
        });

        // Chờ các tác vụ hoàn thành
        try {
            future.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
