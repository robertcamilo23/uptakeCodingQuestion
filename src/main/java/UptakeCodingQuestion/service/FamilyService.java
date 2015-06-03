package UptakeCodingQuestion.service;

import UptakeCodingQuestion.dao.FamilyDAO;
import UptakeCodingQuestion.dao.PersonDAO;
import UptakeCodingQuestion.domain.Family;
import UptakeCodingQuestion.domain.Person;
import UptakeCodingQuestion.interfaces.FamilyCRUDInterface;
import UptakeCodingQuestion.representation.FamilyRepresentation;
import UptakeCodingQuestion.representation.PersonRepresentation;

import org.apache.cxf.rs.security.cors.CrossOriginResourceSharing;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * FamilyService.java
 * 
 * @author: Robert Martinez - robertcamilo23@gmail.com
 */
@CrossOriginResourceSharing ( allowAllOrigins = true )
@Path ( "/familyService/" )
public class FamilyService implements FamilyCRUDInterface
{
	private static final ApplicationContext context = new ClassPathXmlApplicationContext( "META-INF/app-context.xml" );
	private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat( "yyyy-MM-dd" );

	// DAOs
	private FamilyDAO familyDAO = new FamilyDAO( );
	private PersonDAO personDAO = new PersonDAO( );

	// Families
	@POST
	@Produces ( { MediaType.APPLICATION_JSON } )
	@Path ( "/families" )
	public void createFamily( FamilyRepresentation familyRepresentation )
	{
		Family family = getFamilyFromRepresentation( familyRepresentation );
		if ( family != null )
		{
			familyDAO.openCurrentSessionWithTransaction( );
			familyDAO.persist( family );
			familyDAO.closeCurrentSessionWithTransaction( );
		}
	}

	@GET
	@Produces ( { MediaType.APPLICATION_JSON } )
	@Path ( "/families" )
	public List< Family > readFamilies( )
	{
		familyDAO.openCurrentSession( );
		List< Family > families = familyDAO.findAll( );
		families.toString( );
		familyDAO.closeCurrentSession( );
		return families;
	}

	@GET
	@Produces ( { MediaType.APPLICATION_JSON } )
	@Path ( "/families/{familyId}" )
	public Family readFamily( @PathParam ( "familyId" ) Integer familyId )
	{
		familyDAO.openCurrentSession( );
		Family family = familyDAO.findById( familyId );
		family.toString( );
		familyDAO.closeCurrentSession( );
		return family;
	}

	@PUT
	@Produces ( { MediaType.APPLICATION_JSON } )
	@Path ( "/families" )
	public void updateFamily( FamilyRepresentation familyRepresentation )
	{
		Family family = getFamilyFromRepresentation( familyRepresentation );
		if ( family != null && family.getId( ) != null )
		{
			familyDAO.openCurrentSessionWithTransaction( );
			familyDAO.update( family );
			familyDAO.closeCurrentSessionWithTransaction( );
		}
	}

	@DELETE
	@Produces ( { MediaType.APPLICATION_JSON } )
	@Path ( "/families" )
	public void deleteFamily( FamilyRepresentation familyRepresentation )
	{
		Family family = getFamilyFromRepresentation( familyRepresentation );
		if ( family != null && family.getId( ) != null )
		{
			familyDAO.openCurrentSessionWithTransaction( );
			familyDAO.delete( family );
			familyDAO.closeCurrentSessionWithTransaction( );
		}
	}

	@DELETE
	@Produces ( { MediaType.APPLICATION_JSON } )
	@Path ( "/families/{familyId}" )
	public void deleteFamily( @PathParam ( "familyId" ) Integer familyId )
	{
		deleteFamily( getRepresentationFromFamily( readFamily( familyId ) ) );
	}

	// People
	@POST
	@Produces ( { MediaType.APPLICATION_JSON } )
	@Path ( "/people" )
	public void createPerson( PersonRepresentation personRepresentation )
	{
		Person person = getPersonFromRepresentation( personRepresentation );
		if ( person != null )
		{
			personDAO.openCurrentSessionWithTransaction( );
			personDAO.persist( person );
			personDAO.closeCurrentSessionWithTransaction( );
		}
	}

