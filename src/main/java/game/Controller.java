package game;

import database.jpa.DBTools;
import database.gamer.Gamer;
import database.savegame.SaveGame;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.Glow;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
    private static Logger log = LoggerFactory.getLogger(Controller.class);
    private Gamer tmp_gs;
    private SaveGame tmp_sg;
    private DBTools sg = new DBTools(tmp_sg);
    private DBTools gs = new DBTools(tmp_gs);

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
    private Pane score_pane;
    @FXML
    private Pane load_pane;
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
    private TableView<Gamer> top_players;
    @FXML
    private TableView<Gamer> scoreboard;
    @FXML
    private TableView<SaveGame> sg_board;
    @FXML
    private TableColumn<Gamer, String> id;
    @FXML
    private TableColumn<Gamer, String> name;
    @FXML
    private TableColumn<Gamer, String> score;
    @FXML
    private TableColumn<Gamer, String> ids;
    @FXML
    private TableColumn<Gamer, String> names;
    @FXML
    private TableColumn<Gamer, String> scores;
    @FXML
    private TableColumn<SaveGame, String> sg_player1;
    @FXML
    private TableColumn<SaveGame, String> sg_player2;
    @FXML
    private TableColumn<SaveGame, String> sg_heap1;
    @FXML
    private TableColumn<SaveGame, String> sg_heap2;

    @FXML
    public void saveGame() {
        tmp_sg = new SaveGame();

        tmp_sg.setPlayer1(player1.getText());
        tmp_sg.setPlayer2(player2.getText());

        tmp_sg.setRocks1(Integer.parseInt(rocks_in_heap1.getText()));
        tmp_sg.setRocks2(Integer.parseInt(rocks_in_heap2.getText()));

        if(player1_status)
            tmp_sg.setActivePlayer(true);
        else
            tmp_sg.setActivePlayer(false);

        sg.saveGame(tmp_sg);

        log.info("The game has been saved successfully!");
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
        score_pane.setVisible(false);
        load_pane.setVisible(false);
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

        log.info("Heap1 status has been changed successfully!");
    }

    @FXML
    public void activateHeap2() {
        heap2 = !heap2;

        if(heap2)
            img_heap2.setEffect(selected);
        else
            img_heap2.setEffect(not_selected);

        log.info("Heap2 status has been changed successfully!");
    }

    @FXML
    public void takeRocks() {
        error_message2.setVisible(false);

        int rock = 0;
        try {
            rock = Integer.parseInt(take_rocks.getText());
        } catch (Exception e) {
            log.error("Not a number!");
        }

        if (rock == 0) {
            showErrorMessage2("Invalid input number");
            log.warn("The input data is not valid!");
        }
        else {
            if (heap1 && heap2) {
                error_message2.setVisible(false);

                if(rocks1 < rock || rocks2 < rock) {
                    showErrorMessage2("Input number is too big");
                    log.warn("The input number is too big!");
                }
                else {
                    rocks1 -= rock;
                    rocks2 -= rock;
                    rocks_in_heap1.setText(""+rocks1);
                    rocks_in_heap2.setText(""+rocks2);
                    changePlayer();

                    log.info("Rocks taken successfully!");
                }
            }

            if (!heap1 && heap2) {
                error_message2.setVisible(false);

                if(rocks2 < rock) {
                    showErrorMessage2("Input number is too big");
                    log.warn("The input number is too big!");
                }
                else {
                    rocks2 -= rock;
                    rocks_in_heap2.setText("" + rocks2);
                    changePlayer();

                    log.info("Rocks taken successfully!");
                }
            }

            if (heap1 && !heap2) {
                error_message2.setVisible(false);

                if(rocks1 < rock) {
                    showErrorMessage2("Input number is too big");
                    log.warn("The input number is too big!");
                }
                else {
                    rocks1 -= rock;
                    rocks_in_heap1.setText("" + rocks1);
                    changePlayer();

                    log.info("Rocks taken successfully!");
                }
            }

            if (!heap1 && !heap2) {
                error_message2.setVisible(false);
                showErrorMessage2("Choose at least one heap");

                log.warn("No heaps chosen!");
            }
        }

        isWinSituation();

    }

    private void refreshGamer(String winner, String looser) {
        tmp_gs = new Gamer();

        tmp_gs.setName(winner);
        gs.addGamer(tmp_gs);
        gs.updateGamer(tmp_gs);

        tmp_gs.setName(looser);
        gs.addGamer(tmp_gs);
    }

    private void isWinSituation() {
        if(rocks1 == 0 && rocks2 == 0) {
            log.info("Winner situation!");

            if(!player2_status) {
                winner.setText(playerID2);

                refreshGamer(playerID2, playerID1);
            }
            else {
                winner.setText(playerID1);

                refreshGamer(playerID1, playerID2);
            }

            log.info("Successful database update!");

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
        } catch (Exception e) {
            log.error("Not a number!");
        }
        if (playerID1.equals("") || playerID2.equals("") || rocks1 == 0 || rocks2 == 0 || playerID1.equals(playerID2)) {
            error_message1.setVisible(true);
            log.warn("The input data is not valid!");
        }
        else {
            player1.setText(playerID1);
            player2.setText(playerID2);
            player2.setVisible(false);
            rocks_in_heap1.setText("" + rocks1);
            rocks_in_heap2.setText("" + rocks2);
            input_pane.setVisible(false);
            game_scene.setVisible(true);

            log.info("Input data has been saved successfully!");
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
        main_menu.setVisible(false);

        tmp_sg = new SaveGame();
        ObservableList<SaveGame> sgs = FXCollections.observableList(sg.getSaves());

        sg_player1.setCellValueFactory(new PropertyValueFactory<>("player1"));
        sg_player2.setCellValueFactory(new PropertyValueFactory<>("player2"));
        sg_heap1.setCellValueFactory(new PropertyValueFactory<>("rocks1"));
        sg_heap2.setCellValueFactory(new PropertyValueFactory<>("rocks2"));
        sg_board.setItems(sgs);

        load_pane.setVisible(true);
    }

    @FXML
    public void loadSelectedGame() {
        SaveGame selected = sg.loadGame(sg_board.getSelectionModel().getSelectedItem().getId());

        playerID1 = selected.getPlayer1();
        playerID2 = selected.getPlayer2();
        rocks1 = selected.getRocks1();
        rocks2 = selected.getRocks2();
        if(selected.isActivePlayer()) {
            player1_status = true;
            player2_status = false;
        }
        else {
            player1_status = false;
            player2_status = true;
        }


        player1.setText(playerID1);
        player2.setText(playerID2);
        player2.setVisible(false);
        rocks_in_heap1.setText("" + rocks1);
        rocks_in_heap2.setText("" + rocks2);
        load_pane.setVisible(false);
        game_scene.setVisible(true);

        log.info("Game has been loaded successfully!");
    }

    @FXML
    public void showLeaderboard() {
        ObservableList<Gamer> board = FXCollections.observableList(gs.getScoreboard());

        ids.setCellValueFactory(new PropertyValueFactory<>("id"));
        names.setCellValueFactory(new PropertyValueFactory<>("name"));
        scores.setCellValueFactory(new PropertyValueFactory<>("score"));
        scoreboard.setItems(board);

        main_menu.setVisible(false);
        score_pane.setVisible(true);
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
        ObservableList<Gamer> top = FXCollections.observableList(gs.getTopPlayers());

        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        score.setCellValueFactory(new PropertyValueFactory<>("score"));
        top_players.setItems(top);

        main_menu.setVisible(true);
        game_scene.setVisible(false);
        input_pane.setVisible(false);
        winner_scene.setVisible(false);
        help_menu.setVisible(false);
        score_pane.setVisible(false);
        load_pane.setVisible(false);

        log.info("The game has been initialized successfully!");
    }
}