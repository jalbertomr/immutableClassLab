package com.bext;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

import static com.bext.Main.getDateObject;
import static org.junit.jupiter.api.Assertions.*;

class SimpleClassTest {

    HashMap<String, Date> sdMap = new HashMap<>();

    @BeforeEach
    void init(){
        sdMap.put("a",getDateObject("01/01/1971"));
        sdMap.put("b",getDateObject("02/02/1972"));
        sdMap.put("c",getDateObject("03/03/1973"));
    }

    @Test
    void testCopyConstructor(){
        SimpleClass sc = new SimpleClass(1,new BigDecimal("1111.11"),"simpleClassConstructor", getDateObject("01/01/2020"), sdMap);
        SimpleClass scCopyConstructor = new SimpleClass(sc);
        assertEquals( sc, scCopyConstructor);
        assertEquals( sc.getSsMap().get("b"), getDateObject("02/02/1972"));
        assertEquals( sc.getSsMap(), scCopyConstructor.getSsMap());
    }

    @Test
    void testIndependencyCopyConstructor(){
        HashMap<String,Date> refMap = new HashMap<>();
        refMap.put("a",getDateObject("06/06/2066"));
        refMap.put("z",getDateObject("12/12/2012"));

        SimpleClass sc = new SimpleClass(1,new BigDecimal("1111.11"),"simpleClassConstructor", getDateObject("01/01/2020"), sdMap);
        SimpleClass scCopyConstructor = new SimpleClass(sc);

        assertFalse(sc.getSsMap() == scCopyConstructor.getSsMap());
        assertNotSame( sc.getSsMap(), scCopyConstructor.getSsMap());
        scCopyConstructor.setId(2);
        scCopyConstructor.setName("name");
        scCopyConstructor.setBigDecimal( new BigDecimal("22222.22"));
        scCopyConstructor.setDate( getDateObject( "02/02/2022"));
        scCopyConstructor.setSsMap( refMap);

        assertEquals( sc.getId(), 1);
        assertEquals( sc.getName(), "simpleClassConstructor");
        assertEquals( sc.getBigDecimal(), new BigDecimal("1111.11"));
        assertEquals(sc.getDate(), getDateObject("01/01/2020"));
        assertEquals( sc.getSsMap().get("a"), getDateObject("01/01/1971"));

        assertEquals( scCopyConstructor.getId(), 2);
        assertEquals( scCopyConstructor.getName(), "name");
        assertEquals( scCopyConstructor.getBigDecimal(), new BigDecimal("22222.22"));
        assertEquals( scCopyConstructor.getDate(), getDateObject("02/02/2022"));
    }

    @Test
    void testClone() throws CloneNotSupportedException {
        SimpleClass sc = new SimpleClass(1,new BigDecimal("1111.11"),"simpleClassConstructor", getDateObject("01/01/2020"), sdMap);
        SimpleClass scCloned = (SimpleClass) sc.clone();

        assertEquals( sc, scCloned);
        assertNotSame( sc, scCloned);
        assertEquals( sc.getDate(),  scCloned.getDate());
        assertFalse(sc.getDate() == scCloned.getDate());
        assertEquals( sc.getSsMap(), scCloned.getSsMap());
        assertFalse( sc.getSsMap() == scCloned.getSsMap());

        sc.setId(2);
        sc.setName("name");
        sc.setBigDecimal( new BigDecimal("22222.22"));
        sc.setDate( getDateObject( "02/02/2022"));

        assertEquals( scCloned.getId(), 1);
        assertEquals( scCloned.getName(), "simpleClassConstructor");
        assertEquals( scCloned.getBigDecimal(), new BigDecimal("1111.11"));
        assertEquals( scCloned.getDate(), getDateObject("01/01/2020"));
    }
}