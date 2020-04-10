package Programm;

import OrganizationClasses.*;
import org.jetbrains.annotations.NotNull;

import java.time.ZonedDateTime;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.UUID;

public class Factory {
    private Integer id; //not null, more than 0, unique, automatically generated
    private String name; //not null, not empty
    private Coordinates coordinates; //not null
    private java.time.ZonedDateTime creationDate; //not null, automatically generated
    private int annualTurnover; //more than 0
    private String fullName; //not empty, not null
    private long employeesCount; //more than 0
    private OrganizationType type; //not null
    private Address officialAddress; //not null
    private String adStreet;
    private Location adTown;
    private Double locX;
    private Float locY;
    private Float coordX;
    private Float coordY;
    private String locName;
    Scanner scanner = new Scanner(System.in);

    /**
     * Creating an element of the collection
     * @param idarg given id
     * @return
     */
    public Organization create(String idarg) throws InputMismatchException{
        try{id = Integer.parseInt(idarg);
        creationDate = ZonedDateTime.now();
        System.out.println("введите название организации: ");
        setName();
        System.out.println("введите координаты: ");
        setCoordinates();
        System.out.println("введите годовой оборот: ");
        setAnnTurn();
        System.out.println("введите полное название организации: ");
        setFullName();
        System.out.println("введите количество рабочих: ");
        setEmplCount();
        System.out.println("введите тип организации: ");
        setType();
        System.out.println("введите адрес организации: ");
        setAddress();
        Organization org = new Organization(id, name, coordinates, creationDate, annualTurnover, fullName, employeesCount, type, officialAddress);

            return org;
            }
        catch (InputMismatchException e){System.out.println("Вы ввели данные в неверном формате. Попробуйте заново");
        create(idarg);
        return null;}

    }
    public Organization create() throws InputMismatchException{
        Organization org = null;
       try{ id = UUID.randomUUID().toString().hashCode();
        while (id<0) {id = UUID.randomUUID().toString().hashCode();}
        creationDate = ZonedDateTime.now();
        System.out.println("введите название организации: ");
        setName();
        System.out.println("введите координаты: ");
        setCoordinates();
        System.out.println("введите годовой оборот: ");
        setAnnTurn();
        System.out.println("введите полное название организации: ");
        setFullName();
        System.out.println("введите количество рабочих: ");
        setEmplCount();
        System.out.println("введите тип организации: ");
        setType();
        System.out.println("введите адрес организации: ");
        setAddress();
        org = new Organization(id, name, coordinates, creationDate, annualTurnover, fullName, employeesCount, type, officialAddress);
        return org;}
       catch (InputMismatchException e){
           System.out.println("Вы ввели данные в неверном формате");
           create();
           return org;
       }
    }

    private void setAnnTurn() {
            if (scanner.hasNextLine())
            {String line = scanner.nextLine();
                try {
                    annualTurnover = Integer.parseInt(line);
                    if (annualTurnover<1){ System.out.println("Работников должно быть больше 0, попробуйте снова!");
                        setEmplCount();}
                } catch (NumberFormatException e) {
                    System.out.println("Вы ввели некоректное число, попробуйте снова!");
                    setAnnTurn();
                }}
    }

    private void setFullName() {
        if (scanner.hasNextLine()){
            fullName = scanner.nextLine();
            if (fullName==null||fullName.equals("")){
                System.out.println("Имя организации не может быть пустым");
                setFullName();
            }
        }
        }


    public void setAddress() throws InputMismatchException{
        try{System.out.println("Введите название города");
        locName = scanner.nextLine();
            if (locName==null||locName.equals("")){
                System.out.println("Имя организации не может быть пустым");
                setAddress();
            }
        System.out.println("Введите первую координату");
        setX2();
        System.out.println("Введите вторую координату");
        setY2();
        System.out.println("Введите название улицы");
        AdStreet();
        adTown = new Location(locX,locY,locName);
        officialAddress = new Address(adStreet, adTown);}
        catch (InputMismatchException e){
            System.out.println("Неверно введены данные. Попробуйте заново.");
            setAddress();
        }
    }

    private void setType() {
        System.out.println("Введите один из возможных типов:");
        System.out.println("OOO");
        System.out.println("Трест");
        System.out.println("Правительственная");
        System.out.println("Коммерческая");
        String line = scanner.nextLine().toLowerCase();
        switch (line) {
            case ("ооо"):
                type = OrganizationType.OPENED_JOINED_STOCK_COMPANY;
                break;
            case ("правительственная"):
                type = OrganizationType.GOVERNMENT;
                break;
            case ("коммерческая"):
                type = OrganizationType.COMMERCIAL;
                break;
            case ("трест"):
                type = OrganizationType.TRUST;
                break;
            default:
                System.out.println("Вы ввели неккоректный тип! Попробуйте снова!");
                setType();
                break;
    }}

    public void AdStreet(){
        String adStreet = scanner.nextLine();
        if (adStreet=="") {System.out.println("Название улицы не может быть пустым.");
        AdStreet();}
        this.adStreet = adStreet;}


    private void setEmplCount() {
        if (scanner.hasNextLine()){String line = scanner.nextLine();
        try {
            employeesCount = Long.parseLong(line);
            if (employeesCount<1){ System.out.println("Работников должно быть больше 0, попробуйте снова!");
                setEmplCount();}
        } catch (NumberFormatException e) {
            System.out.println("Вы ввели некоректное число, попробуйте снова!");
            setEmplCount();
        }}
    }


    private void setCoordinates() {
        System.out.println("Введите координату Х");
        setX1();
        System.out.println("Введите координату У");
        setY1();
        coordinates = new Coordinates(coordX, coordY);
    }

        public void setX1() {
        if (scanner.hasNextLine()){
            String line = scanner.nextLine();
            try {
                if (Float.parseFloat(line)>-990f){
                coordX = Float.parseFloat(line);}
                else
                    {System.out.println("Число не может быть меньше -990. Попробуйте снова");
                     setX1();}
            } catch (NumberFormatException e) {
                System.out.println("Вы ввели некорректное число, попробуйте снова!");
                setX1();
            }
        }}

    public void setY1() throws NumberFormatException {
        if (scanner.hasNextLine()){
        String line = scanner.nextLine();
        try {
            coordY = Float.parseFloat(line);
        } catch (NumberFormatException e) {
            System.out.println("Вы ввели некорректное число, попробуйте снова!");
            setY1();
        }
    }}

    public void setX2() {
        try{
            if (scanner.hasNextLine()){
            String line = scanner.nextLine();
            locX = Double.parseDouble(line);
            } }
        catch (NumberFormatException e) {
                System.out.println("Вы ввели неккоректное число, попробуйте снова!");
                setX2();
            }
        }

    public void setY2() throws NumberFormatException {
        String line = scanner.nextLine();
        try {
            locY = Float.parseFloat(line);
        } catch (NumberFormatException e) {
            System.out.println("Вы ввели неккоректное число, попробуйте снова!");
            setY2();
        }
    }


    public void setName(){
        if (scanner.hasNextLine()){
            name = scanner.nextLine();
            if (name==null||name.equals("")){
                System.out.println("Имя организации не может быть пустым");
                setName();
            }
        }
        else{
            System.out.println("Название организации не может быть пустым! Попробуйте еще раз");
            setName();
        }}
    public Address getOfficialAddress() {
        return officialAddress;
    }
}

