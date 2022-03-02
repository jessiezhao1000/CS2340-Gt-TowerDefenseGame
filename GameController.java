package com.peons.peonstd;

import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;
import java.util.ResourceBundle;

public class GameController implements Initializable {
    private GameState gameState = new GameState();

    @FXML
    private Label insufficientFunds;

    @FXML
    private Label healthLevel;

    /**
     * Setter for health level
     *
     * @param healthLevel the current amount of health
     */
    private void setHealthLevel(String healthLevel) {
        this.healthLevel.setText(String.format("Health: %s", healthLevel));
    }

    public Label getHealthLevel() {
        return healthLevel;
    }

    @FXML
    private Label coinLevel;

    /**
     * Setter for coin level
     *
     * @param coinLevel the current amount of coins
     */
    private void setCoinLevel(int coinLevel) {
        this.coinLevel.setText(String.format("Coins: %d", coinLevel));
    }

    public Label getCoinLevel() {
        return coinLevel;
    }



    /**
     * Setter for game state
     *
     * @param gameState the current game state
     */
    public void setGameState(GameState gameState) {
        this.gameState = gameState;
        setHealthLevel(Integer.toString(gameState.getMonumentHealth()));
        setCoinLevel(gameState.getMoney());
    }

    public GameState getGameState() {
        return gameState;
    }

    /**
     * Setter for player name
     *
     * @param name the name entered by the player
     */
    public void setPlayerName(String name) {
        this.gameState.setName(name);
    }

    @FXML
    protected ToggleGroup towerMenuGroup;

    public String getSelectedTower() {
        RadioButton s = (RadioButton) towerMenuGroup.getSelectedToggle();
        return s.getText();
    }

    @FXML
    protected AnchorPane pane1;

    public AnchorPane getPane1() {
        return pane1;
    }

    private ArrayList<Tower> towerList = new ArrayList<Tower>();

    public void upgradeTower(ActionEvent event) throws IOException {
        Button buttonPressed = (Button) event.getSource();
        if ((int) buttonPressed.getLayoutX() == 57) {
            if (gameEngine.upgradeTower(gameState, towerList.get(0))) {
                setCoinLevel(gameState.getMoney());
                if (insufficientFunds.isVisible()) {
                    insufficientFunds.setVisible(false);
                }
            } else {
                insufficientFunds.setVisible(true);
            }
        } else {
            if (gameEngine.upgradeTower(gameState, towerList.get(1))) {
                setCoinLevel(gameState.getMoney());
                if (insufficientFunds.isVisible()) {
                    insufficientFunds.setVisible(false);
                }

            } else {
                insufficientFunds.setVisible(true);
            }
        }
    }

    public void placeTower(ActionEvent event) throws IOException {
        Button buttonPressed = (Button) event.getSource();
        int x = (int) buttonPressed.getLayoutX();
        int y = (int) buttonPressed.getLayoutY();
        String towerPicked = getSelectedTower();
        Tower tower;
        if (towerPicked.equals("Waterbender")) {
            tower = new SnowTower(x, y, gameState);
        } else if (towerPicked.equals("Airbender")) {
            tower = new FireTower(x, y, gameState);
        } else {
            tower = new LightingTower(x, y, gameState);
        }

        if (gameEngine.purchaseTower(gameState, tower)) {
            towerList.add(tower);
            Pane root = getPane1();
            tower.setX(x);
            tower.setY(y);
            tower.drawTower("image", x, y, 100, 100, root);
            setCoinLevel(gameState.getMoney());
            buttonPressed.setVisible(false);
            if (insufficientFunds.isVisible()) {
                insufficientFunds.setVisible(false);
            }
        } else {
            insufficientFunds.setVisible(true);
        }
    }

    @FXML
    protected Label tower1Label;

    @FXML
    protected Label tower2Label;

    @FXML
    protected Label tower3Label;

    @FXML
    public void setTowerCosts() {
        SnowTower snowTower = new SnowTower(0, 0, gameState);
        FireTower fireTower = new FireTower(0, 0, gameState);
        LightingTower lightingTower = new LightingTower(0, 0, gameState);
        tower1Label.setText(String.format("%d", snowTower.getBuildCost()));
        tower2Label.setText(String.format("%d", fireTower.getBuildCost()));
        tower3Label.setText(String.format("%d", lightingTower.getBuildCost()));
    }

    protected void setGameWonScreen() throws IOException {
        Stage stage;
        Parent root;
        stage = (Stage) pane1.getScene().getWindow();


        FXMLLoader loader = new FXMLLoader(getClass().getResource("game-won.fxml"));
        root = (Parent) loader.load();

        GameOverController gameOverController = (GameOverController) loader.getController();
        gameOverController.setEnemiesKilled(gameState.getEnemiesKilled());
        gameOverController.setDamageDealt(gameState.getTotalDamageDealt());
        gameOverController.setHealthLost(gameState.getTotalHealthLost());

        gameOverController.setDamageDealtWonLabel();
        gameOverController.setEnemiesKilledWonLabel();
        gameOverController.setHealthLostWonLabel();

        stage = (Stage) startCombat.getScene().getWindow();

        Scene scene = new Scene(root, 1000, 1000);

        stage.setScene(scene);
        stage.setHeight(1000);
        stage.setWidth(1000);
    }

