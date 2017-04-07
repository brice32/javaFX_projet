package contacts.commun.dto;

import java.io.Serializable;

@SuppressWarnings("serial")
public class DtoRubrique implements Serializable{

	// Champs
	
	private int				id;
	
	private String			nom;
	
	
	
	// Getters & setters

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	
	// Constructeurs
	
	public DtoRubrique() {
	}

	public DtoRubrique(int id, String nom ) {
		super();
		this.id = id;
		this.nom = nom;
		
	}
}
