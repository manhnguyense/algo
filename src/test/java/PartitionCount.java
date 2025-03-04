public class PartitionCount {
    public static int partitionCount(int N) {
        // Tạo mảng dp để lưu trữ số phân hoạch của các số từ 0 đến N
        int[] dp = new int[N + 1];
        dp[0] = 1; // Có 1 cách để phân hoạch số 0 (không có phần tử nào)

        // Tính số phân hoạch cho từng số từ 1 đến N
        for (int i = 1; i <= N; i++) {
            for (int j = i; j <= N; j++) {
                dp[j] += dp[j - i];
            }
        }

        return dp[N];
    }
}
