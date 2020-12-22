package com.bext;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
	    SimpleClass simpleClass01 = new SimpleClass(1,new BigDecimal("1111.11"),"simpleClassConstructor", getDateObject("01/01/2020"));

        SimpleClass simpleClassBackup = new SimpleClass( simpleClass01);
        System.out.println("simpleClass01: " + simpleClass01);
        System.out.println("Modifying state of simpleClass01");
        System.out.println( "simpleClass01.getDate().getTime():" + simpleClass01.getDate().getTime() );
        simpleClass01.getDate().setTime( simpleClass01.getDate().getTime() + 1234567890L );
        System.out.println("modified value of simpleClass01: " + simpleClass01);

        System.out.println( "simpleClass01.equals(simpleClassBackup): " + Boolean.toString( simpleClass01.equals( simpleClassBackup)).toUpperCase() );
        System.out.println("original value of simpleClass01: " + simpleClass01);
        System.out.println("modified value of simpleClassBackup: " + simpleClassBackup);
        System.out.println("-----------------------------");
        System.out.println("--- SimpleClass change all value properties ---");
        System.out.println( "original simpleClass01:" + simpleClass01);
        simpleClass01.setId(0);
        simpleClass01.setBigDecimal( simpleClass01.getBigDecimal().add( new BigDecimal("1111.11")));
        simpleClass01.setName( simpleClass01.getName() + "+simpleClassSetName");
        simpleClass01.setDate( getDateObject( "05/05/2055"));
        System.out.println( "changed simpleClass01:" + simpleClass01);

        System.out.println( "---- Working with inherited Class ----");
        SimpleClassExtended simpleClassExtended = new SimpleClassExtended( simpleClass01,1,"simpleClassExtendedConstructor");
        System.out.println("-- Initial Class values --");
  	    System.out.println("simpleClass01: " + simpleClass01);
        System.out.println("simpleClassExtended.getSimpleClass(): " + simpleClassExtended.getSimpleClass());
	    System.out.println("simpleClassExtended: " + simpleClassExtended);

        System.out.println("-- Values before modify --");
        System.out.println("simpleClass01: " + simpleClass01);
        System.out.println("simpleClassExtended.getSimpleClass(): " + simpleClassExtended.getSimpleClass());
        System.out.println("simpleClassExtended: " + simpleClassExtended);
        System.out.println("-- Modified field values inherited class (mutable class)--");

        simpleClassExtended.setId( simpleClassExtended.getId() + 1);
        simpleClassExtended.setName("-simpleClassExtendedSetName");
        simpleClassExtended.setBigDecimal( simpleClassExtended.getBigDecimal().add( new BigDecimal("1111.11")));
        simpleClassExtended.getDate().setTime( simpleClassExtended.getDate().getTime() + 123456789L);

        simpleClassExtended.setIdExtended( simpleClassExtended.getIdExtended() + 1);
        simpleClassExtended.setNameExtended( simpleClassExtended.getNameExtended()+"-simpleClassExtended.setNameExtended");
        System.out.println("simpleClass01: " + simpleClass01);
        System.out.println("simpleClassExtended.getSimpleClass(): " + simpleClassExtended.getSimpleClass());
        System.out.println("simpleClassExtended: " + simpleClassExtended);
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
