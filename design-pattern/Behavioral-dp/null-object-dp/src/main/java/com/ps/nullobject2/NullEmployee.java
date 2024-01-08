package com.ps.nullobject2;

public class NullEmployee extends Employee
{
    @Override
    public String getName() 
    {
        return "Not Available";
    }
 
    @Override
    public boolean isNull() 
    {
        return true;
    }
}
 