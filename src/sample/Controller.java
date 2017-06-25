package sample;

import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import models.AI;
import models.Collocation;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class Controller {

    //public ImageView[][] cells;
    //public GridPane gamePane;
    public Pane A1;
    public Pane A2;
    public Pane A3;
    public Pane A4;
    public Pane A5;
    public Pane A6;
    public Pane A7;
    public Pane A8;
    public Pane A9;
    public Pane A10;
    public Pane A11;
    public Pane A12;
    public Pane A13;
    public Pane A14;
    public Pane A15;

    public Pane B1;
    public Pane B2;
    public Pane B3;
    public Pane B4;
    public Pane B5;
    public Pane B6;
    public Pane B7;
    public Pane B8;
    public Pane B9;
    public Pane B10;
    public Pane B11;
    public Pane B12;
    public Pane B13;
    public Pane B14;
    public Pane B15;

    public Pane C1;
    public Pane C2;
    public Pane C3;
    public Pane C4;
    public Pane C5;
    public Pane C6;
    public Pane C7;
    public Pane C8;
    public Pane C9;
    public Pane C10;
    public Pane C11;
    public Pane C12;
    public Pane C13;
    public Pane C14;
    public Pane C15;

    public Pane D1;
    public Pane D2;
    public Pane D3;
    public Pane D4;
    public Pane D5;
    public Pane D6;
    public Pane D7;
    public Pane D8;
    public Pane D9;
    public Pane D10;
    public Pane D11;
    public Pane D12;
    public Pane D13;
    public Pane D14;
    public Pane D15;

    public Pane E1;
    public Pane E2;
    public Pane E3;
    public Pane E4;
    public Pane E5;
    public Pane E6;
    public Pane E7;
    public Pane E8;
    public Pane E9;
    public Pane E10;
    public Pane E11;
    public Pane E12;
    public Pane E13;
    public Pane E14;
    public Pane E15;

    public Pane F1;
    public Pane F2;
    public Pane F3;
    public Pane F4;
    public Pane F5;
    public Pane F6;
    public Pane F7;
    public Pane F8;
    public Pane F9;
    public Pane F10;
    public Pane F11;
    public Pane F12;
    public Pane F13;
    public Pane F14;
    public Pane F15;

    public Pane G1;
    public Pane G2;
    public Pane G3;
    public Pane G4;
    public Pane G5;
    public Pane G6;
    public Pane G7;
    public Pane G8;
    public Pane G9;
    public Pane G10;
    public Pane G11;
    public Pane G12;
    public Pane G13;
    public Pane G14;
    public Pane G15;

    public Pane H1;
    public Pane H2;
    public Pane H3;
    public Pane H4;
    public Pane H5;
    public Pane H6;
    public Pane H7;
    public Pane H8;
    public Pane H9;
    public Pane H10;
    public Pane H11;
    public Pane H12;
    public Pane H13;
    public Pane H14;
    public Pane H15;

    public Pane I1;
    public Pane I2;
    public Pane I3;
    public Pane I4;
    public Pane I5;
    public Pane I6;
    public Pane I7;
    public Pane I8;
    public Pane I9;
    public Pane I10;
    public Pane I11;
    public Pane I12;
    public Pane I13;
    public Pane I14;
    public Pane I15;

    public Pane J1;
    public Pane J2;
    public Pane J3;
    public Pane J4;
    public Pane J5;
    public Pane J6;
    public Pane J7;
    public Pane J8;
    public Pane J9;
    public Pane J10;
    public Pane J11;
    public Pane J12;
    public Pane J13;
    public Pane J14;
    public Pane J15;

    public Pane K1;
    public Pane K2;
    public Pane K3;
    public Pane K4;
    public Pane K5;
    public Pane K6;
    public Pane K7;
    public Pane K8;
    public Pane K9;
    public Pane K10;
    public Pane K11;
    public Pane K12;
    public Pane K13;
    public Pane K14;
    public Pane K15;

    public Pane L1;
    public Pane L2;
    public Pane L3;
    public Pane L4;
    public Pane L5;
    public Pane L6;
    public Pane L7;
    public Pane L8;
    public Pane L9;
    public Pane L10;
    public Pane L11;
    public Pane L12;
    public Pane L13;
    public Pane L14;
    public Pane L15;

    public Pane M1;
    public Pane M2;
    public Pane M3;
    public Pane M4;
    public Pane M5;
    public Pane M6;
    public Pane M7;
    public Pane M8;
    public Pane M9;
    public Pane M10;
    public Pane M11;
    public Pane M12;
    public Pane M13;
    public Pane M14;
    public Pane M15;

    public Pane N1;
    public Pane N2;
    public Pane N3;
    public Pane N4;
    public Pane N5;
    public Pane N6;
    public Pane N7;
    public Pane N8;
    public Pane N9;
    public Pane N10;
    public Pane N11;
    public Pane N12;
    public Pane N13;
    public Pane N14;
    public Pane N15;

    public Pane O1;
    public Pane O2;
    public Pane O3;
    public Pane O4;
    public Pane O5;
    public Pane O6;
    public Pane O7;
    public Pane O8;
    public Pane O9;
    public Pane O10;
    public Pane O11;
    public Pane O12;
    public Pane O13;
    public Pane O14;
    public Pane O15;

    public HashSet<Pane> flowPanes = new HashSet<>();
    public Label statusBar;

    public boolean playable = true;
    public boolean isBotActivated = false;

    public void getCoordinates(MouseEvent me) {
        System.out.println(((GridPane) me.getSource()).getColumnConstraints());
        start();
    }

    public void start() {
        isBotActivated = true;
//        System.out.println("start");
//        H7.getChildren().add(new ImageView(new Image("sample/black_rock.png")));
//        Class clas = Controller.class;
//        Field[] fields = clas.getFields();
//        System.out.println(fields.length);
//        System.out.println(fields[0].getName());
//        Pane[][] cells = new Pane[15][15];
//        Pane instanseOfFlowPane = new Pane();
//        Pane flowPane = null;
//        try {
//            flowPane = (FlowPane) fields[20].get(instanseOfFlowPane);
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        }
//        flowPane.getChildren().add(new ImageView(new Image("sample/black_rock.png")));
//        if(fields[0].getType().equals(FlowPane.class))
//        try {
//            ((FlowPane) fields[0].get(instanseOfFlowPane)).getChildren().add(new ImageView(new Image("sample/black_rock.png")));
//            ((FlowPane) fields[150].get(instanseOfFlowPane)).getChildren().add(new ImageView(new Image("sample/black_rock.png")));
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        }
////        for (int i = 0; i < 15; i++) {
//            for (int j = 0; j < 15; j++) {
//                fields[i * 15 + j].setAccessible(true);
//                try {
//                    cells[i][j] = (FlowPane) fields[i * 15 + j].get(instanseOfFlowPane);
//                } catch (IllegalAccessException e) {
//                    e.printStackTrace();
//                }
//                cells[i][j].setOnMouseClicked((MouseEvent event) -> {
//                    act((FlowPane) event.getSource());
//                });
//            }
    }
