package Java_Design_Patterns.Decorator;

public  abstract  class PizzaDecorator implements  Pizza {
    protected  Pizza pizza;
    public PizzaDecorator(Pizza pizza){
        this.pizza=pizza;
    }


}
