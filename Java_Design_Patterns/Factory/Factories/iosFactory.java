package Java_Design_Patterns.Factory.Factories;

import Java_Design_Patterns.Factory.Ios.IosButton;
import Java_Design_Patterns.Factory.Ios.IosMenu;

public  class iosFactory implements UiFactory {
    @Override
    public IosButton createButton() {
        return new IosButton();
    }

    @Override
    public IosMenu createMenu() {
        return new IosMenu();
    }
}
