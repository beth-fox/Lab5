package Commands;
import OrganizationClasses.Organizations;
import Programm.Controller;
import Programm.Invoker;

import java.util.HashMap;
/**command clearing the collection*/
public class ClearCommand extends Command {


    public ClearCommand(Controller controller) {
        this.controller = controller;
        setDescription("очистить коллекцию");
        name = "clear";
    }

    @Override
    public void execute(HashMap<String, Command> commands, Organizations organizations, Invoker invoker, String... args) {
        controller.clear(organizations);
    }

}
