package Programm;
import OrganizationClasses.Organizations;
import java.io.IOException;
import java.io.File;


public class Main {
    static String path;
    public static void main(String[] args) throws NullPointerException, NumberFormatException, IOException {
        File file = null;
        CommandRegister app = new CommandRegister();
        Organizations orgs = new Organizations();
        String filePath = System.getenv("INPUT_PATH");
        System.out.println(System.getenv("INPUT_PATH"));
        if (filePath == null){
            setPath("src\\data.csv");
        }else{
            setPath(filePath);
        }
        try {file = new File(getPath());
            if (file.canRead()==false) {
                System.out.println("Недостаточно прав для чтения файла c данными.");
                System.out.println("Введите exit, чтобы завершить программу, или продолжите с пустой коллекцией.");}
            else{
                CSVParser c = new CSVParser(getPath());
                c.parse(orgs);
            }
            }
        catch (NullPointerException e){
            System.out.println("Файл не найден. Невозможно запустить программу.");
            app.controller1.exit();
        }
        while (true){
            app.execute(orgs, file);
        }

    }

    public static void setPath(String path) {
        Main.path = path;
    }


    public static String getPath() throws NullPointerException {
        try {
            return
                    path;
        } catch (NullPointerException e) {
            System.out.println("Не удалось распознать путь до файла");
            return null;
        }
    }
}
