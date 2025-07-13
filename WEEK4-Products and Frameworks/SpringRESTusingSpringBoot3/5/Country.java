package com.cognizant.spring_learn.model;

public class Country {
    private String code;
    private String name;

    public Country() {
        System.out.println("Inside Country Constructor");
    }

    public String getCode() {
        System.out.println("Getter for code");
        return code;
    }

    public void setCode(String code) {
        System.out.println("Setter for code");
        this.code = code;
    }

    public String getName() {
        System.out.println("Getter for name");
        return name;
    }

    public void setName(String name) {
        System.out.println("Setter for name");
        this.name = name;
    }

    @Override
    public String toString() {
        return "Country [code=" + code + ", name=" + name + "]";
    }
}
