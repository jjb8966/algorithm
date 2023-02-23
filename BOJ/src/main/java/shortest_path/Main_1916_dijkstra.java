package shortest_path;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1916_dijkstra {

    private static int numberOfCity;
    private static int numberOfBus;
    private static int start;
    private static int destination;
    private static int[] minCost;
    private static ArrayList<City>[] adjacencyList;

    static class City {

        int number;
        int cost;

        public City(int number, int cost) {
            this.number = number;
            this.cost = cost;
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

        numberOfCity = Integer.parseInt(br.readLine());
        numberOfBus = Integer.parseInt(br.readLine());

        adjacencyList = new ArrayList[numberOfCity + 1];
        minCost = new int[numberOfCity + 1];

        for (int i = 1; i <= numberOfCity; i++) {
            adjacencyList[i] = new ArrayList<>();
        }

        for (int i = 0; i < numberOfBus; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int destination = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            adjacencyList[start].add(new City(destination, cost));
        }

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        destination = Integer.parseInt(st.nextToken());
    }

    private static void process() {
        dijkstra(start);
    }

    private static void dijkstra(int startCity) {
        PriorityQueue<City> queue = new PriorityQueue<>(Comparator.comparingInt(city -> city.cost));

        initMinCost();
        queue.add(new City(startCity, 0));

        while (!queue.isEmpty()) {
            City city = queue.poll();
            int cityNumber = city.number;
            int cityCost = city.cost;

            if (cityCost > minCost[cityNumber]) {
                continue;
            }

            for (City nextCity : adjacencyList[cityNumber]) {
                int nextCityNumber = nextCity.number;
                int newCost = minCost[cityNumber] + nextCity.cost;

                if (newCost >= minCost[nextCityNumber]) {
                    continue;
                }

                minCost[nextCityNumber] = newCost;
                queue.add(new City(nextCity.number, newCost));
            }
        }
    }

    private static void initMinCost() {
        for (int city = 1; city <= numberOfCity; city++) {
            minCost[city] = Integer.MAX_VALUE;

            if (city == start) {
                minCost[city] = 0;
            }
        }
    }

    private static void output() {
        System.out.println(minCost[destination]);
    }

}
