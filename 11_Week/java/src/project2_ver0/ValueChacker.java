package project2_ver0;

public class ValueChacker extends Logic {
    public String isNullFirstValue(){
        String str= buff[0];
        if (str != null) { return  str; }
        else
    }
    public boolean isNullSecondValue(){ return buff[2] == null; }
    public boolean isNullOperatorValue(){ return buff[1] == null; }
}
