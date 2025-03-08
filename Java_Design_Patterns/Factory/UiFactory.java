package Java_Design_Patterns.Factory;

import Java_Design_Patterns.Factory.Button.Button;
import Java_Design_Patterns.Factory.Menu.Menu;

public interface UiFactory {
    Button createButton();
    Menu createMenu();
}
