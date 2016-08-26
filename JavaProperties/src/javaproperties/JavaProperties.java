package javaproperties;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.NumberBinding;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;


class Box
{
    public IntegerProperty a = new SimpleIntegerProperty();
    public IntegerProperty b = new SimpleIntegerProperty();
    
    public Box(int a, int b)
    {
        this.a.set(a);
        this.b.set(b);
    }
    
    public NumberBinding p = Bindings.add(a, b);

}

public class JavaProperties {

    public static void main(String[] args) {
        Box b = new Box(1, 2);
        //b.a.set(10);
        //b.b.set(20);
        
        
        System.out.println(b.p.getValue());
        
    }
    
}
