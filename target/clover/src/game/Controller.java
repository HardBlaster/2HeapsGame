/* $$ This file has been instrumented by Clover 4.3.1#20180921211537623 $$ */package game;

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

public class Controller implements Initializable {public static class __CLR4_3_11v1vjvm4k8hu{public static com_atlassian_clover.CoverageRecorder R;public static com_atlassian_clover.CloverProfile[] profiles = { };@java.lang.SuppressWarnings("unchecked") public static <I, T extends I> I lambdaInc(final int i,final T l,final int si){java.lang.reflect.InvocationHandler h=new java.lang.reflect.InvocationHandler(){public java.lang.Object invoke(java.lang.Object p,java.lang.reflect.Method m,java.lang.Object[] a) throws Throwable{R.inc(i);R.inc(si);try{return m.invoke(l,a);}catch(java.lang.reflect.InvocationTargetException e){throw e.getCause()!=null?e.getCause():new RuntimeException("Clover failed to invoke instrumented lambda",e);}}};return (I)java.lang.reflect.Proxy.newProxyInstance(l.getClass().getClassLoader(),l.getClass().getInterfaces(),h);}static{com_atlassian_clover.CoverageRecorder _R=null;try{com_atlassian_clover.CloverVersionInfo.An_old_version_of_clover_is_on_your_compilation_classpath___Please_remove___Required_version_is___4_3_1();if(20180921211537623L!=com_atlassian_clover.CloverVersionInfo.getBuildStamp()){com_atlassian_clover.Clover.l("[CLOVER] WARNING: The Clover version used in instrumentation does not match the runtime version. You need to run instrumented classes against the same version of Clover that you instrumented with.");com_atlassian_clover.Clover.l("[CLOVER] WARNING: Instr=4.3.1#20180921211537623,Runtime="+com_atlassian_clover.CloverVersionInfo.getReleaseNum()+"#"+com_atlassian_clover.CloverVersionInfo.getBuildStamp());}R=com_atlassian_clover.Clover.getNullRecorder();_R=com_atlassian_clover.Clover.getNullRecorder();_R=com_atlassian_clover.Clover.getRecorder("\u002f\u0068\u006f\u006d\u0065\u002f\u0062\u0061\u0062\u006c\u0061\u006e\u002f\u0044\u006f\u006b\u0075\u006d\u0065\u006e\u0074\u0075\u006d\u006f\u006b\u002f\u0073\u0077\u0065\u002f\u0050\u0072\u006f\u006a\u0065\u006b\u0074\u0032\u002e\u0030\u002f\u0074\u0061\u0072\u0067\u0065\u0074\u002f\u0063\u006c\u006f\u0076\u0065\u0072\u002f\u0063\u006c\u006f\u0076\u0065\u0072\u002e\u0064\u0062",1557737288587L,8589935092L,291,profiles,new java.lang.String[]{"clover.distributed.coverage",null});}catch(java.lang.SecurityException e){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised because it has insufficient security privileges. Please consult the Clover documentation on the security policy file changes required. ("+e.getClass()+":"+e.getMessage()+")");}catch(java.lang.NoClassDefFoundError e){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised. Are you sure you have Clover in the runtime classpath? ("+e.getClass()+":"+e.getMessage()+")");}catch(java.lang.Throwable t){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised because of an unexpected error. ("+t.getClass()+":"+t.getMessage()+")");}R=_R;}}public static final com_atlassian_clover.TestNameSniffer __CLR4_3_1_TEST_NAME_SNIFFER=com_atlassian_clover.TestNameSniffer.NULL_INSTANCE;

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
    public void saveGame() {try{__CLR4_3_11v1vjvm4k8hu.R.inc(67);
        __CLR4_3_11v1vjvm4k8hu.R.inc(68);tmp_sg = new SaveGame();

        __CLR4_3_11v1vjvm4k8hu.R.inc(69);tmp_sg.setPlayer1(player1.getText());
        __CLR4_3_11v1vjvm4k8hu.R.inc(70);tmp_sg.setPlayer2(player2.getText());

        __CLR4_3_11v1vjvm4k8hu.R.inc(71);tmp_sg.setRocks1(Integer.parseInt(rocks_in_heap1.getText()));
        __CLR4_3_11v1vjvm4k8hu.R.inc(72);tmp_sg.setRocks2(Integer.parseInt(rocks_in_heap2.getText()));

        __CLR4_3_11v1vjvm4k8hu.R.inc(73);if((((player1_status)&&(__CLR4_3_11v1vjvm4k8hu.R.iget(74)!=0|true))||(__CLR4_3_11v1vjvm4k8hu.R.iget(75)==0&false)))
            {__CLR4_3_11v1vjvm4k8hu.R.inc(76);tmp_sg.setActivePlayer(true);
        }else
            {__CLR4_3_11v1vjvm4k8hu.R.inc(77);tmp_sg.setActivePlayer(false);

        }__CLR4_3_11v1vjvm4k8hu.R.inc(78);sg.saveGame(tmp_sg);

        __CLR4_3_11v1vjvm4k8hu.R.inc(79);log.info("The game has been saved successfully!");
    }finally{__CLR4_3_11v1vjvm4k8hu.R.flushNeeded();}}

