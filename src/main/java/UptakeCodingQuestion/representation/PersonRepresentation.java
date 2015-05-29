package UptakeCodingQuestion.representation;

/**
 * PersonRepresentation.java
 * 
 * @author: Robert Martinez - robertcamilo23@gmail.com
 */
public class PersonRepresentation
{
	// ----------------------------
	// Constructor
	// ----------------------------

	public PersonRepresentation( )
	{
		super( );
	}

	// ----------------------------
	// Attributes
	// ----------------------------

	private Integer id;
	private String firstName;
	private String lastName;
	private String birthday;
	private String genre;

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

	public String getBirthday( )
	{
		return birthday;
	}

	public void setBirthday( String birthday )
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
}