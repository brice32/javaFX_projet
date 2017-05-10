package contacts.javafx.model.standard;

import contacts.commun.dto.DtoAnnonce;
import contacts.commun.service.IServiceAnnonce;
import contacts.commun.service.IServiceAnnonceur;
import contacts.commun.util.ExceptionAppli;
import contacts.javafx.fxb.FXAnnonce;
import contacts.javafx.fxb.FXAnnonceur;
import contacts.javafx.model.EnumModeVue;
import contacts.javafx.model.IModelAnnonce;
import contacts.javafx.util.mapper.IMapperDtoFX;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ModelAnnonce implements IModelAnnonce {

	private final ObservableList<FXAnnonce> annonces = FXCollections.observableArrayList();
	// a ->new Observable[]{ a.nomProperty(), a.emailProperty()}
	private final FXAnnonce annonceVue = new FXAnnonce();

	private FXAnnonce annonceCourant;

	private IServiceAnnonce serviceAnnonce;

	private IMapperDtoFX mapper;

	private EnumModeVue modeVue;

	@Override
	public void actualiserListe() throws ExceptionAppli {
		annonces.clear();
		for (DtoAnnonce dto : serviceAnnonce.listerTout()){
			FXAnnonce annonce = mapper.map(dto);
			mapper.update(mapper.map(dto.getAnnonceur()), annonce.getFxannonceur());
			mapper.update(mapper.map(dto.getRubrique()), annonce.getFxrubrique());
			mapper.update(mapper.map(dto.getZone()), annonce.getFxzone());
			mapper.update(mapper.map(dto.getCategorie()), annonce.getFxcategorie());
			annonces.add(annonce);
		}
	}

	@Override
	public ObservableList<FXAnnonce> getAnnonces() {
		return annonces;
	}

	@Override
	public void refresh() throws ExceptionAppli {
		actualiserListe();
	}

	public void setMapper(IMapperDtoFX mapper) {
		this.mapper = mapper;
	}

	public void setServiceAnnonce(IServiceAnnonce serviceAnnonce) {
		this.serviceAnnonce = serviceAnnonce;
	}
}
