package UptakeCodingQuestion.domain;

import java.util.List;

/**
 * Family.java
 *
 * @author:
 *
 * Robert Martinez - robertcamilo23@gmail.com
 */
public class Family
{
    // ----------------------------
    // Attributes
    // ----------------------------

    private Integer id;
    private List< Person > people;

    // ----------------------------
    // Getters & Setters
    // ----------------------------
    
    public Integer getId( )
    {
        return id;
    }

    public void setId( Integer id )
    {
        this.id = id;
    }

    public List< Person > getPeople( )
    {
        return people;
    }

    public void setPeople( List< Person > people )
    {
        this.people = people;
    }
}