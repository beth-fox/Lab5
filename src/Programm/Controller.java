package Programm;
import Commands.Command;
import OrganizationClasses.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//receiver
public class Controller {
    Factory factory = new Factory();

    public void help(HashMap<String, Command> commands){
        for(Map.Entry<String, Command> entry : commands.entrySet()) {
            String key = entry.getKey();
            Command value = entry.getValue();
            System.out.println(key+" "+value.getDescription());}
    }

    public void remove_greater(Organizations orgs, String... args){
        if (orgs.size()!=0) orgs.remove_g();
        else System.out.println("Коллекция пуста");
    }

    public void clear(Organizations organizations){
        organizations.clear();
        System.out.println("Коллекция очищена");
    }

    public void exit(){System.out.println("Программа завершена");
        System.exit(0);
    }

    public void head(Organizations orgs){
       if (orgs.peek()==null) {System.out.println("Коллекция пуста");}
        else {System.out.println("Верхний элемент коллекции "+orgs.peek());}
    }

    public void sum_of_annual_turnover(Organizations orgs, String... args) {
        if (orgs.size()!=0) orgs.sumOfAnTurn();
        else System.out.println("Коллекция пуста");
    }

    public void remove_all_by_annual_turnover(Organizations orgs, String... AnT){
            try {
                if (orgs.size()!=0)
                    orgs.removeAnnTurn(AnT[0]);
            else System.out.println("Коллекция пуста");}
            catch (ArrayIndexOutOfBoundsException e) {System.out.println("Необходим аргумент");}}


    public void remove_by_id(Organizations orgs, String... args){
        if (orgs.size()!=0){
        try{try{    int id = Integer.parseInt(args[0]);
            orgs.removeById(id);
        }
        catch (NumberFormatException e) {System.out.println("неверный формат аргументов ");}
        }
        catch (ArrayIndexOutOfBoundsException e) {System.out.println("Необходим аргумент");}}
        else {System.out.println("Коллекция пуста");}}


    public void info(Organizations orgs){
        orgs.getInfo();
    };

    public void show(Organizations orgs) {
       if (orgs.size()>0){ orgs.showIt();}
       else{
           System.out.println("Коллекция пуста");
       }
    };

    public void save(Organizations orgs) {
        String script = "INPUT_PATH";
        String filePath = System.getenv(script);
        if (filePath == null) filePath = "src\\data.csv";
        File f = null;
        try {f = new File(filePath);}
        catch (NullPointerException e) {
            System.out.println("Файл не найден");
        }
        if (f!=null) try{orgs.parseToCSV(f);}
        catch (IOException e) {System.out.println("Файл недоступен");}
    }

    public void add_if_max(Organizations orgs) {
      if (orgs.size()!=0) orgs.addIfMax();
      else {add(orgs);
      System.out.println("В коллекцию добавлен элемент");}
    }

    public void add(Organizations orgs){
        orgs.add(factory.create());
        System.out.println("Вы создали новый элемент в коллекцию");
    }

    public void execute_script (Invoker inv, Organizations orgs) throws IllegalStateException, NullPointerException{
       String script = "SCRIPT_PATH";
        String filePath = System.getenv(script);
        if (filePath == null)
            filePath = "src\\script.txt";
        System.out.println(filePath);
        try {File f = new File (filePath);
        Scanner scanner = new Scanner(f);
            String line = "";
            while (!line.equals("exit") && scanner.hasNextLine()) {
                line = scanner.nextLine();
                String[] lines = line.split(" ");
                try{
                    String command = lines[0];
                    if (lines.length > 1) {
                        String arg = lines[1];
                        try {
                            inv.execute(command, orgs, arg);
                        } catch (IllegalStateException e) {
                            System.out.println("Вы ввели неправильную команду, попробуйте снова!");}}
                    else {
                        try {
                            inv.execute(command, orgs);
                        } catch (IllegalStateException e) {
                            System.out.println("Вы ввели неправильную команду, попробуйте снова!");
                    }}
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Вы ввели непрвильную команду, попробуйте снова");
                }
            }
        } catch (NullPointerException e) {
            System.out.println("Скрипт пустой");
        }
        catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        }
    }

    public void update(Organizations orgs, String... args) throws NumberFormatException{
        try {
            if (args.length > 2) {
                System.out.println("Аргумент команды должен быть только один");
            } else {
                if (orgs.size()!=0){
                int size = orgs.size();
                remove_by_id(orgs, args);
                if (orgs.size()<size){
                orgs.add(factory.create(args[0]));
                System.out.println("Изменен элемент с id "+args[0]);}}
                else System.out.println("Коллекция пустая");

            }
        }catch (NumberFormatException e){
            System.out.println("Неверный формат аргументов");
        }

    }

    public void count_less_then_official_address(Organizations orgs) throws NullPointerException{
        if (orgs.size()!=0){
        factory.setAddress();
        Address adr = factory.getOfficialAddress();
        int i = 0;
        for (Organization o: orgs){
            if (o.getAddress().compareTo(adr)==-1){
                i++;
            }

        }
        System.out.println("Организаций со значениями адреса меньше заданного: "+i);}
        else System.out.println("Коллекция пуста");
        }
    }
