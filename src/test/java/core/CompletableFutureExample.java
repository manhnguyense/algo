package core;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureExample {
    public static void main(String[] args) {
        // Tạo một CompletableFuture và chạy một tác vụ bất đồng bộ
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            // Tác vụ tốn thời gian
            try {
                Thread.sleep(2000);
                System.out.println("Tác vụ đã hoàn thành!");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        // Chờ tác vụ hoàn thành
        try {
            future.get(); // Phương thức get() sẽ chờ cho tới khi tác vụ hoàn thành
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
