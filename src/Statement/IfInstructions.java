package Statement;

import java.util.ArrayList;

public class IfInstructions extends Instructions {
    public IfInstructions(ArrayList<String> instr) {
        super(instr);
        context.remove(0);
         flip();
    }

    @Override
    public String parse() {
        return " "+ context.get(0) + " " +context.get(3) +" "+ context.get(1)+" GOTO "+context.get(2)+ " ";
    }
}
