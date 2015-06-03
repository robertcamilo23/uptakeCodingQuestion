package UptakeCodingQuestion.representation;

import java.util.List;

/**
 * FamilyRepresentation.java
 * 
 * @author: Robert Martinez - robertcamilo23@gmail.com
 */
public class FamilyRepresentation
{

	// ----------------------------
	// Constructor
	// ----------------------------

	public FamilyRepresentation( )
	{
		super( );
	}

	// ----------------------------
	// Attributes
	// ----------------------------

	private Integer id;
	private List< PersonRepresentation > peopleRepresentation;

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

	public List< PersonRepresentation > getPeopleRepresentation( )
	{
		return peopleRepresentation;
	}

	public void setPeopleRepresentation( List< PersonRepresentation > peopleRepresentation )
	{
		this.peopleRepresentation = peopleRepresentation;
	}
}