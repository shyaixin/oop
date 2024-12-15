package entity;
import java.util.*;
import java.util.LinkedList;

public class Ride implements RideInterface {

    private String rideName;
    private Integer maxRider;
    private Employee operator;
    private Queue<Visitor> visitorQueue;
    private LinkedList<Visitor> rideHistory;
    private Integer numOfCycles;

    public Ride() {

    }

    public Ride(String rideName, int maxRider, Employee operator) {
        this.rideName = rideName;
        this.maxRider = maxRider;
        this.operator = operator;
        this.visitorQueue = new LinkedList<>();
        this.rideHistory = new LinkedList<>();
        this.numOfCycles = 0;
    }


    public String getRideName() {
        return rideName;
    }

    public void setRideName(String rideName) {
        this.rideName = rideName;
    }

    public Integer getMaxRider() {
        return maxRider;
    }

    public void setMaxRider(Integer maxRider) {
        if (maxRider < 1) {
            System.out.println("maxRider must be at least 1.");
        } else {
            this.maxRider = maxRider;
        }
    }

    public Employee getOperator() {
        return operator;
    }

    public void setOperator(Employee operator) {
        this.operator = operator;
    }

    public Queue<Visitor> getVisitorQueue() {
        return visitorQueue;
    }

    public void setVisitorQueue(Queue<Visitor> visitorQueue) {
        this.visitorQueue = visitorQueue;
    }

    public LinkedList<Visitor> getRideHistory() {
        return rideHistory;
    }

    public void setRideHistory(LinkedList<Visitor> rideHistory) {
        this.rideHistory = rideHistory;
    }

    public Integer getNumOfCycles() {
        return numOfCycles;
    }

    public void setNumOfCycles(Integer numOfCycles) {
        this.numOfCycles = numOfCycles;
    }

    @Override
    public void addVisitorToQueue(Visitor visitor) {
        if (visitor != null) {
            visitorQueue.add(visitor);
            System.out.println("Successfully added visitor to queue: " + visitor.getName());
        } else {
            System.out.println("Cannot add null visitor to queue.");
        }
    }

    @Override
    public void removeVisitorFromQueue() {
        Visitor removedVisitor = visitorQueue.poll();
        if (removedVisitor != null) {
            System.out.println("Successfully removed visitor from queue: " + removedVisitor.getName());
        } else {
            System.out.println("Queue is empty, no visitor to remove.");
        }
    }

    @Override
    public void printQueue() {
        if (visitorQueue.isEmpty()) {
            System.out.println("Queue is empty.");
        } else {
            System.out.println("Visitors in the queue:");
            for (Visitor v : visitorQueue) {
                System.out.println(v);
            }
        }
    }

    @Override
    public void addVisitorToHistory(Visitor visitor) {
        if (visitor != null) {
            rideHistory.add(visitor);
            System.out.println("Successfully added visitor to history: " + visitor.getName());
        } else {
            System.out.println("Cannot add null visitor to history.");
        }
    }

    @Override
    public boolean checkVisitorFromHistory(Visitor visitor) {
        if (rideHistory.contains(visitor)) {
            System.out.println("Visitor is in the history: " + visitor.getName());
            return true;
        } else {
            System.out.println("Visitor is not in the history: " + visitor.getName());
            return false;
        }
    }

    @Override
    public int numberOfVisitors() {
        System.out.println("Number of visitors in the history: " + rideHistory.size());
        return rideHistory.size();
    }

    @Override
    public void printRideHistory() {
        if (rideHistory.isEmpty()) {
            System.out.println("History is empty.");
        } else {
            System.out.println("Visitors who have ridden the ride:");
            for (Visitor visitor : rideHistory) {
                System.out.println(visitor);
            }
        }
    }

    @Override
    public void runOneCycle() {
        if (operator == null) {
            System.out.println("No operator assigned, cannot run the ride.");
            return;
        }

        if (visitorQueue.isEmpty()) {
            System.out.println("No visitors in the queue, cannot run the ride.");
            return;
        }

        int riders = Math.min(maxRider, visitorQueue.size());
        System.out.println("Starting a cycle, this cycle will take " + riders + " visitors.");

        for (int i = 0; i < riders; i++) {
            Visitor visitor = visitorQueue.poll();
            if (visitor != null) {
                addVisitorToHistory(visitor);
            }
        }

        numOfCycles++;
        System.out.println("Cycle completed. Total number of cycles: " + numOfCycles);
    }

    @Override
    public void exportRideHistory(String filename) {
        try (java.io.FileWriter fw = new java.io.FileWriter(filename)) {
            for (Visitor v : rideHistory) {
                fw.write(v.getName() + "," + v.getAge() + "," + v.getAddress() + "," +
                        v.getMemberId() + "," + v.getVisitorType() + "\n");
            }
            System.out.println("Successfully exported history to file: " + filename);
        } catch (java.io.IOException e) {
            System.out.println("Error exporting history: " + e.getMessage());
        }
    }

    @Override
    public void importRideHistory(String filename) {
        try (java.io.BufferedReader br = new java.io.BufferedReader(new java.io.FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                Visitor visitor = new Visitor(parts[0], Integer.parseInt(parts[1]), parts[2], Integer.valueOf(parts[3]), parts[4]);
                addVisitorToHistory(visitor);
            }
            System.out.println("Successfully imported history from file: " + filename);
        } catch (java.io.IOException e) {
            System.out.println("Error importing history: " + e.getMessage());
        }
    }
}
