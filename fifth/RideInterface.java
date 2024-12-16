package entity;

public interface RideInterface {

//    Part 3
    void addVisitorToQueue(Visitor visitor);
    void removeVisitorFromQueue();
    void printQueue();

//    Part 4
    void addVisitorToHistory(Visitor visitor);
    boolean checkVisitorFromHistory(Visitor visitor);
    int numberOfVisitors();
    void printRideHistory();

//    Part 5
    void runOneCycle();

//    Part 6
    void exportRideHistory(String filename);
//    Part 7
    void importRideHistory(String filename);


}
