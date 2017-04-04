package contacts.javafx.view.mouvement;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

import contacts.commun.util.ExceptionAppli;
import contacts.javafx.fxb.FXAnnonceur;
import contacts.javafx.fxb.FXCompte;
import contacts.javafx.fxb.FXMouvement;
import contacts.javafx.model.IModelAnnonceur;
import contacts.javafx.model.IModelMouvement;
import contacts.javafx.model.IModelPersonne;
import contacts.javafx.view.EnumView;
import contacts.javafx.view.IController;
import contacts.javafx.view.IManagerGui;
import javafx.beans.binding.Bindings;
import javafx.collections.ListChangeListener;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.util.Callback;
import javafx.util.converter.NumberStringConverter;
import sun.security.pkcs11.Secmod.ModuleType;

public class ControllerMouvement implements IController {

	@FXML
	private TextField 		textFieldMontant;

	@FXML
	private TextField       textFieldLibelle;

	@FXML
	private TextArea		textAreaDescription;

	@FXML
	private Button          buttonAjouter;

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

		System.out.println("ok");
		modelAnnonceur = managerGui.getModel(IModelAnnonceur.class);
		modelMouvement = managerGui.getModel(IModelMouvement.class);
		modelMouvement.preparerAjouter();
		mouvementVue = modelMouvement.getMouvementVue();
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

		DecimalFormat nf = new DecimalFormat("0.00");
		textFieldMontant.textProperty().bindBidirectional(mouvementVue.montantProperty(), new NumberStringConverter(nf));
		textFieldLibelle.textProperty().bindBidirectional(mouvementVue.libelleProperty());
		textAreaDescription.textProperty().bindBidirectional(mouvementVue.descriptionProperty());

		comboBoxFXAnnonceur.getSelectionModel().selectedIndexProperty().addListener(
				 c -> {
					buttonAjouter.setDisable(false);
		});
	}


	//m�thode auxiliaire
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

	@FXML
	public void doAjouter(){
		boolean reponse = managerGui.demanderConfirmation( "Confirmez-vous charger "+ textFieldMontant.getText()
						  +" � "+comboBoxFXAnnonceur.getSelectionModel().getSelectedItem().getNom()+" ?");
		if ( reponse ) {
		try {
			modelMouvement.mettreVueAnnonceur(comboBoxFXAnnonceur.getSelectionModel().getSelectedItem());
			modelMouvement.ValiderMiseAJour();
			managerGui.reinit();
			managerGui.showView( EnumView.Info );
		} catch (ExceptionAppli e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}
}
