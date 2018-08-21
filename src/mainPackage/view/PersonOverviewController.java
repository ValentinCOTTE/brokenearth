package mainPackage.view;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import mainPackage.App;
import mainPackage.model.Person;

public class PersonOverviewController {
	@FXML
    private TableView<Person> personTable;
    @FXML
    private TableColumn<Person, String> nameColumn;
    
    @FXML
    private Label forceLabel;
    @FXML
    private Label enduranceLabel;
    @FXML
    private Label dexteriteLabel;
    @FXML
    private Label agiliteLabel;
    @FXML
    private Label perceptionLabel;
    @FXML
    private Label intelligenceLabel;
    @FXML
    private Label charismeLabel;
    @FXML
    private Label chanceLabel;
    
    
    //success pourcent
    @FXML
    private TextField scoreTF;
    
    //count the number of stat used to calculate the score
    private int nbStat;
    
    //stats values as main parameter
    private double forceMod;
    private double enduranceMod;
    private double dexteriteMod;
    private double agiliteMod;
    private double perceptionMod;
    private double intelligenceMod;
    private double charismeMod;
    private double chanceMod;
    
    @FXML
    private Button modForceButton;
    @FXML
    private Button modEnduranceButton;
    @FXML
    private Button modDexteriteButton;
    @FXML
    private Button modAgiliteButton;
    @FXML
    private Button modPerceptionButton;
    @FXML
    private Button modIntelligenceButton;
    @FXML
    private Button modCharismeButton;
    @FXML
    private Button modChanceButton;
    
    @FXML
    private Label modForceLabel;
    @FXML
    private Label modEnduranceLabel;
    @FXML
    private Label modDexteriteLabel;
    @FXML
    private Label modAgiliteLabel;
    @FXML
    private Label modPerceptionLabel;
    @FXML
    private Label modIntelligenceLabel;
    @FXML
    private Label modCharismeLabel;
    @FXML
    private Label modChanceLabel;
    
    //stats values as bonus
    private double forceBonus;
    private double enduranceBonus;
    private double dexteriteBonus;
    private double agiliteBonus;
    private double perceptionBonus;
    private double intelligenceBonus;
    private double charismeBonus;
    private double chanceBonus;
    
    @FXML
    private Button bonusForceButton;
    @FXML
    private Button bonusEnduranceButton;
    @FXML
    private Button bonusDexteriteButton;
    @FXML
    private Button bonusAgiliteButton;
    @FXML
    private Button bonusPerceptionButton;
    @FXML
    private Button bonusIntelligenceButton;
    @FXML
    private Button bonusCharismeButton;
    @FXML
    private Button bonusChanceButton;
    
    @FXML
    private Label bonusForceLabel;
    @FXML
    private Label bonusEnduranceLabel;
    @FXML
    private Label bonusDexteriteLabel;
    @FXML
    private Label bonusAgiliteLabel;
    @FXML
    private Label bonusPerceptionLabel;
    @FXML
    private Label bonusIntelligenceLabel;
    @FXML
    private Label bonusCharismeLabel;
    @FXML
    private Label bonusChanceLabel;
    
    //bonus add to the score
    private double bonus;
    @FXML
    private Label bonusLabel;
    
    
    //value of the roll
    @FXML
    private Label rollLabel;
    
 // Reference to the main application.
    private App app;
    
    /**
     * The constructor.
     * The constructor is called before the initialize() method.
     */
    public PersonOverviewController() {
    }
    
    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
        // Initialize the person table with the two columns.
        nameColumn.setCellValueFactory(cellData -> cellData.getValue().getNameProperty());
        
        // Clear person details.
        showPersonDetails(null);
        
        //initialize score

