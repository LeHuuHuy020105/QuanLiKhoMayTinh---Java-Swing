package model;

public class PC extends MayTinh{
    private String mainBoard;
    private int congSuatNguon;

    public PC(String cardManHinh, double gia, String maMay, String ram, String rom, int soLuong, String tenCpu, String tenMay, int trangThai, String xuatXu, int congSuatNguon, String mainBoard) {
        super(cardManHinh, gia, maMay, ram, rom, soLuong, tenCpu, tenMay, trangThai, xuatXu);
        this.congSuatNguon = congSuatNguon;
        this.mainBoard = mainBoard;
    }
    public PC(){

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
