package com.measuring.equipment.utility;

import java.util.Arrays;
import java.util.List;

public class Units {

    public static List<String> units(){
        return Arrays.asList(
                "mm","Micron","Meter","Minutes","Deg","Shore-A","Celsius",
                "Relative","C/RH","g","Kgf","Nm","N","HRC","HRB",
                "HB","Ohm","K Ohm","M Ohm","G Ohm","pH","Kg",
                "KN","GM","NA","bar","Kg/cm2","Mpa","Psi",
                "Count","Mbar","m A","Bar / m A","L/min",
                "ml","KPA","mm/mtrs","Amp","DB"
        );
    }
}
