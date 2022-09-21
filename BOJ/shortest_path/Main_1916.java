package shortest_path;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_1916 {

    private static int numberOfCity;
    private static int numberOfBus;
    private static int startCity;
    private static int destination;
    private static int[] minimumDistanceFromStartTo;
    private static ArrayList<City>[] adjacencyList;

    static class City {
        int number;
        int distance;

        public City(int number, int distance) {
            this.number = number;
            this.distance = distance;
        }

        public int getNumber() {
            return number;
        }

        public int getDistance() {
            return distance;
        }

        @Override
        public String toString() {
            return "City{" +
                    "number=" + number +
                    ", distance=" + distance +
                    '}';
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
        output();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int start;
        int to;
        int distance;

        st = new StringTokenizer(br.readLine());
        numberOfCity = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        numberOfBus = Integer.parseInt(st.nextToken());

        adjacencyList = new ArrayList[numberOfCity + 1];     // 1 + numberOfCity
        minimumDistanceFromStartTo = new int[numberOfCity + 1];

        for (int i = 1; i <= numberOfCity; i++) {
            adjacencyList[i] = new ArrayList<>();
        }

        for (int i = 0; i < numberOfBus; i++) {
            st = new StringTokenizer(br.readLine());

            start = Integer.parseInt(st.nextToken());
            to = Integer.parseInt(st.nextToken());
            distance = Integer.parseInt(st.nextToken());

            adjacencyList[start].add(new City(to, distance));
        }

        st = new StringTokenizer(br.readLine());
        startCity = Integer.parseInt(st.nextToken());
        destination = Integer.parseInt(st.nextToken());
    }

    private static void process() {
        dijkstra(startCity);
    }

    private static void dijkstra(int startCity) {
        PriorityQueue<City> queue = new PriorityQueue<>((Comparator.comparingInt(o -> o.distance)));

        // dist 배열 초기화
        for (int i = 1; i <= numberOfCity; i++) {
            if (i == startCity) {
                minimumDistanceFromStartTo[i] = 0;
            } else {
                minimumDistanceFromStartTo[i] = Integer.MAX_VALUE;
            }
        }

        queue.add(new City(startCity, 0));  // queue에 들어가는 city : start -> nextCity

        while (!queue.isEmpty()) {
            City currentCity = queue.poll();
            int currentCityNumber = currentCity.getNumber();
            int currentCityDistance = currentCity.getDistance();

            if (currentCityDistance > minimumDistanceFromStartTo[currentCityNumber]) {
                continue;
            }

            for (City nextCity : adjacencyList[currentCityNumber]) {
                int nextCityNumber = nextCity.getNumber();
                int nextCityDistance = nextCity.getDistance();

                if ((currentCityDistance + nextCityDistance) >= minimumDistanceFromStartTo[nextCityNumber]) {
                    continue;
                }

                minimumDistanceFromStartTo[nextCityNumber] = currentCityDistance + nextCityDistance;

                queue.add(new City(nextCityNumber, minimumDistanceFromStartTo[nextCityNumber]));
            }
        }
    }

    private static void output() {
        System.out.println(minimumDistanceFromStartTo[destination]);
    }

}
