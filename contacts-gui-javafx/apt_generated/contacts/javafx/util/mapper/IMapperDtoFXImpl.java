package contacts.javafx.util.mapper;

import contacts.commun.dto.DtoAnnonceur;
import contacts.commun.dto.DtoCompte;
import contacts.commun.dto.DtoPersonne;
import contacts.commun.dto.DtoTelephone;
import contacts.javafx.fxb.FXAnnonceur;
import contacts.javafx.fxb.FXCompte;
import contacts.javafx.fxb.FXPersonne;
import contacts.javafx.fxb.FXTelephone;
import contacts.javafx.util.mapper.IMapperDtoFX.FactoryObsservableList;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.ObservableList;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2017-04-01T12:24:45+0200",
    comments = "version: 1.1.0.Final, compiler: Eclipse JDT (IDE) 1.2.100.v20160418-1457, environment: Java 1.8.0_121 (Oracle Corporation)"
)
public class IMapperDtoFXImpl implements IMapperDtoFX {

    private final FactoryObsservableList factoryObsservableList = new FactoryObsservableList();

    @Override
    public FXCompte update(FXCompte source, FXCompte target) {
        if ( source == null ) {
            return null;
        }

        target.setId( source.getId() );
        target.setPseudo( source.getPseudo() );
        target.setMotDePasse( source.getMotDePasse() );
        target.setEmail( source.getEmail() );
        target.setNom( source.getNom() );
        target.setPrenom( source.getPrenom() );
        target.setTelephone( source.getTelephone() );
        if ( target.getRoles() != null ) {
            target.getRoles().clear();
            ObservableList<String> observableList = source.getRoles();
            if ( observableList != null ) {
                target.getRoles().addAll( observableList );
            }
        }

        return target;
    }

    @Override
    public FXCompte map(DtoCompte source) {
        if ( source == null ) {
            return null;
        }

        FXCompte fXCompte = new FXCompte();

        fXCompte.setId( source.getId() );
        fXCompte.setPseudo( source.getPseudo() );
        fXCompte.setMotDePasse( source.getMotDePasse() );
        fXCompte.setEmail( source.getEmail() );
        fXCompte.setNom( source.getNom() );
        fXCompte.setPrenom( source.getPrenom() );
        fXCompte.setTelephone( source.getTelephone() );
        if ( fXCompte.getRoles() != null ) {
            ObservableList<String> observableList = stringListToStringObservableList( source.getRoles() );
            if ( observableList != null ) {
                fXCompte.getRoles().addAll( observableList );
            }
        }

        return fXCompte;
    }

    @Override
    public DtoCompte map(FXCompte source) {
        if ( source == null ) {
            return null;
        }

        DtoCompte dtoCompte = new DtoCompte();

        dtoCompte.setEmail( source.getEmail() );
        dtoCompte.setId( source.getId() );
        dtoCompte.setMotDePasse( source.getMotDePasse() );
        dtoCompte.setNom( source.getNom() );
        dtoCompte.setPrenom( source.getPrenom() );
        dtoCompte.setPseudo( source.getPseudo() );
        ObservableList<String> observableList = source.getRoles();
        if ( observableList != null ) {
            dtoCompte.setRoles(       new ArrayList<String>( observableList )
            );
        }
        dtoCompte.setTelephone( source.getTelephone() );

        return dtoCompte;
    }

    @Override
    public FXPersonne map(DtoPersonne source) {
        if ( source == null ) {
            return null;
        }

        FXPersonne fXPersonne = new FXPersonne();

        fXPersonne.setId( source.getId() );
        fXPersonne.setNom( source.getNom() );
        fXPersonne.setPrenom( source.getPrenom() );
        if ( fXPersonne.getTelephones() != null ) {
            ObservableList<FXTelephone> observableList = dtoTelephoneListToFXTelephoneObservableList( source.getTelephones() );
            if ( observableList != null ) {
                fXPersonne.getTelephones().addAll( observableList );
            }
        }

        return fXPersonne;
    }

    @Override
    public DtoPersonne map(FXPersonne source) {
        if ( source == null ) {
            return null;
        }

        DtoPersonne dtoPersonne = new DtoPersonne();

        dtoPersonne.setId( source.getId() );
        dtoPersonne.setNom( source.getNom() );
        dtoPersonne.setPrenom( source.getPrenom() );
        List<DtoTelephone> list = fXTelephoneObservableListToDtoTelephoneList( source.getTelephones() );
        if ( list != null ) {
            dtoPersonne.setTelephones( list );
        }

        return dtoPersonne;
    }

    @Override
    public FXTelephone map(DtoTelephone source) {
        if ( source == null ) {
            return null;
        }

        FXTelephone fXTelephone_ = new FXTelephone();

        fXTelephone_.setLibelle( source.getLibelle() );
        fXTelephone_.setNumero( source.getNumero() );
        fXTelephone_.setId( source.getId() );

        return fXTelephone_;
    }

