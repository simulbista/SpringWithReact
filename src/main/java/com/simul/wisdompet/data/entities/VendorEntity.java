package com.simul.wisdompet.data.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

@Data
@Entity
@Table(name = "VENDORS")
@ToString
public class VendorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "VENDOR_ID")
    private long vendorId;

    @Column(name = "NAME")
    private String name;

    @Column(name = "CONTACT")
    private String contact;

    @Column(name = "EMAIL")
    private String emailAddress;

    @Column(name = "PHONE")
    private String phoneNumber;

    @Column(name = "ADDRESS")
    private String address;
}