    @FXML
    public void exitGame() {try{__CLR4_3_11v1vjvm4k8hu.R.inc(80);
        __CLR4_3_11v1vjvm4k8hu.R.inc(81);playerID1 = "";
        __CLR4_3_11v1vjvm4k8hu.R.inc(82);playerID2 = "";
        __CLR4_3_11v1vjvm4k8hu.R.inc(83);rocks1 = 0;
        __CLR4_3_11v1vjvm4k8hu.R.inc(84);rocks2 = 0;
        __CLR4_3_11v1vjvm4k8hu.R.inc(85);heap1 = false;
        __CLR4_3_11v1vjvm4k8hu.R.inc(86);heap2 = false;
        __CLR4_3_11v1vjvm4k8hu.R.inc(87);img_heap1.setEffect(not_selected);
        __CLR4_3_11v1vjvm4k8hu.R.inc(88);img_heap2.setEffect(not_selected);
        __CLR4_3_11v1vjvm4k8hu.R.inc(89);player1_status = true;
        __CLR4_3_11v1vjvm4k8hu.R.inc(90);player2_status = false;

        __CLR4_3_11v1vjvm4k8hu.R.inc(91);game_scene.setVisible(false);
        __CLR4_3_11v1vjvm4k8hu.R.inc(92);main_menu.setVisible(true);
    }finally{__CLR4_3_11v1vjvm4k8hu.R.flushNeeded();}}

    @FXML
    private void goBack() {try{__CLR4_3_11v1vjvm4k8hu.R.inc(93);
        __CLR4_3_11v1vjvm4k8hu.R.inc(94);help_menu.setVisible(false);
        __CLR4_3_11v1vjvm4k8hu.R.inc(95);game_scene.setVisible(true);
    }finally{__CLR4_3_11v1vjvm4k8hu.R.flushNeeded();}}

    @FXML
    public void closeGame() {try{__CLR4_3_11v1vjvm4k8hu.R.inc(96);
        __CLR4_3_11v1vjvm4k8hu.R.inc(97);System.exit(0);
    }finally{__CLR4_3_11v1vjvm4k8hu.R.flushNeeded();}}

    @FXML
    public void showMainMenu() {try{__CLR4_3_11v1vjvm4k8hu.R.inc(98);
        __CLR4_3_11v1vjvm4k8hu.R.inc(99);winner_scene.setVisible(false);
        __CLR4_3_11v1vjvm4k8hu.R.inc(100);score_pane.setVisible(false);
        __CLR4_3_11v1vjvm4k8hu.R.inc(101);load_pane.setVisible(false);
        __CLR4_3_11v1vjvm4k8hu.R.inc(102);main_menu.setVisible(true);
    }finally{__CLR4_3_11v1vjvm4k8hu.R.flushNeeded();}}

    @FXML
    public void showHelp() {try{__CLR4_3_11v1vjvm4k8hu.R.inc(103);
        __CLR4_3_11v1vjvm4k8hu.R.inc(104);help_menu.setVisible(true);
        __CLR4_3_11v1vjvm4k8hu.R.inc(105);game_scene.setVisible(false);
    }finally{__CLR4_3_11v1vjvm4k8hu.R.flushNeeded();}}

