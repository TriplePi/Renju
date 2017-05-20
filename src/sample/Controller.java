package sample;

import models.Collocation;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

import java.util.Arrays;

public class Controller {

    public ImageView[][] cells;
    public GridPane gamePane;

    public void getCoordinates(MouseEvent me) {
        System.out.println(((GridPane) me.getSource()).getColumnConstraints());
        start();
    }

    public void start() {
        System.out.println("start");
        cells = new ImageView[15][15];
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                cells[i][j] = new ImageView();
                cells[i][j].setFitHeight(46);
                cells[i][j].setFitWidth(46);
                cells[i][j].setId("iv_" + i + "_" + j);
                Image image = new Image("sample/one_cell.png", false);
                //cells[i][j].setOpacity(0);
                cells[i][j].setImage(image);
                gamePane.add(cells[i][j], i, j);
                cells[i][j].setOnMouseClicked((MouseEvent event) -> {
                    act((ImageView) event.getSource());
                });
            }
        }
    }

    public int[] parse(String s) {
        int first = s.indexOf('_');
        int second = s.lastIndexOf('_');

        int[] coords = {Integer.parseInt(s.substring(first + 1, second)), Integer.parseInt(s.substring(second + 1))};
        System.out.println(Arrays.toString(coords));
        return coords;
    }

    public void act(ImageView imageView) {
        int[] coords = parse(imageView.getId());
        if (Collocation.getCollocation().addStone(coords[0], coords[1]))
            if (!Collocation.getCollocation().getPlayer())
                imageView.setImage(new Image("sample/white_rock.png"));
            else imageView.setImage(new Image("sample/black_rock.png"));
    }

    public void skip() {
        Collocation.getCollocation().skip();
    }
}
