package entity;

public class Visitor extends Person{

    private Integer memberId;

    private String visitorType;

    public Visitor() {
        super();
    }


    public Visitor(String name, Integer age, String address, Integer memberId, String visitorType) {
        super(name, age, address);
        this.memberId = memberId;
        this.visitorType = visitorType;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public String getVisitorType() {
        return visitorType;
    }

    public void setVisitorType(String visitorType) {
        this.visitorType = visitorType;
    }

    @Override
    public String toString() {
        return super.toString() + ", Member ID: " + memberId + ", Visitor Type: " + visitorType;
    }
}
