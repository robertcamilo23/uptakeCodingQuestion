package UptakeCodingQuestion.domain;

import javax.persistence.Entity;

import java.util.Date;

/**
 * Person.java
 * 
 * @author: Robert Martinez - robertcamilo23@gmail.com
 */
@Entity
public class Person
{
	// ----------------------------
	// Constructor
	// ----------------------------

	public Person( )
	{
		super( );
	}

	// ----------------------------
	// Attributes
	// ----------------------------

	private Integer id;
	private String firstName;
	private String lastName;
	private Date birthday;
	private String genre;
//	private Family family;

	// ----------------------------
	// Getters & Setters
	// ----------------------------

//	public Family getFamily( )
//	{
//		return family;
//	}
//
//	public void setFamily( Family family )
//	{
//		this.family = family;
//	}

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

	public String getGenre( )
	{
		return genre;
	}

	public void setGenre( String genre )
	{
		this.genre = genre;
	}
	
	@Override
    public String toString( )
    {
        StringBuilder sb = new StringBuilder( )            
        .append( this.getClass( ).getName( ) )
        .append( " Person { ")
        .append( "id:" ).append( this.id ).append(',')
        .append( "firstName:" ).append( this.firstName ).append(',')
        .append( "birthday:" ).append( this.birthday ).append(',')
        .append( "genre:" ).append( this.genre ).append(',')
        .append( " }" );
        return sb.toString( );
    }
}