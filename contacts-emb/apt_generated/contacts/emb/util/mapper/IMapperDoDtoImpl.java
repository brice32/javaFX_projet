package contacts.emb.util.mapper;

import contacts.commun.dto.DtoAnnonceur;
import contacts.commun.dto.DtoCategorie;
import contacts.commun.dto.DtoCompte;
import contacts.commun.dto.DtoMouvement;
import contacts.commun.dto.DtoPersonne;
import contacts.commun.dto.DtoRubrique;
import contacts.commun.dto.DtoTelephone;
import contacts.commun.dto.DtoZone;
import contacts.emb.dom.Annonceur;
import contacts.emb.dom.Categorie;
import contacts.emb.dom.Compte;
import contacts.emb.dom.Mouvement;
import contacts.emb.dom.Personne;
import contacts.emb.dom.Rubrique;
import contacts.emb.dom.Telephone;
import contacts.emb.dom.Zone;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2017-04-07T11:48:03+0200",
    comments = "version: 1.1.0.Final, compiler: Eclipse JDT (IDE) 1.2.100.v20160418-1457, environment: Java 1.8.0_121 (Oracle Corporation)"
)
public class IMapperDoDtoImpl implements IMapperDoDto {

    @Override
    public Compte map(DtoCompte source) {
        if ( source == null ) {
            return null;
        }

        Compte compte = new Compte();

        compte.setEmail( source.getEmail() );
        compte.setId( source.getId() );
        compte.setMotDePasse( source.getMotDePasse() );
        compte.setNom( source.getNom() );
        compte.setPrenom( source.getPrenom() );
        compte.setPseudo( source.getPseudo() );
        List<String> list = source.getRoles();
        if ( list != null ) {
            compte.setRoles(       new ArrayList<String>( list )
            );
        }
        compte.setTelephone( source.getTelephone() );

        return compte;
    }

    @Override
    public DtoCompte map(Compte source) {
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
        List<String> list = source.getRoles();
        if ( list != null ) {
            dtoCompte.setRoles(       new ArrayList<String>( list )
            );
        }
        dtoCompte.setTelephone( source.getTelephone() );

        return dtoCompte;
    }

    @Override
    public Personne map(DtoPersonne source) {
        if ( source == null ) {
            return null;
        }

        Personne personne = new Personne();

        personne.setId( source.getId() );
        personne.setNom( source.getNom() );
        personne.setPrenom( source.getPrenom() );
        List<Telephone> list = dtoTelephoneListToTelephoneList( source.getTelephones() );
        if ( list != null ) {
            personne.setTelephones( list );
        }

        ajouterRefPersonne( personne );

        return personne;
    }

    @Override
    public DtoPersonne map(Personne source) {
        if ( source == null ) {
            return null;
        }

        DtoPersonne dtoPersonne = new DtoPersonne();

        dtoPersonne.setId( source.getId() );
        dtoPersonne.setNom( source.getNom() );
        dtoPersonne.setPrenom( source.getPrenom() );
        List<DtoTelephone> list = telephoneListToDtoTelephoneList( source.getTelephones() );
        if ( list != null ) {
            dtoPersonne.setTelephones( list );
        }

        return dtoPersonne;
    }

    @Override
    public Annonceur map(DtoAnnonceur source) {
        if ( source == null ) {
            return null;
        }

        Annonceur annonceur = new Annonceur();

        annonceur.setEmail( source.getEmail() );
        annonceur.setId( source.getId() );
        annonceur.setLieuAdresse( source.getLieuAdresse() );
        annonceur.setLieuCp( source.getLieuCp() );
        annonceur.setLieuNom( source.getLieuNom() );
        annonceur.setLieuVille( source.getLieuVille() );
        annonceur.setNom( source.getNom() );
        annonceur.setSiteWeb( source.getSiteWeb() );
        annonceur.setTelephone( source.getTelephone() );

        return annonceur;
    }

