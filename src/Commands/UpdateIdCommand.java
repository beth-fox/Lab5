package Commands;
import OrganizationClasses.Organizations;
import Programm.Controller;
import Programm.Invoker;

import java.util.HashMap;
/**command changing element with given id*/
public class UpdateIdCommand extends Command {


    public UpdateIdCommand(Controller controller) {
        this.controller = controller;
        setDescription(" id {Element} обновить значение элемента коллекции, id которого равен заданному");
        name = "update";
    }

    @Override
    public void execute(HashMap<String, Command> commands, Organizations organizations, Invoker invoker, String... args) {
        controller.update(organizations, args);
    }
}
