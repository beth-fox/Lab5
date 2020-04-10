package Commands;
import OrganizationClasses.Organizations;
import Programm.Controller;
import Programm.Invoker;

import java.util.HashMap;
//command removing all of the elements bigger than a given one
public class RemoveGreaterCommand extends Command {


    public RemoveGreaterCommand(Controller controller) {
        this.controller = controller;
        setDescription(" {element} удалить из коллекции все элементы, превышающие заданный");
        name = "remove_greater";
    }

    @Override
    public void execute(HashMap<String, Command> commands,
                        Organizations organizations, Invoker invoker, String... args) {
        controller.remove_greater(organizations, args);

    }
}
