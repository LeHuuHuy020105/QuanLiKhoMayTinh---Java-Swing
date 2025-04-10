package view.User.NhanVien;

import DAO.VoucherDAO;
import model.Voucher;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Enumeration;

public class RadioButtonScrollExample extends JFrame {
    private ButtonGroup group; // Để truy cập từ các phương thức khác
    private BanHang banHang;
    private ArrayList<Voucher> vouchers; // Lưu danh sách voucher để truy xuất sau

    public RadioButtonScrollExample(BanHang banHang) {
        this.banHang = banHang;
        // Thiết lập tiêu đề và thuộc tính JFrame
        setTitle("Radio Buttons with Scroll");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null); // Căn giữa cửa sổ
        setLayout(new BorderLayout()); // Dùng BorderLayout để bố trí

        // Tạo JPanel để chứa các JRadioButton
        JPanel radioPanel = new JPanel();
        radioPanel.setLayout(new BoxLayout(radioPanel, BoxLayout.Y_AXIS)); // Sắp xếp theo chiều dọc

        // Tạo ButtonGroup để chỉ chọn được 1 radio button
        group = new ButtonGroup();
        vouchers = VoucherDAO.getInstance().getSelectedVoucher();

        // Thêm các JRadioButton từ danh sách voucher
        for (Voucher voucher : vouchers) {
            JRadioButton radioButton = new JRadioButton(voucher.getDescription());
            radioButton.setActionCommand(String.valueOf(voucher.getId())); // Lưu ID
            group.add(radioButton);
            radioPanel.add(radioButton);
        }

        // Tạo JScrollPane và đặt JPanel vào đó
        JScrollPane scrollPane = new JScrollPane(radioPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); // Luôn hiển thị thanh cuộn dọc
        scrollPane.setPreferredSize(new Dimension(250, 150)); // Kích thước vùng hiển thị

        // Tạo nút Xác nhận
        JButton confirmButton = new JButton("Xác nhận");
        confirmButton.addActionListener(e -> XacNhanMouseClicked());

        // Thêm các thành phần vào JFrame
        add(new JLabel("Chọn voucher:"), BorderLayout.NORTH); // Nhãn tiêu đề
        add(scrollPane, BorderLayout.CENTER); // Vùng cuộn ở giữa
        add(confirmButton, BorderLayout.SOUTH); // Nút xác nhận ở dưới

        // Hiển thị JFrame
        setVisible(true);
    }

    private void XacNhanMouseClicked() {
        Voucher voucher = getSelectedVoucher();
        if (voucher != null) {
            JOptionPane.showMessageDialog(this, "Voucher được chọn: " + voucher.getDescription() +
                    " (ID: " + voucher.getId() + ")");
            dispose();
            banHang.fillInfoVoucher(voucher);
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một voucher!");
        }
    }

    // Lấy ID của voucher được chọn
    private Voucher getSelectedVoucher() {
        for (Enumeration<AbstractButton> buttons = group.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();
            if (button.isSelected()) {
                int selectedId = Integer.parseInt(button.getActionCommand());
                for (Voucher voucher : vouchers) {
                    if (voucher.getId() == selectedId) {
                        return voucher; // Trả về đối tượng Voucher
                    }
                }
            }
        }
        return null;
    }
}