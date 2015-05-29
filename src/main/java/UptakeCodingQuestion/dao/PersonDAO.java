package UptakeCodingQuestion.dao;

import UptakeCodingQuestion.domain.Person;
import UptakeCodingQuestion.interfaces.FamilyDAOInterface;

import java.util.List;

/**
 * PersonDAO.java
 *
 * @author:
 *
 * Robert Martinez - robertcamilo23@gmail.com
 */
public class PersonDAO extends SessionManager implements FamilyDAOInterface< Person, Integer >
{
    public void persist( Person person )
    {
        getCurrentSession( ).save( person );
    }

    public void update( Person person )
    {
        getCurrentSession( ).update( person );
    }

    public Person findById( Integer id )
    {
        return ( Person ) getCurrentSession( ).get( Person.class, id );
    }

    public void delete( Person person )
    {
        getCurrentSession( ).delete( person );
    }

    public List< Person > findAll( )
    {
        return ( List< Person > ) getCurrentSession( ).createQuery( "from Person" ).list( );
    }

    public void deleteAll( )
    {
        for ( Person person : findAll( ) )
        {
            delete( person );
        }
    }
}