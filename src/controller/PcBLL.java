package controller;

import DAO.PCDAO;
import model.PC;

public class PcBLL {
    private PCDAO pcdao;

    public PcBLL() {
        this.pcdao = PCDAO.getInstance();
    }
    public int update(PC pc){
        return this.pcdao.update(pc);
    }
    public int insert(PC pc){
        return this.pcdao.insert(pc);
    }
}
