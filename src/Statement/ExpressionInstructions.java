package Statement;

import java.util.ArrayList;

public class ExpressionInstructions extends Instructions {


    ExpressionInstructions(ArrayList<String> ctx) {
        super(ctx);
        flip();
    }

    public String parse()
    {
        return context.get(0)+ " " +context.get(1) + " " +context.get(2);
    }

}
