package lv2;


public class 타일링 {

    public static int cnt = 0;

    public static void main(String[] args) {
//        int solution = Solution(2);
//        System.out.println(solution);


        long i = threeTilingDP(6);
        System.out.println(i);
    }

    public static int Solution(int n) {
        return dpFibo(n);
    }

    // 2xN 타일링
    // dp
    public static int dpFibo(int n) {
        int dp1 = 1;
        int dp2 = 2;

        int answer = 0;
        for (int i = 3; i <= n; i++) {
            answer = (dp1 + dp2) % 1000000007;
            dp1 = dp2;
            dp2 = answer;
        }

        return answer;
    }

    // 2xN 타일링
    // 시간복잡도 o(n^2)
    public static int recursiveCallFibo(int n) {
        if (n <= 2) return n;
        return (recursiveCallFibo(n - 2) + recursiveCallFibo(n - 1)) % 1000000007;
    }

    static void dfs(int n, int sum, int input) {
        if (sum + input > n) return;
        if (sum + input < n) {
            dfs(n, sum + input, 1);
            dfs(n, sum + input, 2);
        }
        if (sum + input == n) {
            cnt++;
            cnt = cnt % 1000000007;
        }
    }

    // 3xN 타일링
    public static long threeTilingDP(int n) {
        // 홀수의 경우에는 경우의 수가 0이 나온다.
        if (n % 2 == 1) return 0;
        long[] tile = new long[n + 1];
        tile[0] = 1;
        tile[2] = 3;

        for (int i = 4; i <= n; i += 2) {
            tile[i] = tile[i-2] * 3;
            for(int j=i-4; j>=0; j-=2){
                tile[i] += tile[j] * 2;
            }
            tile[i] = tile[i] % 1000000007;
        }

        return (int)tile[n];
    }

}
