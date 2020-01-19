package com.mtxsoftware.listparts.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "part", schema = "testpart")
public class Part {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "part_name")
    private String partname;

    @Column(name = "part_number")
    private String partnumber;

    @Column(name = "vendor")
    private String vendor;

    @Column(name = "qty")
    private Integer qty;

    @Column(name = "shipped_date")
    private LocalDate shippedDate;

    @Column(name = "receive_date")
    private LocalDate receiveDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPartName() {
        return partname;
    }

    public void setPartName(String partname) {
        this.partname = partname;
    }

    public String getPartNumber() {
        return partnumber;
    }

    public void setPartNumber(String partnumber) {
        this.partnumber = partnumber;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public LocalDate getShippedDate() {
        return shippedDate;
    }

    public void setShippedDate(LocalDate shippedDate) {
        this.shippedDate = shippedDate;
    }

    public LocalDate getReceiveDate() {
        return receiveDate;
    }

    public void setReceiveDate(LocalDate receiveDate) {
        this.receiveDate = receiveDate;
    }
}