	@GET
	@Produces ( { MediaType.APPLICATION_JSON } )
	@Path ( "/people" )
	public List< Person > readPeople( )
	{
		personDAO.openCurrentSession( );
		List< Person > people = personDAO.findAll( );
		personDAO.closeCurrentSession( );
		return people;
	}

	@GET
	@Produces ( { MediaType.APPLICATION_JSON } )
	@Path ( "/people/{personId}" )
	public Person readPerson( @PathParam ( "personId" ) Integer personId )
	{
		personDAO.openCurrentSession( );
		Person person = personDAO.findById( personId );
		personDAO.closeCurrentSession( );
		return person;
	}

	@PUT
	@Produces ( { MediaType.APPLICATION_JSON } )
	@Path ( "/people" )
	public void updatePerson( PersonRepresentation personRepresentation )
	{
		Person person = getPersonFromRepresentation( personRepresentation );
		if ( person != null && person.getId( ) != null )
		{
			personDAO.openCurrentSessionWithTransaction( );
			personDAO.update( person );
			personDAO.closeCurrentSessionWithTransaction( );
		}
	}

	@DELETE
	@Produces ( { MediaType.APPLICATION_JSON } )
	@Path ( "/people" )
	public void deletePerson( PersonRepresentation personRepresentation )
	{
		Person person = getPersonFromRepresentation( personRepresentation );
		if ( person != null && person.getId( ) != null )
		{
			personDAO.openCurrentSessionWithTransaction( );
			personDAO.delete( person );
			personDAO.closeCurrentSessionWithTransaction( );
		}
	}

	@DELETE
	@Produces ( { MediaType.APPLICATION_JSON } )
	@Path ( "/people/{personId}" )
	public void deletePerson( @PathParam ( "personId" ) Integer personId )
	{
		deletePerson( getRepresentationFromPerson( readPerson( personId ) ) );
	}

	public Person getPersonFromRepresentation( PersonRepresentation personRepresentation )
	{
		try
		{
			Person person = ( Person ) context.getBean( "person" );
			if ( personRepresentation.getId( ) != null )
			{
				person.setId( personRepresentation.getId( ) );
			}
			person.setFirstName( personRepresentation.getFirstName( ) );
			person.setLastName( personRepresentation.getLastName( ) );
			person.setBirthday( simpleDateFormat.parse( personRepresentation.getBirthday( ) ) );
			person.setGenre( personRepresentation.getGenre( ) );
			return person;
		}
		catch ( ParseException e )
		{
			e.printStackTrace( );
			System.out.println( "ERROR - Person could not be created" );
		}
		return null;
	}

	public PersonRepresentation getRepresentationFromPerson( Person person )
	{
		PersonRepresentation personRepresentation = ( PersonRepresentation ) context.getBean( "personRepresentation" );
		personRepresentation.setId( person.getId( ) );
		personRepresentation.setFirstName( person.getFirstName( ) );
		personRepresentation.setLastName( person.getLastName( ) );
		personRepresentation.setBirthday( simpleDateFormat.format( person.getBirthday( ) ) );
		personRepresentation.setGenre( person.getGenre( ) );
		return personRepresentation;
	}

	public Family getFamilyFromRepresentation( FamilyRepresentation familyRepresentation )
	{
		Family family = ( Family ) context.getBean( "family" );
		family.setId( familyRepresentation.getId( ) );
		Set< Person > people = new HashSet< Person >( );
		for ( PersonRepresentation personRepresentation : familyRepresentation.getPeopleRepresentation( ) )
		{
			people.add( getPersonFromRepresentation( personRepresentation ) );
		}
		family.setPeople( people );
		return family;
	}
	
	public FamilyRepresentation getRepresentationFromFamily( Family family )
	{
		FamilyRepresentation familyRepresentation = ( FamilyRepresentation ) context.getBean( "familyRepresentation" );
		familyRepresentation.setId( family.getId( ) );
		List< PersonRepresentation > peopleRepresentation = new ArrayList< PersonRepresentation >( );
		for ( Person person : family.getPeople( ) )
		{
			peopleRepresentation.add( getRepresentationFromPerson( person ) );
		}
		familyRepresentation.setPeopleRepresentation( peopleRepresentation );
		return familyRepresentation;
	}
}