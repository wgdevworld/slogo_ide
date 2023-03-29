package slogo.model.commands.allcommands;

import java.util.ArrayList;
import java.util.List;

import slogo.model.Turtle;
import slogo.model.commands.Commands;

public class Product extends Commands {

    private double a;
    private double b;
    private double value;

    public Product() {
        a = 0;
        b = 0;
        value = 0;
    }

    public Product(List<String> params) {
        a = Double.parseDouble(params.get(0));
        b = Double.parseDouble(params.get(1));
        value = prodValue(a, b);
    }

    @Override
    public double setBehavior(ArrayList<Double> paramList, Turtle turtle) {
        a = paramList.get(0);
        b = paramList.get(1);
        value = prodValue(a, b);
        return value;

    }
    @Override
    public double execute(Turtle turtle) {
        return value;
    }

    private Double prodValue(double first, double second) {
        return first * second;
    }
}
