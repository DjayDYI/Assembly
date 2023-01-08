package Compiler;

import Statement.Instructions;

import java.util.ArrayList;

public class Compiler {

    String[] str;
    ArrayList<Instructions> instr = new ArrayList<>();
    ArrayList<String> instructions= new ArrayList<>();
    String strend="";

    Compiler(String str){
        str = str.replace("+", "ADD");
        str = str.replace("-", "SUB");
        str = str.replace("*", "MUL");
        str = str.replace("/", "DIV");
        str = str.replace("%", "MOD");
        str = str.replace("<", "LT");
        str = str.replace(">", "GT");
        str = str.replace(">=", "GEQ");
        str = str.replace("<=", "LEQ");
        str = str.replace("==", "EQ");
        str = str.replace("!=", "NEQ");
        str = str.replace("=", "MOV");
        str = str.replace("var", "DECLARE");
        str = str.replace(";", " ; ");
        this.str = str.split(" ");


        for(String s:this.str){
            if(s.contains(":")){
                s = s.replace("\r\n", "");
                instructions.add(s);
                instr.add(Instructions.create(instructions));
                instructions.clear();
            }
            else if(s.equals(";")){
                instr.add(Instructions.create(instructions));
                instructions.clear();
            }else{
                if(!s.equals("")&&!s.equals("\r\n")) {
                    s = s.replace("\r\n", "");
                    instructions.add(s);
                }
            }
        }

        for(Instructions stmt:instr){
            strend += stmt.parse();
        }

    }

    public String getStrend() {
        return strend;
    }

}
