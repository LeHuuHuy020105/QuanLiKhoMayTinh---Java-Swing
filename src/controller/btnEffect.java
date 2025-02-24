package controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class btnEffect {
    public static void effectBtnHover(JButton jButton){
        Color btn_hoverColor = new Color(192, 192, 192);
        Color default_btn_hover = new Color(240, 240, 240);
        jButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                jButton.setBackground(btn_hoverColor);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                jButton.setBackground(default_btn_hover);
            }
        });
    }
}
