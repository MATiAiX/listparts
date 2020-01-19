package com.mtxsoftware.listparts.model.service;

import com.mtxsoftware.listparts.model.Part;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.List;

public interface ServicePart {
    Part getPartById(Long id);

    void savePart(Part part);

    void updatePart(Long id, String partName, String partNumber, Integer qty, Date shippedDate, Date receiveDate);

    void deletePart(Long id);

    List<Part> findAll();

    List<Part> findByPartName(String partName);
}
