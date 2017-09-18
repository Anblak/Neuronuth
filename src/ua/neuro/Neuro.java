package ua.neuro;


public class Neuro {

    private String name;
    private byte [][] input;
    private double weight;
    private byte [][] output;

    public Neuro(String name, byte[][] input, double weight, byte[][] output) {
        this.name = name;
        this.input = input;
        this.weight = weight;
        this.output = output;
    }

    public Neuro(String name, byte[][] input) {
        this.name = name;
        this.input = input;
    }

    public Neuro() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[][] getInput() {
        return input;
    }

    public void setInput(byte[][] input) {
        this.input = input;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public byte[][] getOutput() {
        return output;
    }

    public void setOutput(byte[][] output) {
        this.output = output;
    }
}
