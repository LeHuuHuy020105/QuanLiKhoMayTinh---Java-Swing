package controller;

import DAO.Address.DistrictDAO;
import DAO.Address.ProvinceDAO;
import DAO.Address.WardDAO;
import model.Address.District;
import model.Address.Province;
import model.Address.Ward;
import view.User.NhaCungCap.ThemNhaCungCap;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class ValueAddress {
    public static ValueAddress getInstance(){
        return new ValueAddress();
    }
    public void loadQuanHuyen(JComboBox<String> cbx_ThanhPho, JComboBox<String> cbx_Quan, JComboBox<String> cbx_Phuong) {
        cbx_Quan.removeAllItems();
        cbx_Phuong.removeAllItems();

        ArrayList<Province>provinces = ProvinceDAO.getInstance().selectAll();
        for(Province province : provinces) {
            cbx_ThanhPho.addItem(province.getName());
        }
        loadQuan(cbx_ThanhPho,cbx_Quan,cbx_Phuong);
        cbx_ThanhPho.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                loadQuan(cbx_ThanhPho,cbx_Quan,cbx_Phuong);
            }
        });
        JTextField jTextField_cbxThanhPho = (JTextField) cbx_ThanhPho.getEditor().getEditorComponent();
        jTextField_cbxThanhPho.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                String input = jTextField_cbxThanhPho.getText().toLowerCase();
                cbx_ThanhPho.removeAllItems();
                for(Province province : provinces){
                    if(province.getName().toLowerCase().contains(input)){
                        cbx_ThanhPho.addItem(province.getName());
                    }
                }
                jTextField_cbxThanhPho.setText(input);
                cbx_ThanhPho.showPopup();
            }
        });
        cbx_ThanhPho.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED){
                    loadQuan(cbx_ThanhPho,cbx_Quan,cbx_Phuong);
                }
            }
        });

    }
    public void loadQuan(JComboBox<String> cbx_ThanhPho, JComboBox<String> cbx_Quan, JComboBox<String> cbx_Phuong){
        cbx_Quan.removeAllItems();
        cbx_Phuong.removeAllItems();
        String tenTP = (String) cbx_ThanhPho.getSelectedItem();
        if (tenTP == null) return;

        Province province = ProvinceDAO.getInstance().ProvinceByName(tenTP);
        ArrayList<District> districts = DistrictDAO.getInstance().selectAllByProvince(province);

        for (District district : districts) {
            cbx_Quan.addItem(district.getName());
        }
        loadPhuong(cbx_Quan,cbx_Phuong);
        JTextField jTextField_cbxQuan = (JTextField) cbx_Quan.getEditor().getEditorComponent();

        jTextField_cbxQuan.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                String input = jTextField_cbxQuan.getText().toLowerCase();
                cbx_Quan.removeAllItems();
                for(District district : districts){
                    if(district.getName().toLowerCase().contains(input)){
                        cbx_Quan.addItem(district.getName());
                    }
                }
                jTextField_cbxQuan.setText(input);
                cbx_Quan.showPopup();
            }
        });
        cbx_Quan.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED){
                    loadPhuong(cbx_Quan,cbx_Phuong);
                }
            }
        });
    }
    public void loadPhuong(JComboBox<String> cbx_Quan, JComboBox<String> cbx_Phuong){
        cbx_Phuong.removeAllItems();
        String tenQuan = (String) cbx_Quan.getSelectedItem();
        District district = DistrictDAO.getInstance().DistrictByName(tenQuan);
        ArrayList<Ward>wards = WardDAO.getInstance().selectAllByDistrict(district);
        for (Ward ward : wards) {
            cbx_Phuong.addItem(ward.getName());
        }
        JTextField jTextField_cbxPhuong = (JTextField) cbx_Phuong.getEditor().getEditorComponent();
        jTextField_cbxPhuong.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                String input = jTextField_cbxPhuong.getText().toLowerCase();
                cbx_Phuong.removeAllItems();
                for (Ward ward : wards) {
                    if (ward.getName().toLowerCase().contains(input)) {
                        cbx_Phuong.addItem(ward.getName());
                    }
                }
                jTextField_cbxPhuong.setText(input);
                cbx_Phuong.showPopup();
            }
        });
    }
    public static String getValueAddressFrame(JFrame frame, JComboBox cbxTP, JComboBox cbxQuan, JComboBox cbxPhuong, JTextField soNha) {
        return soNha.getText() + "," + cbxPhuong.getSelectedItem() + "," + cbxQuan.getSelectedItem() + "," + cbxTP.getSelectedItem();
    }
}
