package com.domain;

import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 *
 */
public class Product implements Serializable {
    private int id;
    private String name;
    private double chinese;
    private double math;
    private double english;
    private String classes;

    public Product() {
    }

    public Product(int id,String name, double chinese, double math, double english,String classes) {
        this.id=id;
        this.name = name;
        this.chinese = chinese;
        this.math= math;
        this.english = english;
        this.classes=classes;
    }
    public Product(double chinese, double math, double english) {
        this.chinese = chinese;
        this.math= math;
        this.english = english;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public double getChinese() {
        return chinese;
    }

    public void setChinese(double chinese) {
        this.chinese = chinese;
    }

   public double getMath(){
        return math;
   }

   public void setMath(double math){
        this.math=math;
   }
    public double getEnglish(){
        return english;
    }

    public void setEnglish(double english){
        this.english=english;
    }
}
