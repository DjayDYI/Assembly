package Statement;

import Statement.Instructions;

import java.util.ArrayList;

public class ReassignationInstructions extends Instructions {
    public ReassignationInstructions(ArrayList<String> instr) {
        super(instr);
        flip();
    }

    @Override
    public String parse() {
        // reassign
        if(context.size() == 5) {
            // two instructions in one Add,sub,mul,div then assign with mov
            return context.get(2) + " " + context.get(3) + " " + context.get(4) + " MOV " + context.get(1) + " ";
        }else {
            return "MOV " + context.get(1) + " " + context.get(2);
        }
    }
}
