package main.java.com.app;

import main.java.com.app.annotacions.XmlAttribute;
import main.java.com.app.annotacions.XmlObject;
import main.java.com.app.annotacions.XmlTag;

@XmlObject
public class Product {

    double price;

    @XmlAttribute
    String name;

    public Product(String name, double price){
        this.name = name;
        this.price = price;
    }

    @XmlTag
    public double getPrice(){
        return price;
    }
}


