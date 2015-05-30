package UptakeCodingQuestion.interfaces;

import UptakeCodingQuestion.domain.Family;
import UptakeCodingQuestion.domain.Person;
import UptakeCodingQuestion.representation.PersonRepresentation;

import javax.jws.WebService;
import java.util.List;

/**
 * FamilyCRUDInterface.java
 *
 * @author: Robert Martinez - robertcamilo23@gmail.com
 */
@WebService
public interface FamilyCRUDInterface
{
    // Families table
    public void createFamily( Family family );

    public Family readFamily( Integer familyId );

    public List< Family > readFamilies( );

    public void updateFamily( Family family );

    public void deleteFamily( Family family );

    public void deleteFamily( Integer familyId );

    // People table
    public void createPerson( PersonRepresentation personRepresentation );

    public Person readPerson( Integer personId );

    public List< Person > readPeople( );

    public void updatePerson( PersonRepresentation personRepresentation );

    public void deletePerson( PersonRepresentation personRepresentation );

    public void deletePerson( Integer personId );
}