package main.java.com.app;

import main.java.com.app.annotacions.XmlObject;
import main.java.com.app.annotacions.XmlTag;


@XmlObject
public class Comp extends Product{

    @XmlTag
    private String color;

    Comp(String name, double price, String color){
        super(name, price);
        this.color = color;
    }

    @XmlTag
    public String getColorMethod(){
        return color;
    }


    @Override
    public String toString() {
        return "toString()";
    }
}
