package UptakeCodingQuestion.interfaces;

import java.io.Serializable;
import java.util.List;

/**
 * FamilyDAOInterface.java
 *
 * @author:
 *
 * Robert Martinez - robertcamilo23@gmail.com
 */
public interface FamilyDAOInterface< T, Id extends Serializable >
{
    public void persist( T entity );

    public void update( T entity );

    public T findById( Id id );

    public void delete( T entity );

    public List< T > findAll( );

    public void deleteAll( );
}