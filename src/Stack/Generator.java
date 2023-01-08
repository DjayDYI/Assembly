package Stack;

/*
    Exemple d'utilisation
    DECLARE i 0
    ForLoop:
    ADD i 1
    MOV i
    PRINT i
    LT 5 i
    GOTO ForLoop

    DECLARE i 5
    ADD i 1
    MOV i
    PRINT i
    EQ 5 i
    GOTO Label
    Labelse:
    ADD i 2
    PRINT i
    Label:
    PRINT i
    GOTO Labelfin
    Labelfin:

 */
public class Generator {
    public static boolean isNumeric(String str) {
        return str != null && str.matches("[-+]?\\d*\\.?\\d+");
    }

    public String res(String x , String y)
    {
        String str = "PUSH "+ x + " ";
        if(!isNumeric(x))
            str = "PUSH "+ x +" LOAD ";

        if(!isNumeric(y))
            str += "PUSH "+y+" LOAD ";
        else
            str += "PUSH "+ y + " ";
        return str;
    }

    String PUSH(String x)
    {
        return "PUSH "+ x+ " ";
    }

    String POP(){
        return "POP";
    }

    String ADD(String x, String y)
    {
        return res(x, y) + " ADD ";
    }
    String SUB(String x, String y)
    {
        return res(x, y) + " SUB ";
    }
    String MUL(String x, String y)
    {
        return res(x, y) + " MUL ";
    }
    String DIV(String x, String y)
    {
        return res(x, y) + " DIV ";
    }
    String MOD(String x, String y)
    {
        return res(x, y) + " MOD ";
    }
    String LT(String x, String y, String z)
    {
        return res(x, y)+  " LT PUSH " + z + " GOTO";
    }
    String GT(String x, String y, String z)
    {
        return res(x, y)+  " GT PUSH " + z + " GOTO";
    }
    String LEQ(String x, String y, String z)
    {
        return res(x, y)+  " LEQ PUSH " + z + " GOTO";
    }
    String GEQ(String x, String y, String z)
    {
        return res(x, y)+  " GEQ PUSH " + z + " GOTO";
    }
    String NOT(String x)
    {
        return "PUSH "+ x + " NOT ";
    }
    String NEQ(String x, String y, String z)
    {
        return res(x, y)+  " NEQ PUSH " + z + " GOTO";
    }
    String EQ(String x, String y, String z)
    {
        return res(x, y)+  " EQ PUSH " + z + " GOTO";
    }
    String DECLARE(String x, String y)
    {
        return "PUSH "+ x + " PUSH " + y + " DECLARE ";
    }
    String LOAD(String x)
    {
        return "PUSH " + x + " LOAD ";
    }
    String MOV(String x, String y)
    {
        return res(x, y)+  " PUSH "+x+" MOV ";
    }
    String MOV2(String x)
    {
        return " PUSH "+x+" MOV ";
    }
    String GOTO(String x)
    {
        return "PUSH true PUSH "+ x+ " GOTO ";
    }

    String RETURN(String x)
    {
        return LOAD(x) + " RETURN ";
    }

    String PRINT(String x)
    {
        return "PUSH "+ x + " PRINT ";
    }
    StringBuilder res = new StringBuilder();
    public Generator(String str)
    {
        String[] s = str.replace("\r\n", " ").split(" ");
        for(int i = 0; i<s.length;i++)
        {
            switch (s[i]) {
                case "PUSH" -> res.append(PUSH(s[++i]));
                case "POP" -> res.append(POP());
                case "ADD" -> res.append(ADD(s[++i], s[++i]));
                case "SUB" -> res.append(SUB(s[++i], s[++i]));
                case "MUL" -> res.append(MUL(s[++i], s[++i]));
                case "DIV" -> res.append(DIV(s[++i], s[++i]));
                case "MOD" -> res.append(MOD(s[++i], s[++i]));
                case "GT" -> res.append(GT(s[++i], s[++i], s[++i]));
                case "LT" -> res.append(LT(s[++i], s[++i], s[++i]));
                case "GEQ" -> res.append(GEQ(s[++i], s[++i], s[++i]));
                case "LEQ" -> res.append(LEQ(s[++i], s[++i], s[++i]));
                case "EQ" -> res.append(EQ(s[++i], s[++i], s[++i]));
                case "NEQ" -> res.append(NEQ(s[++i], s[++i], s[++i]));
                case "NOT" -> res.append(NOT(s[++i]));
                case "DECLARE" -> res.append(DECLARE(s[++i], s[++i]));
                case "ASSIGN" -> res.append(MOV(s[++i], s[++i]));
                case "MOV" -> res.append(MOV2(s[++i]));
                case "LOAD" -> res.append(LOAD(s[++i]));
                case "GOTO" -> res.append(GOTO(s[++i]));
                case "RETURN" -> res.append(RETURN(s[++i]));
                case "PRINT" -> res.append(PRINT(s[++i]));
                default -> res.append(s[i]).append(" ");
            }
        }
    }

    public String toString()
    {
        return res.toString();
    }

}
