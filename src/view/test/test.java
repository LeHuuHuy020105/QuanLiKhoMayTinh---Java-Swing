import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class test extends JFrame {
    private JTextField txtSearch;
    private DefaultListModel<String> listModel;
    private JList<String> suggestionList;
    private JScrollPane scrollPane;

    // Danh sách dữ liệu mẫu
    private List<String> data = List.of("Laptop Dell", "Laptop HP", "Laptop Asus", "Chuột Logitech", "Bàn phím cơ", "Tai nghe Sony", "Laptop Lenovo");

    public test() {
        setTitle("Autocomplete JTextField");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        txtSearch = new JTextField(20);
        listModel = new DefaultListModel<>();
        suggestionList = new JList<>(listModel);
        scrollPane = new JScrollPane(suggestionList);
        scrollPane.setPreferredSize(new Dimension(200, 100));
        scrollPane.setVisible(false); // Ẩn khi chưa nhập gì

        add(txtSearch);
        add(scrollPane);

        // Lắng nghe sự kiện nhập
        txtSearch.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                filterData();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                filterData();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                filterData();
            }
        });

        // Xử lý khi click vào danh sách gợi ý
        suggestionList.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting() && !suggestionList.isSelectionEmpty()) {
                txtSearch.setText(suggestionList.getSelectedValue());
                scrollPane.setVisible(false);
            }
        });

        setVisible(true);
    }

    // Lọc dữ liệu dựa trên nội dung nhập
    private void filterData() {
        String keyword = txtSearch.getText().trim().toLowerCase();
        listModel.clear();
        if (!keyword.isEmpty()) {
            for (String item : data) {
                if (item.toLowerCase().contains(keyword)) {
                    listModel.addElement(item);
                }
            }
        }
        scrollPane.setVisible(!listModel.isEmpty()); // Hiển thị gợi ý nếu có kết quả
    }

    public static void main(String[] args) {
        new test();
    }
}
