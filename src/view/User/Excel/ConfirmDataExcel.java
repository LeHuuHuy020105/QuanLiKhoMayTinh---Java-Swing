package view.User.Excel;

import DAO.BrandDAO;
import DAO.ProducersDAO;
import DAO.ProductsDAO;
import controller.Notification;
import model.Branch;
import model.Computer;
import model.Laptop;
import model.Producer;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class ConfirmDataExcel extends JFrame {

    private static final long serialVersionUID = 1L;
    private JButton btn_Confirm;
    private JPanel contentPane;
    private JTable table_product;
    private ArrayList<Object> data;

    /**
     * Launch the application.
     */

    /**
     * Create the frame.
     */
    public ConfirmDataExcel(ArrayList<?> data, String[] columnNames, String title) {
        this.data = new ArrayList<>(data);
        setTitle(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 982, 536);
        setLocationRelativeTo(null);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        DecimalFormat df = new DecimalFormat("#,###");
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        table_product = new JTable(model);

        // Xử lý dữ liệu linh hoạt
        int i =0;
        for (Object obj : data) {
            if (obj instanceof Computer) {
                Computer computer = (Computer) obj;
                model.addRow(new Object[]{
                        ++i,computer.getTenMay(), computer.getSoLuong(),
                        df.format(computer.getGia()), df.format(computer.getGiaBan()), computer.getTenCpu(),
                        computer.getRam(), computer.getRom(), (computer instanceof Laptop) ? "Laptop" : "PC"
                });
            } else if (obj instanceof Branch) {
                Branch branch = (Branch) obj;
                model.addRow(new Object[]{
                        ++i,branch.getTenChiNhanh(), branch.getDiaChi(), branch.getTenQuan(),
                        branch.getThanhPho(), branch.getSoDienThoai(), branch.getMoTa()
                });
            }else if (obj instanceof Producer){
                Producer producer =(Producer) obj;
                model.addRow(new Object[]{
                        ++i,producer.getMaNhaCungCap(),producer.getTenNhaCungCap(),producer.getDiaChi(),
                        producer.getSdt(),
                });
            }
        }

        JScrollPane scrollPane = new JScrollPane(table_product);
        scrollPane.setBounds(10, 53, 948, 371);
        contentPane.add(scrollPane);

        btn_Confirm = new JButton("Xác nhận");
        btn_Confirm.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
                XacNhanMouseClicked();
        	}
        });
        
        btn_Confirm.setForeground(Color.WHITE);
        btn_Confirm.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btn_Confirm.setBorderPainted(false);
        btn_Confirm.setBackground(new Color(60, 179, 113));
        btn_Confirm.setBounds(819, 448, 139, 41);
        contentPane.add(btn_Confirm);

        this.setVisible(true);
    }


    public void insertObject(Object obj){
        if (obj instanceof Computer){
            Computer computer = (Computer) obj;
            ProductsDAO.getInstance().insert(computer);
        }else {
            if(obj instanceof Branch){
                Branch branch = (Branch)obj;
                BrandDAO.getInstance().insert(branch);
            }
            else if (obj instanceof Producer){
                Producer producer = (Producer) obj;
                ProducersDAO.getInstance().insert(producer);
            }
        }
    }
    public void XacNhanMouseClicked() {
        if (data == null || data.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không có sản phẩm nào để thêm!", "Thông báo", JOptionPane.WARNING_MESSAGE);
            return;
        }
        int choice = JOptionPane.showConfirmDialog(this, "Bạn có chắc thêm những sản phẩm này?", "Xác nhận", JOptionPane.YES_NO_OPTION);
        if (choice == JOptionPane.YES_OPTION) {
            for (Object obj : data) {
               insertObject(obj);
            }
            JOptionPane.showMessageDialog(this, Notification.success_ImportExcel);
            this.dispose();
        } else {
            this.dispose();
        }

    }

}
