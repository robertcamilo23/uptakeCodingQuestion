package UptakeCodingQuestion.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

/**
 * Family.java
 *
 * @author:
 *
 * Robert Martinez - robertcamilo23@gmail.com
 */
@XmlRootElement( name = "Family" )
@XmlAccessorType( XmlAccessType.FIELD )
@XmlType( name = "" )
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