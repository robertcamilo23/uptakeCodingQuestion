package UptakeCodingQuestion.interfaces;

import UptakeCodingQuestion.domain.Family;
import UptakeCodingQuestion.domain.Person;
import UptakeCodingQuestion.representation.FamilyRepresentation;
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
	public void createFamily( FamilyRepresentation familyRepresentation );

	public Family readFamily( Integer familyId );

	public List< Family > readFamilies( );

	public void updateFamily( FamilyRepresentation familyRepresentation );

	public void deleteFamily( FamilyRepresentation familyRepresentation );

	public void deleteFamily( Integer familyId );

	// People table
	public void createPerson( PersonRepresentation personRepresentation );

	public Person readPerson( Integer personId );

	public List< Person > readPeople( );

	public void updatePerson( PersonRepresentation personRepresentation );

	public void deletePerson( PersonRepresentation personRepresentation );

	public void deletePerson( Integer personId );
}