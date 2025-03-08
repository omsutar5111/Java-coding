package Java_Design_Patterns.Factory;

import Java_Design_Patterns.Factory.Button.Button;
import Java_Design_Patterns.Factory.Menu.Menu;

public class Client {
    public static void main(String[] args) {
        UiFactory uiFactory=Flutter.getUiFactory(Platforms.ANDROID);
        Menu menu= uiFactory.createMenu();
        menu.render();
        menu.createMenu();
       Button button= uiFactory.createButton();
       button.createButton();

    }

}
