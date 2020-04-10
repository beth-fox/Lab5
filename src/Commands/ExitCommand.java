package Commands;
import OrganizationClasses.Organizations;
import Programm.Controller;
import Programm.Invoker;

import java.util.HashMap;
/**exit command*/
public class ExitCommand extends Command {


    public ExitCommand(Controller controller) {
        this.controller = controller;
        setDescription("завершить программу (без сохранения в файл)");
        name = "exit";
    }

    @Override
    public void execute(HashMap<String, Command> commands, Organizations organizations, Invoker invoker, String... args) {
        controller.exit();
    }
}