    @FXML
    public void activateHeap1() {try{__CLR4_3_11v1vjvm4k8hu.R.inc(106);
        __CLR4_3_11v1vjvm4k8hu.R.inc(107);heap1 = !heap1;

        __CLR4_3_11v1vjvm4k8hu.R.inc(108);if((((heap1)&&(__CLR4_3_11v1vjvm4k8hu.R.iget(109)!=0|true))||(__CLR4_3_11v1vjvm4k8hu.R.iget(110)==0&false)))
            {__CLR4_3_11v1vjvm4k8hu.R.inc(111);img_heap1.setEffect(selected);
        }else
            {__CLR4_3_11v1vjvm4k8hu.R.inc(112);img_heap1.setEffect(not_selected);

        }__CLR4_3_11v1vjvm4k8hu.R.inc(113);log.info("Heap1 status has been changed successfully!");
    }finally{__CLR4_3_11v1vjvm4k8hu.R.flushNeeded();}}

    @FXML
    public void activateHeap2() {try{__CLR4_3_11v1vjvm4k8hu.R.inc(114);
        __CLR4_3_11v1vjvm4k8hu.R.inc(115);heap2 = !heap2;

        __CLR4_3_11v1vjvm4k8hu.R.inc(116);if((((heap2)&&(__CLR4_3_11v1vjvm4k8hu.R.iget(117)!=0|true))||(__CLR4_3_11v1vjvm4k8hu.R.iget(118)==0&false)))
            {__CLR4_3_11v1vjvm4k8hu.R.inc(119);img_heap2.setEffect(selected);
        }else
            {__CLR4_3_11v1vjvm4k8hu.R.inc(120);img_heap2.setEffect(not_selected);

        }__CLR4_3_11v1vjvm4k8hu.R.inc(121);log.info("Heap2 status has been changed successfully!");
    }finally{__CLR4_3_11v1vjvm4k8hu.R.flushNeeded();}}

