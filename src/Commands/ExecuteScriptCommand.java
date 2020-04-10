package Commands;
import OrganizationClasses.Organizations;
import Programm.Controller;
import Programm.Invoker;

import java.util.HashMap;
/**command executing script of commands*/
public class ExecuteScriptCommand extends Command {

    public ExecuteScriptCommand(Controller controller) {
        this.controller = controller;
        setDescription("считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.") ;
       name = "execute_script";}

    @Override
    public void execute(HashMap<String, Command> commands, Organizations organizations, Invoker invoker, String... args) {
        controller.execute_script(invoker, organizations);
    }
}
