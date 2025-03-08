package Java_Design_Patterns.Factory.Andriod;

import Java_Design_Patterns.Factory.UiFactory;

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
