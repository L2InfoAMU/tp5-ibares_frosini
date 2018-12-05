package image;

import javafx.scene.paint.Color;

import java.util.ArrayList;


public class PaletteRasterImage extends RasterImage {
    int [][] imagecolors;
    ArrayList<Color> palette;

    public PaletteRasterImage(Color color, int width, int height) {
        super(color, width, height);
    }

    public PaletteRasterImage(Color[][] colors) {
        super(colors);
    }


    public void createRepresentation () {

        this.imagecolors = new int[this.width][this.height];
        this.palette = new ArrayList<>();
    }

    public void setPixelColor(Color color, int x, int y){
        if (!palette.contains(color)){
            palette.add(color);
        }
        this.imagecolors[x][y] = palette.indexOf(color);
    }

    public Color getPixelColor(int x, int y) {

        return palette.get(imagecolors[x][y]);
    }


}
