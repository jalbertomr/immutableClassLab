package com.bext;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;

import static com.bext.Main.getDateObject;
import static org.junit.jupiter.api.Assertions.*;

class SimpleClassExtendedTest {
    SimpleClass sc;
    HashMap<String, Date> sdMap = new HashMap<>();
    Date dateExtended;

    @BeforeEach
    void init(){
        sdMap.put("a",getDateObject("01/01/1971"));
        sdMap.put("b",getDateObject("02/02/1972"));
        sdMap.put("c",getDateObject("03/03/1973"));
        dateExtended = getDateObject("01/01/2020");
        sc = new SimpleClass(1,new BigDecimal("1111.11"),"simpleClassConstructor", getDateObject("01/01/2020"), sdMap);
    }

    @Test
    void testCopyConstructor(){
        SimpleClassExtended sce = new SimpleClassExtended( sc, 10, "nameExtended", dateExtended);
        SimpleClassExtended sceCC = new SimpleClassExtended( sce);
        assertEquals( sce, sceCC);
    }

    @Test
    void testIndependencyCopyConstructor(){
        SimpleClassExtended sce = new SimpleClassExtended( sc, 10, "nameExtended", dateExtended);
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

    @Test
    void testClone() throws CloneNotSupportedException {
        SimpleClassExtended sce = new SimpleClassExtended( sc, 10, "nameExtended", dateExtended);
        SimpleClassExtended sceCloned = (SimpleClassExtended) sce.clone();

        assertEquals(sce, sceCloned);
        assertNotSame( sce, sceCloned);
    }


}