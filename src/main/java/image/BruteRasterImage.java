package image;

import javafx.scene.paint.Color;
import java.util.Arrays;
import static java.util.Arrays.*;
import static util.Matrices.*;


public class BruteRasterImage implements Image {

    int width;
    int height;
    Color [][] colors;

    public BruteRasterImage (Color color, int width, int height){
        this.width = width;
        this.height = height;
        createRepresentation();
        for (int i = 0; i < this.width; i++){
            for (int j =0; j < this.height; j++){
                this.colors[i][j] = color;
            }
        }
    }

    public BruteRasterImage (Color[][] colors){

        requiresNonNull(colors);
        requiresNonZeroDimensions(colors);
        requiresRectangularMatrix(colors);
        this.width = getRowCount(colors);
        this.height = getColumnCount(colors);
        createRepresentation();
        for (int i = 0; i < this.width; i++){
            for (int j = 0; j < this.height; j++){
                this.colors[i][j] = colors[i][j];
            }
        }


    }

    public void createRepresentation () {
        this.colors = new Color[this.width][this.height];
    }


    @Override
    public Color getPixelColor(int x, int y) {
        return colors[x][y];
    }

    @Override
    public int getWidth() {
        return this.width;
    }

    @Override
    public int getHeight() {
        return this.height;
    }
}
