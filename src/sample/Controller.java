package sample;

import javafx.scene.layout.FlowPane;
import models.Collocation;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Controller {

    //public ImageView[][] cells;
    //public GridPane gamePane;
    public FlowPane A1;
    public FlowPane A2;
    public FlowPane A3;
    public FlowPane A4;
    public FlowPane A5;
    public FlowPane A6;
    public FlowPane A7;
    public FlowPane A8;
    public FlowPane A9;
    public FlowPane A10;
    public FlowPane A11;
    public FlowPane A12;
    public FlowPane A13;
    public FlowPane A14;
    public FlowPane A15;

    public FlowPane B1;
    public FlowPane B2;
    public FlowPane B3;
    public FlowPane B4;
    public FlowPane B5;
    public FlowPane B6;
    public FlowPane B7;
    public FlowPane B8;
    public FlowPane B9;
    public FlowPane B10;
    public FlowPane B11;
    public FlowPane B12;
    public FlowPane B13;
    public FlowPane B14;
    public FlowPane B15;

    public FlowPane C1;
    public FlowPane C2;
    public FlowPane C3;
    public FlowPane C4;
    public FlowPane C5;
    public FlowPane C6;
    public FlowPane C7;
    public FlowPane C8;
    public FlowPane C9;
    public FlowPane C10;
    public FlowPane C11;
    public FlowPane C12;
    public FlowPane C13;
    public FlowPane C14;
    public FlowPane C15;

    public FlowPane D1;
    public FlowPane D2;
    public FlowPane D3;
    public FlowPane D4;
    public FlowPane D5;
    public FlowPane D6;
    public FlowPane D7;
    public FlowPane D8;
    public FlowPane D9;
    public FlowPane D10;
    public FlowPane D11;
    public FlowPane D12;
    public FlowPane D13;
    public FlowPane D14;
    public FlowPane D15;

    public FlowPane E1;
    public FlowPane E2;
    public FlowPane E3;
    public FlowPane E4;
    public FlowPane E5;
    public FlowPane E6;
    public FlowPane E7;
    public FlowPane E8;
    public FlowPane E9;
    public FlowPane E10;
    public FlowPane E11;
    public FlowPane E12;
    public FlowPane E13;
    public FlowPane E14;
    public FlowPane E15;

    public FlowPane F1;
    public FlowPane F2;
    public FlowPane F3;
    public FlowPane F4;
    public FlowPane F5;
    public FlowPane F6;
    public FlowPane F7;
    public FlowPane F8;
    public FlowPane F9;
    public FlowPane F10;
    public FlowPane F11;
    public FlowPane F12;
    public FlowPane F13;
    public FlowPane F14;
    public FlowPane F15;

    public FlowPane G1;
    public FlowPane G2;
    public FlowPane G3;
    public FlowPane G4;
    public FlowPane G5;
    public FlowPane G6;
    public FlowPane G7;
    public FlowPane G8;
    public FlowPane G9;
    public FlowPane G10;
    public FlowPane G11;
    public FlowPane G12;
    public FlowPane G13;
    public FlowPane G14;
    public FlowPane G15;

    public FlowPane H1;
    public FlowPane H2;
    public FlowPane H3;
    public FlowPane H4;
    public FlowPane H5;
    public FlowPane H6;
    public FlowPane H7;
    public FlowPane H8;
    public FlowPane H9;
    public FlowPane H10;
    public FlowPane H11;
    public FlowPane H12;
    public FlowPane H13;
    public FlowPane H14;
    public FlowPane H15;

    public FlowPane I1;
    public FlowPane I2;
    public FlowPane I3;
    public FlowPane I4;
    public FlowPane I5;
    public FlowPane I6;
    public FlowPane I7;
    public FlowPane I8;
    public FlowPane I9;
    public FlowPane I10;
    public FlowPane I11;
    public FlowPane I12;
    public FlowPane I13;
    public FlowPane I14;
    public FlowPane I15;

    public FlowPane J1;
    public FlowPane J2;
    public FlowPane J3;
    public FlowPane J4;
    public FlowPane J5;
    public FlowPane J6;
    public FlowPane J7;
    public FlowPane J8;
    public FlowPane J9;
    public FlowPane J10;
    public FlowPane J11;
    public FlowPane J12;
    public FlowPane J13;
    public FlowPane J14;
    public FlowPane J15;

    public FlowPane K1;
    public FlowPane K2;
    public FlowPane K3;
    public FlowPane K4;
    public FlowPane K5;
    public FlowPane K6;
    public FlowPane K7;
    public FlowPane K8;
    public FlowPane K9;
    public FlowPane K10;
    public FlowPane K11;
    public FlowPane K12;
    public FlowPane K13;
    public FlowPane K14;
    public FlowPane K15;

    public FlowPane L1;
    public FlowPane L2;
    public FlowPane L3;
    public FlowPane L4;
    public FlowPane L5;
    public FlowPane L6;
    public FlowPane L7;
    public FlowPane L8;
    public FlowPane L9;
    public FlowPane L10;
    public FlowPane L11;
    public FlowPane L12;
    public FlowPane L13;
    public FlowPane L14;
    public FlowPane L15;

    public FlowPane M1;
    public FlowPane M2;
    public FlowPane M3;
    public FlowPane M4;
    public FlowPane M5;
    public FlowPane M6;
    public FlowPane M7;
    public FlowPane M8;
    public FlowPane M9;
    public FlowPane M10;
    public FlowPane M11;
    public FlowPane M12;
    public FlowPane M13;
    public FlowPane M14;
    public FlowPane M15;

    public FlowPane N1;
    public FlowPane N2;
    public FlowPane N3;
    public FlowPane N4;
    public FlowPane N5;
    public FlowPane N6;
    public FlowPane N7;
    public FlowPane N8;
    public FlowPane N9;
    public FlowPane N10;
    public FlowPane N11;
    public FlowPane N12;
    public FlowPane N13;
    public FlowPane N14;
    public FlowPane N15;

    public FlowPane O1;
    public FlowPane O2;
    public FlowPane O3;
    public FlowPane O4;
    public FlowPane O5;
    public FlowPane O6;
    public FlowPane O7;
    public FlowPane O8;
    public FlowPane O9;
    public FlowPane O10;
    public FlowPane O11;
    public FlowPane O12;
    public FlowPane O13;
    public FlowPane O14;
    public FlowPane O15;


    public void getCoordinates(MouseEvent me) {
        System.out.println(((GridPane) me.getSource()).getColumnConstraints());
        start();
    }

    public void start() {
        System.out.println("start");
        H7.getChildren().add(new ImageView(new Image("sample/black_rock.png")));
        Class clas = Controller.class;
        Field[] fields = clas.getFields();
        System.out.println(fields.length);
        System.out.println(fields[0].getName());
        FlowPane[][] cells = new FlowPane[15][15];
        FlowPane instanseOfFlowPane = new FlowPane();
        try {
            ((FlowPane)fields[0].get(instanseOfFlowPane)).getChildren().add(new ImageView(new Image("sample/black_rock.png")));
            ((FlowPane)fields[150].get(instanseOfFlowPane)).getChildren().add(new ImageView(new Image("sample/black_rock.png")));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
//        for (int i = 0; i < 15; i++) {
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
        System.out.println(s);
        ArrayList forParsing = new ArrayList() {
        };
        forParsing.addAll(Arrays.asList('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O'));
        int[] coords = {forParsing.indexOf(s.charAt(0)), Integer.parseInt(s.substring(1))};
        System.out.println(Arrays.toString(coords));
        return coords;
    }

    public void act(MouseEvent e) {
        FlowPane flowPane = (FlowPane)e.getSource();
        int[] coords = parse(flowPane.getId());
        if (Collocation.getCollocation().addStone(coords[0], coords[1]))
            if (!Collocation.getCollocation().getPlayer())
                flowPane.getChildren().add(new ImageView(new Image("sample/white_rock.png")));
            else flowPane.getChildren().add(new ImageView(new Image("sample/black_rock.png")));
    }

    public void skip() {
        Collocation.getCollocation().skip();
    }
}
