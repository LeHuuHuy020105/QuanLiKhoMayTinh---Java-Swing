package GUI.User.QLTaiKhoanAdmin;

import BLL.SearchUser;
import BLL.UserBLL;
import BLL.btnEffect;
import BLL.updateDataToTable;
import DTO.User;
import GUI.Icon;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class QLTaiKhoanForm extends JPanel implements updateDataToTable<User> {

    private static final long serialVersionUID = 1L;
    private JComboBox comboBox;
    private JTextField textField;
    private JTable table_user;
    private User currentUser;
    private UserBLL userBLL;

    /**
     * Create the panel.
     */
    public QLTaiKhoanForm(User currentUser) {
        this.currentUser = currentUser;
        this.userBLL = new UserBLL();
        setLayout(null);
        setSize(1257, 911);
        Box verticalBox = Box.createVerticalBox();
        verticalBox.setBorder(new TitledBorder(
                new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
                "Chức năng",
                TitledBorder.LEADING,
                TitledBorder.TOP,
                new Font("Tahoma", Font.BOLD, 12),  // Đã sửa null thành Font.BOLD
                new Color(0, 0, 0)  // Màu chữ đen
        ));
        verticalBox.setBounds(10, 11, 574, 75);
        add(verticalBox);

        JPanel panel_5_1 = new JPanel();
        panel_5_1.setLayout(null);
        verticalBox.add(panel_5_1);

        JButton btnNewButton = new JButton("Thêm");
        btnEffect.setIcon(btnNewButton, Icon.add);
        btnNewButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ThemTaiKhoanMouseClicked();
            }
        });
        btnNewButton.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnNewButton.setHorizontalTextPosition(SwingConstants.CENTER);
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
        btnNewButton.setFocusPainted(false);
        btnNewButton.setContentAreaFilled(false);
        btnNewButton.setBorderPainted(false);
        btnNewButton.setBackground(UIManager.getColor("Button.background"));
        btnNewButton.setBounds(10, 0, 70, 52);
        panel_5_1.add(btnNewButton);

        JButton btnXuatExcel = new JButton("Xuất Excel");
        btnEffect.setIcon(btnXuatExcel,Icon.xuatExcel);
        btnXuatExcel.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnXuatExcel.setHorizontalTextPosition(SwingConstants.CENTER);
        btnXuatExcel.setFont(new Font("Tahoma", Font.PLAIN, 12));
        btnXuatExcel.setFocusPainted(false);
        btnXuatExcel.setContentAreaFilled(false);
        btnXuatExcel.setBorderPainted(false);
        btnXuatExcel.setBackground(UIManager.getColor("Button.background"));
        btnXuatExcel.setBounds(440, 0, 99, 52);
        panel_5_1.add(btnXuatExcel);

        JButton btnNhapExcel = new JButton("Nhập Excel");
        btnEffect.setIcon(btnNhapExcel,Icon.nhapExcel);
        btnNhapExcel.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnNhapExcel.setHorizontalTextPosition(SwingConstants.CENTER);
        btnNhapExcel.setFont(new Font("Tahoma", Font.PLAIN, 12));
        btnNhapExcel.setFocusPainted(false);
        btnNhapExcel.setContentAreaFilled(false);
        btnNhapExcel.setBorderPainted(false);
        btnNhapExcel.setBackground(UIManager.getColor("Button.background"));
        btnNhapExcel.setBounds(297, 0, 98, 52);
        panel_5_1.add(btnNhapExcel);

        JButton btnSua = new JButton("Sửa");
        btnEffect.setIcon(btnSua,Icon.edit);
        btnSua.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                SuaTaiKhoanMouseClicked();
            }
        });
        btnSua.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnSua.setHorizontalTextPosition(SwingConstants.CENTER);
        btnSua.setFont(new Font("Tahoma", Font.PLAIN, 12));
        btnSua.setFocusPainted(false);
        btnSua.setContentAreaFilled(false);
        btnSua.setBorderPainted(false);
        btnSua.setBackground(UIManager.getColor("Button.background"));
        btnSua.setBounds(90, 0, 70, 52);
        panel_5_1.add(btnSua);

        JButton btnXoa = new JButton("Xoá");
        btnEffect.setIcon(btnXoa,Icon.delete);
        btnXoa.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                XoaMouseClicked();
            }
        });
        btnXoa.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnXoa.setHorizontalTextPosition(SwingConstants.CENTER);
        btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 12));
        btnXoa.setFocusPainted(false);
        btnXoa.setContentAreaFilled(false);
        btnXoa.setBorderPainted(false);
        btnXoa.setBackground(UIManager.getColor("Button.background"));
        btnXoa.setBounds(184, 0, 70, 52);
        panel_5_1.add(btnXoa);

        Box verticalBox_1 = Box.createVerticalBox();
        verticalBox_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "T\u00ECm ki\u1EBFm", TitledBorder.LEADING, TitledBorder.TOP, new Font("Tahoma", Font.BOLD, 12), new Color(0, 0, 0)));
        verticalBox_1.setBounds(594, 11, 653, 75);
        add(verticalBox_1);

        JPanel panel_5_1_1 = new JPanel();
        verticalBox_1.add(panel_5_1_1);
        panel_5_1_1.setLayout(null);

        String[] cbx_Search = new String[]{"Tất cả","Tên đăng nhập","Tên người dùng","Số điện thoại","Email"};
        comboBox = new JComboBox(cbx_Search);
        comboBox.setBackground(UIManager.getColor("Button.background"));
        comboBox.setBounds(10, 11, 126, 30);
        panel_5_1_1.add(comboBox);

        textField = new JTextField();
        textField.addKeyListener(new KeyAdapter() {
        	@Override
        	public void keyReleased(KeyEvent e) {
                jTextFieldSearchKeyReleased();
        	}
        });
        textField.setColumns(10);
        textField.setBounds(156, 11, 325, 30);
        panel_5_1_1.add(textField);

        JButton btnNewButton_1 = new JButton("");
        btnEffect.setIcon(btnNewButton_1,Icon.refesh);
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            }
        });
        btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnNewButton_1.setBounds(491, 9, 114, 30);
        panel_5_1_1.add(btnNewButton_1);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 126, 1247, 774);
        add(scrollPane);

        table_user = new JTable();
        table_user.setModel(new DefaultTableModel(
                new Object[][] {
                },
                new String[] {
                        "Mã người dùng","Tên tài khoản", "Tên đăng nhập", "Email", "Vai trò", "Trạng thái"
                }
        ));
        scrollPane.setViewportView(table_user);
        updateTableDataFormDAO();
    }

    public void XoaMouseClicked(){
        User user = this.getUserSelected();
        if(user==null){
            return;
        }
        int luaChon = JOptionPane.showConfirmDialog(this,"Bạn có muốn xoá tài khoản này hay không ", "xoá nhà cung cấp", JOptionPane.YES_NO_OPTION);
        if(luaChon == JOptionPane.YES_OPTION){
            int ketQua = userBLL.delete(user);
            if (ketQua == -1) {
                JOptionPane.showMessageDialog(this, "Không thể xóa đã có tham chiếu liên quan!");
            } else if (ketQua > 0) {
                updateTableDataFormDAO();
                JOptionPane.showMessageDialog(this, "Xóa tài khoản thành công!");
            } else if (ketQua == 0) {
                JOptionPane.showMessageDialog(this, "Không tìm thấy tài khoản để xóa!");
            } else {
                JOptionPane.showMessageDialog(this, "Lỗi không xác định khi xóa tài khoản!");
            }
            updateTableDataFormDAO();
        }

    }
    public void jTextFieldSearchKeyReleased() {
        String luachon = (String) comboBox.getSelectedItem();
        String content_Search = textField.getText();
        ArrayList<User> result = SearchFn(luachon, content_Search);
        updateTableData(result);
    }

    public ArrayList<User> SearchFn(String luachon, String content_Search) {
        ArrayList<User> result = new ArrayList<>();
        SearchUser searchUser = new SearchUser();
        switch (luachon) {
            case "Tất cả":
                result = searchUser.searchTatCa(content_Search);
                break;
            case "Tên đăng nhập":
                result = searchUser.searchUserName(content_Search);
                break;
            case "Tên người dùng":
                result = searchUser.searchFullName(content_Search);
                break;
            case "Số điện thoại":
                result = searchUser.searchSDT(content_Search);
                break;
            case "Email":
                result = searchUser.searchEmail(content_Search);
        }
        return result;
    }

    @Override
    public void updateTableDataFormDAO() {
        ArrayList<User>users = userBLL.selectAllNotAdmin(currentUser);
        updateTableData(users);
    }

    @Override
    public void updateTableData(ArrayList<User> t) {
        DefaultTableModel model = (DefaultTableModel)table_user.getModel();
        model.setRowCount(0);
        for(User user : t){
            String role = userBLL.getRoleByIDUser(user.getIdUser());
            model.addRow(new Object[]{
                    user.getIdUser(),
                    user.getFullName(),
                    user.getUserName(),
                    user.getEmail(),
                    role,
                    user.getStatus()==1?"Bình thường":"Khoá",
            });
        }
    }
    public void ThemTaiKhoanMouseClicked() {
        System.out.println("aaaaa");
        ThemTaiKhoanForm themTaiKhoanForm = new ThemTaiKhoanForm(this);
        themTaiKhoanForm.setVisible(true);
    }
    public void SuaTaiKhoanMouseClicked() {
        SuaTaiKhoanForm suaTaiKhoanForm = new SuaTaiKhoanForm(this);
        suaTaiKhoanForm.setVisible(true);
    }
    public User getUserSelected(){
        DefaultTableModel model = (DefaultTableModel) table_user.getModel();
        int i_row = table_user.getSelectedRow();
        if(i_row==-1){
            JOptionPane.showMessageDialog(this,"Vui lòng chọn tài khoản!");
            return null;
        }
        int idUser = Integer.parseInt(model.getValueAt(i_row,0)+"");
        User user_Selected = userBLL.getUsetById(idUser);
        return user_Selected;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }
}
