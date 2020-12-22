package com.bext;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

public class SimpleClassExtended extends SimpleClass {
    int idExtended;
    String nameExtended;

    public SimpleClassExtended(int id, BigDecimal bigDecimal, String name, Date date, int idExtended, String nameExtended) {
        super( id, bigDecimal, name, date);
        this.idExtended = idExtended;
        this.nameExtended = nameExtended;
    }

//    public void setId(int id){ super.setId( id * 2); }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SimpleClassExtended)) return false;
        if (!super.equals(o)) return false;
        SimpleClassExtended that = (SimpleClassExtended) o;
        return getIdExtended() == that.getIdExtended() &&
                Objects.equals(getNameExtended(), that.getNameExtended());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getIdExtended(), getNameExtended());
    }

    @Override
    public String toString() {
        return "SimpleClassExtend{ " + super.toString() + ", " +
                "idExtended=" + idExtended +
                ", nameExtended='" + nameExtended + '\'' +
                '}';
    }
}
