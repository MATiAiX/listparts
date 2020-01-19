package com.mtxsoftware.listparts.model.service;

import com.mtxsoftware.listparts.model.Part;
import com.mtxsoftware.listparts.model.repository.RepositoryPart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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
    public void updatePart(Long id, String partName, String partNumber, Integer qty, Date shippedDate, Date receiveDate) {
        Part findPart = this.getPartById(id);
        findPart.setQty(qty);
        findPart.setPartName(partName);
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
    public List<Part> findByPartName(String partName) {
        List<Part> resultList = new ArrayList<>();
        repositoryPart.findByPartNameContaining(partName).iterator().forEachRemaining(resultList::add);
        return resultList;
    }

}
