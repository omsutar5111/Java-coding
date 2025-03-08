package Java_Design_Patterns.Factory.Factories;

import Java_Design_Patterns.Factory.Features.Button;
import Java_Design_Patterns.Factory.Features.Menu;

public interface UiFactory {
    Button createButton();
    Menu createMenu();
}
