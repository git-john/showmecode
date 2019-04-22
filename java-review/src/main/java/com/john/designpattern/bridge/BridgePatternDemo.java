package com.john.designpattern.bridge;

public class BridgePatternDemo {

    public static void main(String[] args) {
        Shape green = new Circle(1,1,1,new GreenCircle());
        Shape red = new Circle(1,1,1,new RedCircle());

        green.draw();
        red.draw();
    }
}
