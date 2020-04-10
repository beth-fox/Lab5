package Commands;
import OrganizationClasses.Organizations;
import Programm.Controller;
import Programm.Invoker;

import java.util.HashMap;
/**command printing the first one element of the collection*/
public class HeadCommand extends Command {


    public HeadCommand(Controller controller) {
        this.controller = controller;
        setDescription("вывести первый элемент коллекции");
        name = "head";
    }

    @Override
    public void execute(HashMap<String, Command> commands, Organizations organizations, Invoker invoker, String... args) {
        controller.head(organizations);
    }
}
