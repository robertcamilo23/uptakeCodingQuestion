package UptakeCodingQuestion.dao;

import UptakeCodingQuestion.domain.People;
import UptakeCodingQuestion.interfaces.DAOInterface;

import java.util.List;

/**
 * PeopleDAO.java
 *
 * @author:
 *
 * Robert Martinez - robertcamilo23@gmail.com
 */
public class PeopleDAO extends SessionManager implements DAOInterface< People, Integer >
{
    @Override
    public void persist( People people )
    {
        getCurrentSession( ).save( people );
    }

    @Override
    public void update( People people )
    {
        getCurrentSession( ).update( people );
    }

    @Override
    public People findById( Integer id )
    {
        return ( People ) getCurrentSession( ).get( People.class, id );
    }

    @Override
    public void delete( People people )
    {
        getCurrentSession( ).delete( people );
    }

    @Override
    public List< People > findAll( )
    {
        return ( List< People > ) getCurrentSession( ).createQuery( "from People" ).list( );
    }

    @Override
    public void deleteAll( )
    {
        for ( People people : findAll( ) )
        {
            delete( people );
        }
    }
}