    @FXML
    public void takeRocks() {try{__CLR4_3_11v1vjvm4k8hu.R.inc(122);
        __CLR4_3_11v1vjvm4k8hu.R.inc(123);error_message2.setVisible(false);

        __CLR4_3_11v1vjvm4k8hu.R.inc(124);int rock = 0;
        __CLR4_3_11v1vjvm4k8hu.R.inc(125);try {
            __CLR4_3_11v1vjvm4k8hu.R.inc(126);rock = Integer.parseInt(take_rocks.getText());
        } catch (Exception e) {
            __CLR4_3_11v1vjvm4k8hu.R.inc(127);log.error("Not a number!");
        }

        __CLR4_3_11v1vjvm4k8hu.R.inc(128);if ((((rock == 0)&&(__CLR4_3_11v1vjvm4k8hu.R.iget(129)!=0|true))||(__CLR4_3_11v1vjvm4k8hu.R.iget(130)==0&false))) {{
            __CLR4_3_11v1vjvm4k8hu.R.inc(131);showErrorMessage2("Invalid input number");
            __CLR4_3_11v1vjvm4k8hu.R.inc(132);log.warn("The input data is not valid!");
        }
        }else {{
            __CLR4_3_11v1vjvm4k8hu.R.inc(133);if ((((heap1 && heap2)&&(__CLR4_3_11v1vjvm4k8hu.R.iget(134)!=0|true))||(__CLR4_3_11v1vjvm4k8hu.R.iget(135)==0&false))) {{
                __CLR4_3_11v1vjvm4k8hu.R.inc(136);error_message2.setVisible(false);

                __CLR4_3_11v1vjvm4k8hu.R.inc(137);if((((rocks1 < rock || rocks2 < rock)&&(__CLR4_3_11v1vjvm4k8hu.R.iget(138)!=0|true))||(__CLR4_3_11v1vjvm4k8hu.R.iget(139)==0&false))) {{
                    __CLR4_3_11v1vjvm4k8hu.R.inc(140);showErrorMessage2("Input number is too big");
                    __CLR4_3_11v1vjvm4k8hu.R.inc(141);log.warn("The input number is too big!");
                }
                }else {{
                    __CLR4_3_11v1vjvm4k8hu.R.inc(142);rocks1 -= rock;
                    __CLR4_3_11v1vjvm4k8hu.R.inc(143);rocks2 -= rock;
                    __CLR4_3_11v1vjvm4k8hu.R.inc(144);rocks_in_heap1.setText(""+rocks1);
                    __CLR4_3_11v1vjvm4k8hu.R.inc(145);rocks_in_heap2.setText(""+rocks2);
                    __CLR4_3_11v1vjvm4k8hu.R.inc(146);changePlayer();

                    __CLR4_3_11v1vjvm4k8hu.R.inc(147);log.info("Rocks taken successfully!");
                }
            }}

            }__CLR4_3_11v1vjvm4k8hu.R.inc(148);if ((((!heap1 && heap2)&&(__CLR4_3_11v1vjvm4k8hu.R.iget(149)!=0|true))||(__CLR4_3_11v1vjvm4k8hu.R.iget(150)==0&false))) {{
                __CLR4_3_11v1vjvm4k8hu.R.inc(151);error_message2.setVisible(false);

                __CLR4_3_11v1vjvm4k8hu.R.inc(152);if((((rocks2 < rock)&&(__CLR4_3_11v1vjvm4k8hu.R.iget(153)!=0|true))||(__CLR4_3_11v1vjvm4k8hu.R.iget(154)==0&false))) {{
                    __CLR4_3_11v1vjvm4k8hu.R.inc(155);showErrorMessage2("Input number is too big");
                    __CLR4_3_11v1vjvm4k8hu.R.inc(156);log.warn("The input number is too big!");
                }
                }else {{
                    __CLR4_3_11v1vjvm4k8hu.R.inc(157);rocks2 -= rock;
                    __CLR4_3_11v1vjvm4k8hu.R.inc(158);rocks_in_heap2.setText("" + rocks2);
                    __CLR4_3_11v1vjvm4k8hu.R.inc(159);changePlayer();

                    __CLR4_3_11v1vjvm4k8hu.R.inc(160);log.info("Rocks taken successfully!");
                }
            }}

            }__CLR4_3_11v1vjvm4k8hu.R.inc(161);if ((((heap1 && !heap2)&&(__CLR4_3_11v1vjvm4k8hu.R.iget(162)!=0|true))||(__CLR4_3_11v1vjvm4k8hu.R.iget(163)==0&false))) {{
                __CLR4_3_11v1vjvm4k8hu.R.inc(164);error_message2.setVisible(false);

                __CLR4_3_11v1vjvm4k8hu.R.inc(165);if((((rocks1 < rock)&&(__CLR4_3_11v1vjvm4k8hu.R.iget(166)!=0|true))||(__CLR4_3_11v1vjvm4k8hu.R.iget(167)==0&false))) {{
                    __CLR4_3_11v1vjvm4k8hu.R.inc(168);showErrorMessage2("Input number is too big");
                    __CLR4_3_11v1vjvm4k8hu.R.inc(169);log.warn("The input number is too big!");
                }
                }else {{
                    __CLR4_3_11v1vjvm4k8hu.R.inc(170);rocks1 -= rock;
                    __CLR4_3_11v1vjvm4k8hu.R.inc(171);rocks_in_heap1.setText("" + rocks1);
                    __CLR4_3_11v1vjvm4k8hu.R.inc(172);changePlayer();

                    __CLR4_3_11v1vjvm4k8hu.R.inc(173);log.info("Rocks taken successfully!");
                }
            }}

            }__CLR4_3_11v1vjvm4k8hu.R.inc(174);if ((((!heap1 && !heap2)&&(__CLR4_3_11v1vjvm4k8hu.R.iget(175)!=0|true))||(__CLR4_3_11v1vjvm4k8hu.R.iget(176)==0&false))) {{
                __CLR4_3_11v1vjvm4k8hu.R.inc(177);error_message2.setVisible(false);
                __CLR4_3_11v1vjvm4k8hu.R.inc(178);showErrorMessage2("Choose at least one heap");

                __CLR4_3_11v1vjvm4k8hu.R.inc(179);log.warn("No heaps chosen!");
            }
        }}

        }__CLR4_3_11v1vjvm4k8hu.R.inc(180);isWinSituation();

    }finally{__CLR4_3_11v1vjvm4k8hu.R.flushNeeded();}}

    private void refreshGamer(String winner, String looser) {try{__CLR4_3_11v1vjvm4k8hu.R.inc(181);
        __CLR4_3_11v1vjvm4k8hu.R.inc(182);tmp_gs = new Gamer();

        __CLR4_3_11v1vjvm4k8hu.R.inc(183);tmp_gs.setName(winner);
        __CLR4_3_11v1vjvm4k8hu.R.inc(184);gs.addGamer(tmp_gs);
        __CLR4_3_11v1vjvm4k8hu.R.inc(185);gs.updateGamer(tmp_gs);

        __CLR4_3_11v1vjvm4k8hu.R.inc(186);tmp_gs.setName(looser);
        __CLR4_3_11v1vjvm4k8hu.R.inc(187);gs.addGamer(tmp_gs);
    }finally{__CLR4_3_11v1vjvm4k8hu.R.flushNeeded();}}

