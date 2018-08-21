package mainPackage;

import java.io.IOException;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import mainPackage.model.Person;
import mainPackage.view.PersonEditDialogController;
import mainPackage.view.PersonOverviewController;

public class App extends Application {

	private Stage primaryStage;
    private BorderPane rootLayout;
    
    /**
     * The data as an observable list of Persons.
     */
    private ObservableList<Person> personData = FXCollections.observableArrayList();

    /**
     * Constructor
     */
    public App() {
        // Add some sample data
        personData.add(new Person("Youpii"));
        personData.get(0).setForce(5);
        personData.get(0).setEndurance(3);
        personData.get(0).setDexterite(5);
        personData.get(0).setAgilite(15);
        personData.get(0).setPerception(5);
        personData.get(0).setIntelligence(5);
        personData.get(0).setCharisme(3);
        personData.get(0).setChance(4);
        
        
        
        personData.add(new Person("Groot"));
        personData.get(1).setForce(15);
        personData.get(1).setEndurance(5);
        personData.get(1).setDexterite(5);
        personData.get(1).setAgilite(4);
        personData.get(1).setPerception(3);
        personData.get(1).setIntelligence(5);
        personData.get(1).setCharisme(3);
        personData.get(1).setChance(5);
        
        personData.add(new Person("Edgar"));
        personData.get(2).setForce(4);
        personData.get(2).setEndurance(4);
        personData.get(2).setDexterite(5);
        personData.get(2).setAgilite(5);
        personData.get(2).setPerception(7);
        personData.get(2).setIntelligence(10);
        personData.get(2).setCharisme(5);
        personData.get(2).setChance(5);
        
        personData.add(new Person("Heinz"));
        personData.add(new Person("Cornelia"));
        personData.add(new Person("Werner"));
        personData.add(new Person("Lydia"));
        personData.add(new Person("Anna"));
        personData.add(new Person("Stefan"));
        personData.add(new Person("Martin"));

    }
    
    /**
     * Returns the data as an observable list of Persons. 
     * @return
     */
    public ObservableList<Person> getPersonData() {
        return personData;
    }
    
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
        this.primaryStage.setTitle("BrokenEarth");
        
        //Set the icon of the application
        this.primaryStage.getIcons().add(new Image("file:res/images/Sans.jpg"));

        
        initRootLayout();
        
        showPersonOverview();
        
	}
	
	/**
     * Initializes the root layout.
     */
    public void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Shows the person overview inside the root layout.
     */
    public void showPersonOverview() {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("view/PersonOverview.fxml"));
            AnchorPane personOverview = (AnchorPane) loader.load();

            // Set person overview into the center of root layout.
            rootLayout.setCenter(personOverview);
            
            // Give the controller access to the main app.
            PersonOverviewController controller = loader.getController();
            controller.setApp(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Opens a dialog to edit details for the specified person. If the user
     * clicks OK, the changes are saved into the provided person object and true
     * is returned.
     *
     * @param person the person object to be edited
     * @return true if the user clicked OK, false otherwise.
     */
    public boolean showPersonEditDialog(Person person) {
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("view/PersonEditDialog.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Edit Person");
            //set icon
            dialogStage.getIcons().add(new Image("file:res/images/Sans.jpg"));
         
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // Set the person into the controller.
            PersonEditDialogController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setPerson(person);

            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();

            return controller.isOkClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    /**
     * Returns the main stage.
     * @return
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }
    
   

	public static void main(String[] args) {
		launch(args);
	}
}
