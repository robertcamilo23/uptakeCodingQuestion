package UptakeCodingQuestion.service;

import UptakeCodingQuestion.dao.FamilyDAO;
import UptakeCodingQuestion.dao.PersonDAO;
import UptakeCodingQuestion.domain.Family;
import UptakeCodingQuestion.domain.Person;
import UptakeCodingQuestion.interfaces.FamilyCRUDInterface;
import UptakeCodingQuestion.representation.PersonRepresentation;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.ws.rs.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * FamilyService.java
 *
 * @author: Robert Martinez - robertcamilo23@gmail.com
 */
@Path( "/familyService/" )
public class FamilyService implements FamilyCRUDInterface
{
    private static final ApplicationContext context = new ClassPathXmlApplicationContext( "META-INF/app-context.xml" );

    // DAOs
    private FamilyDAO familyDAO = new FamilyDAO( );
    private PersonDAO personDAO = new PersonDAO( );

    // Families
    public void createFamily( Family family )
    {
        familyDAO.openCurrentSessionWithTransaction( );
        familyDAO.persist( family );
        familyDAO.closeCurrentSessionWithTransaction( );
    }

    @GET
    @Produces( { "application/xml", "application/json" } )
    @Path( "/families" )
    public List< Family > readFamilies( )
    {
        familyDAO.openCurrentSession( );
        List< Family > family = familyDAO.findAll( );
        familyDAO.closeCurrentSession( );
        return family;
    }

    @GET
    @Produces( { "application/xml", "application/json" } )
    @Path( "/families/{familyId}" )
    public Family readFamily( @PathParam( "familyId" ) Integer familyId )
    {
        familyDAO.openCurrentSession( );
        Family family = familyDAO.findById( familyId );
        familyDAO.closeCurrentSession( );
        return family;
    }

    public void updateFamily( Family family )
    {
        familyDAO.openCurrentSessionWithTransaction( );
        familyDAO.update( family );
        familyDAO.closeCurrentSessionWithTransaction( );
    }

    public void deleteFamily( Family family )
    {
        familyDAO.openCurrentSessionWithTransaction( );
        familyDAO.delete( family );
        familyDAO.closeCurrentSessionWithTransaction( );
    }

    public void deleteFamily( Integer familyId )
    {
        deleteFamily( readFamily( familyId ) );
    }

    // People

    @POST
    @Produces( { "application/xml", "application/json" } )
    @Path( "/people" )
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
    @Produces( { "application/xml", "application/json" } )
    @Path( "/people" )
    public List< Person > readPeople( )
    {
        personDAO.openCurrentSession( );
        List< Person > people = personDAO.findAll( );
        personDAO.closeCurrentSession( );
        return people;
    }

    @GET
    @Produces( { "application/xml", "application/json" } )
    @Path( "/people/{personId}" )
    public Person readPerson( @PathParam( "personId" ) Integer personId )
    {
        personDAO.openCurrentSession( );
        Person person = personDAO.findById( personId );
        personDAO.closeCurrentSession( );
        return person;
    }

    @PUT
    @Produces( { "application/xml", "application/json" } )
    @Path( "/people" )
    public void updatePerson( Person person )
    {
        personDAO.openCurrentSessionWithTransaction( );
        personDAO.update( person );
        personDAO.closeCurrentSessionWithTransaction( );
    }

    @DELETE
    @Produces( { "application/xml", "application/json" } )
    @Path( "/people" )
    public void deletePerson( Person person )
    {
        personDAO.openCurrentSessionWithTransaction( );
        personDAO.delete( person );
        personDAO.closeCurrentSessionWithTransaction( );
    }

    @DELETE
    @Produces( { "application/xml", "application/json" } )
    @Path( "/people/{personId}" )
    public void deletePerson( @PathParam( "personId" ) Integer personId )
    {
        deletePerson( readPerson( personId ) );
    }


    public Person getPersonFromRepresentation( PersonRepresentation personRepresentation )
    {
        try
        {
            Person person = ( Person ) context.getBean( "person" );
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat( "yyyy-MM-dd" );

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
}