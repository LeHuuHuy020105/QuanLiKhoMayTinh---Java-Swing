package controller;

import DAO.CountryDAO;
import model.Country;

import java.util.ArrayList;

public class CountryBLL {
    private CountryDAO countryDAO;

    public CountryBLL() {
        this.countryDAO = CountryDAO.getInstance();
    }
    public Country CountryByID(String id){
        return this.countryDAO.CountryByID(id);
    }
    public ArrayList<Country> selectAll(){
        return this.countryDAO.selectAll();
    }
    public Country CountryByName(String nameCountry){
        return this.countryDAO.CountryByName(nameCountry);
    }
}
