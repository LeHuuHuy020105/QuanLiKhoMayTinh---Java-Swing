package model;

import java.math.BigDecimal;

public class Voucher {
    private int id;
    private BigDecimal percent;
    private String description;

    public Voucher(int id, BigDecimal percent, String description) {
        this.id = id;
        this.percent = percent;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BigDecimal getPercent() {
        return percent;
    }

    public void setPercent(BigDecimal percent) {
        this.percent = percent;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Voucher{" +
                "id=" + id +
                ", percent=" + percent +
                ", description='" + description + '\'' +
                '}';
    }
}
