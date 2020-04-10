package OrganizationClasses;

public class Location {
    private Double x; //not null
    private Float y; //not null
    private String name; //not empty, not null

    @Override
    public String toString() {
        return "Координаты {" +
                "x=" + x +
                ", y=" + y +'}'+
                ", название города :'" + name + '\''
                ;
    }

    public Location(Double x, Float y, String name) {
        this.x = x;
        this.y = y;
        this.name = name;
    }

    public Double getX() {
        return x;
    }

    public Float getY() {
        return y;
    }

    public String parsetoString() {
        return x+","+y+","+name;
    }
}
