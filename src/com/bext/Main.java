package com.bext;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws CloneNotSupportedException {

        Map<Integer, String> hash_Map
                = new HashMap<Integer, String>();

        // putting elements into the map
        hash_Map.put(1, "primero");
        hash_Map.put(2, "segundo");
        hash_Map.put(3, "tercero");

        HashMap<String, Date> sdMap = new HashMap<String, Date>();
        sdMap.put("a",getDateObject("01/01/1971"));
        sdMap.put("b",getDateObject("02/02/1972"));
        sdMap.put("c",getDateObject("03/03/1973"));

        SimpleClass simpleClass01 = new SimpleClass(1,new BigDecimal("1111.11"),"simpleClassConstructor", getDateObject("01/01/2020"), sdMap);

        SimpleClass simpleClassBackup = new SimpleClass( simpleClass01);

        SimpleClass simpleClassCloned = (SimpleClass) simpleClass01.clone();
        System.out.println("                  simpleClass01: " + simpleClass01);
        System.out.println("--- Modifying state of simpleClass01---");
        System.out.println("simpleClass01.getDate().getTime():" + simpleClass01.getDate().getTime() );
        //simpleClass01.getDate().setTime( simpleClass01.getDate().getTime() + 1234567890L );
        simpleClassBackup.getSsMap().put("a",getDateObject("06/06/2066"));
        simpleClassCloned.getSsMap().put("a",getDateObject("07/07/2077"));
        System.out.println("modified value of simpleClass01: " + simpleClass01);

        System.out.println("simpleClass01.equals(simpleClassBackup): " + Boolean.toString( simpleClass01.equals( simpleClassBackup)).toUpperCase() );
        System.out.println("simpleClass01.equals(simpleClassCloned): " + Boolean.toString( simpleClass01.equals( simpleClassCloned)).toUpperCase() );
        System.out.println("value of simpleClass01    : " + simpleClass01);
        System.out.println("value of simpleClassBackup: " + simpleClassBackup);
        System.out.println("value of simpleClassCloned: " + simpleClassCloned);
        System.out.println("-----------------------------");
        System.out.println("--- SimpleClass change all value properties ---");
        System.out.println( "original simpleClass01:" + simpleClass01);
        simpleClass01.setId(0);
        simpleClass01.setBigDecimal( simpleClass01.getBigDecimal().add( new BigDecimal("1111.11")));
        simpleClass01.setName( simpleClass01.getName() + "+simpleClassSetName");
        simpleClass01.setDate( getDateObject( "05/05/2055"));
        System.out.println( "changed simpleClass01:" + simpleClass01);

        System.out.println( "---- Working with inherited Class ----");
        SimpleClassExtended simpleClassExtended = new SimpleClassExtended( simpleClass01,10,"simpleClassExtendedConstructor", getDateObject("06/06/1066"));
        SimpleClassExtended simpleClassExtCloned = (SimpleClassExtended) simpleClassExtended.clone();
        System.out.println("-- Initial Class values --");
  	    System.out.println("simpleClass01: " + simpleClass01);
        System.out.println("simpleClassExtended.getSimpleClass(): " + simpleClassExtended.getSimpleClass());
	    System.out.println("simpleClassExtended: " + simpleClassExtended);

        System.out.println("-- Values before modify --");
        System.out.println("simpleClass01: " + simpleClass01);
        System.out.println("simpleClassExtended.getSimpleClass(): " + simpleClassExtended.getSimpleClass());
        System.out.println("simpleClassExtended: " + simpleClassExtended);
        System.out.println("simpleClassExtCloned: " + simpleClassExtCloned);
        System.out.println("-- Modified field values of inherited class (mutable class)--");

        simpleClassExtended.setId( simpleClassExtended.getId() + 1);
        simpleClassExtended.setName("-simpleClassExtendedSetName");
        simpleClassExtended.setBigDecimal( simpleClassExtended.getBigDecimal().add( new BigDecimal("1111.11")));
        simpleClassExtended.getDate().setTime( simpleClassExtended.getDate().getTime() + 123456789L);

        simpleClassExtCloned.setId( simpleClassCloned.getId() + 10);
        simpleClassExtCloned.setName("-simpleClassCloned.setName");
        simpleClassExtCloned.setBigDecimal( simpleClassCloned.getBigDecimal().add( new BigDecimal("99999.99")));
        simpleClassExtCloned.getDate().setTime( simpleClassExtCloned.getDate().getTime() + 99999999L);

        simpleClassExtended.setIdExtended( simpleClassExtended.getIdExtended() + 1);
        simpleClassExtended.setNameExtended( simpleClassExtended.getNameExtended()+"-simpleClassExtended.setNameExtended");
        System.out.println("simpleClass01: " + simpleClass01);
        System.out.println("simpleClassExtended.getSimpleClass(): " + simpleClassExtended.getSimpleClass());
        System.out.println("simpleClassExtended: " + simpleClassExtended);
        System.out.println("simpleClassExtCloned.getSimpleClass(): " + simpleClassExtCloned.getSimpleClass());
        System.out.println("simpleClassExtCloned: " + simpleClassExtCloned);
    }

    static Date getDateObject(String sDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            return sdf.parse( sDate);
        } catch (ParseException pe) {
            pe.printStackTrace();
            return null;
        }
    }

}
