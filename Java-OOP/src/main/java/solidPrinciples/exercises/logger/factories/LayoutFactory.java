package solidPrinciples.exercises.logger.factories;

import solidPrinciples.exercises.logger.interfaces.Factory;
import solidPrinciples.exercises.logger.interfaces.Layout;
import solidPrinciples.exercises.logger.layouts.SimpleLayout;
import solidPrinciples.exercises.logger.layouts.XmlLayout;

public class LayoutFactory implements Factory<Layout> {

    @Override
    public Layout produce(String input) {
        Layout layout = null;
        switch (input) {
            case "SimpleLayout":
                layout = new SimpleLayout();
                break;
            case "XmlLayout":
                layout = new XmlLayout();
                break;
        }
        return layout;
    }
}
