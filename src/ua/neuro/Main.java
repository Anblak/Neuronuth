package ua.neuro;


import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {


        Function function = new Function();

        int [][] binaryPicArray = function.convertPictureIntoArray(new File("20141204182214-google-says-rip-captcha-sort-of-1.jpeg"));

        int [][] binaryPicArrayWithoutNoise = function.cleanNoise(binaryPicArray);

        //int [][] binaryPicArrayRenderPicture = function.renderImage(binaryPicArrayWithoutNoise);

        function.createPicture(binaryPicArrayWithoutNoise);

    }


}
