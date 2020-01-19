package com.mtxsoftware.listparts.controller.helpers;

public enum SortNameColumns {
    PARTNAME("partname"),
    PARTNUMBER("partnumber"),
    VENDOR("vendor"),
    QTY("qty"),
    SHIPPEDDATE("shippeddate"),
    RECEIVEDATE("receivedate");


    private final String columnName;

    SortNameColumns(String columnName) {
        this.columnName = columnName;
    }

    public String getColumnName() {
        return columnName;
    }

    public static SortNameColumns valueNameOf(String name){
        for (SortNameColumns value : values()) {
            // либо equalsIgnoreCase, на ваше усмотрение
            if (value.getColumnName().equals(name)) {
                return value;
            }
        }

        throw new IllegalArgumentException("No enum found with name: [" + name + "]");
    }
}
