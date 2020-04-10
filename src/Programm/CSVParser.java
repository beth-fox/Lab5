package Programm;
import OrganizationClasses.*;
import java.io.IOException;
import java.nio.file.Paths;
import java.time.ZonedDateTime;
import java.util.Scanner;

public class CSVParser {
    private String ipath;
    public CSVParser(String path) {
        ipath = path;
    }

    /**
     * Method parsing file from CSV
     * @param orgs Collection of elements
     * @throws IOException
     */
    public void parse(Organizations orgs) throws IOException {
        try {
                Scanner scanner = new Scanner(Paths.get(ipath));
                while (scanner.hasNext()) {
                    //парсим строку в объект Organization
                    Organization org;
                    org = parseCSVLine(scanner.nextLine());
                    try{orgs.add(org);}
                    catch (NullPointerException e){}
                }
                scanner.close();
         }
        catch (IOException e) {
            System.out.println("Не найден файл для загрузки в коллекцию");
        }}

    /**
     * method parsing a line in CSV to executable format
     * @param line the line we need to parse
     * @return
     * @throws NumberFormatException
     */
    private static Organization parseCSVLine(String line) throws NumberFormatException {
        try {
            String[] args = line.split("\\s*[,;]\\s*");
            OrganizationType type = null;
            int id = Integer.parseInt(args[0].trim());
            String name = args[1].trim();
            float  x = Float.parseFloat(args[2].trim());
            float y = Float.parseFloat(args[3].trim());
            Coordinates coordinates = new Coordinates(x, y);
            ZonedDateTime time = ZonedDateTime.parse(args[4].trim());
            int annualTurnover = Integer.parseInt(args[5].trim());
            String fullName = args[6].trim();
            long employeeCount = Long.parseLong(args[7].trim());
            String typo = args[8].trim();
            if (typo.equals("COMMERCIAL")) {
                type =OrganizationType.COMMERCIAL;
            } else {
                if (typo.equals("GOVERNMENT")) {
                    type =OrganizationType.GOVERNMENT;
                } else {
                    if (typo.equals("PRIVATE_LIMITED_COMPANY")) {
                        type =OrganizationType.PRIVATE_LIMITED_COMPANY;
                    }
                    else{
                        if (typo.equals("TRUST")){
                            type =OrganizationType.TRUST;
                        }
                        else {
                            if (typo.equals("OPENED_JOINED_STOCK_COMPANY")) {
                                type=OrganizationType.OPENED_JOINED_STOCK_COMPANY;
                            }
                        }
                    }
                }}
                if (typo==null) throw new NumberFormatException();
            String street = args[9].trim();
            double locx = Double.parseDouble(args[10].trim());
            float locy = Float.parseFloat(args[11].trim());
            String strname = args[12].trim();
            Location location = new Location(locx, locy, strname);
            Address address = new Address(street, location);
            Organization organization = new Organization(id, name,coordinates, time, annualTurnover, fullName, employeeCount, type, address);
            return organization;
        } catch (NumberFormatException n) {
            System.out.println("Неверный формат введенных данных. Проверьте файл");
            return null;
        }

    }
}

