    @Override
    public DtoAnnonceur map(Annonceur source) {
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
    public Categorie map(DtoCategorie source) {
        if ( source == null ) {
            return null;
        }

        Categorie categorie = new Categorie();

        categorie.setIdCategorie( source.getIdCategorie() );
        categorie.setLibelle( source.getLibelle() );

        return categorie;
    }

    @Override
    public DtoCategorie map(Categorie source) {
        if ( source == null ) {
            return null;
        }

        DtoCategorie dtoCategorie = new DtoCategorie();

        dtoCategorie.setIdCategorie( source.getIdCategorie() );
        dtoCategorie.setLibelle( source.getLibelle() );

        return dtoCategorie;
    }

    @Override
    public Mouvement map(DtoMouvement source) {
        if ( source == null ) {
            return null;
        }

        Mouvement mouvement = new Mouvement();

        mouvement.setAnnonceur( map( source.getAnnonceur() ) );
        mouvement.setDate( source.getDate() );
        mouvement.setDescription( source.getDescription() );
        mouvement.setHeure( source.getHeure() );
        mouvement.setIdMouvement( source.getIdMouvement() );
        mouvement.setLibelle( source.getLibelle() );
        mouvement.setMontant( source.getMontant() );
        mouvement.setSolde( source.getSolde() );

        return mouvement;
    }

    @Override
    public DtoMouvement map(Mouvement source) {
        if ( source == null ) {
            return null;
        }

        DtoMouvement dtoMouvement = new DtoMouvement();

        dtoMouvement.setAnnonceur( map( source.getAnnonceur() ) );
        dtoMouvement.setDate( source.getDate() );
        dtoMouvement.setDescription( source.getDescription() );
        dtoMouvement.setHeure( source.getHeure() );
        dtoMouvement.setIdMouvement( source.getIdMouvement() );
        dtoMouvement.setLibelle( source.getLibelle() );
        dtoMouvement.setMontant( source.getMontant() );
        dtoMouvement.setSolde( source.getSolde() );

        return dtoMouvement;
    }

    @Override
    public Zone map(DtoZone source) {
        if ( source == null ) {
            return null;
        }

        Zone zone = new Zone();

        zone.setId( source.getId() );
        zone.setNom( source.getNom() );

        return zone;
    }

    @Override
    public DtoZone map(Zone source) {
        if ( source == null ) {
            return null;
        }

        DtoZone dtoZone = new DtoZone();

        dtoZone.setId( source.getId() );
        dtoZone.setNom( source.getNom() );

        return dtoZone;
    }

    @Override
    public Rubrique map(DtoRubrique source) {
        if ( source == null ) {
            return null;
        }

        Rubrique rubrique = new Rubrique();

        rubrique.setId( source.getId() );
        rubrique.setNom( source.getNom() );

        return rubrique;
    }

    @Override
    public DtoRubrique map(Rubrique source) {
        if ( source == null ) {
            return null;
        }

        DtoRubrique dtoRubrique = new DtoRubrique();

        dtoRubrique.setId( source.getId() );
        dtoRubrique.setNom( source.getNom() );

        return dtoRubrique;
    }

    @Override
    public Telephone map(DtoTelephone source) {
        if ( source == null ) {
            return null;
        }

        Telephone telephone_ = new Telephone();

        telephone_.setId( source.getId() );
        telephone_.setLibelle( source.getLibelle() );
        telephone_.setNumero( source.getNumero() );

        return telephone_;
    }

    @Override
    public DtoTelephone map(Telephone source) {
        if ( source == null ) {
            return null;
        }

        DtoTelephone dtoTelephone_ = new DtoTelephone();

        dtoTelephone_.setId( source.getId() );
        dtoTelephone_.setLibelle( source.getLibelle() );
        dtoTelephone_.setNumero( source.getNumero() );

        return dtoTelephone_;
    }

    protected List<Telephone> dtoTelephoneListToTelephoneList(List<DtoTelephone> list) {
        if ( list == null ) {
            return null;
        }

        List<Telephone> list_ = new ArrayList<Telephone>();
        for ( DtoTelephone dtoTelephone : list ) {
            list_.add( map( dtoTelephone ) );
        }

        return list_;
    }

    protected List<DtoTelephone> telephoneListToDtoTelephoneList(List<Telephone> list) {
        if ( list == null ) {
            return null;
        }

        List<DtoTelephone> list_ = new ArrayList<DtoTelephone>();
        for ( Telephone telephone : list ) {
            list_.add( map( telephone ) );
        }

        return list_;
    }
}