    private void isWinSituation() {try{__CLR4_3_11v1vjvm4k8hu.R.inc(188);
        __CLR4_3_11v1vjvm4k8hu.R.inc(189);if((((rocks1 == 0 && rocks2 == 0)&&(__CLR4_3_11v1vjvm4k8hu.R.iget(190)!=0|true))||(__CLR4_3_11v1vjvm4k8hu.R.iget(191)==0&false))) {{
            __CLR4_3_11v1vjvm4k8hu.R.inc(192);log.info("Winner situation!");

            __CLR4_3_11v1vjvm4k8hu.R.inc(193);if((((!player2_status)&&(__CLR4_3_11v1vjvm4k8hu.R.iget(194)!=0|true))||(__CLR4_3_11v1vjvm4k8hu.R.iget(195)==0&false))) {{
                __CLR4_3_11v1vjvm4k8hu.R.inc(196);winner.setText(playerID2);

                __CLR4_3_11v1vjvm4k8hu.R.inc(197);refreshGamer(playerID2, playerID1);
            }
            }else {{
                __CLR4_3_11v1vjvm4k8hu.R.inc(198);winner.setText(playerID1);

                __CLR4_3_11v1vjvm4k8hu.R.inc(199);refreshGamer(playerID1, playerID2);
            }

            }__CLR4_3_11v1vjvm4k8hu.R.inc(200);log.info("Successful database update!");

            __CLR4_3_11v1vjvm4k8hu.R.inc(201);game_scene.setVisible(false);
            __CLR4_3_11v1vjvm4k8hu.R.inc(202);winner_scene.setVisible(true);
        }
    }}finally{__CLR4_3_11v1vjvm4k8hu.R.flushNeeded();}}

    @FXML
    public void newGame() {try{__CLR4_3_11v1vjvm4k8hu.R.inc(203);
        __CLR4_3_11v1vjvm4k8hu.R.inc(204);input_pane.setVisible(true);
        __CLR4_3_11v1vjvm4k8hu.R.inc(205);main_menu.setVisible(false);
    }finally{__CLR4_3_11v1vjvm4k8hu.R.flushNeeded();}}

    @FXML
    public void saveInputData() {try{__CLR4_3_11v1vjvm4k8hu.R.inc(206);
        __CLR4_3_11v1vjvm4k8hu.R.inc(207);try {
            __CLR4_3_11v1vjvm4k8hu.R.inc(208);playerID1 = player1ID.getText();
            __CLR4_3_11v1vjvm4k8hu.R.inc(209);playerID2 = player2ID.getText();
            __CLR4_3_11v1vjvm4k8hu.R.inc(210);rocks1 = Integer.parseInt(input_rock1.getText());
            __CLR4_3_11v1vjvm4k8hu.R.inc(211);rocks2 = Integer.parseInt(input_rock2.getText());
        } catch (Exception e) {
            __CLR4_3_11v1vjvm4k8hu.R.inc(212);log.error("Not a number!");
        }
        __CLR4_3_11v1vjvm4k8hu.R.inc(213);if ((((playerID1.equals("") || playerID2.equals("") || rocks1 == 0 || rocks2 == 0 || playerID1.equals(playerID2))&&(__CLR4_3_11v1vjvm4k8hu.R.iget(214)!=0|true))||(__CLR4_3_11v1vjvm4k8hu.R.iget(215)==0&false))) {{
            __CLR4_3_11v1vjvm4k8hu.R.inc(216);error_message1.setVisible(true);
            __CLR4_3_11v1vjvm4k8hu.R.inc(217);log.warn("The input data is not valid!");
        }
        }else {{
            __CLR4_3_11v1vjvm4k8hu.R.inc(218);player1.setText(playerID1);
            __CLR4_3_11v1vjvm4k8hu.R.inc(219);player2.setText(playerID2);
            __CLR4_3_11v1vjvm4k8hu.R.inc(220);player2.setVisible(false);
            __CLR4_3_11v1vjvm4k8hu.R.inc(221);rocks_in_heap1.setText("" + rocks1);
            __CLR4_3_11v1vjvm4k8hu.R.inc(222);rocks_in_heap2.setText("" + rocks2);
            __CLR4_3_11v1vjvm4k8hu.R.inc(223);input_pane.setVisible(false);
            __CLR4_3_11v1vjvm4k8hu.R.inc(224);game_scene.setVisible(true);

            __CLR4_3_11v1vjvm4k8hu.R.inc(225);log.info("Input data has been saved successfully!");
        }

    }}finally{__CLR4_3_11v1vjvm4k8hu.R.flushNeeded();}}

