package com.order.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;

@Data
@Entity
@Table(name = "orders")
public class Order  {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id" ,nullable = false)
    private long id;

    @Column(name = "orderId" ,nullable = false)
    private String orderId;

    @Column(name = "quantity" ,nullable = false)
    private int quantity;

    @Column(name = "description" ,nullable = false)
    private String description;

    @Setter(AccessLevel.NONE)
    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date" ,nullable = false)
    private Date date;

}
