package UptakeCodingQuestion.domain;

import java.util.Date;

/**
 * People.java
 *
 * @author:
 *
 * Robert Martinez - robertcamilo23@gmail.com
 */
public class People
{
    private Integer id;
    private String firstName;
    private String lastName;
    private Date birthday;
    private Boolean genre;

    public Integer getId( )
    {
        return id;
    }

    public void setId( Integer id )
    {
        this.id = id;
    }

    public String getFirstName( )
    {
        return firstName;
    }

    public void setFirstName( String firstName )
    {
        this.firstName = firstName;
    }

    public String getLastName( )
    {
        return lastName;
    }

    public void setLastName( String lastName )
    {
        this.lastName = lastName;
    }

    public Date getBirthday( )
    {
        return birthday;
    }

    public void setBirthday( Date birthday )
    {
        this.birthday = birthday;
    }

    public Boolean getGenre( )
    {
        return genre;
    }

    public void setGenre( Boolean genre )
    {
        this.genre = genre;
    }
}