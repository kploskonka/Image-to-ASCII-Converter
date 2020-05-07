package pl.ksoai;

import ij.IJ;
import ij.ImagePlus;
import pl.ksoai.converter.AsciiConverter;

public class Main {

    public static void main(String[] args) {
        ImagePlus image = IJ.openImage("src/main/resources/sample.jpg");
        AsciiConverter converter = AsciiConverter.getInstance();

        int height = image.getHeight();
        int width = image.getWidth();

        System.out.println("Successfully loaded image!");
        System.out.println("Image size: " + width + " x " + height);

        converter.printAsciiImage(image);
    }
}
