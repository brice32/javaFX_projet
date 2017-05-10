package contacts.commun.service;

import java.util.List;

import contacts.commun.dto.DtoAnnonce;
import contacts.commun.util.ExceptionAppli;


public interface IServiceAnnonce {

	List<DtoAnnonce> listerTout() throws ExceptionAppli;

}
