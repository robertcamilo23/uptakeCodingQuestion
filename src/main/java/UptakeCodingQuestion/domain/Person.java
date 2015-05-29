package UptakeCodingQuestion.domain;

import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import java.util.Date;

/**
 * Person.java
 * 
 * @author: Robert Martinez - robertcamilo23@gmail.com
 */
@XmlRootElement ( name = "Person" )
@XmlAccessorType ( XmlAccessType.FIELD )
@XmlType ( name = "" )
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
}