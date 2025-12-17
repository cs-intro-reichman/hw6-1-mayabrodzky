import java.awt.Color;
/**
 * Demonstrates the morphing operation featured by Runigram.java. 
 * The program recieves two command-line arguments: a string representing the name
 * of the PPM file of a source image, and the number of morphing steps (n). 
 * For example, to morph thor.ppm to its greyscaled version in 50 steps, use:
 * java Editor4 thor.ppm 50
 */
public class Editor4 {

    public static void main (String[] args) {
        String fileName = args[0];
        int n = Integer.parseInt(args[1]);

        Color[][] sourceImage = Runigram.read(fileName);
        
        Color[][] targetImage = Runigram.grayScaled(sourceImage);

        Runigram.setCanvas(sourceImage);
        
        int height = sourceImage.length;
        int width = sourceImage[0].length;
        StdDraw.setCanvasSize(width, height);
        StdDraw.setXscale(0, width);
        StdDraw.setYscale(0, height);
        StdDraw.enableDoubleBuffering();

        Runigram.morph(sourceImage, targetImage, n);
    }
}