    @FXML
    public void cancelNewGame() {try{__CLR4_3_11v1vjvm4k8hu.R.inc(226);
        __CLR4_3_11v1vjvm4k8hu.R.inc(227);input_pane.setVisible(false);
        __CLR4_3_11v1vjvm4k8hu.R.inc(228);error_message1.setVisible(false);
        __CLR4_3_11v1vjvm4k8hu.R.inc(229);main_menu.setVisible(true);
    }finally{__CLR4_3_11v1vjvm4k8hu.R.flushNeeded();}}

    @FXML
    public void loadGame() {try{__CLR4_3_11v1vjvm4k8hu.R.inc(230);
        __CLR4_3_11v1vjvm4k8hu.R.inc(231);main_menu.setVisible(false);

        __CLR4_3_11v1vjvm4k8hu.R.inc(232);tmp_sg = new SaveGame();
        __CLR4_3_11v1vjvm4k8hu.R.inc(233);ObservableList<SaveGame> sgs = FXCollections.observableList(sg.getSaves());

        __CLR4_3_11v1vjvm4k8hu.R.inc(234);sg_player1.setCellValueFactory(new PropertyValueFactory<>("player1"));
        __CLR4_3_11v1vjvm4k8hu.R.inc(235);sg_player2.setCellValueFactory(new PropertyValueFactory<>("player2"));
        __CLR4_3_11v1vjvm4k8hu.R.inc(236);sg_heap1.setCellValueFactory(new PropertyValueFactory<>("rocks1"));
        __CLR4_3_11v1vjvm4k8hu.R.inc(237);sg_heap2.setCellValueFactory(new PropertyValueFactory<>("rocks2"));
        __CLR4_3_11v1vjvm4k8hu.R.inc(238);sg_board.setItems(sgs);

        __CLR4_3_11v1vjvm4k8hu.R.inc(239);load_pane.setVisible(true);
    }finally{__CLR4_3_11v1vjvm4k8hu.R.flushNeeded();}}

    @FXML
    public void loadSelectedGame() {try{__CLR4_3_11v1vjvm4k8hu.R.inc(240);
        __CLR4_3_11v1vjvm4k8hu.R.inc(241);SaveGame selected = sg.loadGame(sg_board.getSelectionModel().getSelectedItem().getId());

        __CLR4_3_11v1vjvm4k8hu.R.inc(242);playerID1 = selected.getPlayer1();
        __CLR4_3_11v1vjvm4k8hu.R.inc(243);playerID2 = selected.getPlayer2();
        __CLR4_3_11v1vjvm4k8hu.R.inc(244);rocks1 = selected.getRocks1();
        __CLR4_3_11v1vjvm4k8hu.R.inc(245);rocks2 = selected.getRocks2();
        __CLR4_3_11v1vjvm4k8hu.R.inc(246);if((((selected.isActivePlayer())&&(__CLR4_3_11v1vjvm4k8hu.R.iget(247)!=0|true))||(__CLR4_3_11v1vjvm4k8hu.R.iget(248)==0&false))) {{
            __CLR4_3_11v1vjvm4k8hu.R.inc(249);player1_status = true;
            __CLR4_3_11v1vjvm4k8hu.R.inc(250);player2_status = false;
        }
        }else {{
            __CLR4_3_11v1vjvm4k8hu.R.inc(251);player1_status = false;
            __CLR4_3_11v1vjvm4k8hu.R.inc(252);player2_status = true;
        }


        }__CLR4_3_11v1vjvm4k8hu.R.inc(253);player1.setText(playerID1);
        __CLR4_3_11v1vjvm4k8hu.R.inc(254);player2.setText(playerID2);
        __CLR4_3_11v1vjvm4k8hu.R.inc(255);player2.setVisible(false);
        __CLR4_3_11v1vjvm4k8hu.R.inc(256);rocks_in_heap1.setText("" + rocks1);
        __CLR4_3_11v1vjvm4k8hu.R.inc(257);rocks_in_heap2.setText("" + rocks2);
        __CLR4_3_11v1vjvm4k8hu.R.inc(258);load_pane.setVisible(false);
        __CLR4_3_11v1vjvm4k8hu.R.inc(259);game_scene.setVisible(true);

        __CLR4_3_11v1vjvm4k8hu.R.inc(260);log.info("Game has been loaded successfully!");
    }finally{__CLR4_3_11v1vjvm4k8hu.R.flushNeeded();}}

