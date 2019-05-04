package game;

import database.DBTools;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.Glow;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    private static String playerID1 = "";
    private static String playerID2 = "";
    private static boolean player1_status = true;
    private static boolean player2_status = false;
    private static int rocks1 = 0;
    private static int rocks2 = 0;
    private static boolean heap1 = false;
    private static boolean heap2 = false;
    private static Glow selected = new Glow(1.7f);
    private static Glow not_selected = new Glow(0);

    @FXML
    private Label player1;
    @FXML
    private Label player2;
    @FXML
    private Label rocks_in_heap1;
    @FXML
    private Label rocks_in_heap2;
    @FXML
    private Label error_message1;
    @FXML
    private Label error_message2;
    @FXML
    private Label winner;
    @FXML
    private AnchorPane input_pane;
    @FXML
    private AnchorPane game_scene;
    @FXML
    private Pane main_menu;
    @FXML
    private Pane winner_scene;
    @FXML
    private Pane help_menu;
    @FXML
    private TextField player1ID;
    @FXML
    private TextField player2ID;
    @FXML
    private TextField input_rock1;
    @FXML
    private TextField input_rock2;
    @FXML
    private TextField take_rocks;
    @FXML
    private ImageView img_heap1;
    @FXML
    private ImageView img_heap2;

    @FXML
    public void saveGame() {

    }

    @FXML
    public void exitGame() {
        playerID1 = "";
        playerID2 = "";
        rocks1 = 0;
        rocks2 = 0;
        heap1 = false;
        heap2 = false;
        img_heap1.setEffect(not_selected);
        img_heap2.setEffect(not_selected);
        player1_status = true;
        player2_status = false;

        game_scene.setVisible(false);
        main_menu.setVisible(true);
    }

    @FXML
    private void goBack() {
        help_menu.setVisible(false);
        game_scene.setVisible(true);
    }

    @FXML
    public void closeGame() {
        System.exit(0);
    }

    @FXML
    public void showMainMenu() {
        winner_scene.setVisible(false);
        main_menu.setVisible(true);
    }

    @FXML
    public void showHelp() {
        help_menu.setVisible(true);
        game_scene.setVisible(false);
    }

    @FXML
    public void activateHeap1() {
        heap1 = !heap1;

        if(heap1)
            img_heap1.setEffect(selected);
        else
            img_heap1.setEffect(not_selected);
    }

    @FXML
    public void activateHeap2() {
        heap2 = !heap2;

        if(heap2)
            img_heap2.setEffect(selected);
        else
            img_heap2.setEffect(not_selected);
    }

    @FXML
    public void takeRocks() {
        error_message2.setVisible(false);

        int rock = 0;
        try {
            rock = Integer.parseInt(take_rocks.getText());
        } catch (Exception ignored) {}

        if (rock == 0) {
            showErrorMessage2("Invalid input number");
        }
        else {
            if (heap1 && heap2) {
                error_message2.setVisible(false);

                if(rocks1 < rock || rocks2 < rock)
                    showErrorMessage2("Input number is too big");
                else {
                    rocks1 -= rock;
                    rocks2 -= rock;
                    rocks_in_heap1.setText(""+rocks1);
                    rocks_in_heap2.setText(""+rocks2);
                    changePlayer();
                }
            }

            if (!heap1 && heap2) {
                error_message2.setVisible(false);

                if(rocks2 < rock)
                    showErrorMessage2("Input number is too big");
                else {
                    rocks2 -= rock;
                    rocks_in_heap2.setText("" + rocks2);
                    changePlayer();
                }
            }

            if (heap1 && !heap2) {
                error_message2.setVisible(false);

                if(rocks1 < rock)
                    showErrorMessage2("Input number is too big");
                else {
                    rocks1 -= rock;
                    rocks_in_heap1.setText("" + rocks1);
                    changePlayer();
                }
            }

            if (!heap1 && !heap2) {
                error_message2.setVisible(false);
                showErrorMessage2("Choose at least one heap");
            }
        }

        if(rocks1 == 0 && rocks2 == 0) {
            Gamer player1 = new Gamer();
            Gamer player2 = new Gamer();

            player1.setName(playerID1);
            player2.setName(playerID2);

            new DBTools().addGamer(player1);
            new DBTools().addGamer(player2);

            if(!player2_status) {
                winner.setText(playerID2);
                new DBTools().updateGamer(player2);
            }
            else {
                winner.setText(playerID1);
                new DBTools().updateGamer(player1);
            }

            game_scene.setVisible(false);
            winner_scene.setVisible(true);
        }

    }

    @FXML
    public void newGame() {
        input_pane.setVisible(true);
        main_menu.setVisible(false);
    }

    @FXML
    public void saveInputData() {
        try {
            playerID1 = player1ID.getText();
            playerID2 = player2ID.getText();
            rocks1 = Integer.parseInt(input_rock1.getText());
            rocks2 = Integer.parseInt(input_rock2.getText());
        } catch (Exception ignored) {
        }
        if (playerID1.equals("") || playerID2.equals("") || rocks1 == 0 || rocks2 == 0 || playerID1.equals(playerID2))
            error_message1.setVisible(true);
        else {
            player1.setText(playerID1);
            player2.setText(playerID2);
            player2.setVisible(false);
            rocks_in_heap1.setText("" + rocks1);
            rocks_in_heap2.setText("" + rocks2);
            input_pane.setVisible(false);
            game_scene.setVisible(true);
        }

    }

    @FXML
    public void cancelNewGame() {
        input_pane.setVisible(false);
        error_message1.setVisible(false);
        main_menu.setVisible(true);
    }

    @FXML
    public void loadGame() {

    }

    @FXML
    public void showLeaderboard() {

    }

    private void changePlayer() {
        player1_status = !player1_status;
        player2_status = !player2_status;

        player1.setVisible(player1_status);
        player2.setVisible(player2_status);
    }

    private void showErrorMessage2(String message) {
        error_message2.setText(message);
        error_message2.setVisible(true);
    }

    public void initialize(URL url, ResourceBundle resourceBundle) {
        main_menu.setVisible(true);
        game_scene.setVisible(false);
        input_pane.setVisible(false);
        winner_scene.setVisible(false);
        help_menu.setVisible(false);
    }
}




