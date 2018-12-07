package image;

import javafx.scene.paint.Color;
import java.util.ArrayList;
import java.util.List;

public class VectorImage implements Image {

    private List<Shape> shapes;
    private int width;
    private int height;

    public VectorImage (List<Shape>shapes, int width, int height){
        this.shapes = new ArrayList<>();
        for (Shape shape : shapes){
            this.shapes.add(shape);
        }
        setWidth(width);
        setHeight(height);
    }

    @Override
    public Color getPixelColor(int x, int y) {

        Point toSearch = new Point (x,y);
        for (Shape shape : this.shapes){
            if (shape.contains(toSearch)){
                return shape.getColor();
            }
        }
        return Color.WHITE;

    }

    @Override
    public int getWidth() {
        return this.width;
    }

    @Override
    public int getHeight() {
        return this.height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWidth(int width) {
        this.width = width;
    }
}
