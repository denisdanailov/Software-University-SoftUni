package designPatterns.command.commandImpl;

import designPatterns.command.Lamp;

public class TurnLampOn implements Command{
    private Lamp lamp;

    public TurnLampOn(Lamp lamp) {
        this.lamp = lamp;
    }

    @Override
    public void execute() {
        this.lamp.turnOn();
    }
}
