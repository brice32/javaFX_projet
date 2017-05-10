package contacts.javafx.view.annonce;

import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTimePicker;

import contacts.commun.util.ExceptionAppli;
import contacts.javafx.view.IController;
import contacts.javafx.view.IManagerGui;
import javafx.fxml.FXML;
import contacts.javafx.view.DateTimePicker;

public class ControllerAnnonceForm implements IController {

	private IManagerGui managerGui;

	@FXML
	private JFXDatePicker heureDebutPicker;

	@FXML
	private JFXTimePicker heureFinPicker;



	@Override
	public void setManagerGui(IManagerGui managerGui) throws ExceptionAppli {
		// TODO Auto-generated method stub
		this.managerGui=managerGui;

	}

}
