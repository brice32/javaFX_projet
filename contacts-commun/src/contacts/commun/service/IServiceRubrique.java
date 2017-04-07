package contacts.commun.service;

import java.util.List;

import contacts.commun.dto.DtoRubrique;
import contacts.commun.util.ExceptionAppli;

public interface IServiceRubrique {

	int inserer(DtoRubrique dtoRubrique) throws ExceptionAppli;

	void			modifier( DtoRubrique dtoRubrique ) throws ExceptionAppli;
	
	void			supprimer( int idRubrique ) throws ExceptionAppli;
	
	DtoRubrique 	retrouver( int idRubrique ) throws ExceptionAppli;
	
	List<DtoRubrique> listerTout() throws ExceptionAppli;
}
