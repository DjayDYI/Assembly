package Statement;

import Statement.Instructions;

import java.util.ArrayList;

public class PrintInstructions extends Instructions {
    public PrintInstructions(ArrayList<String> instr) {
        super(instr);
    }

    @Override
    public String parse() {
        return "PRINT" + " " + context.get(1);
    }
}
