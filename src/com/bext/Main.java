package com.bext;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
	    SimpleClass simpleClass = new SimpleClass(1,new BigDecimal("1232.12"),"simpleClassConstructor", getDateObject("01/01/2020"));
	    SimpleClassExtended simpleClassExtended = new SimpleClassExtended(simpleClass.getId(),simpleClass.getBigDecimal(),"simpleClassExtended"+simpleClass.getName(),simpleClass.getDate(),1,"simpleClassExtendedConstructor");
        System.out.println("-- Initial field values --");
  	    System.out.println(simpleClass);
	    System.out.println(simpleClassExtended);
        System.out.println("-- Modified field values (mutable class)--");
        simpleClass.setId(0);
        simpleClass.setBigDecimal( simpleClass.getBigDecimal().add( new BigDecimal("1111.11")));
        simpleClass.setName( simpleClass.getName() + "-simpleClasssetName");
        simpleClass.setDate( getDateObject( "05/05/2055"));
        simpleClassExtended.setId( 100);
	    simpleClassExtended.setName("-simpleClassExtendedSetName");
        simpleClassExtended.setDate( getDateObject("02/02/2022"));
        simpleClassExtended.setNameExtended( simpleClassExtended.getNameExtended()+"-simpleClassExtended.setNameExtended");
	    System.out.println(simpleClass);
        System.out.println(simpleClassExtended);
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
