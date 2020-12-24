package com.bext;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static com.bext.Main.getDateObject;
import static org.junit.jupiter.api.Assertions.*;

class SimpleClassTest {

    @Test
    void testCopyConstructor(){
        SimpleClass sc = new SimpleClass(1,new BigDecimal("1111.11"),"simpleClassConstructor", getDateObject("01/01/2020"));
        SimpleClass scCopyConstructor = new SimpleClass(sc);
        assertEquals( sc, scCopyConstructor);
    }

    @Test
    void testIndependencyCopyConstructor(){
        SimpleClass sc = new SimpleClass(1,new BigDecimal("1111.11"),"simpleClassConstructor", getDateObject("01/01/2020"));
        SimpleClass scCopyConstructor = new SimpleClass(sc);
        scCopyConstructor.setId(2);
        scCopyConstructor.setName("name");
        scCopyConstructor.setBigDecimal( new BigDecimal("22222.22"));
        scCopyConstructor.setDate( getDateObject( "02/02/2022"));

        assertEquals( sc.getId(), 1);
        assertEquals( sc.getName(), "simpleClassConstructor");
        assertEquals( sc.getBigDecimal(), new BigDecimal("1111.11"));
        assertEquals(sc.getDate(), getDateObject("01/01/2020"));

        assertEquals( scCopyConstructor.getId(), 2);
        assertEquals( scCopyConstructor.getName(), "name");
        assertEquals( scCopyConstructor.getBigDecimal(), new BigDecimal("22222.22"));
        assertEquals( scCopyConstructor.getDate(), getDateObject("02/02/2022"));
    }

}