package com.mtxsoftware.listparts.controller;


import com.mtxsoftware.listparts.controller.helpers.SortDirection;
import com.mtxsoftware.listparts.controller.helpers.SortNameColumns;
import com.mtxsoftware.listparts.model.Part;
import com.mtxsoftware.listparts.model.service.ServicePart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
public class ControllerPart {

    private ServicePart servicePart;
    private SortDirection selectingSortDirection;
    private SortNameColumns selectingSortColumn;
    private static final DateTimeFormatter dtfForParams = DateTimeFormatter.ofPattern("MMM-dd-yyyy");
    private static final DateTimeFormatter dtfForSee = DateTimeFormatter.ofPattern("MMM dd, yyyy");

    @Autowired
    public ControllerPart(ServicePart servicePart) {
        this.servicePart = servicePart;
        selectingSortDirection = SortDirection.ASC;
        selectingSortColumn = SortNameColumns.PARTNAME;
    }

    @GetMapping("/allpart")
    public List<Part> getAllPart() {
        List<Part> allParts = servicePart.findAll();
        return allParts;
    }

    @PostMapping(value = "/part")
    public Part createPart(@RequestBody Part part) {
        servicePart.savePart(part);
        return part;
    }

    @GetMapping("/searchpart")
    public List<Part> searchPart(@RequestParam(value = "partname", required = false) String partname,
                                 @RequestParam(value = "partnumber", required = false) String partnumber,
                                 @RequestParam(value = "vendor", required = false) String vendor,
                                 @RequestParam(value = "qty", required = false) Integer qty,
                                 @RequestParam(value = "fromshippeddate", required = false) String fromShippedDate,
                                 @RequestParam(value = "toshippeddate", required = false) String toShippedDate,
                                 @RequestParam(value = "fromreceivedate", required = false) String fromReceiveDate,
                                 @RequestParam(value = "toreceivedate", required = false) String toReceiveDate,
                                 @RequestParam(value = "columnname", required = false) @Nullable String columnName,
                                 @RequestParam(value = "sortdirection", required = false) @Nullable String sortDirection) {

        LocalDate fromShippedDateObj = null;
        if (fromShippedDate != null) fromShippedDateObj = LocalDate.parse(fromShippedDate, dtfForParams);
        LocalDate toShippedDateObj = null;
        if (toShippedDate != null) toShippedDateObj = LocalDate.parse(toShippedDate, dtfForParams);

        LocalDate fromReceiveDateObj = null;
        if (fromReceiveDate != null) fromReceiveDateObj = LocalDate.parse(fromReceiveDate, dtfForParams);
        LocalDate toReceiveDateObj = null;
        if (toReceiveDate != null) toReceiveDateObj = LocalDate.parse(toReceiveDate, dtfForParams);

        String sortNameColumns = null;
        if (columnName != null) sortNameColumns = SortNameColumns.valueNameOf(columnName).getColumnName();

        String sortDirectionName = null;
        if (sortDirection != null) sortDirectionName = SortDirection.valueOf(sortDirection).name();


        List<Part> partsByName = servicePart.searchPart(
                partname, partnumber, vendor, qty,
                fromShippedDateObj, toShippedDateObj,
                fromReceiveDateObj, toReceiveDateObj);
                //sortNameColumns, sortDirectionName);
        return partsByName;
    }
}
