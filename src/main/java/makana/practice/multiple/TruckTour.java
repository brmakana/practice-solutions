package makana.practice.multiple;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

@Slf4j
public class TruckTour {
    public static class Truck {
        int fuel;
        int distance;

        public Truck(int fuel, int distance) {
            this.fuel = fuel;
            this.distance = distance;
        }
    }

    public static int truckTour(Scanner scanner) {
        int size = Integer.parseInt(scanner.nextLine().trim());
        Queue<Truck> truckQueue = new LinkedList<>();
        int totalFuel = 0;
        int index = 0;
        for (int i = 0; i < size; i++) {
            int fuel = scanner.nextInt();
            int distance = scanner.nextInt();
            Truck truck = new Truck(fuel, distance);
            truckQueue.add(truck);
            totalFuel += fuel;
            totalFuel -= distance;
            if (totalFuel < 0) {
                index = i + 1;
                totalFuel = 0;
            } else if (i + 1 > size - 1) {
                Truck currentTruck = truck;
                while (truckQueue.size() > 1) {
                    Truck nextTruck = truckQueue.poll();
                    totalFuel += nextTruck.fuel;
                    totalFuel -= nextTruck.distance;
                    if (totalFuel < 0) {
                        return -1;
                    }
                }
                return index;
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int smallestIndex = truckTour(scanner);
        System.out.println(smallestIndex);
        scanner.close();
    }

}