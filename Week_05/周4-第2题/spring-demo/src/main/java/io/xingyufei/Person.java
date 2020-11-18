package io.xingyufei;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * ClassName: io.xingyufei.Person
 * Description:
 * Author: xyf
 * Date: 2020-11-18 22:15
 * Version: 1.0
 **/
public class Person
{
    private String id;

    private String name;

    @Autowired
    private Student student;

    public void hello()
    {
        System.out.println("id:" + this.id);
        System.out.println("name:" + this.name);
        student.hi();
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }
}
