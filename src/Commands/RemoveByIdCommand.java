package Commands;
import OrganizationClasses.Organizations;
import Programm.Controller;
import Programm.Invoker;

import java.util.HashMap;
/**elements deleting element with the given id*/
public class RemoveByIdCommand extends Command {


    public RemoveByIdCommand (Controller controller){
        setDescription("удалить элемент с id равным заданному");
        this.controller=controller;
        name = "remove_by_id";
    }


    @Override
    public void execute(HashMap<String, Command> commands, Organizations organizations, Invoker invoker, String... args) {
         controller.remove_by_id(organizations, args);
    }
}
