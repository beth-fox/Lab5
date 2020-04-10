package Commands;
import OrganizationClasses.Organizations;
import Programm.Controller;
import Programm.Invoker;

import java.io.IOException;
import java.util.HashMap;

public abstract class Command {
    public String name;
    public String args;
    public String description;
    public Controller controller = new Controller();

    /**
     * executing command
     * @param commands collection of possible commands
     * @param organizations collection of elements
     * @param invoker invoker
     * @param args arguments
     */
    public void execute(HashMap<String, Command> commands, Organizations organizations, Invoker invoker, String... args) {
        execute(commands, organizations, invoker, args);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArgs() {
        return args;
    }

    public void setArgs(String args) {
        this.args = args;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }

}
