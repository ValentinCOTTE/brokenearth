package mainPackage.model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Person{
	private final StringProperty name;
	private final IntegerProperty force;
	private final IntegerProperty endurance;
	private final IntegerProperty dexterite;
	private final IntegerProperty agilite;
	private final IntegerProperty perception;
	private final IntegerProperty intelligence;
	private final IntegerProperty charisme;
	private final IntegerProperty chance;


	/**
     * Default constructor.
     */
    public Person() {
        this(null);
    }
    
    /**
     * Constructor with some initial data.
     * 
     * @param firstName
     * @param lastName
     */
    public Person(String name) {
    	this.name = new SimpleStringProperty(name);
    	
        this.force = new SimpleIntegerProperty(5);
        this.endurance = new SimpleIntegerProperty(5);
        this.dexterite = new SimpleIntegerProperty(5);
        this.agilite = new SimpleIntegerProperty(5);
        this.perception = new SimpleIntegerProperty(5);
        this.intelligence = new SimpleIntegerProperty(5);
        this.charisme = new SimpleIntegerProperty(5);
        this.chance = new SimpleIntegerProperty(5);
    }
    
    
    public StringProperty getNameProperty() {
		return name;
    	
    }
    public IntegerProperty getForceProperty() {
		return force;
    	
    }
    public IntegerProperty getEnduranceProperty() {
		return endurance;
    	
    }
    public IntegerProperty getDexteriteProperty() {
		return dexterite;
    	
    }
    public IntegerProperty getAgiliteProperty() {
		return agilite;
    	
    }
    public IntegerProperty getPerceptionProperty() {
		return perception;
    	
    }
    public IntegerProperty getIntelligenceProperty() {
		return intelligence;
    	
    }
    public IntegerProperty getCharismeProperty() {
		return charisme;
    	
    }
    public IntegerProperty getChanceProperty() {
		return chance;
    }

    
    
	public String getName() {
		return name.get();
	}
	public void setName(String name) {
		this.name.set(name);
	}

	public int getForce() {
		return force.get();
	}
	public void setForce(int force) {
		this.force.set(force);
	}

	public int getEndurance() {
		return endurance.get();
	}
	public void setEndurance(int endurance) {
		this.endurance.set(endurance);
	}

	public int getDexterite() {
		return dexterite.get();
	}
	public void setDexterite(int dexterite) {
		this.dexterite.set(dexterite);
	}

	public int getAgilite() {
		return agilite.get();
	}
	public void setAgilite(int agilite) {
		this.agilite.set(agilite);
	}

	public int getPerception() {
		return perception.get();
	}
	public void setPerception(int perception) {
		this.perception.set(perception);
	}

	public int getIntelligence() {
		return intelligence.get();
	}
	public void setIntelligence(int intelligence) {
		this.intelligence.set(intelligence);
	}

	public int getCharisme() {
		return charisme.get();
	}
	public void setCharisme(int charisme) {
		this.charisme.set(charisme);
	}


	public int getChance() {
		return chance.get();
	}
	public void setChance(int chance) {
		this.chance.set(chance);
	}
}
