package model;

public class PC extends Computer {
    private String mainBoard;
    private int congSuatNguon;

    public PC(String cardManHinh, double gia, int maMay, String ram, String rom, int soLuong, String tenCpu, String tenMay, String xuatXu, int congSuatNguon, String mainBoard, String maNhaCungCap , double dungLuongLuuTru) {
        super(cardManHinh, gia, maMay, ram, rom, soLuong, tenCpu, tenMay, xuatXu,maNhaCungCap,dungLuongLuuTru);
        this.congSuatNguon = congSuatNguon;
        this.mainBoard = mainBoard;
    }


    public int getCongSuatNguon() {
        return congSuatNguon;
    }

    public void setCongSuatNguon(int congSuatNguon) {
        this.congSuatNguon = congSuatNguon;
    }

    public String getMainBoard() {
        return mainBoard;
    }

    public void setMainBoard(String mainBoard) {
        this.mainBoard = mainBoard;
    }

    @Override
    public String toString() {
        return "PC{" +
                "congSuatNguon=" + congSuatNguon +
                ", mainBoard='" + mainBoard + '\'' +
                '}';
    }
}
