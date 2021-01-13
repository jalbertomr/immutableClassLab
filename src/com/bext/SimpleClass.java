package com.bext;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

import static com.bext.InitWays.*;

public class SimpleClass implements Cloneable{
    private final InitWays INIT_WAY = SHALLOW_COPY;
    private int id;
    private BigDecimal bigDecimal;
    private String name;
    private Date date;
    private HashMap<String, Date> ssMap = new HashMap<>();

    public SimpleClass(int id, BigDecimal bigDecimal, String name, Date date, HashMap<String, Date> ssMap) {
        this.id = id;
        this.bigDecimal = bigDecimal;
        this.name = name;
        Object obj = date.clone();
        this.date = (Date) obj;
        String key;
        switch (INIT_WAY) {
            case SHALLOW_COPY:
                this.ssMap = ssMap;   // Shallow Copy
                break;
            case DEEP_COPY_WHILE:      // Deep Copy
                Iterator<String> iterator = ssMap.keySet().iterator();
                while (iterator.hasNext()) {
                    key = iterator.next();
                    this.ssMap.put(key, ssMap.get(key));
                }
                break;
            case DEEP_COPY_FOR_MAPENTRY:
                for (Map.Entry<String, Date> mapEntry : ssMap.entrySet()) {
                    this.ssMap.put(mapEntry.getKey(), mapEntry.getValue());
                }
                break;
            case DEEP_COPY_FOR:
                for (String s : ssMap.keySet()) {
                    this.ssMap.put(s, ssMap.get(s));
                }
                break;
            case DEEP_COPY_FUNCTIONAL:
                this.ssMap = (HashMap)ssMap.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
                break;
            case CLONNING:
                this.ssMap = (HashMap<String, Date>) ssMap.clone();
                break;
        }
    }

    /**
     * Copy Constructor
     * @param simpleClass
     */
    public SimpleClass( SimpleClass simpleClass) {
        this.id = simpleClass.getId();
        this.bigDecimal = simpleClass.getBigDecimal();
        this.setName( simpleClass.getName());
        Object obj = simpleClass.getDate().clone();
        this.date = (Date)obj;

        switch(INIT_WAY){
            case SHALLOW_COPY:
                this.ssMap = simpleClass.getSsMap();
                break;
            case DEEP_COPY_WHILE:
                String key;
                Iterator<String> iterator = simpleClass.getSsMap().keySet().iterator();
                while (iterator.hasNext()) {
                    key = iterator.next();
                    this.ssMap.put(key, simpleClass.getSsMap().get(key));
                }
                break;
            case DEEP_COPY_FOR:
                for ( String s : simpleClass.getSsMap().keySet())
                    this.ssMap.put( s, simpleClass.getSsMap().get( s));
                break;
            case DEEP_COPY_FOR_MAPENTRY:
                for (Map.Entry<String, Date> mapEntry :  simpleClass.getSsMap().entrySet()){
                    this.ssMap.put( mapEntry.getKey(), mapEntry.getValue());
                }
                break;
            case DEEP_COPY_FUNCTIONAL:
                this.ssMap = (HashMap)simpleClass.getSsMap().entrySet().stream()
                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
                break;
            case CLONNING:
                this.ssMap = (HashMap<String,Date>) simpleClass.getSsMap().clone();
                break;
        }
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

    public HashMap<String, Date> getSsMap() {
        return (HashMap<String, Date>) ssMap;
    }

    public void setSsMap(HashMap<String, Date> ssMap) {
        this.ssMap = ssMap;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        SimpleClass sc = (SimpleClass) super.clone();
        Object obj = sc.date.clone();
        sc.date = (Date) obj;
        Object obj2 = ((HashMap<String, Date>)sc.ssMap).clone();
        sc.ssMap = (HashMap<String, Date>) obj2;
        return sc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SimpleClass)) return false;
        SimpleClass that = (SimpleClass) o;
        return getId() == that.getId() &&
                getBigDecimal().equals(that.getBigDecimal()) &&
                getName().equals(that.getName()) &&
                getDate().equals(that.getDate()) &&
                ssMap.equals(that.ssMap);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getBigDecimal(), getName(), getDate(), ssMap);
    }

    @Override
    public String toString() {
        return "SimpleClass{" +
                "id=" + id +
                ", bigDecimal=" + bigDecimal +
                ", name='" + name + '\'' +
                ", date=" + date +
                ", ssMap=" + ssMap +
                '}';
    }

}
