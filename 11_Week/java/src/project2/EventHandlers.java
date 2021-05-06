package project2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventHandlers {

    /**
     * Event Method
     */
    private void evenHandlerNumber(JButton btn) {
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String current_val = label.getText();
                String sum_str = current_val + btn.getText();
                label.setText(sum_str);
            }
        });
    }

    private void evenHandlerOperator(JButton btn) {
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String current_val = label.getText();
                if ( !(current_val.equals("")) || !(current_val.equals("0"))) {
                    logic.saveCurrentVal(current_val);
                    logic.saveOperateVal(btn.getText());
                    label.setText("");
                } else {
                    return;
                }
            }
        });
    }

    private void evenHandlerEqual(JButton btn) {
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!logic.checkOperatorIsNotNull()) {
                    String current_val = label.getText();
                    logic.saveCurrentVal(current_val);

                    logic.cal();
                    view_value = logic.getResult() + "";
                    label.setText(view_value);
                } else {
                    return;
                }
            }
        });
    }

    private void evenHandlerClear(JButton btn) {
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TA.append(logic.printNumbers());
                logic.resetAll();
                label.setText("0");
            }
        });
    }
}
