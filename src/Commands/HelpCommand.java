package Commands;
import OrganizationClasses.Organizations;
import Programm.Controller;
import Programm.Invoker;

import java.util.HashMap;
/**command printing all of the commands with those descriptions*/
public class HelpCommand extends Command {

    public HelpCommand (Controller controller){
        setDescription("вывести справку по доступным командам");
        this.controller=controller;
        name = "help";
    }


    @Override
    public void execute(HashMap<String, Command> commands, Organizations organizations, Invoker invoker, String... args) {
        controller.help(commands);
    }
}
