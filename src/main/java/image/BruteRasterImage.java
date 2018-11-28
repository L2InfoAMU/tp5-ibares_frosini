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
        colors = new Color [this.width][this.height];
        for (Color[] col: colors) {
            Arrays.fill(col, color);
        }
    }

    public BruteRasterImage (Color[][] colors){

        requiresNonNull(colors);
        requiresNonZeroDimensions(colors);
        requiresRectangularMatrix(colors);
        this.colors = colors;
        this.width = getRowCount(colors);
        this.height = getColumnCount(colors);

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
