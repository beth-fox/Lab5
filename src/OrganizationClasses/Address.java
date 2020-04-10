package OrganizationClasses;

public class Address implements Comparable<Address> {
    private String street; //not null
    private Location town; //not null

    public Address(String street, Location town) {
        this.street = street;
        this.town = town;
    }

    @Override
    public int compareTo(Address o) {
        int comp = 0;
        Location townn = o.getTown();
        float j = (float) (townn.getX() * townn.getX() + townn.getY() * townn.getY());
        float i = (float) (town.getX() * town.getX() + town.getY() * town.getY());
        if (i > j) {
            comp = 1;
        } else {
            if (i == j) {
                comp = 0;
            } else {
                if (i < j) {
                    comp = -1;
                }
            }
        }
        return comp;
    }

    public Location getTown() {
        return town;
    }

    @Override
    public String toString() {
        return "Адрес {" +
                "улица :'" + street + '\'' +
                ", " + town.toString() +
                '}';
    }

    public String parsetoString() {
        return  street+
                "," + town.parsetoString();
    }
}


