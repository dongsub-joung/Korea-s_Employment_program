package project2_ver0;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * num_btn(e) => num+= num
 * operator_btn (e) => save(num), save(btn_e), reset(view)
 * num_btn(e) => num+= num
 * equal_btn(e) => save(num), calculate(bff), save(result), show(result), reset(bff), addBff(result)
 * */

public class Logic {
    protected double result = 0;
    protected String[] buff = new String[5];
    protected ArrayList<String> history= new ArrayList<>();

    //    Setter
    public void saveFirstValue(String current_Value) {
        buff[0]= current_Value;
    }
    public void saveSecondValue(String current_Value) {
        buff[2]= current_Value;
    }
    public void saveOperateVal(String current_Value) {
        buff[1]= current_Value;
    }
    public void saveResult(String result){
        buff[4]= result;
    }
    public void setHistory(String result) {
        history.add(result);
    }

    public void resetAll() {
//      garbage collector because weal mapping && new array mapping
        buff= new String[5];
        result = 0;
    }

    //    Getter
    public double getResult() {
        return result;
    }
    public String[] getBuff() {
        return buff;
    }
}
