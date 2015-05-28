package UptakeCodingQuestion.dao;

import UptakeCodingQuestion.domain.Family;
import UptakeCodingQuestion.interfaces.FamilyDAOInterface;

import java.util.List;

/**
 * FamilyDAO.java
 *
 * @author:
 *
 * Robert Martinez - robertcamilo23@gmail.com
 */
public class FamilyDAO extends SessionManager implements FamilyDAOInterface< Family, Integer >
{
    public void persist( Family family )
    {
        getCurrentSession( ).save( family );
    }

    public void update( Family family )
    {
        getCurrentSession( ).update( family );
    }

    public Family findById( Integer id )
    {
        return ( Family ) getCurrentSession( ).get( Family.class, id );
    }

    public void delete( Family family )
    {
        getCurrentSession( ).delete( family );
    }

    public List< Family > findAll( )
    {
        return ( List< Family > ) getCurrentSession( ).createQuery( "from Families" ).list( );
    }

    public void deleteAll( )
    {
        for ( Family family : findAll( ) )
        {
            delete( family );
        }
    }
}