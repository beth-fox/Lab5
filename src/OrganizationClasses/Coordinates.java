package OrganizationClasses;

public class Coordinates {
    private float x; //more than -990
    private float y; //not null

    public Coordinates(float x,float y){
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public String parsetoString() {
        return x+","+y;
    }
}
