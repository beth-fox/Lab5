package Programm;

import Commands.Command;
import OrganizationClasses.*;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.HashMap;

public class Invoker {
    private HashMap<String, Command> commands = new HashMap<>();

    /**
     *  uploading elements into HashMap
     */

    public Invoker(@NotNull Command... com){
         for (Command comm : com){
             register(comm.getName(), comm);
         }
     }

    /**adding command to the list*/
    public void register(String commandName, Command command) {
        commands.put(commandName, command);
    }

    /**
     * Executing invoker
     * @param commandName the name of the command
     * @param orgs collection
     * @param args arguments
     */
    public void execute(String commandName, Organizations orgs, String... args){
        Command command = commands.get(commandName);
        if (command == null) {
            throw new IllegalStateException("Не найдено такой команды " + commandName);
        }
        command.execute(commands, orgs, this, args);
    }


    public HashMap<String, Command> getCommands() {
        return commands;
    }
}
