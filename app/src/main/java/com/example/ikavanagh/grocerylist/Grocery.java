package com.example.ikavanagh.grocerylist;

public class Grocery {

    private String id;
    private String name;
    private String quantity;

    public Grocery(String name)
    {

        this.name = name;

    }
    public Grocery()
    {

    }

    public void setName(String name)
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


    public void setID(String id)
    {
        this.id = id;

    }

    public String getId()
    {
        return id;
    }
}
