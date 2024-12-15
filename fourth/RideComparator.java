package entity;

import java.util.Comparator;
import java.util.Objects;

public class RideComparator implements Comparator<Visitor> {
    @Override
    public int compare(Visitor v1, Visitor v2) {
        if (!Objects.equals(v1.getAge(), v2.getAge())) {
            return v1.getAge() - v2.getAge();
        } else {
            return v1.getName().compareTo(v2.getName());
        }
    }
}
