package Commands;
import OrganizationClasses.Organizations;
import Programm.Controller;
import Programm.Invoker;

import java.util.HashMap;
/**command printing information about the collection*/
public class InfoCommand extends Command {


    public InfoCommand(Controller controller) {
        this.controller = controller;
        setDescription("вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)");
        name = "info";
    }

    @Override
    public void execute(HashMap<String, Command> commands, Organizations organizations, Invoker invoker, String... args) {
        controller.info(organizations);
    }
}
