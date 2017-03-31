package contacts.javafx.util.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import contacts.commun.dto.DtoAnnonceur;
import contacts.commun.dto.DtoCompte;
import contacts.commun.dto.DtoPersonne;
import contacts.commun.dto.DtoTelephone;
import contacts.javafx.fxb.FXAnnonceur;
import contacts.javafx.fxb.FXCompte;
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

	FXAnnonceur update( FXAnnonceur source, @MappingTarget FXAnnonceur cible);

	FXPersonne update( FXPersonne source, @MappingTarget FXPersonne cible );

	FXTelephone duplicate( FXTelephone source );

	ObservableList<FXTelephone> duplicate( ObservableList<FXTelephone> source );
    // Classe auxiliaire

    public static class FactoryObsservableList {

    	ObservableList<String> createObsListString() {
    		return FXCollections.observableArrayList();
    	}

    	ObservableList<FXTelephone> createObsListFXTelephone() {
    		 return FXCollections.observableArrayList();
    	}
    }

}