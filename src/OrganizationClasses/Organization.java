package OrganizationClasses;

import org.jetbrains.annotations.NotNull;

import java.time.ZonedDateTime;

public class Organization implements Comparable<Organization> {
    private Integer id; //not null, more than 0, unique, automatically generated
    private String name; //not null, not empty
    private Coordinates coordinates; //not null
    private java.time.ZonedDateTime creationDate; //not null, automatically generated
    private int annualTurnover; //more than 0
    private String fullName; //not empty, not null
    private long employeesCount; //more than 0
    private OrganizationType type; //not null
    private Address officialAddress; //not null

    public Organization(Integer id, String name, Coordinates coordinates, ZonedDateTime creationDate, int annualTurnover, String fullName, long employeesCount, OrganizationType type, Address officialAddress) {
        this.id = id;
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = creationDate;
        this.annualTurnover = annualTurnover;
        this.fullName = fullName;
        this.employeesCount = employeesCount;
        this.type = type;
        this.officialAddress = officialAddress;
    }

/**
toString according to CSV coding
 */
    @Override
    @NotNull
    public String toString() {
        return  "id: "+id +
                " , название: " + name +
                " , координаты: " + coordinates.toString() +
                ", дата создания: " + creationDate +
                ", годовой оборот: " + annualTurnover +
                ", полное название: " + fullName+
                ", количество сотрудников: " + employeesCount +
                ", тип организации: " + type.toString() +
                ", Официальный адрес: " + officialAddress.toString();
    }

    @Override
    public int compareTo(Organization o) {
        if (annualTurnover>o.getAnnualTurnover()) return 1;
        else if (annualTurnover<o.getAnnualTurnover()) return -1;
        else return 0;
    }

//getters
    public Address getAddress() {
        return officialAddress;
    }

    public int getId() {
        return this.id;
    }

    public int getAnnualTurnover() {
        return annualTurnover;
    }

    public String parse() {
        return  id +","+ name +
                "," + coordinates.parsetoString() +
                "," + creationDate +
                "," + annualTurnover +
                "," + fullName+
                "," + employeesCount +
                "," + type +
                "," + officialAddress.parsetoString();
    }

}
