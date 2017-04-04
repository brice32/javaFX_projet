package contacts.commun.dto;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
public class DtoMouvement implements Serializable {

	//Champs
	private int				idMouvement;

//	private int				idAnnonceur;

	private float			montant;

	private Date 			date;

	private Time            heure;

	private float           solde;

	private String			libelle;

	private String          description;

	private List<DtoAnnonceur>     annonceurs = new ArrayList<>();

	//get & set



	public DtoMouvement(){

	}

	public DtoMouvement(int idMouvement,  float montant, Date date, Time heure, float solde, String lebelle, String description ){
		super();
		this.setIdMouvement(idMouvement);
		this.setMontant(montant);
		this.setDate(date);
		this.setHeure(heure);
		this.setSolde(solde);
		this.setLibelle(lebelle);
		this.setDescription(description);
	}

	public int getIdMouvement() {
		return idMouvement;
	}

	public void setIdMouvement(int idMouvement) {
		this.idMouvement = idMouvement;
	}

//	public int getIdAnnonceur() {
//		return idAnnonceur;
//	}
//
//	public void setIdAnnonceur(int idAnnonceur) {
//		this.idAnnonceur = idAnnonceur;
//	}



	public float getMontant() {
		return montant;
	}

	public void setMontant(float montant) {
		this.montant = montant;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Time getHeure() {
		return heure;
	}

	public void setHeure(Time heure) {
		this.heure = heure;
	}

	public float getSolde() {
		return solde;
	}

	public void setSolde(float solde) {
		this.solde = solde;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<DtoAnnonceur> getAnnonceurs() {
		return annonceurs;
	}

	public void setAnnonceurs(List<DtoAnnonceur> annonceurs) {
		this.annonceurs = annonceurs;
	}
}
