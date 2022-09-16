package graph_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_2644 {

    private static int totalNumber;
    private static int countOfRelation;
    private static ArrayList<Integer>[] adjacencyList;
    private static boolean[] visited;
    private static int result = Integer.MAX_VALUE;
    private static Person firstPerson;
    private static Person secondPerson;

    static class Person {
        int number;
        int count;

        public Person(int number, int count) {
            this.number = number;
            this.count = count;
        }

        public int getNumber() {
            return number;
        }

        public void setNumber(int number) {
            this.number = number;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
        output();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        totalNumber = Integer.parseInt(st.nextToken());

        adjacencyList = new ArrayList[totalNumber + 1]; // 1 ~ totalNumber
        visited = new boolean[totalNumber + 1];

        for (int i = 1; i <= totalNumber; i++) {
            adjacencyList[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());
        firstPerson = new Person(Integer.parseInt(st.nextToken()),0);
        secondPerson = new Person(Integer.parseInt(st.nextToken()), 0);

        st = new StringTokenizer(br.readLine());
        countOfRelation = Integer.parseInt(st.nextToken());

        for (int i = 0; i < countOfRelation; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adjacencyList[a].add(b);
            adjacencyList[b].add(a);
        }
    }

    private static void process() {
        bfs();

        if (result == Integer.MAX_VALUE) {
            result = -1;
        }
    }

    private static void bfs() {
        Queue<Person> queue = new LinkedList<>();

        queue.add(firstPerson);
        visited[firstPerson.getNumber()] = true;

        while (!queue.isEmpty()) {
            Person nextPerson = queue.poll();

            for (Integer personNumber : adjacencyList[nextPerson.getNumber()]) {
                if (visited[personNumber]) {
                    continue;
                }

                if (personNumber == secondPerson.getNumber()) {
                    result = nextPerson.getCount() + 1;
                    return;
                }

                queue.add(new Person(personNumber, nextPerson.getCount() + 1));
                visited[personNumber] = true;
            }
        }
    }

    private static void output() {
        System.out.println(result);
    }
}