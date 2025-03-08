package Java_Design_Patterns.Factory.Ios;

import Java_Design_Patterns.Factory.UiFactory;

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
