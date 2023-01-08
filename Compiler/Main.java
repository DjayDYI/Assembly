package Compiler;

import Stack.Generator;
import Stack.StackEmulator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main{
    public static void main(String[] args) throws IOException {
        Main m = new Main();
        Path fileName = Path.of(args[0]);
        m.init(Files.readString(fileName));
    }
    void init(String file)
    {
        Compiler sugarCoating = new Compiler(file);
        String or = sugarCoating.getStrend();
        Generator program = new Generator(or);
        StackEmulator emu = new StackEmulator(program.toString());
    }

}