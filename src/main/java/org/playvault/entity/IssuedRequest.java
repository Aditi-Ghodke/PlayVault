package org.playvault.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "issuerequests")
public class IssuedRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long requestId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "equipment_equipment_id")
    private Equipment equipment;

    private int quantity;
    private double requestDate;

    @Enumerated(EnumType.STRING)
    private RequestStatus status;
}
