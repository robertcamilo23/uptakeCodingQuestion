package UptakeCodingQuestion.domain;

import javax.persistence.Entity;

import java.util.Set;

/**
 * Family.java
 * 
 * @author: Robert Martinez - robertcamilo23@gmail.com
 */
@Entity
public class Family
{
	// ----------------------------
	// Constructor
	// ----------------------------

	public Family( )
	{
		super( );
		// TODO Auto-generated constructor stub
	}

	// ----------------------------
	// Attributes
	// ----------------------------

	private Integer id;
	private Set< Person > people;

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

	public Set< Person > getPeople( )
	{
		return people;
	}

	public void setPeople( Set< Person > people )
	{
		this.people = people;
	}

	@Override
    public String toString( )
    {
        StringBuilder sb = new StringBuilder( )            
        .append( this.getClass( ).getName( ) )
        .append( " Family { ")
        .append( "id:" ).append( this.id ).append(',')
        .append( "set<person>:" ).append( this.people ).append(',')
        .append( " }" );
        return sb.toString( );
    }
}