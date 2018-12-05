package image;

import javafx.scene.paint.Color;

public class Rectangle implements Shape {
    int x;
    int y;
    int width;
    int height;
    Color color;

    public Rectangle(int x, int y, int width, int height, Color color){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
    }


    @Override
    public boolean contains(Point point) {
        return ((this.x <= point.x)&& (point.x <= this.width) && (this.y <= point.y)&& (point.y <= this.height));
    }

    @Override
    public Color getColor() {
        return this.color;
    }
}
