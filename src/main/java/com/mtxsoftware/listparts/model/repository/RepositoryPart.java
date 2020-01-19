package com.mtxsoftware.listparts.model.repository;

import com.mtxsoftware.listparts.model.Part;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositoryPart extends CrudRepository<Part, Long> {
    List<Part> findByPartNameContaining(String partName);
}
