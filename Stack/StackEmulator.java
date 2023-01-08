package Stack;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class StackEmulator {
        Map<String, Info> tableSymbol = new HashMap<>();
        String[] pile = new String[255];
        String[] program = null;
        int sp = 0;
        int pc = 0;
        boolean ret = false;
        int retpc = 0;
        boolean running = true;
        public StackEmulator(String program){
            this.program = program.split(" ");

            int i = 0;
            for(String instr:this.program){
                if(instr.contains(":"))
                    tableSymbol.put(instr.replace(":", ""),new Info(String.valueOf(i)));
                i++;
            }

            this.run();
        }

        void run(){
            while (running && pc < program.length){
                String instr = program[pc++];
                switch (instr) {
                    case "PUSH" -> push();
                    case "POP" -> pop();
                    case "ADD" -> add();
                    case "SUB" -> sub();
                    case "MUL" -> mul();
                    case "DIV" -> div();
                    case "MOD" -> mod();
                    case "LT" -> lower();
                    case "GT" -> greater();
                    case "LEQ" -> lower_equals();
                    case "GEQ" -> greater_equals();
                    case "EQ" -> equals();
                    case "NOT" -> not();
                    case "NEQ" -> not_equals();
                    case "DECLARE" -> declare();
                    case "DECLARRAY" -> declare_array();
                    case "MOV" -> mov();
                    case "LOAD" -> load();
                    case "GOTO" -> branch();
                    case "RETURN" -> Return();
                    case "JMP" -> jump();
                    case "HALT" -> halt();
                    case "PRINT" -> print();
                }
            }
        }

        void print(){
            if(this.tableSymbol.containsKey(this.pile[sp-1]))
                System.out.println(this.pile[sp-1] + " " + tableSymbol.get(this.pile[sp-1]).getValue());
            else
                System.out.println(this.pile[sp-1]);
        }
        void halt(){
            System.out.println("Machine halting ...");
            running = false;
        }
        void push(){
            pile[sp++] = program[pc];
        }

        String pop(){
            return pile[--sp];
        }

        void declare(){
            String opValue = pop();
            String opName = pop();
            tableSymbol.put(opName,new Info(opValue));
        }

        void declare_array(){
            List<String> buffer = new LinkedList<>();
            while(sp > 0){
                buffer.add( pop() );
            }
            String name = buffer.get(buffer.size()-1);
            buffer.remove(buffer.size()-1);
            tableSymbol.put(name, new Info(buffer.toArray(new String[0])));
        }


        void load(){
            String opName = pop();
            pile[sp++] = tableSymbol.get(opName).getValue();
        }

        void mov(){
            String opName = pop();
            String opValue = pop();
            if(tableSymbol.containsKey(opValue))
                opValue = tableSymbol.get(opValue).getValue();
            tableSymbol.get(opName).setValue(opValue);
        }

        void add() {
            int opLeft = Integer.parseInt(pop());
            int opRight = Integer.parseInt(pop());
            int res = opLeft + opRight;
            pile[sp++] = String.valueOf(res);
        }

        void sub() {
            int opLeft = Integer.parseInt(pop());
            int opRight = Integer.parseInt(pop());
            int res = opRight - opLeft;
            pile[sp++] = String.valueOf(res);
        }
        void mul() {
            int opLeft = Integer.parseInt(pop());
            int opRight = Integer.parseInt(pop());
            int res = opLeft * opRight;
            pile[sp++] = String.valueOf(res);
        }
        void div() {
            int opLeft = Integer.parseInt(pop());
            int opRight = Integer.parseInt(pop());
            int res = opLeft / opRight;
            pile[sp++] = String.valueOf(res);
        }
        void mod() {
            int opLeft = Integer.parseInt(pop());
            int opRight = Integer.parseInt(pop());
            int res = opLeft % opRight;
            pile[sp++] = String.valueOf(res);
        }

        void equals() {
            int opLeft = Integer.parseInt(pop());
            int opRight = Integer.parseInt(pop());
            if(opLeft == opRight)
                pile[sp++] = "true";
            else
                pile[sp++] = "false";
        }

        void lower() {
            int opLeft = Integer.parseInt(pop());
            int opRight = Integer.parseInt(pop());
            if(opLeft < opRight)
                pile[sp++] = "true";
            else
                pile[sp++] = "false";
        }

        void greater() {
            int opLeft = Integer.parseInt(pop());
            int opRight = Integer.parseInt(pop());
            if(opLeft > opRight)
                pile[sp++] = "true";
            else
                pile[sp++] = "false";
        }

        void greater_equals() {
            int opLeft = Integer.parseInt(pop());
            int opRight = Integer.parseInt(pop());
            if(opLeft >= opRight)
                pile[sp++] = "true";
            else
                pile[sp++] = "false";
        }
        void lower_equals() {
            int opLeft = Integer.parseInt(pop());
            int opRight = Integer.parseInt(pop());
            if(opLeft >= opRight)
                pile[sp++] = "true";
            else
                pile[sp++] = "false";
        }

        void not() {
            String opLeft = pop();
            if(opLeft.equals("false"))
                pile[sp++] = "true";
            else
                pile[sp++] = "false";
        }

        void not_equals() {
            equals();
            not();
        }

        void branch(){
            String opLabel = pop();
            String opCond = pop();
            if(opCond.equals("true"))
            {
                retpc = pc;
                pc = Integer.parseInt(tableSymbol.get(opLabel).getValue());
            }
        }

        void Return(){
            pc = retpc+1;
        }

        void jump(){
            int unit = Integer.parseInt(pop());
            String opCond = pop();
            if(opCond.equals("true")) {
                pc = pc + unit;
            }
        }

    }
