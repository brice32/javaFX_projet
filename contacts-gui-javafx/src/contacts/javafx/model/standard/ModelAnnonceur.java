package contacts.javafx.model.standard;

import contacts.commun.dto.DtoAnnonceur;
import contacts.commun.service.IServiceAnnonceur;
import contacts.commun.util.ExceptionAppli;
import contacts.javafx.fxb.FXAnnonceur;
import contacts.javafx.model.IModelAnnonceur;
import contacts.javafx.util.mapper.IMapperDtoFX;
import contacts.javafx.view.IManagerGui;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ModelAnnonceur implements IModelAnnonceur {

	private final ObservableList<FXAnnonceur> annonceurs = FXCollections.observableArrayList(a ->new Observable[]{ a.nomProperty(), a.emailProperty()});


	private IServiceAnnonceur serviceAnnonceur;

	private IMapperDtoFX mapper;

	@Override
	public void actualiserListe() throws ExceptionAppli {
		// TODO Auto-generated method stub
		annonceurs.clear();
		for( DtoAnnonceur dto : serviceAnnonceur.listerTout() ) {
			FXAnnonceur annonceur = mapper.map( dto );
				annonceurs.add(annonceur);
			}
	}

	@Override
	public ObservableList<FXAnnonceur> getAnnonceurs() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void supprimer(FXAnnonceur annonceur) throws ExceptionAppli {
		// TODO Auto-generated method stub

	}

	@Override
	public FXAnnonceur getAnnonceurVue() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void preparerModifier(FXAnnonceur annonceur) {
		// TODO Auto-generated method stub

	}

	@Override
	public void preparerModifier() {
		// TODO Auto-generated method stub

	}

	@Override
	public void ValiderMiseAJour() throws ExceptionAppli {
		// TODO Auto-generated method stub

	}

	@Override
	public void refresh() throws ExceptionAppli {
		actualiserListe();
	}

}
