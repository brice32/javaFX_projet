package contacts.javafx.view.systeme;

import contacts.commun.util.ExceptionAppli;
import contacts.commun.util.Roles;
import contacts.javafx.fxb.FXCompte;
import contacts.javafx.model.IModelConnexion;
import contacts.javafx.model.IModelInfo;
import contacts.javafx.view.EnumView;
import contacts.javafx.view.IController;
import contacts.javafx.view.IManagerGui;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;

public class ControllerMenuConfiguration implements IController {

	private IModelConnexion modelConnexion;

	private IManagerGui managerGui;
	// Composants de la vue
	@FXML
	private Label labelTitre;
	@FXML
	private Label labelMessage;
	@FXML
	private Label labelNom;
	@FXML
	private Label labelPrenom;
	@FXML
	private Label labelAdministrateur;
	@FXML
	private Label labelModerateur;
	@FXML
	private Label labelSecretaire;

	@Override
	public void setManagerGui(IManagerGui managerGui) throws ExceptionAppli {
		// TODO Auto-generated method stub

		// Injection de dépendances
		this.managerGui = managerGui;
		// Data binding
		labelTitre.textProperty().bind( new SimpleStringProperty("Menu De Configuration") );
		labelMessage.textProperty().bind( new SimpleStringProperty("Choisissez Une Selection"));
		modelConnexion = managerGui.getModel(IModelConnexion.class);
		FXCompte compteConnecte = modelConnexion.getCompteConnecte();
		labelNom.textProperty().bind(new SimpleStringProperty(compteConnecte.getNom()));
		labelPrenom.textProperty().bind(new SimpleStringProperty(compteConnecte.getPrenom()));

		if(compteConnecte.isInRole(Roles.ADMINISTRATEUR)){
			labelAdministrateur.setTextFill(Color.BLACK);
		}
		if(compteConnecte.isInRole("Mod�rateur")){
			labelModerateur.setTextFill(Color.BLACK);
		}
		if(compteConnecte.isInRole("Secr�taire")){
			labelSecretaire.setTextFill(Color.BLACK);
		}
	}

	@FXML
	public void doCategorieListe(){
		managerGui.showView(EnumView.CategorieListe);
	}

}
