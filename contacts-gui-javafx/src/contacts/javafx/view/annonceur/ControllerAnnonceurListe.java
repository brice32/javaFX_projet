package contacts.javafx.view.annonceur;

import contacts.commun.util.ExceptionAppli;
import contacts.javafx.fxb.FXAnnonceur;
import contacts.javafx.fxb.FXPersonne;
import contacts.javafx.model.IModelAnnonceur;
import contacts.javafx.model.IModelPersonne;
import contacts.javafx.view.IController;
import contacts.javafx.view.IManagerGui;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class ControllerAnnonceurListe implements IController {

	@FXML
	private TableView<FXAnnonceur> tableViewAnnonceur;

	@FXML
    private TableColumn<FXAnnonceur, String> nomColumn;

	@FXML
	private TableColumn<FXAnnonceur, String> emailColumn;


	@FXML
	private Label 	LabelIdAnnonceur;

	@FXML
	private Label 	LabelNom;

	@FXML
	private Label 	LabelTelephone;

	@FXML
	private Label 	LabelEmail;

	@FXML
	private Label 	LabelLieuNom;

	@FXML
	private Label   LabelLieuAdresse;

	@FXML
	private Label 	LabelLieuCp;

	@FXML
	private Label 	LabelLieuVille;

	@FXML
	private Label 	LabelSiteWeb;

	@FXML
	private Button buttonModifier;

	@FXML
	private Button buttonSupprimer;

	private IManagerGui managerGui;

	private IModelAnnonceur modelAnnonceur;

	@FXML
	private void doActualiser() {
		try {
			modelAnnonceur.actualiserListe();
			tableViewAnnonceur.getSelectionModel().clearSelection();
		} catch (Exception e) {
			managerGui.afficherErreur(e);
		};
	}

	@Override
	public void setManagerGui(IManagerGui managerGui) throws ExceptionAppli {
		// TODO Auto-generated method stub

		LabelIdAnnonceur.setText("");
		LabelNom.setText("");
		LabelTelephone.setText("");
		LabelEmail.setText("");
		LabelLieuNom.setText("");
		LabelLieuAdresse.setText("");
		LabelLieuCp.setText("");
		LabelLieuVille.setText("");
		LabelSiteWeb.setText("");

		this.managerGui = managerGui;
		modelAnnonceur = managerGui.getModel(IModelAnnonceur.class);

		tableViewAnnonceur.setItems(modelAnnonceur.getAnnonceurs());
		nomColumn.setCellValueFactory(a -> a.getValue().nomProperty());
		emailColumn.setCellValueFactory(a -> a.getValue().emailProperty());

		tableViewAnnonceur.getSelectionModel().getSelectedItems().addListener((ListChangeListener<FXAnnonceur>) (c) -> {
			if (tableViewAnnonceur.getSelectionModel().getSelectedItem() != null) {
//				int idAnnonceur = tableViewAnnonceur.getSelectionModel().getSelectedItem().getId();
				ObservableList<FXAnnonceur> selectedItems = tableViewAnnonceur.getSelectionModel().getSelectedItems();
				FXAnnonceur annonceur = (FXAnnonceur) selectedItems.get(0);
				LabelIdAnnonceur.setText( "" + annonceur.getId());
				LabelNom.setText(annonceur.getNom());
				LabelTelephone.setText(annonceur.getTelephone());
				LabelEmail.setText(annonceur.getEmail());
				LabelLieuNom.setText(annonceur.getLieuNom());
				LabelLieuAdresse.setText(annonceur.getLieuAdresse());
				LabelLieuCp.setText(annonceur.getLieuCp());
				LabelLieuVille.setText(annonceur.getLieuVille());
				LabelSiteWeb.setText(annonceur.getSiteWeb());
				buttonModifier.setDisable(false);
				buttonSupprimer.setDisable(false);
			}
			else{
				LabelIdAnnonceur.setText("");
				LabelNom.setText("");
				LabelTelephone.setText("");
				LabelEmail.setText("");
				LabelLieuNom.setText("");
				LabelLieuAdresse.setText("");
				LabelLieuCp.setText("");
				LabelLieuVille.setText("");
				LabelSiteWeb.setText("");
				buttonModifier.setDisable(true);
				buttonSupprimer.setDisable(true);
			}
		});
		}
}
