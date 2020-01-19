package com.mtxsoftware.listparts.controller;


import com.mtxsoftware.listparts.controller.helpers.SortDirection;
import com.mtxsoftware.listparts.controller.helpers.SortNameColumns;
import com.mtxsoftware.listparts.model.Part;
import com.mtxsoftware.listparts.model.service.ServicePart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ControllerPart {

    private ServicePart servicePart;
    private SortDirection selectingSortDirection;
    private SortNameColumns selectingSortColumn;

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
    public List<Part> searchPart(@RequestParam(value = "partname") String partName,
                                 @RequestParam(value = "partnumber") String partNumber,
                                 @RequestParam(value = "vendor") String vendor,
                                 @RequestParam(value = "qty") Integer qty,
                                 @RequestParam(value = "columnname") SortNameColumns columnName,
                                 @RequestParam(value = "sortdirection") String sortDirection) {
        List<Part> partsByName = servicePart.findByPartName(columnName.getColumnName());
        return partsByName;
    }
}
