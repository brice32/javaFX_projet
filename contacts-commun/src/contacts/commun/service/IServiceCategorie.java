package contacts.commun.service;

import java.util.List;

import contacts.commun.dto.DtoAnnonceur;
import contacts.commun.dto.DtoCategorie;
import contacts.commun.util.ExceptionAppli;


public interface IServiceCategorie {

	int				inserer( DtoCategorie dtoCategorie ) throws ExceptionAppli;

	void			modifier( DtoCategorie dtoCategorie ) throws ExceptionAppli;

	void			supprimer( int idCategorie ) throws ExceptionAppli;

	DtoCategorie 	retrouver( int idCategorie ) throws ExceptionAppli;

	List<DtoCategorie> listerTout() throws ExceptionAppli;

}
