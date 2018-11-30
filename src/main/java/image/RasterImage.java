package image;

import javafx.scene.paint.Color;
import static util.Matrices.*;

abstract class RasterImage implements Image {

    int width;
    int height;

    public RasterImage (Color color, int width, int height){
        setWidth(width);
        setHeight(height);
        createRepresentation();
        setPixelsColor(color);
    }

    public RasterImage (Color[][] colors){

        requiresNonNull(colors);
        requiresNonZeroDimensions(colors);
        requiresRectangularMatrix(colors);
        setWidth(getRowCount(colors));
        setHeight(getColumnCount(colors));
        createRepresentation();
        setPixelsColor(colors);

    }

    public abstract void setPixelColor(Color color, int x, int y);

    public abstract void createRepresentation ();

    private void setPixelsColor(Color[][] pixels){

        for (int i = 0; i < this.width; i++){
            for (int j = 0; j < this.height; j++) {
                setPixelColor(pixels[i][j],i,j);
            }
        }
    }

    private void setPixelsColor(Color color){

        for (int i = 0; i < this.width; i++){
            for (int j = 0; j < this.height; j++) {
                setPixelColor(color,i,j);
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
    public int getWidth() {

        return this.width;
    }

    @Override
    public int getHeight() {

        return this.height;
    }

}
