package kr.ejsoft.lecture.chapter09.organization.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="organization")
public class Organization {
    @Id
    @Column(name="organization_id", nullable=false)
    private String organizationId;

    @Column(name="name", nullable=false)
    private String name;
    @Column(name="contact_name", nullable=true)
    private String contactName;
    @Column(name="contact_email", nullable=true)
    private String contactEmail;
    @Column(name="contact_phone", nullable=true)
    private String contactPhone;

    @Column(name="client_type", nullable=false)
    private String clientType;
}