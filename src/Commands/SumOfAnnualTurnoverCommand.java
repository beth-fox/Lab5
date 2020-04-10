package Commands;
import OrganizationClasses.Organizations;
import Programm.Controller;
import Programm.Invoker;

import java.util.HashMap;
/**command printing the sum of the collection*/
public class SumOfAnnualTurnoverCommand extends Command {


    public SumOfAnnualTurnoverCommand(Controller controller) {
        this.controller = controller;
        setDescription("вывести сумму значения поля annualTurnover для всех элементов коллекции");
        name = "sum_of_annual_turnover";
    }

    @Override
    public void execute(HashMap<String, Command> commands, Organizations organizations, Invoker invoker, String... args) {
        controller.sum_of_annual_turnover(organizations, args);
    }
}
