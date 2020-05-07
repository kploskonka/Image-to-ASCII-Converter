package pl.ksoai.util;

import ij.ImagePlus;

public class ImageUtil {

    private static ImageUtil instance = null;

    private ImageUtil() {}

    public static ImageUtil getInstance() {
        if (instance == null) {
            instance = new ImageUtil();
        }

        return instance;
    }

    private int[][] pixelsToRgbMatrix(ImagePlus image) {
        int[][] pixelMatrix = new int[image.getWidth() * image.getHeight()][4];

        int i = 0;
        for (int j = 0; j < image.getWidth(); j++) {
            for (int k = 0; k < image.getHeight(); k++) {
                int[] rgb = image.getPixel(j, k).clone();
                pixelMatrix[i] = rgb;
                i++;
            }
        }

        return pixelMatrix;
    }

    public int[] pixelsToBrightnessMatrix(ImagePlus image) {
        int[][] rgbMatrix = pixelsToRgbMatrix(image);
        int[] brightnessMatrix = new int[image.getWidth() * image.getHeight()];

        for (int i = 0; i < brightnessMatrix.length; i++) {
            brightnessMatrix[i] = (rgbMatrix[i][0] + rgbMatrix[i][1] + rgbMatrix[i][2]) / 3;
        }

        return brightnessMatrix;
    }

}
