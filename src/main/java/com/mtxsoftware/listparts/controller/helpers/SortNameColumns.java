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
}
