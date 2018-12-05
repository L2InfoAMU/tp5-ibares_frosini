package image;

import javafx.scene.paint.Color;

import java.util.HashMap;

public class SparseRasterImage extends RasterImage {

    HashMap<Point,Color> image;

    public SparseRasterImage(Color color, int width, int height) {
        super(color, width, height);
    }

    public SparseRasterImage(Color[][] colors) {
        super(colors);
    }


    @Override
    public void setPixelColor(Color color, int x, int y) {
        Point point = new Point(x,y);
        if (image.containsKey(point)){
            image.remove(point);
        }
        image.put(point,color);
    }

    @Override
    public void createRepresentation() {
        this.image = new HashMap<>();
    }

    @Override
    public Color getPixelColor(int x, int y) {
        return image.get(new Point(x,y));
    }
}
