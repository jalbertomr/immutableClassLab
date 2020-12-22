package com.bext;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

public class SimpleClass {
    private int id;
    private BigDecimal bigDecimal;
    private String name;
    private Date date;

    public SimpleClass(int id, BigDecimal bigDecimal, String name, Date date) {
        this.id = id;
        this.bigDecimal = bigDecimal;
        this.name = name;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BigDecimal getBigDecimal() {
        return bigDecimal;
    }

    public void setBigDecimal(BigDecimal bigDecimal) {
        this.bigDecimal = bigDecimal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SimpleClass)) return false;
        SimpleClass that = (SimpleClass) o;
        return getId() == that.getId() &&
                Objects.equals(getBigDecimal(), that.getBigDecimal()) &&
                Objects.equals(getName(), that.getName()) &&
                Objects.equals(getDate(), that.getDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getBigDecimal(), getName(), getDate());
    }

    @Override
    public String toString() {
        return "SimpleClass{" +
                " id=" + id +
                ", bigDecimal=" + bigDecimal +
                ", name='" + name + '\'' +
                ", date=" + date +
                '}';
    }
}
