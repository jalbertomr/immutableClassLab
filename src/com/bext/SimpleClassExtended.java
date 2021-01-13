package com.bext;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Objects;

public class SimpleClassExtended extends SimpleClass implements Cloneable {
    int idExtended;
    String nameExtended;
    Date dateExtended;

    public SimpleClassExtended(int id, BigDecimal bigDecimal, String name, Date date, HashMap<String, Date> sdMap, int idExtended, String nameExtended, Date dateExtended) {
        super( id, bigDecimal, name, date, sdMap);
        this.idExtended = idExtended;
        this.nameExtended = nameExtended;
        Object obj = dateExtended.clone();
        this.dateExtended = (Date)obj;
    }

    public SimpleClassExtended( SimpleClass simpleClass, int idExtended, String nameExtended, Date dateExtended) {
        super( simpleClass);
        this.idExtended = idExtended;
        this.nameExtended = nameExtended;
        Object obj = dateExtended.clone();
        this.dateExtended = (Date)obj;
    }

    public SimpleClassExtended( SimpleClassExtended simpleClassExtended){
        super( simpleClassExtended.getSimpleClass());
        this.idExtended = simpleClassExtended.getIdExtended();
        this.nameExtended = simpleClassExtended.getNameExtended();
        Object obj = simpleClassExtended.getDateExtended().clone();
        this.dateExtended = (Date) obj;
    }

    public SimpleClass getSimpleClass() {
        return this;
    }

    public int getIdExtended() {
        return idExtended;
    }

    public void setIdExtended(int idExtended) {
        this.idExtended = idExtended;
    }

    public String getNameExtended() {
        return nameExtended;
    }

    public void setNameExtended(String nameExtended) {
        this.nameExtended = nameExtended;
    }

    public Date getDateExtended() { return dateExtended; }

    public void setDateExtended(Date dateExtended) {
        this.dateExtended = dateExtended;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        SimpleClassExtended sce = ( SimpleClassExtended) super.clone();
        Object obj = this.getDate().clone();
        sce.setDate( (Date) obj);
        return super.clone();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SimpleClassExtended)) return false;
        if (!super.equals(o)) return false;
        SimpleClassExtended that = (SimpleClassExtended) o;
        return getIdExtended() == that.getIdExtended() &&
                getNameExtended().equals(that.getNameExtended()) &&
                getDateExtended().equals(that.getDateExtended());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getIdExtended(), getNameExtended(), getDateExtended());
    }

    @Override
    public String toString() {
        return "SimpleClassExtended{" +
                "idExtended=" + idExtended +
                ", nameExtended='" + nameExtended + '\'' +
                ", dateExtended=" + dateExtended +
                '}';
    }
}
