package Java_Design_Patterns.Decorator;

public class PizzaType extends PizzaDecorator{
//    private EatingPref eatingPref;
    public PizzaType(Pizza pizza){
      super(pizza);
//      this.eatingPref=eatingPref;
    }
    @Override
    public double getCost() {
//        if(eatingPref==EatingPref.VEG){
//            return pizza.getCost()+80;
//        } else if (eatingPref==EatingPref.NONVEG) {
//            return pizza.getCost()+100;
//        }
        return pizza.getCost()+120;
    }

    @Override
    public String getDescription() {
//        String choice="";
//        if(eatingPref==EatingPref.VEG){
//            choice="Veg";
//        } else if (eatingPref==EatingPref.NONVEG) {
//           choice="Nonveg";
//        }
//        else {
//            choice="Vegan";
//        }
        return pizza.getDescription()+",with Meal preferance ";
    }
}
