package designPatterns.command;

import designPatterns.command.commandImpl.TurnLampOff;
import designPatterns.command.commandImpl.TurnLampOn;

public class Main {
    public static void main(String[] args) {
        Lamp lamp = new Lamp();
        Switch aSwitch = new Switch();

        aSwitch.pushSwitch(new TurnLampOn(lamp));
        aSwitch.pushSwitch(new TurnLampOff(lamp));
        aSwitch.undo();

    }
}
