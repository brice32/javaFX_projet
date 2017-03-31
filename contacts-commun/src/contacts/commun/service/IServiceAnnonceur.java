package contacts.commun.service;

import java.util.List;

import contacts.commun.dto.DtoAnnonceur;
import contacts.commun.util.ExceptionAppli;


public interface IServiceAnnonceur {

	int				inserer( DtoAnnonceur dtoannonceur ) throws ExceptionAppli;

	void			modifier( DtoAnnonceur dtoannonceur ) throws ExceptionAppli;

	void			supprimer( int idAnnonceur ) throws ExceptionAppli;

	DtoAnnonceur 	retrouver( int idAnnonceur ) throws ExceptionAppli;

	List<DtoAnnonceur> listerTout() throws ExceptionAppli;

}
