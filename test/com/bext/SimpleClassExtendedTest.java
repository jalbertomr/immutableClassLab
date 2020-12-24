package com.bext;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static com.bext.Main.getDateObject;
import static org.junit.jupiter.api.Assertions.*;

class SimpleClassExtendedTest {
    SimpleClass sc;

    @BeforeEach
    void init(){
        sc = new SimpleClass(1,new BigDecimal("1111.11"),"simpleClassConstructor", getDateObject("01/01/2020"));
    }

    @Test
    void testCopyConstructor(){
        SimpleClassExtended sce = new SimpleClassExtended( sc, 10, "nameExtended");
        SimpleClassExtended sceCC = new SimpleClassExtended( sce);
        assertEquals( sce, sceCC);
    }

    @Test
    void testIndependencyCopyConstructor(){
        SimpleClassExtended sce = new SimpleClassExtended( sc, 10, "nameExtended");
        SimpleClassExtended sceCC = new SimpleClassExtended( sce);

        sceCC.setId( 2);
        sceCC.setName("sce");
        sceCC.setBigDecimal( new BigDecimal("2222.22"));
        sceCC.setDate( getDateObject("02/02/2022"));
        sceCC.setIdExtended(200);
        sceCC.setNameExtended("setNameExtended");

        assertEquals( sce.getSimpleClass().getId(), 1);
        assertEquals( sce.getSimpleClass().getName(), "simpleClassConstructor");
        assertEquals( sce.getSimpleClass().getBigDecimal(), new BigDecimal("1111.11"));
        assertEquals( sce.getSimpleClass().getDate(), getDateObject("01/01/2020"));
        assertEquals( sce.getIdExtended(), 10);
        assertEquals( sce.getNameExtended(),"nameExtended" );
        assertNotSame( sce, sceCC);
    }

}