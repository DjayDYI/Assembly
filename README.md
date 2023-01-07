# Assembly
Wanted to do one for a long time, here it is Stack Machine Push Pop assembly langugage  

### Machine Itself
The machine is a emulator it work in a queue way. First-in-first-out! I know stack based machine working in a queue way?
Here it is : `PUSH 4` followed by `PUSH 5` will put the `stack pointer to 5` wich is the top of te stack.

Exemple : `for loop`
```
  PUSH x PUSH 1 DECLARE 
  LABEL:
  PUSH x LOAD PUSH 1 ADD
  PUSH X MOV
  PUSH 5 PUSH x LOAD
  LT PUSH LABEL GOTO
```

### Generator


Before calling a goto you need to push true into the stack `PUSH true` and then `GOTO Label`
```
PUSH true
GOTO label
```

It is made so to simplify branch operation from comaparaison `eq 1 x` will push `true` or `false` on the stack and then execute the command `GOTO label` according to the stack. If the stack point to `false` then it wont branch if it point to `true` then it will modify the `pc` according to the program! The instruction will move the top of the stack into `i` wich is `i+1` 
```
ADD i 1
MOV i
```

The generator simplify the writing 
```
PUSH 2 PUSH 3 ADD       | 2 3 ADD | ADD 2 3
PUSH x LOAD PUSH 1 ADD  | x 1 ADD | ADD 1 x
PUSH 2 PUSH x LOAD MOV  | 2 x MOV | MOV x 2
```
It transform the for loop example into 
```
  DECLARE i2 0
  ForLoop:
  ADD i2 1
  MOV i2
  PRINT i2
  LT 5 i2
  GOTO ForLoop
```
Here is more clever example:
```
Main:
    DECLARE i 2
    ADD i 1
    MOV i
    PRINT i
    EQ 5 i GOTO Label

Labelse:
    PRINT "tabelse"
    ADD i 2
    MOV i
    PRINT i
    PUSH true
    GOTO Labelfin

Label:
    PRINT "tabif"
    PRINT i
    PUSH true
    GOTO Labelfin

Labelfin:
```