        // Listen for selection changes and show the person details when changed.
        personTable.getSelectionModel().selectedItemProperty().addListener((observable,oldValue,newValue) -> showPersonDetails(newValue));
    }
    
    /**
     * Is called by the main application to give a reference back to itself.
     * 
     * @param mainApp
     */
    public void setApp(App app) {
        this.app = app;

        // Add observable list data to the table
        personTable.setItems(app.getPersonData());
    }
    
    /**
     * Fills all text fields to show details about the person.
     * If the specified person is null, all text fields are cleared.
     *
     * @param person the person or null
     */
    private void showPersonDetails(Person person) {
    	resetScore();
    	
        if (person != null) {
            // Fill the labels with info from the person object.
            forceLabel.setText(Integer.toString(person.getForce()));
            enduranceLabel.setText(Integer.toString(person.getEndurance()));
            dexteriteLabel.setText(Integer.toString(person.getDexterite()));
            agiliteLabel.setText(Integer.toString(person.getAgilite()));
            perceptionLabel.setText(Integer.toString(person.getPerception()));
            intelligenceLabel.setText(Integer.toString(person.getIntelligence()));
            charismeLabel.setText(Integer.toString(person.getCharisme()));
            chanceLabel.setText(Integer.toString(person.getChance()));
            
        } else {
            // Person is null, remove all the text.
            forceLabel.setText("");
            enduranceLabel.setText("");
            dexteriteLabel.setText("");
            agiliteLabel.setText("");
            perceptionLabel.setText("");
            intelligenceLabel.setText("");
            charismeLabel.setText("");
            chanceLabel.setText("");
            
            //and disable all button
            modForceButton.setDisable(true);
            modEnduranceButton.setDisable(true);
            modDexteriteButton.setDisable(true);
            modAgiliteButton.setDisable(true);
            modPerceptionButton.setDisable(true);
            modIntelligenceButton.setDisable(true);
            modCharismeButton.setDisable(true);
            modChanceButton.setDisable(true);
            
            bonusForceButton.setDisable(true);
            bonusEnduranceButton.setDisable(true);
            bonusDexteriteButton.setDisable(true);
            bonusAgiliteButton.setDisable(true);
            bonusPerceptionButton.setDisable(true);
            bonusIntelligenceButton.setDisable(true);
            bonusCharismeButton.setDisable(true);
            bonusChanceButton.setDisable(true);
        }
    }
    
    
    
    /**
     * Called when the user clicks on the delete button.
     */
    @FXML
    private void handleDeletePerson() {
        int selectedIndex = personTable.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            personTable.getItems().remove(selectedIndex);
        } else {
            // Nothing selected.
            Alert alert = new Alert(AlertType.WARNING);
            alert.initOwner(app.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No Person Selected");
            alert.setContentText("Please select a person in the table.");

            alert.showAndWait();
        }
    }
    
    /**
     * Called when the user clicks the new button. Opens a dialog to edit
     * details for a new person.
     */
    @FXML
    private void handleNewPerson() {
        Person tempPerson = new Person();
        boolean okClicked = app.showPersonEditDialog(tempPerson);
        if (okClicked) {
            app.getPersonData().add(tempPerson);
        }
    }
    

    /**
     * Called when the user clicks the edit button. Opens a dialog to edit
     * details for the selected person.
     */
    @FXML
	private void handleEditPerson() {
		Person selectedPerson = personTable.getSelectionModel().getSelectedItem();
		if (selectedPerson != null) {
				boolean okClicked = app.showPersonEditDialog(selectedPerson);
			if (okClicked) {
				showPersonDetails(selectedPerson);
			}

		} else {
			// Nothing selected.
			Alert alert = new Alert(AlertType.WARNING);
			alert.initOwner(app.getPrimaryStage());
			alert.setTitle("No Selection");
			alert.setHeaderText("No Person Selected");
			alert.setContentText("Please select a person in the table.");

			alert.showAndWait();
		}
	}
    
    private void resetScore() {
    	//reset number of stats took in paramater
    	nbStat=0;
    	
    	//reset every stats modificater
    	forceMod=0;
        enduranceMod=0;
        dexteriteMod=0;
        agiliteMod=0;
        perceptionMod=0;
        intelligenceMod=0;
        charismeMod=0;
        chanceMod=0;
        
        modForceLabel.setText("");
        modEnduranceLabel.setText("");
        modDexteriteLabel.setText("");
        modAgiliteLabel.setText("");
        modPerceptionLabel.setText("");
        modIntelligenceLabel.setText("");
        modCharismeLabel.setText("");
        modChanceLabel.setText("");
    	
    	//reset every bonus
    	forceBonus=0;
        enduranceBonus=0;
        dexteriteBonus=0;
        agiliteBonus=0;
        perceptionBonus=0;
        intelligenceBonus=0;
        charismeBonus=0;
        chanceBonus=0;
        
        bonusForceLabel.setText("");
        bonusEnduranceLabel.setText("");
        bonusDexteriteLabel.setText("");
        bonusAgiliteLabel.setText("");
        bonusPerceptionLabel.setText("");
        bonusIntelligenceLabel.setText("");
        bonusCharismeLabel.setText("");
        bonusChanceLabel.setText("");
    	
    	bonus=0;
    	bonusLabel.setText("0%");
    	
    	//reset Button
        if (personTable.getSelectionModel().getSelectedItem()!=null) {
        	modForceButton.setDisable(false);
            modEnduranceButton.setDisable(false);
            modDexteriteButton.setDisable(false);
            modAgiliteButton.setDisable(false);
            modPerceptionButton.setDisable(false);
            modIntelligenceButton.setDisable(false);
            modCharismeButton.setDisable(false);
            modChanceButton.setDisable(false);
            
            bonusForceButton.setDisable(false);
            bonusEnduranceButton.setDisable(false);
            bonusDexteriteButton.setDisable(false);
            bonusAgiliteButton.setDisable(false);
            bonusPerceptionButton.setDisable(false);
            bonusIntelligenceButton.setDisable(false);
            bonusCharismeButton.setDisable(false);
            bonusChanceButton.setDisable(false);
            
        }
        
    	//resetScore and roll value
    	scoreTF.setText("0");
    	rollLabel.setText("X");
    	
    	
    	
    }
    
    /**
     * ROLL A DICE
     */
    @FXML
    private void handleRoll() {
    	int roll= (int) ((Math.random()*100)+1);
    	rollLabel.setText(Integer.toString(roll));
    }
    
    /**
     * RESET ROLL AND ALL SCORE STUFF
     */
    @FXML
    private void handleReset() {
    	resetScore();
    }
    
    /**
     * Write down the score in the label
     */
    private void showScore() {
    	
    	Person selectedPerson = personTable.getSelectionModel().getSelectedItem();
    	
    	double mod_score=0;
    	double bonus_score=0;
    	
    	if(selectedPerson!=null) {
    		//update nbStat
        	nbStat=0;
        	if(modForceButton.isDisable()) nbStat++;
        	if(modEnduranceButton.isDisable()) nbStat++;
        	if(modDexteriteButton.isDisable()) nbStat++;
        	if(modAgiliteButton.isDisable()) nbStat++;
        	if(modPerceptionButton.isDisable()) nbStat++;
        	if(modIntelligenceButton.isDisable()) nbStat++;
        	if(modCharismeButton.isDisable()) nbStat++;
        	if(modChanceButton.isDisable()) nbStat++;
        	
        	//update modifier
        	if(modForceButton.isDisable()) forceMod = (double) (selectedPerson.getForce()*10) / (double) nbStat;
            if(modEnduranceButton.isDisable()) enduranceMod = (double) (selectedPerson.getEndurance()*10) / (double) nbStat;
            if(modDexteriteButton.isDisable()) dexteriteMod = (double) (selectedPerson.getDexterite()*10) / (double) nbStat;
            if(modAgiliteButton.isDisable()) agiliteMod = (double) (selectedPerson.getAgilite()*10) / (double) nbStat;
            if(modPerceptionButton.isDisable()) perceptionMod = (double) (selectedPerson.getPerception()*10) / (double) nbStat;
            if(modIntelligenceButton.isDisable()) intelligenceMod = (double) (selectedPerson.getIntelligence()*10) / (double) nbStat;
            if(modCharismeButton.isDisable()) charismeMod = (double) (selectedPerson.getCharisme()*10) / (double) nbStat;
            if(modChanceButton.isDisable()) chanceMod = (double) (selectedPerson.getChance()*10) / (double) nbStat;
            	
        	
        	mod_score=forceMod
        			+ enduranceMod
        			+ dexteriteMod
        			+ agiliteMod
        			+ perceptionMod
        			+ intelligenceMod
        			+ charismeMod
        			+ chanceMod;
        	
        	//bonus updating
        	
        	//if bonus stat is equal or superior than mod_score, the 10% bonus is according
        	//this bonus is 20% if the bonus stat is 3 times superior (initiate bonus) or 30% if the bonus time is 6 times superior (expert bonus)
        	//there is a -1 mercy margin
        	
        	if(bonusForceButton.isDisable() && selectedPerson.getForce()*10 >= mod_score*6 - 1) forceBonus = 30;
    		else if(bonusForceButton.isDisable() && selectedPerson.getForce()*10 >= mod_score*3 - 1) forceBonus = 20;
    		else if(bonusForceButton.isDisable() && selectedPerson.getForce()*10 >= mod_score - 1) forceBonus = 10;
    		else forceBonus = 0;
    		
    		if(bonusEnduranceButton.isDisable() && selectedPerson.getEndurance()*10 >= mod_score*6- 1) enduranceBonus = 30;
    		else if(bonusEnduranceButton.isDisable() && selectedPerson.getEndurance()*10 >= mod_score*3- 1) enduranceBonus = 20;
    		else if(bonusEnduranceButton.isDisable() && selectedPerson.getEndurance()*10 >= mod_score- 1) enduranceBonus = 10;
    		else enduranceBonus = 0;
    		
    		if(bonusDexteriteButton.isDisable() && selectedPerson.getDexterite()*10 >= mod_score*6 - 1) dexteriteBonus = 30;
    		else if(bonusDexteriteButton.isDisable() && selectedPerson.getDexterite()*10 >= mod_score*3 - 1) dexteriteBonus = 20;
    		else if(bonusDexteriteButton.isDisable() && selectedPerson.getDexterite()*10 >= mod_score - 1) dexteriteBonus = 10;
    		else dexteriteBonus = 0;
    		
    		if(bonusAgiliteButton.isDisable() && selectedPerson.getAgilite()*10 >= mod_score*6 - 1) agiliteBonus = 30;
    		else if(bonusAgiliteButton.isDisable() && selectedPerson.getAgilite()*10 >= mod_score*3 - 1) agiliteBonus = 20;
    		else if(bonusAgiliteButton.isDisable() && selectedPerson.getAgilite()*10 >= mod_score - 1) agiliteBonus = 10;
    		else agiliteBonus = 0;
    		
    		if(bonusPerceptionButton.isDisable() && selectedPerson.getPerception()*10 >= mod_score*6 - 1) perceptionBonus = 30;
    		else if(bonusPerceptionButton.isDisable() && selectedPerson.getPerception()*10 >= mod_score*3 - 1) perceptionBonus = 20;
    		else if(bonusPerceptionButton.isDisable() && selectedPerson.getPerception()*10 >= mod_score - 1) perceptionBonus = 10;
    		else perceptionBonus = 0;
    		
    		if(bonusIntelligenceButton.isDisable() && selectedPerson.getIntelligence()*10 >= mod_score*6 - 1) intelligenceBonus = 30;
    		else if(bonusIntelligenceButton.isDisable() && selectedPerson.getIntelligence()*10 >= mod_score*3 - 1) intelligenceBonus = 20;
    		else if(bonusIntelligenceButton.isDisable() && selectedPerson.getIntelligence()*10 >= mod_score - 1) intelligenceBonus = 10;
    		else intelligenceBonus = 0;
    		
    		if(bonusCharismeButton.isDisable() && selectedPerson.getCharisme()*10 >= mod_score*6 - 1) charismeBonus = 30;
    		else if(bonusCharismeButton.isDisable() && selectedPerson.getCharisme()*10 >= mod_score*3 - 1) charismeBonus = 20;
    		else if(bonusCharismeButton.isDisable() && selectedPerson.getCharisme()*10 >= mod_score - 1) charismeBonus = 10;
    		else charismeBonus = 0;
    		
    		if(bonusChanceButton.isDisable() && selectedPerson.getChance()*10 >= mod_score*6 - 1) chanceBonus = 30;
    		else if(bonusChanceButton.isDisable() && selectedPerson.getChance()*10 >= mod_score*3 - 1) chanceBonus = 20;
    		else if(bonusChanceButton.isDisable() && selectedPerson.getChance()*10 >= mod_score - 1) chanceBonus = 10;
    		else chanceBonus = 0;
        	
        	
        	
        	
        	//update labels
        	if(modForceButton.isDisable()) modForceLabel.setText(Integer.toString((int) forceMod) + "%");
        		else modForceLabel.setText("");
        	if(modEnduranceButton.isDisable()) modEnduranceLabel.setText(Integer.toString((int) enduranceMod) + "%");
        		else modEnduranceLabel.setText("");
        	if(modDexteriteButton.isDisable()) modDexteriteLabel.setText(Integer.toString((int) dexteriteMod) + "%");
        		else modDexteriteLabel.setText("");
        	if(modAgiliteButton.isDisable()) modAgiliteLabel.setText(Integer.toString((int) agiliteMod) + "%");
        		else modAgiliteLabel.setText("");
        	if(modPerceptionButton.isDisable()) modPerceptionLabel.setText(Integer.toString((int) perceptionMod) + "%");
        		else modPerceptionLabel.setText("");
        	if(modIntelligenceButton.isDisable()) modIntelligenceLabel.setText(Integer.toString((int) intelligenceMod) + "%");
        		else modIntelligenceLabel.setText("");
        	if(modCharismeButton.isDisable()) modCharismeLabel.setText(Integer.toString((int) charismeMod) + "%");
        		else modCharismeLabel.setText("");
        	if(modChanceButton.isDisable()) modChanceLabel.setText(Integer.toString((int) chanceMod) + "%");
        		else modChanceLabel.setText("");
            
        	

        	if(bonusForceButton.isDisable()) bonusForceLabel.setText("+" + Integer.toString((int) forceBonus) + "%");
        		else bonusForceLabel.setText("");
        	if(bonusEnduranceButton.isDisable()) bonusEnduranceLabel.setText("+" + Integer.toString((int) enduranceBonus) + "%");
    			else bonusEnduranceLabel.setText("");
        	if(bonusDexteriteButton.isDisable()) bonusDexteriteLabel.setText("+" + Integer.toString((int) dexteriteBonus) + "%");
    			else bonusDexteriteLabel.setText("");
        	if(bonusAgiliteButton.isDisable()) bonusAgiliteLabel.setText("+" + Integer.toString((int) agiliteBonus) + "%");
    			else bonusAgiliteLabel.setText("");
        	if(bonusPerceptionButton.isDisable()) bonusPerceptionLabel.setText("+" + Integer.toString((int) perceptionBonus) + "%");
    			else bonusPerceptionLabel.setText("");
        	if(bonusIntelligenceButton.isDisable()) bonusIntelligenceLabel.setText("+" + Integer.toString((int) intelligenceBonus) + "%");
    			else bonusIntelligenceLabel.setText("");
        	if(bonusCharismeButton.isDisable()) bonusCharismeLabel.setText("+" + Integer.toString((int) charismeBonus) + "%");
    			else bonusCharismeLabel.setText("");
        	if(bonusChanceButton.isDisable()) bonusChanceLabel.setText("+" + Integer.toString((int) chanceBonus) + "%");
    			else bonusChanceLabel.setText("");
        	
        	bonus_score= forceBonus
        			+ enduranceBonus
        			+ dexteriteBonus
        			+ agiliteBonus
        			+ perceptionBonus
        			+ intelligenceBonus
        			+ charismeBonus
        			+ chanceBonus;
    	}    	
    	
    	
    	bonusLabel.setText(Integer.toString((int) bonus) + "%");
    	
    	
    	double score = mod_score + bonus_score + bonus;
    	
    	scoreTF.setText(Integer.toString((int) score));
    }
    
    
    //STATS BUTTONS
    @FXML
    private void handleForce() {
		Person selectedPerson = personTable.getSelectionModel().getSelectedItem();

		if (selectedPerson != null) {
			forceMod=1;
			modForceButton.setDisable(true);
			
			showScore();
			
		} else {
			// Nothing selected.
			Alert alert = new Alert(AlertType.WARNING);
			alert.initOwner(app.getPrimaryStage());
			alert.setTitle("No Selection");
			alert.setHeaderText("No Person Selected");
			alert.setContentText("Please select a person in the table.");
			alert.showAndWait();
		}
    }
    
    @FXML
    private void handleEndurance() {
		Person selectedPerson = personTable.getSelectionModel().getSelectedItem();

		if (selectedPerson != null) {
			enduranceMod=1;
			modEnduranceButton.setDisable(true);
			
			showScore();
			
		} else {
			// Nothing selected.
			Alert alert = new Alert(AlertType.WARNING);
			alert.initOwner(app.getPrimaryStage());
			alert.setTitle("No Selection");
			alert.setHeaderText("No Person Selected");
			alert.setContentText("Please select a person in the table.");
			alert.showAndWait();
		}
    }
    
    @FXML
    private void handleDexterite() {
		Person selectedPerson = personTable.getSelectionModel().getSelectedItem();

		if (selectedPerson != null) {
			dexteriteMod=1;
			modDexteriteButton.setDisable(true);
			
			showScore();
			
		} else {
			// Nothing selected.
			Alert alert = new Alert(AlertType.WARNING);
			alert.initOwner(app.getPrimaryStage());
			alert.setTitle("No Selection");
			alert.setHeaderText("No Person Selected");
			alert.setContentText("Please select a person in the table.");
			alert.showAndWait();
		}
    }
    
    @FXML
    private void handleAgilite() {
		Person selectedPerson = personTable.getSelectionModel().getSelectedItem();

		if (selectedPerson != null) {
			agiliteMod=1;
			modAgiliteButton.setDisable(true);
			
			showScore();
			
		} else {
			// Nothing selected.
			Alert alert = new Alert(AlertType.WARNING);
			alert.initOwner(app.getPrimaryStage());
			alert.setTitle("No Selection");
			alert.setHeaderText("No Person Selected");
			alert.setContentText("Please select a person in the table.");
			alert.showAndWait();
		}
    }
    
    @FXML
    private void handlePerception() {
		Person selectedPerson = personTable.getSelectionModel().getSelectedItem();

		if (selectedPerson != null) {
			perceptionMod=1;
			modPerceptionButton.setDisable(true);
			
			showScore();
			
		} else {
			// Nothing selected.
			Alert alert = new Alert(AlertType.WARNING);
			alert.initOwner(app.getPrimaryStage());
			alert.setTitle("No Selection");
			alert.setHeaderText("No Person Selected");
			alert.setContentText("Please select a person in the table.");
			alert.showAndWait();
		}
    }
    
    @FXML
    private void handleIntelligence() {
		Person selectedPerson = personTable.getSelectionModel().getSelectedItem();

		if (selectedPerson != null) {
			intelligenceMod=1;
			modIntelligenceButton.setDisable(true);
			
			showScore();
			
		} else {
			// Nothing selected.
			Alert alert = new Alert(AlertType.WARNING);
			alert.initOwner(app.getPrimaryStage());
			alert.setTitle("No Selection");
			alert.setHeaderText("No Person Selected");
			alert.setContentText("Please select a person in the table.");
			alert.showAndWait();
		}
    }
    
    @FXML
    private void handleCharisme() {
		Person selectedPerson = personTable.getSelectionModel().getSelectedItem();

		if (selectedPerson != null) {
			charismeMod=1;
			modCharismeButton.setDisable(true);
			
			showScore();
			
		} else {
			// Nothing selected.
			Alert alert = new Alert(AlertType.WARNING);
			alert.initOwner(app.getPrimaryStage());
			alert.setTitle("No Selection");
			alert.setHeaderText("No Person Selected");
			alert.setContentText("Please select a person in the table.");
			alert.showAndWait();
		}
    }
    
    @FXML
    private void handleChance() {
		Person selectedPerson = personTable.getSelectionModel().getSelectedItem();

		if (selectedPerson != null) {
			chanceMod=1;
			modChanceButton.setDisable(true);
			
			showScore();
			
		} else {
			// Nothing selected.
			Alert alert = new Alert(AlertType.WARNING);
			alert.initOwner(app.getPrimaryStage());
			alert.setTitle("No Selection");
			alert.setHeaderText("No Person Selected");
			alert.setContentText("Please select a person in the table.");
			alert.showAndWait();
		}
    }
    
    
    
    
    //BONUS STATS BUTTONS
    @FXML
    private void handleForceBonus() {
		Person selectedPerson = personTable.getSelectionModel().getSelectedItem();

		if (selectedPerson != null) {
			forceBonus=1;
			bonusForceButton.setDisable(true);
			
			showScore();
			
		} else {
			// Nothing selected.
			Alert alert = new Alert(AlertType.WARNING);
			alert.initOwner(app.getPrimaryStage());
			alert.setTitle("No Selection");
			alert.setHeaderText("No Person Selected");
			alert.setContentText("Please select a person in the table.");
			alert.showAndWait();
		}
    }
    
    @FXML
    private void handleEnduranceBonus() {
		Person selectedPerson = personTable.getSelectionModel().getSelectedItem();

		if (selectedPerson != null) {
			enduranceBonus=1;
			bonusEnduranceButton.setDisable(true);
			
			showScore();
			
		} else {
			// Nothing selected.
			Alert alert = new Alert(AlertType.WARNING);
			alert.initOwner(app.getPrimaryStage());
			alert.setTitle("No Selection");
			alert.setHeaderText("No Person Selected");
			alert.setContentText("Please select a person in the table.");
			alert.showAndWait();
		}
    }
    
    @FXML
    private void handleDexteriteBonus() {
		Person selectedPerson = personTable.getSelectionModel().getSelectedItem();

		if (selectedPerson != null) {
			dexteriteBonus=1;
			bonusDexteriteButton.setDisable(true);
			
			showScore();
			
		} else {
			// Nothing selected.
			Alert alert = new Alert(AlertType.WARNING);
			alert.initOwner(app.getPrimaryStage());
			alert.setTitle("No Selection");
			alert.setHeaderText("No Person Selected");
			alert.setContentText("Please select a person in the table.");
			alert.showAndWait();
		}
    }
    
    @FXML
    private void handleAgiliteBonus() {
		Person selectedPerson = personTable.getSelectionModel().getSelectedItem();

		if (selectedPerson != null) {
			agiliteBonus=1;
			bonusAgiliteButton.setDisable(true);
			
			showScore();
			
		} else {
			// Nothing selected.
			Alert alert = new Alert(AlertType.WARNING);
			alert.initOwner(app.getPrimaryStage());
			alert.setTitle("No Selection");
			alert.setHeaderText("No Person Selected");
			alert.setContentText("Please select a person in the table.");
			alert.showAndWait();
		}
    }
    
    @FXML
    private void handlePerceptionBonus() {
		Person selectedPerson = personTable.getSelectionModel().getSelectedItem();

		if (selectedPerson != null) {
			perceptionBonus=1;
			bonusPerceptionButton.setDisable(true);
			
			showScore();
			
		} else {
			// Nothing selected.
			Alert alert = new Alert(AlertType.WARNING);
			alert.initOwner(app.getPrimaryStage());
			alert.setTitle("No Selection");
			alert.setHeaderText("No Person Selected");
			alert.setContentText("Please select a person in the table.");
			alert.showAndWait();
		}
    }
    
    @FXML
    private void handleIntelligenceBonus() {
		Person selectedPerson = personTable.getSelectionModel().getSelectedItem();

		if (selectedPerson != null) {
			intelligenceBonus=1;
			bonusIntelligenceButton.setDisable(true);
			
			showScore();
			
		} else {
			// Nothing selected.
			Alert alert = new Alert(AlertType.WARNING);
			alert.initOwner(app.getPrimaryStage());
			alert.setTitle("No Selection");
			alert.setHeaderText("No Person Selected");
			alert.setContentText("Please select a person in the table.");
			alert.showAndWait();
		}
    }
    
    @FXML
    private void handleCharismeBonus() {
		Person selectedPerson = personTable.getSelectionModel().getSelectedItem();

		if (selectedPerson != null) {
			charismeBonus=1;
			bonusCharismeButton.setDisable(true);
			
			showScore();
			
		} else {
			// Nothing selected.
			Alert alert = new Alert(AlertType.WARNING);
			alert.initOwner(app.getPrimaryStage());
			alert.setTitle("No Selection");
			alert.setHeaderText("No Person Selected");
			alert.setContentText("Please select a person in the table.");
			alert.showAndWait();
		}
    }
    
    @FXML
    private void handleChanceBonus() {
		Person selectedPerson = personTable.getSelectionModel().getSelectedItem();

		if (selectedPerson != null) {
			chanceBonus=1;
			bonusChanceButton.setDisable(true);
			
			showScore();
			
		} else {
			// Nothing selected.
			Alert alert = new Alert(AlertType.WARNING);
			alert.initOwner(app.getPrimaryStage());
			alert.setTitle("No Selection");
			alert.setHeaderText("No Person Selected");
			alert.setContentText("Please select a person in the table.");
			alert.showAndWait();
		}
    }
    
    //BONUS AJUSTEMENT BUTTON
    @FXML
    private void handlePlus1() {
    	bonus+=1;
    	showScore();
    }
    @FXML
    private void handlePlus5() {
    	bonus+=5;
    	showScore();
    }
    @FXML
    private void handlePlus10() {
    	bonus+=10;
    	showScore();
    }
    @FXML
    private void handleMinus1() {
    	bonus-=1;
    	showScore();
    }
    @FXML
    private void handleMinus5() {
    	bonus-=5;
    	showScore();
    }
    @FXML
    private void handleMinus10() {
    	bonus-=10;
    	showScore();
    }
    
}
