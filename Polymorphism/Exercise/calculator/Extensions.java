package Polymorphism.Exercise.calculator;

import java.util.Stack;

public class Extensions {

    public static InputInterpreter buildInterpreter(CalculationEngine engine, Stack<Integer> memory) {
        return new InputInterpreter(engine, memory);
    }
}