//        cells = new ImageView[15][15];
//        for (int i = 0; i < 15; i++) {
//            for (int j = 0; j < 15; j++) {
//                cells[i][j] = new ImageView();
//                cells[i][j].setFitHeight(46);
//                cells[i][j].setFitWidth(46);
//                cells[i][j].setId("iv_" + i + "_" + j);
//                Image image = new Image("sample/one_cell.png", false);
//                //cells[i][j].setOpacity(0);
//                cells[i][j].setImage(image);
//                gamePane.add(cells[i][j], i, j);
//                cells[i][j].setOnMouseClicked((MouseEvent event) -> {
//                    act((ImageView) event.getSource());
//                });
//            }


    public int[] parse(String s) {
        //System.out.println(s);
        ArrayList forParsing = new ArrayList() {
        };
        forParsing.addAll(Arrays.asList('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O'));
        int[] coords = {forParsing.indexOf(s.charAt(0)), Integer.parseInt(s.substring(1)) - 1};
        //System.out.println(Arrays.toString(coords));
        return coords;
    }

    public String unparse(int[] coords){
        ArrayList forParsing = new ArrayList() {
        };
        forParsing.addAll(Arrays.asList('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O'));
        return forParsing.get(coords[0])+Integer.toString(coords[1]+1);
    }

    public void act(MouseEvent e) {
        if (playable) {
            Pane flowPane = (Pane) e.getSource();
            flowPanes.add(flowPane);
            int[] coords = parse(flowPane.getId());
            Collocation.getCollocation().addStone(coords[0], coords[1]);
            int check = Collocation.getCollocation().check();
            statusBar.setText(Integer.toString(check));
            if (check == -1 || check == 2 || check == -2)
                playable = false;
            flowPane.getChildren().retainAll();
            if (!Collocation.getCollocation().getPlayer())
                flowPane.getChildren().add(new ImageView(new Image("sample/white_rock.png")));
            else flowPane.getChildren().add(new ImageView(new Image("sample/black_rock.png")));
            if (isBotActivated && Collocation.getCollocation().check()==0)
                botAct();
        }
    }

    public void botAct() {
        AI ai = new AI();
        int[] move = ai.calculate();
        System.out.println("taks taks "+Arrays.toString(move));
        if (move != null) {
            Class clazz = Controller.class;
            try {
                ((Pane)clazz.getField(unparse(move)).get(this)).getChildren().add(new ImageView(new Image("sample/white_rock.png")));
            } catch (NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace();
            }
            Collocation.getCollocation().addStone(move[0], move[1]);

        }
    }

    public void skip() {
        Collocation.getCollocation().skip();
    }

    public void restart() {
        System.out.println("wtf");
        Collocation.restart();
        for (Pane flowPane : flowPanes) {
            flowPane.getChildren().retainAll();
        }
        playable = true;
        isBotActivated = false;
    }

    public void highlight(MouseEvent e) {
        Pane pane = (Pane) e.getSource();
        Rectangle rectangle = new Rectangle(57, 57);
        rectangle.setFill(Color.LIGHTGREEN);
        rectangle.setOpacity(0.5);
        pane.getChildren().add(rectangle);
    }

    public void lowlight(MouseEvent e) {
        Pane pane = (Pane) e.getSource();
        Rectangle rectangle = null;
        for (Node node : pane.getChildren()) {
            if (node instanceof Rectangle)
                rectangle = (Rectangle) node;
        }
        pane.getChildren().remove(rectangle);
    }

}
