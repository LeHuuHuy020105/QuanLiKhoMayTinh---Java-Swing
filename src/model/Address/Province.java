package model.Address;

public class Province {
    private int province_id ;
    private String name;

    public Province() {
    }

    public Province(String name, int province_id) {
        this.name = name;
        this.province_id = province_id;
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
        return "Province{" +
                "name='" + name + '\'' +
                ", province_id='" + province_id + '\'' +
                '}';
    }
}
