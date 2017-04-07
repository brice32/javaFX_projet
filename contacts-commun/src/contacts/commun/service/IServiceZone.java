package contacts.commun.service;

import java.util.List;


import contacts.commun.dto.DtoZone;
import contacts.commun.util.ExceptionAppli;

public interface IServiceZone {

	int inserer(DtoZone dtoZone) throws ExceptionAppli;

	void			modifier( DtoZone dtoZone ) throws ExceptionAppli;
	
	void			supprimer( int idZone ) throws ExceptionAppli;
	
	DtoZone 	retrouver( int idZone ) throws ExceptionAppli;
	
	List<DtoZone> listerTout() throws ExceptionAppli;
	
}
