package Commands;
import OrganizationClasses.Organizations;
import Programm.Controller;
import Programm.Invoker;

import java.io.IOException;
import java.util.HashMap;

/**command saving changed collection to the file*/
public class SaveCommand extends Command{


    public SaveCommand(Controller controller){
        this.controller = controller;
        setDescription("сохранить коллекцию в файл");
        name = "save";
    }

    public void execute(HashMap<String, Command> commands, Organizations organizations, Invoker invoker, String... args) {
       controller.save(organizations);
    }

    }

