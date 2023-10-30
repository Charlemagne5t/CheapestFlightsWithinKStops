import java.util.*;

public class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<Pair>> adjacencyList = new HashMap<>();
        int distIn = 0;
        for (int i = 0; i < n; i++) {
            adjacencyList.put(i, new ArrayList<>());
        }
        for (int[] flight : flights) {
            int from = flight[0];
            int to = flight[1];
            if(to == dst){
                distIn++;
            }
            int cost = flight[2];
            List<Pair> destinations = adjacencyList.get(from);
            destinations.add(new Pair(to, cost));
            adjacencyList.put(from, destinations);
        }
        if (distIn == 0){
            return -1;
        }

        PriorityQueue<Stop> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(a -> a.currentCost));
        priorityQueue.add(new Stop(src, 0, k));
        while (!priorityQueue.isEmpty()){
            Stop current = priorityQueue.poll();
            if(current.nodeNumber == dst){
                return current.currentCost;
            }
            if(current.stopsLeft < 0){
                continue;
            }
            int currentNodeNumber = current.nodeNumber;

            List<Pair> neighbours = adjacencyList.get(currentNodeNumber);
            for (Pair nextNeighbour : neighbours) {
                int nextNeighbourNumber = nextNeighbour.to;
                    priorityQueue.add(new Stop(nextNeighbourNumber, current.currentCost + nextNeighbour.cost, current.stopsLeft - 1));

            }
        }

        return -1;
    }
}
class Pair {
    int to;
    int cost;

    public Pair(int to, int cost) {
        this.to = to;
        this.cost = cost;
    }


}
class Stop {
    int nodeNumber;
    int currentCost;
    int stopsLeft;

    public Stop(int nodeNumber, int currentCost, int stopsLeft) {
        this.nodeNumber = nodeNumber;
        this.currentCost = currentCost;
        this.stopsLeft = stopsLeft;
    }
}