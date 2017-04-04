package contacts.javafx.util.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import contacts.commun.dto.DtoAnnonceur;
import contacts.commun.dto.DtoCategorie;
import contacts.commun.dto.DtoCompte;
import contacts.commun.dto.DtoMouvement;
import contacts.commun.dto.DtoPersonne;
import contacts.commun.dto.DtoTelephone;
import contacts.javafx.fxb.FXAnnonceur;
import contacts.javafx.fxb.FXCategorie;
import contacts.javafx.fxb.FXCompte;
import contacts.javafx.fxb.FXMouvement;
import contacts.javafx.fxb.FXPersonne;
import contacts.javafx.fxb.FXTelephone;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


@Mapper( uses=IMapperDtoFX.FactoryObsservableList.class  )
public interface IMapperDtoFX {

	IMapperDtoFX INSTANCE = Mappers.getMapper( IMapperDtoFX.class );


	// Compte

	FXCompte update( FXCompte source, @MappingTarget FXCompte target );

	FXCompte map( DtoCompte source );

	DtoCompte map( FXCompte source );

	FXPersonne map( DtoPersonne source);

	DtoPersonne map( FXPersonne source );

	FXTelephone map( DtoTelephone source );

	DtoTelephone map( FXTelephone source);

	FXAnnonceur map( DtoAnnonceur source );

	DtoAnnonceur map( FXAnnonceur source );

	FXCategorie map( DtoCategorie source );

	DtoCategorie map ( FXCategorie source);

	FXMouvement map( DtoMouvement source );

	DtoMouvement map( FXMouvement source );

	FXAnnonceur update( FXAnnonceur source, @MappingTarget FXAnnonceur cible);

	FXPersonne update( FXPersonne source, @MappingTarget FXPersonne cible );

	FXCategorie update( FXCategorie source, @MappingTarget FXCategorie cible );

	FXMouvement update( FXMouvement source, @MappingTarget FXMouvement cible );

	FXTelephone duplicate( FXTelephone source );

	ObservableList<FXTelephone> duplicate( ObservableList<FXTelephone> source );

	FXAnnonceur duplicate( FXAnnonceur source );
//
//	ObservableList<FXAnnonceur> duplicate( ObservableList<FXAnnonceur> source );
    // Classe auxiliaire

    public static class FactoryObsservableList {

    	ObservableList<String> createObsListString() {
    		return FXCollections.observableArrayList();
    	}

    	ObservableList<FXTelephone> createObsListFXTelephone() {
    		 return FXCollections.observableArrayList();
    	}

    	ObservableList<FXAnnonceur> createObsListFXAnnonceur() {
   		 return FXCollections.observableArrayList();
   	}
    }

}