package com.example.ikavanagh.grocerylist;

public class Grocery {

    private long id;
    private String name;
    private String quantity;

    public Grocery(String name)
    {

        this.name = name;

    }

    public String getName()
    {
        return name;
    }

    public String getQuantity()
    {
        return quantity;
    }


    public void setID(long id)
    {
        this.id = id;

    }

    public long getId()
    {
        return id;
    }
}
