public class Info {

    String[] value = new String[1];
    String[] param;
    Info(String val)
    {
        this.value[0] = val;
    }

    Info(String[] val)
    {
        this.value = val;
    }

    public void setValue(String opValue) {
        this.value[0] = opValue;
    }

    public String getValue() {
        return value[0];
    }
}
