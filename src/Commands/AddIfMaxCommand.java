package Commands;
import OrganizationClasses.Organizations;
import Programm.Controller;
import Programm.Invoker;

import java.util.HashMap;
/**command adding a new element to the collection if its value bigger then the previous maximum*/
public class AddIfMaxCommand extends Command {


    public AddIfMaxCommand(Controller controller){
        this.controller=controller;
        setDescription(" {element} добавить элемент в коллекцию, если его значение превышает значение наибольшего элемента этой коллекции");
        name = "add_if_max";
    }

    @Override
    public void execute(HashMap<String, Command> commands, Organizations organizations, Invoker invoker, String... args){
        controller.add_if_max(organizations);
    }
}