    protected void setGameOverScreen() throws IOException {
        Stage stage;
        Parent root;
        stage = (Stage) pane1.getScene().getWindow();


        FXMLLoader loader = new FXMLLoader(getClass().getResource("gameOver.fxml"));
        root = (Parent) loader.load();

        GameOverController gameOverController = (GameOverController) loader.getController();
        gameOverController.setEnemiesKilled(gameState.getEnemiesKilled());
        gameOverController.setDamageDealt(gameState.getTotalDamageDealt());
        gameOverController.setHealthLost(gameState.getTotalHealthLost());

        gameOverController.setDamageDealtLostLabel();
        gameOverController.setEnemiesKilledLostLabel();
        gameOverController.setHealthLostLostLabel();

        stage = (Stage) startCombat.getScene().getWindow();

        Scene scene = new Scene(root, 1000, 1000);

        stage.setScene(scene);
        stage.setHeight(1000);
        stage.setWidth(1000);
    }


    ArrayList<Projectile> projectiles = new ArrayList<>();

    @FXML
    protected Button startCombat;
    @FXML
    protected void startCombatClick(ActionEvent actionEvent) throws IOException {
        startCombat.setDisable(true);
        gameEngine = new GameEngine();
        gameState.setFrameCounter(0);


        Pane pane = this.getPane1();

        AnimationTimer timer = new AnimationTimer() {
            private int frame = 0;
            @Override
            public void handle(long now) {
                if (gameState.getEnemiesKilled() == gameState.getNumEnemies() && gameState.getMonumentHealth() > 0) {
                    try {
                        setGameWonScreen();
                        gameState.setMonumentHealth(100000);
                        this.stop();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                for (Projectile proj : projectiles) {
                    proj.translate();
                }
                for (int i = 0;
                     i < gameState.getFrameCounter() / gameState.getFramesPerEnemy();
                     i++) {
                    Enemy enemy = gameState.getEnemies().get(i);


                    if (enemy.isDead()) {
                        continue;
                    }

                    // No interaction with dead enemies after this, unless enemy dies
                    // after tower attacks it.

                    enemy.drawEnemy(enemy.getPosX() + (enemy.getSpeed()), 590, getPane1());

                    boolean called = false;
                    for (int j = 0; j < towerList.size(); j++) {
                        Tower tower = towerList.get(j);
                        if (frame % tower.getFramesPerAttack() == 0) {
                            Projectile projectile = tower.effectOnEnemy(enemy);
                            gameState.updateDamageDealt(tower.getAttackPower());
                            if (projectile != null) {
                                projectiles.add(projectile);
                                pane1.getChildren().add(projectile.getImageView());
                            }
                        }
                        if (enemy.isDead() && !called) {
                            gameState.setMoney(gameState.getMoney() + enemy.getCoinReward());
                            setCoinLevel(gameState.getMoney());
                            gameState.updateEnemiesKilled();
                            called = true;
                        }
                    }
                    if (enemy.getPosX() > 850) {
                        int newHealth = getGameState().getMonumentHealth()
                                - enemy.getDamage();


                        getGameState().setMonumentHealth(newHealth);
                        setHealthLevel(Integer.toString(newHealth));
                        gameState.updateTotalHealthLost(enemy.getDamage());
                        enemy.drawEnemy(2000, 0, getPane1());
                        enemy.damageHealth(enemy.getHealth());
                    }
                    if (gameState.getMonumentHealth() <= 0) {
                        try {
                            setGameOverScreen();
                            gameState.setMonumentHealth(100000);
                            this.stop();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    frame++;
                }
                if (gameState.getFrameCounter()
                        < gameState.getFramesPerEnemy() * gameState.getNumEnemies()) {
                    gameState.setFrameCounter(gameState.getFrameCounter() + 1);
                }
            }
        };
        timer.start();

    }


    /**
     * getStartCombatText
     * @return combat text
     */
    public String getStartCombatText() {
        String startCombatText = startCombat.getText();
        return startCombatText;
    }

    public ArrayList<Tower> getTowerList() {
        return towerList;
    }

    public ArrayList<Projectile> getProjectiles() {
        return projectiles;
    }

    private GameEngine gameEngine;
    /**
     * returning the gameengine class
     * @return gameengine
     */
    public GameEngine getGameEngine() {
        return gameEngine;
    }

    @FXML
    Button Upgrade1;

    public Button getUpgrade1() {
        return Upgrade1;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        gameEngine = new GameEngine();
    }

}