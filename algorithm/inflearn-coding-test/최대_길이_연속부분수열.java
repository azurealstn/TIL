import java.io.*;
import java.util.*;

public class Main {
    public static int solution(int n, int k, int[] arr) {
        int answer = 0, cnt = 0;
        int lt = 0;

        //rt는 계속 증가
        for (int rt = 0; rt < n; rt++) {
            if (arr[rt] == 0) cnt++; //0인 부분은 cnt 증가
            while (cnt > k) { //cnt가 k보다 클 때 동안
                if (arr[lt] == 0) cnt--;
                lt++;
            }
            answer = Math.max(answer, rt - lt + 1); //rt - lt + 1 : 길이의 합
        }

        return answer;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(solution(n, k, arr));
    }
}
