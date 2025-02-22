package model.Address;

public class District {
    private int district_id;
    private int province_id;
    private String name;

    public District() {
    }

    public District(int district_id, String name, int province_id) {
        this.district_id = district_id;
        this.name = name;
        this.province_id = province_id;
    }

    public int getDistrict_id() {
        return district_id;
    }

    public void setDistrict_id(int district_id) {
        this.district_id = district_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getProvince_id() {
        return province_id;
    }

    public void setProvince_id(int province_id) {
        this.province_id = province_id;
    }

    @Override
    public String toString() {
        return "District{" +
                "district_id='" + district_id + '\'' +
                ", province_id='" + province_id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
