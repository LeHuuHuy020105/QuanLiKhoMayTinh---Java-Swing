package model.Address;

public class Ward {
    private int wards_id;
    private int district_id;
    private String name;

    public Ward(int district_id, String name, int wards_id) {
        this.district_id = district_id;
        this.name = name;
        this.wards_id = wards_id;
    }

    public Ward() {
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

    public int getWards_id() {
        return wards_id;
    }

    public void setWards_id(int wards_id) {
        this.wards_id = wards_id;
    }

    @Override
    public String toString() {
        return "Ward{" +
                "district_id='" + district_id + '\'' +
                ", wards_id='" + wards_id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
