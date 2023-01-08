package Statement;

import Statement.Instructions;

import java.util.ArrayList;

public class VariableInstructions extends Instructions {
    public VariableInstructions(ArrayList<String> instr) {
        super(instr);
    }

    @Override
    public String parse() {
        // declare
        table.put(context.get(1), context.get(3));
        return "DECLARE " + context.get(1) +" "+context.get(3)+" ";
    }
}
