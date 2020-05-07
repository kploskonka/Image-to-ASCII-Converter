package pl.ksoai.converter;

import ij.ImagePlus;
import pl.ksoai.util.ImageUtil;

public class AsciiConverter {

    private static AsciiConverter instance = null;

    private AsciiConverter() {
    }

    public static AsciiConverter getInstance() {
        if (instance == null) {
            instance = new AsciiConverter();
        }

        return instance;
    }

    private char[] asciiChars = {'`', '^', '"', ',', ':', ';', 'I', 'l', '!', 'i', '~', '+', '_', '-', '?', ']', '[', '}', '{', '1',
            ')', '(', '|', '\\', '/', 't', 'f', 'j', 'r', 'x', 'n', 'u', 'c', 'z', 'X', 'Y', 'U', 'J', 'C', 'L', 'Q', '0', 'O', 'Z', 'm',
            'w', 'q', 'p', 'd', 'b', 'k', 'h', 'a', 'o', '*', '#', 'M', 'W', '&', '8', '%', 'B', '@', '$'};

    private char[] brightnessToAscii(int[] brightnessMatrix) {
        char[] asciiMatrix = new char[brightnessMatrix.length];

        for (int i = 0; i < asciiMatrix.length; i++) {

            for (int j = 0; j < 256; j += 4) {
                if (brightnessMatrix[i] >= j && brightnessMatrix[i] < j + 4) {
                    asciiMatrix[i] = asciiChars[j / 4];
                }
            }
        }

        return asciiMatrix;
    }

    public void printAsciiImage(ImagePlus image) {
        ImageUtil imageUtil = ImageUtil.getInstance();
        int[] brightnessMatrix = imageUtil.pixelsToBrightnessMatrix(image);
        char[] asciiMatrix = brightnessToAscii(brightnessMatrix);

        int width = image.getWidth();

//        for (int i = 0; i < asciiMatrix.length; i++) {
//            if (i == width - 1) {
//                System.out.println();
//                width += image.getWidth();
//            } else {
//                System.out.print(asciiMatrix[i]);
//            }
//        }
    }

}
