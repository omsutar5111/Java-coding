package Java_Design_Patterns.Factory;

import Java_Design_Patterns.Factory.Factories.AndriodFactory;
import Java_Design_Patterns.Factory.Factories.UiFactory;
import Java_Design_Patterns.Factory.Factories.iosFactory;

public class Flutter {

    public  static UiFactory getUiFactory(Platforms platforms){
        if(platforms.equals(Platforms.ANDROID)){
            return new AndriodFactory();
        } else if (platforms.equals(Platforms.IOS)) {
            return new iosFactory();
        }
        return null;
    }
}
