package com.mtxsoftware.listparts.model.repository;

import com.mtxsoftware.listparts.model.Part;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface RepositoryPart extends JpaRepository<Part, Long> {
    List<Part> findByPartnameContaining(String partname);

    @Query("SELECT p FROM Part p WHERE " +
            "(:partname is null or p.partname like %:partname%) " +
            "and (:partnumber is null or p.partnumber like %:partnumber%) " +
            "and (:vendor is null or p.vendor like %:vendor%) " +
            "and (:qty is null or p.qty >= :qty)" +
            "and (:fromshippeddate is null or p.shippedDate >= :fromshippeddate)" +
            "and (:toshippeddate is null or p.shippedDate <= :toshippeddate)" +
            "and (:fromreceivedate is null or p.receiveDate >= :fromreceivedate)" +
            "and (:toreceivedate is null or p.receiveDate <= :toreceivedate)")
    List<Part> findPart(@Param("partname") String partname, @Param("partnumber") String partnumber,
                        @Param("vendor") String vendor, @Param("qty") Integer qty,
                        @Param("fromshippeddate") LocalDate fromShippedDate, @Param("toshippeddate") LocalDate toShippedDate,
                        @Param("fromreceivedate") LocalDate fromReceiveDate, @Param("toreceivedate") LocalDate toReceiveDate);
                        //@Param("columnname") String columnName//, @Param("sortdirection") String sortDirection);
}
