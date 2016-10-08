package com.test.java.clone;

/**
 * @author Huang, Liangliang
 *
 */
public class Cat implements Cloneable{

    private Integer feet;
    
    private Integer tail;
    
    private String sound;

    private Cat babyCat;
    
    public Cat getBabyCat() {
        return babyCat;
    }

    public void setBabyCat(Cat babyCat) {
        this.babyCat = babyCat;
    }

    public Integer getFeet() {
        return feet;
    }

    public void setFeet(Integer feet) {
        this.feet = feet;
    }

    public Integer getTail() {
        return tail;
    }

    public void setTail(Integer tail) {
        this.tail = tail;
    }

    public String getSound() {
        return sound;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }
    @Override
    public Object clone(){
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }
    
}
