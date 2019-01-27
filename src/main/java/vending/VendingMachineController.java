package vending;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VendingMachineController implements ActionListener {

    private final VendingMachineModel model;

    VendingMachineController(VendingMachineModel model) {
        this.model = model;
    }

    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand());
    }
}