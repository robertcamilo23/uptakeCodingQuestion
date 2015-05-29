package UptakeCodingQuestion.interfaces;

import UptakeCodingQuestion.domain.Family;
import UptakeCodingQuestion.domain.Person;
import UptakeCodingQuestion.representation.PersonRepresentation;

import javax.jws.WebService;

/**
 * FamilyCRUDInterface.java
 *
 * @author:
 *
 * Robert Martinez - robertcamilo23@gmail.com
 */
@WebService
public interface FamilyCRUDInterface
{
    // Families table
    public void createFamily( Family family );

    public Family readFamily( Integer familyId );

    public void updateFamily( Family family );

    public void deleteFamily( Family family );

    public void deleteFamily( Integer familyId );

    // People table
    public void createPerson( PersonRepresentation personRepresentation );

    public Person readPerson( Integer personId );

    public void updatePerson( Person person );

    public void deletePerson( Person person );

    public void deletePerson( Integer personId );
}