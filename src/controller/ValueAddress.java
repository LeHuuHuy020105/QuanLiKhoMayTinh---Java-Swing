package controller;

import DAO.Address.DistrictDAO;
import DAO.Address.ProvinceDAO;
import DAO.Address.WardDAO;
import model.Address.District;
import model.Address.Province;
import model.Address.Ward;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class ValueAddress {
    public static String getValueAddressFrame(JFrame jFrame,JComboBox cbx_ThanhPho , JComboBox cbx_Quan , JComboBox cbx_Phuong , JTextField input_SoNha){
        String name_ThanhPho = cbx_ThanhPho.getSelectedItem()+"";
        if (name_ThanhPho == ""){
            JOptionPane.showMessageDialog(jFrame,"Vui lòng chọn thành phố");
            return "N/A";
        }else {
            Province province_findName = ProvinceDAO.getInstance().ProvinceByName(name_ThanhPho);
            ArrayList<District>districts = DistrictDAO.getInstance().selectAllByProvince(province_findName);
            for(District district : districts){
                cbx_ThanhPho.addItem(district.getName());
            }
            JTextField textField_Quan = (JTextField) cbx_Quan.getEditor().getEditorComponent();
            textField_Quan.addKeyListener(new KeyAdapter() {
                @Override
                public void keyReleased(KeyEvent e) {
                    String input = textField_Quan.getText().toLowerCase();
                    cbx_Quan.removeAllItems();

                    for (District district : districts) {
                        if (district.getName().toLowerCase().contains(input)) {
                            cbx_ThanhPho.addItem(district.getName());
                        }
                    }
                    textField_Quan.setText(input);
                    cbx_Quan.showPopup(); // Hiển thị danh sách gợi ý
                }
            });
            String name_District = cbx_Quan.getSelectedItem()+"";
            if (name_District == "") {
                JOptionPane.showMessageDialog(jFrame,"Vui lòng chọn quận huyện");
                return "N/A";
            }else {
                District district_find = DistrictDAO.getInstance().DistrictByName(name_District);
                ArrayList<Ward>wards = WardDAO.getInstance().selectAllByDistrict(district_find);
                for(Ward ward : wards){
                    cbx_Phuong.addItem(ward.getName());
                }
                JTextField textField_Phuong = (JTextField) cbx_Phuong.getEditor().getEditorComponent();
                textField_Phuong.addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyReleased(KeyEvent e) {
                        String input = textField_Phuong.getText().toLowerCase();
                        cbx_Phuong.removeAllItems();

                        for (Ward ward : wards) {
                            if (ward.getName().toLowerCase().contains(input)) {
                                cbx_Phuong.addItem(ward.getName());
                            }
                        }
                        textField_Phuong.setText(input);
                        cbx_Phuong.showPopup(); // Hiển thị danh sách gợi ý
                    }
                });
            }
        }
        String soNha = input_SoNha.getText();
        String phuong = cbx_Phuong.getSelectedItem()+"";
        String quan = cbx_Quan.getSelectedItem()+"";
        String thanhPho = cbx_ThanhPho.getSelectedItem()+"";
        return soNha+","+phuong+","+quan+","+thanhPho;
    }
}