    @FXML
    public void showLeaderboard() {try{__CLR4_3_11v1vjvm4k8hu.R.inc(261);
        __CLR4_3_11v1vjvm4k8hu.R.inc(262);ObservableList<Gamer> board = FXCollections.observableList(gs.getScoreboard());

        __CLR4_3_11v1vjvm4k8hu.R.inc(263);ids.setCellValueFactory(new PropertyValueFactory<>("id"));
        __CLR4_3_11v1vjvm4k8hu.R.inc(264);names.setCellValueFactory(new PropertyValueFactory<>("name"));
        __CLR4_3_11v1vjvm4k8hu.R.inc(265);scores.setCellValueFactory(new PropertyValueFactory<>("score"));
        __CLR4_3_11v1vjvm4k8hu.R.inc(266);scoreboard.setItems(board);

        __CLR4_3_11v1vjvm4k8hu.R.inc(267);main_menu.setVisible(false);
        __CLR4_3_11v1vjvm4k8hu.R.inc(268);score_pane.setVisible(true);
    }finally{__CLR4_3_11v1vjvm4k8hu.R.flushNeeded();}}

    private void changePlayer() {try{__CLR4_3_11v1vjvm4k8hu.R.inc(269);
        __CLR4_3_11v1vjvm4k8hu.R.inc(270);player1_status = !player1_status;
        __CLR4_3_11v1vjvm4k8hu.R.inc(271);player2_status = !player2_status;

        __CLR4_3_11v1vjvm4k8hu.R.inc(272);player1.setVisible(player1_status);
        __CLR4_3_11v1vjvm4k8hu.R.inc(273);player2.setVisible(player2_status);
    }finally{__CLR4_3_11v1vjvm4k8hu.R.flushNeeded();}}

    private void showErrorMessage2(String message) {try{__CLR4_3_11v1vjvm4k8hu.R.inc(274);
        __CLR4_3_11v1vjvm4k8hu.R.inc(275);error_message2.setText(message);
        __CLR4_3_11v1vjvm4k8hu.R.inc(276);error_message2.setVisible(true);
    }finally{__CLR4_3_11v1vjvm4k8hu.R.flushNeeded();}}

    public void initialize(URL url, ResourceBundle resourceBundle) {try{__CLR4_3_11v1vjvm4k8hu.R.inc(277);
        __CLR4_3_11v1vjvm4k8hu.R.inc(278);ObservableList<Gamer> top = FXCollections.observableList(gs.getTopPlayers());

        __CLR4_3_11v1vjvm4k8hu.R.inc(279);id.setCellValueFactory(new PropertyValueFactory<>("id"));
        __CLR4_3_11v1vjvm4k8hu.R.inc(280);name.setCellValueFactory(new PropertyValueFactory<>("name"));
        __CLR4_3_11v1vjvm4k8hu.R.inc(281);score.setCellValueFactory(new PropertyValueFactory<>("score"));
        __CLR4_3_11v1vjvm4k8hu.R.inc(282);top_players.setItems(top);

        __CLR4_3_11v1vjvm4k8hu.R.inc(283);main_menu.setVisible(true);
        __CLR4_3_11v1vjvm4k8hu.R.inc(284);game_scene.setVisible(false);
        __CLR4_3_11v1vjvm4k8hu.R.inc(285);input_pane.setVisible(false);
        __CLR4_3_11v1vjvm4k8hu.R.inc(286);winner_scene.setVisible(false);
        __CLR4_3_11v1vjvm4k8hu.R.inc(287);help_menu.setVisible(false);
        __CLR4_3_11v1vjvm4k8hu.R.inc(288);score_pane.setVisible(false);
        __CLR4_3_11v1vjvm4k8hu.R.inc(289);load_pane.setVisible(false);

        __CLR4_3_11v1vjvm4k8hu.R.inc(290);log.info("The game has been initialized successfully!");
    }finally{__CLR4_3_11v1vjvm4k8hu.R.flushNeeded();}}
}