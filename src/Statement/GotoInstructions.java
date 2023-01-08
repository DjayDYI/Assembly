package Statement;

import java.util.ArrayList;

public class GotoInstructions extends Instructions {
    public GotoInstructions(ArrayList<String> instructions) {
        super(instructions);
    }

    @Override
    public String parse() {
        return "GOTO "+ context.get(1);
    }
}
