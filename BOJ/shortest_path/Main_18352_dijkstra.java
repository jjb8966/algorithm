package shortest_path;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_18352_dijkstra {

    private static int numberOfCity;
    private static int numberOfRoad;
    private static int targetDistance;
    private static int startCity;
    private static int[] minDistance;
    private static ArrayList<Integer> result = new ArrayList<>();
    private static ArrayList<City>[] adjacencyList;

    static class City {

        int number;
        int distance;

        public City(int number, int distance) {
            this.number = number;
            this.distance = distance;
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

        st = new StringTokenizer(br.readLine());
        numberOfCity = Integer.parseInt(st.nextToken());
        numberOfRoad = Integer.parseInt(st.nextToken());
        targetDistance = Integer.parseInt(st.nextToken());
        startCity = Integer.parseInt(st.nextToken());

        minDistance = new int[numberOfCity + 1];
        adjacencyList = new ArrayList[numberOfCity + 1];

        for (int i = 1; i <= numberOfCity; i++) {
            adjacencyList[i] = new ArrayList<>();
        }

        for (int i = 0; i < numberOfRoad; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int destination = Integer.parseInt(st.nextToken());

            adjacencyList[start].add(new City(destination, 1));
        }
    }

    private static void process() {
        dijkstra(startCity);

        for (int city = 1; city <= numberOfCity; city++) {
            if (minDistance[city] == targetDistance) {
                result.add(city);
            }
        }

        if (result.isEmpty()) {
            result.add(-1);
        }
    }

    private static void dijkstra(int startCity) {
        Queue<City> queue = new PriorityQueue<>(Comparator.comparingInt(city -> city.distance));

        initDistance();
        queue.add(new City(startCity, 0));

        while (!queue.isEmpty()) {
            City city = queue.poll();
            int cityNumber = city.number;
            int cityDistance = city.distance;

            if (cityDistance > minDistance[cityNumber]) {
                continue;
            }

            for (City nextCity : adjacencyList[cityNumber]) {
                int nextCityNumber = nextCity.number;
                int newDistance = minDistance[cityNumber] + nextCity.distance;

                if (newDistance >= minDistance[nextCityNumber]) {
                    continue;
                }

                minDistance[nextCityNumber] = newDistance;
                queue.add(new City(nextCityNumber, newDistance));
            }
        }
    }

    private static void initDistance() {
        for (int city = 1; city <= numberOfCity; city++) {
            minDistance[city] = Integer.MAX_VALUE;

            if (city == startCity) {
                minDistance[city] = 0;
            }
        }
    }

    private static void output() {
        result.forEach(System.out::println);
    }

}
