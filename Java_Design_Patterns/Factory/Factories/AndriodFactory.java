package Java_Design_Patterns.Factory.Factories;

import Java_Design_Patterns.Factory.Andriod.AndriodButton;
import Java_Design_Patterns.Factory.Andriod.AndriodMenu;

public class AndriodFactory implements UiFactory {
    @Override
    public AndriodButton createButton() {
        return new AndriodButton();
    }

    @Override
    public AndriodMenu createMenu() {
        return new AndriodMenu();
    }
}
