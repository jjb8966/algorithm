package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * for 문 내에서 index를 찾는 작업을 포함시켜 시간초과 오류가 남
 * Top 클래스를 별도로 생성해 탑의 인덱스를 각 객체가 가지도록 수정하여 문제 해결
 */
public class Main_2493 {

    static class Top {
        int index;
        int height;

        void set(int index, int height) {
            this.index = index;
            this.height = height;
        }
    }

    public static void main(String[] args) throws IOException {
        Stack<Top> stack = new Stack<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int number;
        String[] str;

        number = Integer.parseInt(br.readLine());       //타워의 갯수
        str = br.readLine().split(" ");

        for (int i = 0; i < number; i++) {
            Top top = new Top();
            top.set(i+1, Integer.parseInt(str[i]));       //i+1 = 타워의 인덱스

            while (true) {
                if (stack.empty()) {                    //stack이 비어있으면 0 저장하고 현재 타워 push
                    sb.append(0 + " ");
                    stack.push(top);
                    break;
                }

                if (stack.peek().height >= top.height) {    //stack의 peek 탑이 현재 탑보다 클 시 peek 탑의 인덱스 저장 & 현재 탑 push
                    sb.append(stack.peek().index + " ");
                    stack.push(top);
                    break;
                }

                if (stack.peek().height < top.height) {     //peek 탑이 현자 탑보다 작을 시 pop
                    stack.pop();
                }
            }
        }

        System.out.print(sb);
    }
}
