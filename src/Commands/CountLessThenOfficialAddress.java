package Commands;
import OrganizationClasses.Organizations;
import Programm.Controller;
import Programm.Invoker;

import java.util.HashMap;
/**command counting elements that have officialAddress value smaller than a given value*/
public class CountLessThenOfficialAddress extends Command{


    public CountLessThenOfficialAddress(Controller controller) {
        this.controller = controller;
        setDescription("вывести количество элементов, значение поля officialAddress которых меньше заданного");
        name = "count_less_then_official_address";
    }

    @Override
    public void execute(HashMap<String, Command> commands, Organizations organizations, Invoker invoker, String... args) {
            controller.count_less_then_official_address(organizations);
    }
}
