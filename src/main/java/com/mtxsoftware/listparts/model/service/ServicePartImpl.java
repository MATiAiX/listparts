package com.mtxsoftware.listparts.model.service;

import com.mtxsoftware.listparts.model.Part;
import com.mtxsoftware.listparts.model.repository.RepositoryPart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
public class ServicePartImpl implements ServicePart {


    private RepositoryPart repositoryPart;

    @Autowired
    public void setRepositoryPart(RepositoryPart repositoryPart) {
        this.repositoryPart = repositoryPart;
    }


    @Override
    public Part getPartById(Long id) {
        Optional<Part> optionalPart = repositoryPart.findById(id);
        return optionalPart.get();
    }

    @Override
    public void savePart(Part part) {
        repositoryPart.save(part);
    }

    @Override
    public void updatePart(Long id, String partname, String partnumber, Integer qty, LocalDate shippedDate, LocalDate receiveDate) {
        Part findPart = this.getPartById(id);
        findPart.setQty(qty);
        findPart.setPartName(partname);
        findPart.setReceiveDate(receiveDate);
        findPart.setShippedDate(shippedDate);

        repositoryPart.save(findPart);
    }

    @Override
    public void deletePart(Long id) {
        repositoryPart.deleteById(id);
    }


    @Override
    public List<Part> findAll() {
        //List<Part> lstPart = new ArrayList<>();
        // Iterable<Part> iterator = repositoryPart.findAll(pageable);
        // iterator.forEach(part -> lstPart.add(part));
        List<Part> resultList = new ArrayList<>();
        repositoryPart.findAll().iterator().forEachRemaining(resultList::add);
        return resultList;
    }

    @Override
    public List<Part> findByPartname(String partname) {
        List<Part> resultList = new ArrayList<>();
        repositoryPart.findByPartnameContaining(partname).iterator().forEachRemaining(resultList::add);
        return resultList;
    }

    @Override
    public List<Part> searchPart(String partname, String partnumber, String vendor, Integer qty,
                                 LocalDate fromShippedDate, LocalDate DatetoShippedDate,
                                 LocalDate fromReceiveDate, LocalDate toReceiveDate) {
        //String columnName, String sortDirection) {
        List<Part> resultList = new ArrayList<>();

        List<Part> result = repositoryPart.findPart(partname, partnumber, vendor, qty,
                fromShippedDate, DatetoShippedDate, fromReceiveDate, toReceiveDate);
        //"p." + columnName, sortDirection.name());
        result.iterator().

                forEachRemaining(resultList::add);
        return resultList;
    }
}
