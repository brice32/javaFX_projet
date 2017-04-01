package contacts.javafx.view.systeme;

import java.util.List;

import contacts.commun.dto.DtoAnnonceur;
import contacts.commun.service.IServiceAnnonceur;
import contacts.commun.util.ExceptionAppli;

public class ControllerMenuConfiguration implements IServiceAnnonceur {

	@Override
	public int inserer(DtoAnnonceur dtoannonceur) throws ExceptionAppli {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void modifier(DtoAnnonceur dtoannonceur) throws ExceptionAppli {
		// TODO Auto-generated method stub

	}

	@Override
	public void supprimer(int idAnnonceur) throws ExceptionAppli {
		// TODO Auto-generated method stub

	}

	@Override
	public DtoAnnonceur retrouver(int idAnnonceur) throws ExceptionAppli {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DtoAnnonceur> listerTout() throws ExceptionAppli {
		// TODO Auto-generated method stub
		return null;
	}

}
