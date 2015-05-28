package UptakeCodingQuestion.service;

import UptakeCodingQuestion.dao.FamilyDAO;
import UptakeCodingQuestion.dao.PersonDAO;
import UptakeCodingQuestion.domain.Family;
import UptakeCodingQuestion.domain.Person;
import UptakeCodingQuestion.interfaces.FamilyCRUDInterface;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 * FamilyService.java
 *
 * @author:
 *
 * Robert Martinez - robertcamilo23@gmail.com
 */
@Path( "/familyService/" )
public class FamilyService implements FamilyCRUDInterface
{
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
    public void createPerson( Person person )
    {
        personDAO.openCurrentSessionWithTransaction( );
        personDAO.persist( person );
        personDAO.closeCurrentSessionWithTransaction( );
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

    public void updatePerson( Person person )
    {
        personDAO.openCurrentSessionWithTransaction( );
        personDAO.update( person );
        personDAO.closeCurrentSessionWithTransaction( );
    }

    public void deletePerson( Person person )
    {
        personDAO.openCurrentSessionWithTransaction( );
        personDAO.delete( person );
        personDAO.closeCurrentSessionWithTransaction( );
    }

    public void deletePerson( Integer personId )
    {
        deletePerson( readPerson( personId ) );
    }
}