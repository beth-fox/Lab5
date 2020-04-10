package Programm;
import Commands.*;
import OrganizationClasses.Organizations;

import java.io.File;
import java.util.Scanner;
/**class realizing commands*/
public class CommandRegister {
    Invoker invoker;
    Controller controller1 = new Controller();

    public CommandRegister() {
        Command add = new AddCommand(controller1);
        Command clear = new ClearCommand(controller1);
        Command execute = new ExecuteScriptCommand(controller1);
        Command exit = new ExitCommand(controller1);
        Command filter_by_full_name = new CountLessThenOfficialAddress(controller1);
        Command filter_starts_with_name = new RemoveAllByAnnualTurnoverCommand(controller1);
        Command help = new HelpCommand(controller1);
        Command history = new AddIfMaxCommand(controller1);
        Command info = new InfoCommand(controller1);
        Command print_unique_annual_turnover = new SumOfAnnualTurnoverCommand(controller1);
        Command remove_by_id = new RemoveByIdCommand(controller1);
        Command remove_head_command = new HeadCommand(controller1);
        Command remove_greater = new RemoveGreaterCommand(controller1);
        Command save = new SaveCommand(controller1);
        Command show = new ShowCommand(controller1);
        Command update_id_command = new UpdateIdCommand(controller1);

       this.invoker = new Invoker(remove_greater,add, clear, execute, exit, filter_by_full_name, filter_starts_with_name, help,
                info, print_unique_annual_turnover, remove_by_id, remove_head_command, save, show, update_id_command,history);

    }

    Scanner sc = new Scanner(System.in);

    /**
     * method dividing string into parts of executable command
     * @param org Collection of elements
     * @param file
     */
    public void execute(Organizations org, File file){
        String line = sc.nextLine().toLowerCase().trim();
        if(!line.equals("")) {
            String[] lines = line.split(" ");
            if (lines.length > 1) {
                try {
                    String command = lines[0];
                    String arg = lines[1];
                    invoker.execute(command, org, arg);
                } catch (IllegalStateException e) {
                    System.out.println(e.getMessage());
                }
            } else if (lines.length == 1) {
                try {
                    String command = lines[0];
                    invoker.execute(command,org);
                }catch (IllegalStateException e){
                    System.out.println(e.getMessage());
                }

            } else {
                System.out.println("Введены неправильные аргументы!");
            }
        }
    }

}
