package commands.availableCommands;

import collection.PersonCollection;
import commands.Command;

import java.util.Scanner;

/**
 * add_if_min {element} :
 * add a new element to the collection if its value is less than the smallest element of that collection
 */
public class AddIfMin extends Command {
    private PersonCollection personCollection;

    @Override
    public void execute(String[] args) {
        if (args.length != 0) {
            System.out.println("Вы неправильно ввели команду");
        } else {
            Scanner sc = new Scanner(System.in);
            personCollection.addIfMin(sc);
            System.out.println("Персонаж добавлен");
        }
    }
}
