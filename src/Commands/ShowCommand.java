package Commands;
import OrganizationClasses.Organizations;
import Programm.Controller;
import Programm.Invoker;

import java.util.HashMap;
/**command printing the collection*/
public class ShowCommand extends Command {


    public ShowCommand(Controller controller) {
        this.controller = controller;
        setDescription("вывести в стандартный поток вывода все элементы коллекции в строковом представлении");
        name = "show";
    }

    @Override
    public void execute(HashMap<String, Command> commands, Organizations organizations, Invoker invoker, String... args) {
        controller.show(organizations);
    }
}
