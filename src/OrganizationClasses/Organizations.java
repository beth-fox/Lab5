package OrganizationClasses;

import Programm.Factory;
import org.jetbrains.annotations.NotNull;

import java.io.*;
import java.util.Date;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Scanner;
//main collection
public class Organizations extends PriorityQueue<Organization>{
    Factory factory = new Factory();
    Date InitDate;
    Scanner sc;

    

    public Organizations() {
    }

    //method removing greater elements
    public void remove_g() {
        Organization org = factory.create();
        Iterator<Organization> iter = this.iterator();
        while (iter.hasNext()) {
            Organization o = iter.next();
            if (o.getAnnualTurnover() > org.getAnnualTurnover()) {
                this.remove(o);
                iter = this.iterator();
            }
        }
    }
//method removing by id
    public void removeById(int args) {
        int id = Integer.parseInt(String.valueOf(args));
        boolean found = false;
        for (Organization org : this){
            if (org.getId() == id){
                this.remove(org);
                found = true;
                break;
                }
            }
        if (found == false) {System.out.println("Не найдено элемента с таким id");}
    }
//method counting sum of annual turnovers
    public void sumOfAnTurn() {
        String phrase = "Сумма значений годовых оборотов: ";
        int sum = 0;
        if (this.size()>0){
            for (Organization org : this)
                {sum += org.getAnnualTurnover();}
            System.out.println(phrase+" "+sum);}
        else {System.out.println("Массив пуст. Заполните массив");}
    }
//method removing by annual turnover
    public void removeAnnTurn(String AnTurn){
        int AnTurn1;
        if (AnTurn=="") {
            System.out.println("требуется аргумент"); }
        else{
        try {AnTurn1 = Integer.parseInt(AnTurn);
            if (AnTurn1<0) throw new NumberFormatException();
            Iterator<Organization> iter = this.iterator();
            while (iter.hasNext())
            {
                Organization org = iter.next();
                if (org.getAnnualTurnover()==AnTurn1) {
                    this.remove(org);
                    iter = this.iterator();}
            };
        }
        catch (NumberFormatException e) {
        System.out.println("Неверный формат аргументов"); }
    }}
//method giving info about the collection
    public void getInfo(){
        System.out.println("Тип коллекции: PriorityQueue");
        System.out.println("Количество элементов в коллекции: "+ this.size());
        System.out.println("Дата инициализации: "+InitDate);

    }
//method printing the collection
    public void showIt(){
        for (Organization o: this){
            System.out.println(o.toString());
        }
    }
//method parsing the collection to CSV
    @NotNull
    public void parseToCSV(File f) throws IOException {
        File file = f;
        if (file.canRead()&file.canWrite()&file.exists()&file.isFile()){
            FileWriter eraser = new FileWriter(file, false);
            eraser.write("");
            for (Organization o: this) {
            try(FileWriter writer = new FileWriter(file, true))
            {
                writer.write(o.parse()+",\n");
                writer.flush();
            }
            catch(IOException ex){
                System.out.println(ex.getMessage());
            }
            System.out.println("Cохранено в файл "+f.getName());

        }}
        else {
            if ((file.canWrite() == false) | (file.canRead() == false)) {
                System.out.println("Проблема с правами доступа к файлу");
            }else {
                if (file.exists() == false) {
                    System.out.println("Файл не существует");
                } else {
                    if (file.isFile()) {
                        System.out.println("Вероятно, Ваш файл - директория");
                    }
                }
            }
        }

    }
//method adding greater element
    public void addIfMax() {
        Organization org = factory.create();
        Organization max = this.peek();
        for (Organization o: this){
            if (o.getAnnualTurnover()>max.getAnnualTurnover()) {
                max = o;
            }
        }
        int maxAn = 0;
        if (max!=null) maxAn=max.getAnnualTurnover();
        if (maxAn < org.getAnnualTurnover()){
            this.add(org);
            System.out.println("В коллекцию добавлен новый элемент");
        }
        else {System.out.println("Элемент не добавлен");}
    }
}

