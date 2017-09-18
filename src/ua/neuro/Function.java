package ua.neuro;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class Function {

    static int column=600;
    static int row=800;

    public  int[][] convertPictureIntoArray(File file) throws IOException {

        BufferedImage bufferedImage = ImageIO.read(file);
        int[][] mas = new int[bufferedImage.getHeight()][bufferedImage.getWidth()];


        System.err.println("height : "+bufferedImage.getHeight());
        System.err.println("width : "+bufferedImage.getWidth());
        for (int i = 0; i < bufferedImage.getHeight()-1; i++) {
            for (int j = 0; j < bufferedImage.getWidth()-1; j++) {
//                System.err.println("i : " + i);
//                System.err.println("j : " + j);

                Color col = new Color(bufferedImage.getRGB(j, i));
                int red = col.getRed();
                int green = col.getGreen();
                int blue = col.getBlue();
                if (red < 200 && green < 200 && blue < 200) {
                    mas[i][j] = 1;
                } else {
                    mas[i][j] = 0;
                }

            }
        }
        return mas;
    }

    public int[][] cleanNoise(int [][] array){
        for (int i = 1; i < array.length; i++) {
            for (int j = 1; j < array[0].length; j++) {
                if (array[i][j] != 0 && (array[i - 1][j] == 0 ||
                        array[i + 1][j] == 0 || array[i][j - 1] == 0 || array[i][j + 1] == 0 || array[i -1][j - 1] == 0
                        || array[i+1][j - 1] == 0 ||array[i-1][j + 1] == 0 ||array[i+1][j + 1] == 0 )) {
                    array[i][j] = 2;
                }
            }
        }
        for (int i = 1; i < array.length; i++) {
            for (int j = 1; j < array[0].length; j++) {
                if (array[i][j] == 2) {
                    array[i][j] = 0;
                }
            }
        }

        return array;
    }


    public void createPicture(int [][] array) throws IOException {
        File fileOutput = new File("outFirstTry.png");

        BufferedImage bf = new BufferedImage(array[0].length, array.length, BufferedImage.TYPE_INT_BGR);

        for (int i = 0; i <  array.length; i++) {
            for (int j = 0; j <array[0].length; j++) {

                if(array[i][j]==1){
                    bf.setRGB(j,i, Color.BLACK.getRGB());
                }else {
                    bf.setRGB(j,i, Color.WHITE.getRGB());

                }

            }
        }

        ImageIO.write(bf, "png", fileOutput);

    }

    public int[][] renderImage(int [][] array){
        for (int i = 1; i < column; i++) {
            for (int j = 1; j < row; j++) {
                if (!(array[i][j] != 0 && (array[i - 1][j] == 0 ||
                        array[i + 1][j] == 0 || array[i][j - 1] == 0 || array[i][j + 1] == 0))) {
                    array[i][j] = 1;
                }
            }
        }

        return array;
    }



}
