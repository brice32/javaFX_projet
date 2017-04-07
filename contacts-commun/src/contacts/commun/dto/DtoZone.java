package contacts.commun.dto;

import java.io.Serializable;


	@SuppressWarnings("serial")
	public class DtoZone implements Serializable {
		
		
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
		
		public DtoZone() {
		}

		public DtoZone(int id, String nom ) {
			super();
			this.id = id;
			this.nom = nom;
			
		}
}
