package Statement;

import Statement.Instructions;

import java.util.ArrayList;

public class LabelInstructions extends Instructions {
    public LabelInstructions(ArrayList<String> instructions) {
        super(instructions);
    }

    @Override
    public String parse() {
        return " "+context.get(0)+" ";
    }
}
