package Statement;

import java.util.ArrayList;

public class Instructions implements Table {

    ArrayList<String> context = new ArrayList<>();

    Instructions(ArrayList<String> ctx){
        context.addAll(ctx);
    }

    protected void flip()
    {
        for(int i=0;i<context.size()-1;i=i+2)
        {
            String s = context.get(i);
            context.remove(i);
            context.add(i+1, s);
        }
    }

    public static Instructions create(ArrayList<String> instructions){
        if(instructions.get(0).contains(":")){return new LabelInstructions(instructions);}
        else if(instructions.get(0).equals("if")){return new IfInstructions(instructions);}
        else if(instructions.get(0).equals("print")){return new PrintInstructions(instructions);}
        else if(instructions.get(0).equals("goto")){return new GotoInstructions(instructions);}
        else if(instructions.get(0).equals("DECLARE")){return new VariableInstructions(instructions);}
        else if(instructions.get(1).equals("MOV")){return new ReassignationInstructions(instructions);}
        else return new ExpressionInstructions(instructions);
    }

    public String parse() {
        return null;
    }
}
