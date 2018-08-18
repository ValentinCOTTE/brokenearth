package mainPackage.view;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import mainPackage.model.Person;

/**
 * Dialog to edit details of a person.
 *
 */
public class PersonEditDialogController {
	
	@FXML
	private TextField nameTF;
	@FXML
	private TextField forceTF;
	@FXML
	private TextField enduranceTF;
	@FXML
	private TextField dexteriteTF;
	@FXML
	private TextField agiliteTF;
	@FXML
	private TextField perceptionTF;
	@FXML
	private TextField intelligenceTF;
	@FXML
	private TextField charismeTF;
	@FXML
	private TextField chanceTF;
	
	private Stage dialogStage;
	
    private Person person;
    
    private boolean okClicked = false;


    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
    }
	
    /**
     * Sets the stage of this dialog.
     *
     * @param dialogStage
     */
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }
    

    /**
     * Sets the person to be edited in the dialog.
     *
     * @param person
     */
    public void setPerson(Person person) {
        this.person = person;

        nameTF.setText(person.getName());
        forceTF.setText(Integer.toString(person.getForce()));
        enduranceTF.setText(Integer.toString(person.getEndurance()));
        dexteriteTF.setText(Integer.toString(person.getDexterite()));
        agiliteTF.setText(Integer.toString(person.getAgilite()));
        perceptionTF.setText(Integer.toString(person.getPerception()));
        intelligenceTF.setText(Integer.toString(person.getIntelligence()));
        charismeTF.setText(Integer.toString(person.getCharisme()));
        chanceTF.setText(Integer.toString(person.getChance()));

    }
    
    /**
     * Returns true if the user clicked OK, false otherwise.
     *
     * @return
     */
    public boolean isOkClicked() {
        return okClicked;
    }
    
    /**
     * Called when the user clicks ok.
     */
    @FXML
    private void handleOk() {
        if (isInputValid()) {
            person.setName(nameTF.getText());
            person.setForce(Integer.parseInt(forceTF.getText()));
            person.setEndurance(Integer.parseInt(enduranceTF.getText()));
            person.setDexterite(Integer.parseInt(dexteriteTF.getText()));
            person.setAgilite(Integer.parseInt(agiliteTF.getText()));
            person.setPerception(Integer.parseInt(perceptionTF.getText()));
            person.setIntelligence(Integer.parseInt(intelligenceTF.getText()));
            person.setCharisme(Integer.parseInt(charismeTF.getText()));
            person.setChance(Integer.parseInt(chanceTF.getText()));

            okClicked = true;
            dialogStage.close();
        }
    }
	
    
    /**
     * Called when the user clicks cancel.
     */
    @FXML
    private void handleCancel() {
        dialogStage.close();
    }
    
    /**
     * Validates the user input in the text fields.
     *
     * @return true if the input is valid
     */
    private boolean isInputValid() {
        String errorMessage = "";

        if (nameTF.getText() == null || nameTF.getText().length() == 0) {
            errorMessage += "No valid name!\n";
        }
        if (forceTF.getText() == null || forceTF.getText().length() == 0) {
            errorMessage += "No valid Force!\n";
        } else {
            // try to parse into an int.
            try {
                Integer.parseInt(forceTF.getText());
            } catch (NumberFormatException e) {
                errorMessage += "No valid Force (must be an integer)!\n";
            }
        }
        if (enduranceTF.getText() == null || enduranceTF.getText().length() == 0) {
            errorMessage += "No valid Endurance!\n";
        } else {
            // try to parse into an int.
            try {
                Integer.parseInt(enduranceTF.getText());
            } catch (NumberFormatException e) {
                errorMessage += "No valid Endurance (must be an integer)!\n";
            }
        }
        if (dexteriteTF.getText() == null || dexteriteTF.getText().length() == 0) {
            errorMessage += "No valid Dextérité!\n";
        } else {
            // try to parse into an int.
            try {
                Integer.parseInt(dexteriteTF.getText());
            } catch (NumberFormatException e) {
                errorMessage += "No valid Dextérité (must be an integer)!\n";
            }
        }
        if (agiliteTF.getText() == null || agiliteTF.getText().length() == 0) {
            errorMessage += "No valid Agilité!\n";
        } else {
            // try to parse into an int.
            try {
                Integer.parseInt(agiliteTF.getText());
            } catch (NumberFormatException e) {
                errorMessage += "No valid Agilité (must be an integer)!\n";
            }
        }
        if (perceptionTF.getText() == null || perceptionTF.getText().length() == 0) {
            errorMessage += "No valid Perception!\n";
        } else {
            // try to parse into an int.
            try {
                Integer.parseInt(perceptionTF.getText());
            } catch (NumberFormatException e) {
                errorMessage += "No valid Perception (must be an integer)!\n";
            }
        }
        if (intelligenceTF.getText() == null || intelligenceTF.getText().length() == 0) {
            errorMessage += "No valid Intelligence!\n";
        } else {
            // try to parse into an int.
            try {
                Integer.parseInt(intelligenceTF.getText());
            } catch (NumberFormatException e) {
                errorMessage += "No valid Intelligence (must be an integer)!\n";
            }
        }
        if (charismeTF.getText() == null || charismeTF.getText().length() == 0) {
            errorMessage += "No valid Charisme!\n";
        } else {
            // try to parse into an int.
            try {
                Integer.parseInt(charismeTF.getText());
            } catch (NumberFormatException e) {
                errorMessage += "No valid Charisme (must be an integer)!\n";
            }
        }
        if (chanceTF.getText() == null || chanceTF.getText().length() == 0) {
            errorMessage += "No valid Chance!\n";
        } else {
            // try to parse into an int.
            try {
                Integer.parseInt(chanceTF.getText());
            } catch (NumberFormatException e) {
                errorMessage += "No valid Chance (must be an integer)!\n";
            }
        }


        
        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Show the error message.
            Alert alert = new Alert(AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText(errorMessage);

            alert.showAndWait();

            return false;
        }
    }
    
}
