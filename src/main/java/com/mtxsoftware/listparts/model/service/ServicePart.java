package com.mtxsoftware.listparts.model.service;

import com.mtxsoftware.listparts.model.Part;

import java.time.LocalDate;
import java.util.List;

public interface ServicePart {
    Part getPartById(Long id);

    void savePart(Part part);

    void updatePart(Long id, String partname, String partnumber, Integer qty, LocalDate shippedDate, LocalDate receiveDate);

    void deletePart(Long id);

    List<Part> findAll();

    List<Part> findByPartname(String partname);

    List<Part> searchPart(String partname, String partnumber, String vendor, Integer qty,
                          LocalDate fromShippedDate, LocalDate DatetoShippedDate,
                          LocalDate fromReceiveDate, LocalDate toReceiveDate);
                          //String columnName, String sortDirection);
}
