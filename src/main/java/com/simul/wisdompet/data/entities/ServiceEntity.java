package com.simul.wisdompet.data.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "SERVICES")
@ToString
public class ServiceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SERVICE_ID")
    private long id;

    @Column(name = "PRICE")
    private BigDecimal price;

    @Column(name = "NAME")
    private String name;
}
