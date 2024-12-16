import entity.Employee;
import entity.Ride;
import entity.RideComparator;
import entity.Visitor;

public class AssignmentTwo {
    public static void main(String[] args) {
        AssignmentTwo assignment = new AssignmentTwo();
        System.out.println("Part 3  =====================================");
        assignment.partThree();
        System.out.println("=====================================");

        System.out.println("Part 4A  =====================================");
        assignment.partFourA();
        System.out.println("=====================================");

        System.out.println("Part 4B  =====================================");
        assignment.partFourB();
        System.out.println("=====================================");

        System.out.println("Part 5  =====================================");
        assignment.partFive();
        System.out.println("=====================================");

        System.out.println("Part 6  =====================================");
        assignment.partSix();
        System.out.println("=====================================");

        System.out.println("Part 7  =====================================");
        assignment.partSeven();
        System.out.println("=====================================");
    }

    public void partThree(){
        Employee operator = new Employee("Tea", 22, "Alabama", "00001", "123456789");
        Ride ride = new Ride("Ferris Wheel", 5, operator);

        Visitor visitor1 = new Visitor("Visitor1", 25, "Alabama", 11111, "normal");
        Visitor visitor2 = new Visitor("Visitor2", 25, "Alabama", 11112, "vip");
        Visitor visitor3 = new Visitor("Visitor3", 25, "Alabama", 11113, "normal");
        Visitor visitor4 = new Visitor("Visitor4", 25, "Alabama", 11114, "vip");
        Visitor visitor5 = new Visitor("Visitor5", 25, "Alabama", 11115, "super vip");

        ride.addVisitorToQueue(visitor1);
        ride.addVisitorToQueue(visitor2);
        ride.addVisitorToQueue(visitor3);
        ride.addVisitorToQueue(visitor4);
        ride.addVisitorToQueue(visitor5);

        ride.removeVisitorFromQueue();

        ride.printQueue();
    }

    public void partFourA(){
        Employee operator = new Employee("Tea", 22, "Alabama", "00001", "123456789");
        Ride ride = new Ride("Ferris Wheel", 5, operator);

        Visitor visitor1 = new Visitor("Visitor1", 25, "Alabama", 11111, "normal");
        Visitor visitor2 = new Visitor("Visitor2", 25, "Alabama", 11112, "vip");
        Visitor visitor3 = new Visitor("Visitor3", 25, "Alabama", 11113, "normal");
        Visitor visitor4 = new Visitor("Visitor4", 25, "Alabama", 11114, "vip");
        Visitor visitor5 = new Visitor("Visitor5", 25, "Alabama", 11115, "super vip");

        ride.addVisitorToHistory(visitor1);
        ride.addVisitorToHistory(visitor2);
        ride.addVisitorToHistory(visitor3);
        ride.addVisitorToHistory(visitor4);
        ride.addVisitorToHistory(visitor5);

        Visitor checkVisitor = visitor3;
        ride.checkVisitorFromHistory(checkVisitor);

        ride.numberOfVisitors();

        ride.printRideHistory();
    }

    public void partFourB(){
        Employee operator = new Employee("Tea", 22, "Alabama", "00001", "123456789");
        Ride ride = new Ride("Ferris Wheel", 5, operator);

        Visitor visitor1 = new Visitor("Visitor1", 22, "Alabama", 11111, "normal");
        Visitor visitor2 = new Visitor("Visitor2", 21, "Alabama", 11112, "vip");
        Visitor visitor3 = new Visitor("Visitor3", 23, "Alabama", 11113, "normal");
        Visitor visitor4 = new Visitor("Visitor4", 24, "Alabama", 11114, "vip");
        Visitor visitor5 = new Visitor("Visitor5", 27, "Alabama", 11115, "super vip");

        ride.addVisitorToHistory(visitor1);
        ride.addVisitorToHistory(visitor2);
        ride.addVisitorToHistory(visitor3);
        ride.addVisitorToHistory(visitor4);
        ride.addVisitorToHistory(visitor5);

        System.out.println("Before Sorting:");
        ride.printRideHistory();

        ride.getRideHistory().sort(new RideComparator());

        System.out.println("After Sorting:");
        ride.printRideHistory();
    }

    public void partFive(){
        Employee operator = new Employee("Tea", 22, "Alabama", "00001", "123456789");
        Ride ride = new Ride("Ferris Wheel", 5, operator);

        for (int i = 0; i < 10; i++) {
            Visitor visitor = new Visitor("Visitor" + i, 20+i, "Alabama", 11111 + i, "normal");
            ride.addVisitorToQueue(visitor);
        }
        System.out.println("Queue before running cycle:");
        ride.printQueue();

        ride.runOneCycle();

        System.out.println("Queue after running cycle:");
        ride.printQueue();

        System.out.println("Ride History after running cycle:");
        ride.printRideHistory();
    }

    public void partSix(){
        Employee operator = new Employee("Tea", 22, "Alabama", "00001", "123456789");
        Ride ride = new Ride("Ferris Wheel", 5, operator);

        Visitor visitor1 = new Visitor("Visitor1", 25, "Alabama", 11111, "normal");
        Visitor visitor2 = new Visitor("Visitor2", 25, "Alabama", 11112, "vip");
        Visitor visitor3 = new Visitor("Visitor3", 25, "Alabama", 11113, "normal");
        Visitor visitor4 = new Visitor("Visitor4", 25, "Alabama", 11114, "vip");
        Visitor visitor5 = new Visitor("Visitor5", 25, "Alabama", 11115, "super vip");

        ride.addVisitorToHistory(visitor1);
        ride.addVisitorToHistory(visitor2);
        ride.addVisitorToHistory(visitor3);
        ride.addVisitorToHistory(visitor4);
        ride.addVisitorToHistory(visitor5);

        ride.exportRideHistory("rideHistory.txt");
    }

    public void partSeven(){
        Employee operator = new Employee("Tea", 22, "Alabama", "00001", "123456789");
        Ride ride = new Ride("Ferris Wheel", 5, operator);

        ride.importRideHistory("rideHistory.txt");

        ride.numberOfVisitors();

        ride.printRideHistory();
    }
}