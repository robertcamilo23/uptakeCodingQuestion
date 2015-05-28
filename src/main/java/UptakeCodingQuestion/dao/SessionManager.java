package UptakeCodingQuestion.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 * SessionManager.java
 *
 * @author:
 *
 * Robert Martinez - robertcamilo23@gmail.com
 */
public abstract class SessionManager
{
    private Session currentSession;

    private Transaction currentTransaction;

    private static SessionFactory getSessionFactory( )
    {
        Configuration configuration = new Configuration( ).configure( );
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder( )
                .applySettings( configuration.getProperties( ) );
        SessionFactory sessionFactory = configuration.buildSessionFactory( builder.build( ) );
        return sessionFactory;
    }

    public Session openCurrentSession( )
    {
        currentSession = getSessionFactory( ).openSession( );
        return currentSession;
    }

    public Session openCurrentSessionWithTransaction( )
    {
        currentSession = getSessionFactory( ).openSession( );
        currentTransaction = currentSession.beginTransaction( );
        return currentSession;
    }

    public void closeCurrentSession( )
    {
        currentSession.close( );
    }

    public void closeCurrentSessionWithTransaction( )
    {
        currentTransaction.commit( );
        currentSession.close( );
    }

    public Session getCurrentSession( )
    {
        return currentSession;
    }

    public void setCurrentSession( Session currentSession )
    {
        this.currentSession = currentSession;
    }

    public Transaction getCurrentTransaction( )
    {
        return currentTransaction;
    }

    public void setCurrentTransaction( Transaction currentTransaction )
    {
        this.currentTransaction = currentTransaction;
    }
}