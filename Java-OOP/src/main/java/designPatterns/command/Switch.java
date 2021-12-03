package designPatterns.command;

import designPatterns.command.commandImpl.Command;

import java.util.ArrayDeque;
import java.util.NoSuchElementException;

public class Switch {
    private ArrayDeque<Command> log;

    public Switch() {
        this.log = new ArrayDeque<Command>();
    }

    public void pushSwitch(Command command) {
        log.push(command);
        command.execute();
    }

    public void undo() {
        if (log.size() > 0) {
            log.pop();
        }
        Command prevCommand = log.peek();
        if (prevCommand != null) {
            prevCommand.execute();
        } else {
            System.out.println("No previous element");
        }
    }
}
