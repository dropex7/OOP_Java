package main.java.com.app;

import main.java.com.app.annotacions.XmlAttribute;
import main.java.com.app.annotacions.XmlObject;
import main.java.com.app.annotacions.XmlTag;

@XmlObject
public class Person {
    @XmlTag(name = "fullname")
    private final String name;

    @XmlAttribute(tag = "fullname")
    private final String lang;

    @XmlTag
    Comp comp;

    private final int age;

    public Person(String name, String lang, int age) {
        this.name = name;
        this.lang = lang;
        this.age = age;
    }


    public void setComp(Comp comp) {
        this.comp = comp;
    }



    public int getAge() {
        return age;
    }
}
