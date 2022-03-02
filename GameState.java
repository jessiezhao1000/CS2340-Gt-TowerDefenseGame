package com.peons.peonstd;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Class used to store information that the user selects in the startup screen,
 * such as the difficulty, the level, and the language.
 */
public class GameState {
    /**
     * Keeps track of the difficulty the user has selected for enemy action
     * and also to designate starting money amount for the player.
     */
    private String difficulty;

    /**
     * Denotes the level of the game the user wants to play
     */
    private int level;

    /**
     * Keeps track of the player's total money at their disposal
     */
    private int money;

    /**
     * The chosen name for the player
     */
    private String name;

    /**
     * Lets the user choose what language they want to play in, but will most
     * likely just be english.
     */
    private String language;

    /**
     * The health variable for the monument the user is defending
     */
    private int monumentHealth;

    /**
     * Number of frames before a new enemy is spawned
     */
    private int framesPerEnemy;

    /**
     * Number of enemies
     */

    private int numEnemies;

    /**
     * Total number of enemies killed throughout game
     */
    private int enemiesKilled;

    /**
     * Total health lost to monument throughout game
     */
    private int totalHealthLost;

    /**
     * Total damage dealt to enemies throughout game
     */
    private int totalDamageDealt;

    /**
     * Empty constructor for game state
     */
    public GameState() {
    }

    /**
     * Constructor for game state
     *
     * @param difficulty the difficulty level selected by player
     */
    public GameState(String difficulty) {
        this.difficulty = difficulty;
        this.totalHealthLost = 0;
        this.totalDamageDealt = 0;
        this.enemiesKilled = 0;
        if (Objects.equals(difficulty, "Easy")) {
            this.monumentHealth = 180;
            this.money = 2000;
            this.framesPerEnemy = 240;
            setNumEnemies(8);
            addEnemies(0, "Easy");
        } else if (Objects.equals(difficulty, "Medium")) {
            this.monumentHealth = 150;
            this.money = 1500;
            this.framesPerEnemy = 120;
            setNumEnemies(8);
            addEnemies(2, "Medium");
        } else if (Objects.equals(difficulty, "Hard")) {
            this.monumentHealth = 100;
            this.money = 1000;
            this.framesPerEnemy = 120;
            setNumEnemies(16);
            addEnemies(2, "Medium");
            addEnemies(1, "Hard");
        }
    }

    private static ArrayList<Enemy> enemies = new ArrayList<Enemy>();

    private int frameCounter;

    /**
     * return the frame counter so that we can release enemies in sequence
     * @return current frame
     */
    public int getFrameCounter() {
        return this.frameCounter;
    }

    /**
     * setter for the frame counter so that we can update as enemies come in
     * @param counter current frame
     */
    public void setFrameCounter(int counter) {
        this.frameCounter = counter;
    }

    /**
     * getter for the array of enemy objects
     * @return enemy array
     */
    public static ArrayList<Enemy> getEnemies() {
        return enemies;
    }

    /**
     * Getter for difficulty
     *
     * @return the difficulty setting
     */
    public String getDifficulty() {
        return this.difficulty;
    }

    /**
     * Getter for the level
     *
     * @return the current level
     */
    public int getLevel() {
        return this.level;
    }

    /**
     * Setter for the level
     *
     * @param level the current level
     */
    public void setLevel(int level) {
        this.level = level;
    }

    /**
     * Getter for the language
     *
     * @return the language the game is currently in
     */
    public String getLanguage() {
        return this.language;
    }

    /**
     * Setter for language
     *
     * @param language the langauge the player chose
     */
    public void setLanguage(String language) {
        this.language = language;
    }

    /**
     * Getter for monument health
     *
     * @return the current health of the monument
     */
    public int getMonumentHealth() {
        return this.monumentHealth;
    }

    /**
     * setter for monument health variable for when the player takes damage
     * @param health the health of the monument
     */
    public void setMonumentHealth(int health) {
        this.monumentHealth = health;
    }

    /**
     * gets the username for the player
     * @return returns the name of the player
     */
    public String getName() {
        return this.name;
    }

    /**
     * sets the users name from the initial screen
     * @param name the name of the player
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * returns the amount of money the player has
     * @return the amount of money the player has
     */
    public int getMoney() {
        return this.money;
    }

    /**
     * allows the engine to change the player money as needed
     * @param money the amount of money the player received
     */
    public void setMoney(int money) {
        this.money = money;
    }

    public int getFramesPerEnemy() {
        return framesPerEnemy;
    }

    /**
     * Adds to number of enemies killed when an enemy dies
     */
    public void updateEnemiesKilled() {
        this.enemiesKilled++;
    }

    /**
     * Gets how many enemies the user has killed
     * @return number of enemies killed
     */
    public int getEnemiesKilled() {
        return enemiesKilled;
    }

    /**
     * Adds damage to total damage dealt
     * @param damage amount of damage dealt
     */
    public void updateDamageDealt(int damage) {
        totalDamageDealt += damage;
    }

    /**
     * Gets the amount of damage dealt
     * @return total amount of damage dealt
     */
    public int getTotalDamageDealt() {
        return totalDamageDealt;
    }

    /**
     * Adds to total monument health lost
     * @param health the amount of health lost
     */
    public void updateTotalHealthLost(int health) {
        totalHealthLost += health;
    }

    /**
     * Returns the total amount of monument health lost
     * @return total health monument lost
     */
    public int getTotalHealthLost() {
        return totalHealthLost;
    }

    public int getNumEnemies() {
        return numEnemies;
    }

    private void setNumEnemies(int numEnemies) {
        this.numEnemies = numEnemies;
        for (int i = 0; i < numEnemies; i++) {
            Minion minion = new Minion();
            this.enemies.add(minion);
        }
    }

    private void addEnemies(int additionalEnemies, String level) {
        if (Objects.equals(level, "Medium")) {
            this.numEnemies += additionalEnemies;
            for (int i = 0; i < additionalEnemies; i++) {
                Azula azula = new Azula();
                this.enemies.add(azula);
            }
        } else if (Objects.equals(level, "Hard")) {
            this.numEnemies += additionalEnemies;
            for (int i = 0; i < additionalEnemies; i++) {
                Zuko zuko = new Zuko();
                this.enemies.add(zuko);
            }
        }
        enemies.add(new FireLordOzo());
        this.numEnemies ++;
    }
}