    @Override
    public DtoTelephone map(FXTelephone source) {
        if ( source == null ) {
            return null;
        }

        DtoTelephone dtoTelephone_ = new DtoTelephone();

        dtoTelephone_.setId( source.getId() );
        dtoTelephone_.setLibelle( source.getLibelle() );
        dtoTelephone_.setNumero( source.getNumero() );

        return dtoTelephone_;
    }

    @Override
    public FXAnnonceur map(DtoAnnonceur source) {
        if ( source == null ) {
            return null;
        }

        FXAnnonceur fXAnnonceur = new FXAnnonceur();

        fXAnnonceur.setId( source.getId() );
        fXAnnonceur.setNom( source.getNom() );
        fXAnnonceur.setTelephone( source.getTelephone() );
        fXAnnonceur.setEmail( source.getEmail() );
        fXAnnonceur.setLieuNom( source.getLieuNom() );
        fXAnnonceur.setLieuAdresse( source.getLieuAdresse() );
        fXAnnonceur.setLieuCp( source.getLieuCp() );
        fXAnnonceur.setLieuVille( source.getLieuVille() );
        fXAnnonceur.setSiteWeb( source.getSiteWeb() );

        return fXAnnonceur;
    }

    @Override
    public DtoAnnonceur map(FXAnnonceur source) {
        if ( source == null ) {
            return null;
        }

        DtoAnnonceur dtoAnnonceur = new DtoAnnonceur();

        dtoAnnonceur.setEmail( source.getEmail() );
        dtoAnnonceur.setId( source.getId() );
        dtoAnnonceur.setLieuAdresse( source.getLieuAdresse() );
        dtoAnnonceur.setLieuCp( source.getLieuCp() );
        dtoAnnonceur.setLieuNom( source.getLieuNom() );
        dtoAnnonceur.setLieuVille( source.getLieuVille() );
        dtoAnnonceur.setNom( source.getNom() );
        dtoAnnonceur.setSiteWeb( source.getSiteWeb() );
        dtoAnnonceur.setTelephone( source.getTelephone() );

        return dtoAnnonceur;
    }

    @Override
    public FXAnnonceur update(FXAnnonceur source, FXAnnonceur cible) {
        if ( source == null ) {
            return null;
        }

        cible.setId( source.getId() );
        cible.setNom( source.getNom() );
        cible.setTelephone( source.getTelephone() );
        cible.setEmail( source.getEmail() );
        cible.setLieuNom( source.getLieuNom() );
        cible.setLieuAdresse( source.getLieuAdresse() );
        cible.setLieuCp( source.getLieuCp() );
        cible.setLieuVille( source.getLieuVille() );
        cible.setSiteWeb( source.getSiteWeb() );

        return cible;
    }

    @Override
    public FXPersonne update(FXPersonne source, FXPersonne cible) {
        if ( source == null ) {
            return null;
        }

        cible.setId( source.getId() );
        cible.setNom( source.getNom() );
        cible.setPrenom( source.getPrenom() );
        if ( cible.getTelephones() != null ) {
            cible.getTelephones().clear();
            ObservableList<FXTelephone> observableList = duplicate( source.getTelephones() );
            if ( observableList != null ) {
                cible.getTelephones().addAll( observableList );
            }
        }

        return cible;
    }

    @Override
    public FXTelephone duplicate(FXTelephone source) {
        if ( source == null ) {
            return null;
        }

        FXTelephone fXTelephone = new FXTelephone();

        fXTelephone.setLibelle( source.getLibelle() );
        fXTelephone.setNumero( source.getNumero() );
        fXTelephone.setId( source.getId() );

        return fXTelephone;
    }

    @Override
    public ObservableList<FXTelephone> duplicate(ObservableList<FXTelephone> source) {
        if ( source == null ) {
            return null;
        }

        ObservableList<FXTelephone> observableList____ = factoryObsservableList.createObsListFXTelephone();
        for ( FXTelephone fXTelephone : source ) {
            observableList____.add( duplicate( fXTelephone ) );
        }

        return observableList____;
    }

    protected ObservableList<String> stringListToStringObservableList(List<String> list) {
        if ( list == null ) {
            return null;
        }

        ObservableList<String> observableList = factoryObsservableList.createObsListString();
        for ( String string : list ) {
            observableList.add( string );
        }

        return observableList;
    }

    protected ObservableList<FXTelephone> dtoTelephoneListToFXTelephoneObservableList(List<DtoTelephone> list) {
        if ( list == null ) {
            return null;
        }

        ObservableList<FXTelephone> observableList = factoryObsservableList.createObsListFXTelephone();
        for ( DtoTelephone dtoTelephone : list ) {
            observableList.add( map( dtoTelephone ) );
        }

        return observableList;
    }

    protected List<DtoTelephone> fXTelephoneObservableListToDtoTelephoneList(ObservableList<FXTelephone> observableList) {
        if ( observableList == null ) {
            return null;
        }

        List<DtoTelephone> list = new ArrayList<DtoTelephone>();
        for ( FXTelephone fXTelephone : observableList ) {
            list.add( map( fXTelephone ) );
        }

        return list;
    }
}
