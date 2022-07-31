package lv2;

public class 타일링 {

    public static int cnt = 0;

    public static void main(String[] args) {
        int solution = Solution(2);
        System.out.println(solution);
    }

    public static int Solution(int n) {
        return dpFibo(n);
    }


    // dp
    public static int dpFibo(int n){
        int dp1 = 1;
        int dp2 = 2;

        int answer = 0;
        for(int i = 3; i <= n; i++){
            answer = (dp1 + dp2) % 1000000007;
            dp1 = dp2;
            dp2 = answer;
        }

        return answer;
    }

    // 시간복잡도 o(n^2)
    public static int recursiveCallFibo(int n){
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

}
