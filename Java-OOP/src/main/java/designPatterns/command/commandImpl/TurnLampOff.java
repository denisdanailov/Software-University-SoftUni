package designPatterns.command.commandImpl;

import designPatterns.command.Lamp;

public class TurnLampOff implements Command{
    private Lamp lamp;

    public TurnLampOff(Lamp lamp) {
        this.lamp = lamp;
    }

    @Override
    public void execute() {
        this.lamp.turnOff();
    }
}
