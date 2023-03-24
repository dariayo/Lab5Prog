package commands;

import client.InputManager;
import collection.PersonCollection;
import commands.availableCommands.*;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class CommandManager {
    
    private final PersonCollection personCollection;
    private static boolean isWorking = true;
    private static HashMap<String, Command> commandMap = new HashMap();
    
    public CommandManager(PersonCollection personCollection) {
            this.personCollection = personCollection;
            commandMap = new HashMap<>();
            commandMap.put("add", new Add(personCollection));
            commandMap.put("add_if_max", new AddIfMax(personCollection));
            commandMap.put("add_if_min", new AddIfMin(personCollection));
            commandMap.put("clear", new Clear(personCollection));
            commandMap.put("remove_by_id", new RemoveById(personCollection));
            commandMap.put("show", new Show(personCollection));
            commandMap.put("remove_greater", new RemoveGreater(personCollection));
            commandMap.put("count_greater_than_eye_color", new CountGreaterThanEyeColor(personCollection));
            commandMap.put("update", new Update(personCollection));
            commandMap.put("filter_greater_than_location", new FilterGreaterThanLocation(personCollection));
            commandMap.put("print_unique_location", new PrintUniqueLocation(personCollection));
            commandMap.put("info", new Info(personCollection));
            commandMap.put("help", new Help());
            commandMap.put("save", new Save(personCollection));
            commandMap.put("exit", new Exit());
            commandMap.put("execute_script", new ExecuteScript());
    }


    public static HashMap<String, Command> getCommandMap() {
        return commandMap;
    }


    public static PersonCollection getPersonCollection() {
        return CommandManager.personCollection;
    }

    public static void existCommand() {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Введите команду: ");
            String command = sc.nextLine().trim();

            String[] commandArg = command.split(" ");
            String argument;

            if (commandArg.length == 1)
                argument = null;
            else if (commandArg.length == 2)
                argument = commandArg[1];
            else {
                return;
            }

            if (commandMap.containsKey(commandArg[0])) {
                commandMap.get(commandArg[0]).setArgument(argument);
                try {
                    commandMap.get(commandArg[0]).execute(commandArg);
                } catch (JAXBException | IOException e) {
                    throw new RuntimeException(e);
                }
            } else {
                System.out.println("Команды " + commandArg[0] + " не существует");
            }
        } catch (NoSuchElementException e) {
            System.out.println("На этом все");
            isWorking = false;
            System.exit(0);
        }
    }
    
    public static boolean getWork() {
        return isWorking;
    }
    
    public static HashMap<String, Command> getCommandMap() {
        return commandMap;
    }
}
