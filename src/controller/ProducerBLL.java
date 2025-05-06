package controller;

import DAO.ProducersDAO;
import model.Producer;

import java.util.ArrayList;

public class ProducerBLL {
    private ProducersDAO producersDAO;

    public ProducerBLL() {
        this.producersDAO = ProducersDAO.getInstance();
    }
    public ArrayList<Producer> selectAll(){
        return ProducersDAO.getInstance().selectAll();
    }
    public int delete(Producer producer){
        return ProducersDAO.getInstance().delete(producer);
    }
    public Producer producerByID(String maNCC){
        return ProducersDAO.getInstance().producerByID(maNCC);
    }
    public int update(Producer producer){
        return ProducersDAO.getInstance().update(producer);
    }
    public int insert(Producer producer){
        return ProducersDAO.getInstance().insert(producer);
    }

}
