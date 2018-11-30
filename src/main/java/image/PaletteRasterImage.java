package image;

import javafx.scene.paint.Color;

import java.util.ArrayList;

import static util.Matrices.*;

public class PaletteRasterImage implements Image {
    int width;
    int height;
    Color [][] colors;
    ArrayList<Color> palette;

    public PaletteRasterImage (Color color, int width, int height){
        setWidth(width);
        setHeight(height);
        this.height = height;
        createRepresentation();
        palette.add(color);
        for (int i = 0; i < this.width; i++){
            for (int j =0; j < this.height; j++){
                this.colors[i][j] = color;
            }
        }
    }

    public PaletteRasterImage (Color[][] colors){

        requiresNonNull(colors);
        requiresNonZeroDimensions(colors);
        requiresRectangularMatrix(colors);
        setWidth(getRowCount(colors));
        setHeight(getColumnCount(colors));
        createRepresentation();
        for (int i = 0; i < this.width; i++){
            for (int j = 0; j < this.height; j++){
                if (!palette.contains(colors[i][j])){
                    palette.add(colors[i][j]);
                }
                this.colors[i][j] = colors[i][j];
            }
        }


    }

    public void createRepresentation () {

        this.colors = new Color[this.width][this.height];
        this.palette = new ArrayList<Color>();
    }

    public void setPixelColor(Color color, int x, int y){
        if (!palette.contains(color)){
            palette.add(color);
        }
        this.colors[x][y] = color;
    }

    private void setPixelsColor(Color[][] pixels){

        for (int i = 0; i < this.width; i++){
            for (int j = 0; j < this.height; j++) {
                if (!palette.contains(colors[i][j])){
                    palette.add(colors[i][j]);
                }
                this.colors[i][j] = pixels[i][j];
            }
        }
    }

    private void setPixelsColor(Color color){

        for (int i = 0; i < this.width; i++){
            for (int j = 0; j < this.height; j++) {
                if (!palette.contains(colors[i][j])){
                    palette.add(colors[i][j]);
                }
                this.colors[i][j] = color;
            }
        }
    }

    protected void setWidth(int width){

        this.width = width;
    }

    protected void setHeight(int height){

        this.height = height;
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
