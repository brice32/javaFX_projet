package contacts.commun.dto;

import java.io.Serializable;

@SuppressWarnings("serial")
public class DtoCategorie implements Serializable {

	//Champs
	private int				idCategorie;

	private String			libelle;


	//get & set
	public int getIdCategorie() {
		return idCategorie;
	}

	public void setIdCategorie(int idCategorie) {
		this.idCategorie = idCategorie;
	}

	public DtoCategorie(){

	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public DtoCategorie(int id,String libelle){
		super();
		this.setIdCategorie(id);
		this.setLibelle(libelle);
	}

}
