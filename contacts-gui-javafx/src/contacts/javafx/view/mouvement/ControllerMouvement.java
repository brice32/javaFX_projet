package contacts.javafx.view.mouvement;

import contacts.commun.util.ExceptionAppli;
import contacts.javafx.fxb.FXAnnonceur;
import contacts.javafx.fxb.FXCompte;
import contacts.javafx.fxb.FXMouvement;
import contacts.javafx.model.IModelAnnonceur;
import contacts.javafx.model.IModelMouvement;
import contacts.javafx.model.IModelPersonne;
import contacts.javafx.view.IController;
import contacts.javafx.view.IManagerGui;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.util.Callback;

public class ControllerMouvement implements IController {

	@FXML
	private TextField 		textFieldMontant;

	@FXML
	private TextField       textFieldLibelle;

	@FXML
	private TextArea		textAreaDescription;

	@FXML
	private ComboBox<FXAnnonceur> 	comboBoxFXAnnonceur;

	private IManagerGui managerGui;

	private IModelMouvement modelMouvement;

	private IModelAnnonceur modelAnnonceur;

	private FXMouvement mouvementVue;

	@Override
	public void setManagerGui(IManagerGui managerGui) throws ExceptionAppli {
		// TODO Auto-generated method stub
		this.managerGui=managerGui;

		modelAnnonceur = managerGui.getModel(IModelAnnonceur.class);
		modelMouvement = managerGui.getModel(IModelMouvement.class);
		modelMouvement.preparerAjouter();

		//pour afficher
		comboBoxFXAnnonceur.setItems(modelAnnonceur.getAnnonceurs());

		comboBoxFXAnnonceur.setCellFactory( (list) -> {
//		    return new ListCell<FXAnnonceur>() {
//	        @Override
//	        protected void updateItem(FXAnnonceur item, boolean empty) {
//	            super.updateItem(item, empty);
//	            if (item == null) {
//	                setText(null);
//	            } else {
//	                setText(item.nomProperty().get() );
//	            }
//	        }
//	    };
			return callAnnonceur();
	}
		);
		comboBoxFXAnnonceur.setButtonCell(
//				new ListCell<FXAnnonceur>(){
//					 protected void updateItem(FXAnnonceur item, boolean empty) {
//				            super.updateItem(item, empty);
//				            if (item == null) {
//				                setText(null);
//				            } else {
//				                setText(item.nomProperty().get() );
//				            }
//				        }
//				}
				callAnnonceur());



	}


	//méthode auxiliaire
	public ListCell<FXAnnonceur> callAnnonceur(){
	return new ListCell<FXAnnonceur>() {
        @Override
        protected void updateItem(FXAnnonceur item, boolean empty) {
            super.updateItem(item, empty);
            if (item == null) {
                setText(null);
            } else {
                setText(item.nomProperty().get() );
            }
        }
    };
	}
}
