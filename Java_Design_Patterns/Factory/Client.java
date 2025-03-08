package Java_Design_Patterns.Factory;

import Java_Design_Patterns.Factory.Factories.UiFactory;
import Java_Design_Patterns.Factory.Features.Button;
import Java_Design_Patterns.Factory.Features.Menu;

public class Client {
    public static void main(String[] args) {
//        Flutter flutter=new Flutter();
        UiFactory uiFactory=Flutter.getUiFactory(Platforms.ANDROID);
        if (uiFactory == null) throw new AssertionError();
        Menu menu= uiFactory.createMenu();
        menu.render();
        menu.createMenu();
       Button button= uiFactory.createButton();
       button.createButton();

    }

}
