package Commands;
import OrganizationClasses.Organizations;
import Programm.*;

import java.util.HashMap;
/**command adding a new element to the collection*/
public class AddCommand extends Command {

    public AddCommand(Controller controller){
        this.controller = controller;
        setDescription("добавить новый элемент в коллекцию");
        name = "add";
    }

    @Override
    public void execute(HashMap<String, Command> commands, Organizations organizations, Invoker invoker, String... args) {
        controller.add(organizations);
    }

}
