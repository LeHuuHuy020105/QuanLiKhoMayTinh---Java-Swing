package controller;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ImageHelper {
    public static ImageIcon byteArrayToImageIcon(byte[] imageBytes, JPanel panel) {
        if (imageBytes != null && panel != null) {
            int width = panel.getWidth();
            int height = panel.getHeight();

            if (width > 0 && height > 0) { // Đảm bảo JPanel có kích thước hợp lệ
                ImageIcon icon = new ImageIcon(imageBytes);
                Image img = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
                return new ImageIcon(img);
            }
        }
        return null;
    }
    public static void hienThiAnhTrenPanel(byte[] imageBytes, JPanel panel) {
        ImageIcon icon = ImageHelper.byteArrayToImageIcon(imageBytes, panel);
        if (icon != null) {
            JLabel label = new JLabel(icon);
            label.setSize(panel.getWidth(), panel.getHeight());
            panel.removeAll(); // Xóa ảnh cũ (nếu có)
            panel.add(label);
            panel.revalidate();
            panel.repaint();
        }
    }
    public static byte[] convertImageToBytes(String imagePath) {
        try {
            File file = new File(imagePath);
            FileInputStream fis = new FileInputStream(file);
            byte[] imageBytes = new byte[(int) file.length()];
            fis.read(imageBytes);
            fis.close();
            return imageBytes;
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Lỗi khi chuyển ảnh thành byte!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
}
