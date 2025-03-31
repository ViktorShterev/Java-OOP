package Solid.Exercise.logger.impl.factories;

import Solid.Exercise.logger.impl.layouts.SimpleLayout;
import Solid.Exercise.logger.impl.layouts.XmlLayout;
import Solid.Exercise.logger.interfaces.Factory;
import Solid.Exercise.logger.interfaces.Layout;

public class LayoutFactory implements Factory<Layout> {

    @Override
    public Layout produce(String input) {
        Layout layout = null;

        if (input.equals("SimpleLayout")) {
            layout = new SimpleLayout();

        } else if (input.equals("XmlLayout")) {
            layout = new XmlLayout();
        }
        return layout;
    }
}
