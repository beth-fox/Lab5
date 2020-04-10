package Commands;
import OrganizationClasses.Organizations;
import Programm.Controller;
import Programm.Invoker;

import java.util.HashMap;
/**command removing all of the elements which annualTurnover value equals to a given one*/
public class RemoveAllByAnnualTurnoverCommand extends Command {


    public RemoveAllByAnnualTurnoverCommand(Controller controller) {
        this.controller = controller;
        setDescription(" х - удалить из коллекции все элементы, значения поля annualTurnover эквивалентны заданному(х)");
        name = "remove_all_by_annual_turnover";
    }

    @Override
    public void execute(HashMap<String, Command> commands, Organizations organizations, Invoker invoker, String... args) {
        controller.remove_all_by_annual_turnover(organizations, args);
    }
}
