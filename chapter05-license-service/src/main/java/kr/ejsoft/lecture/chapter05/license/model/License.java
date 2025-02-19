package kr.ejsoft.lecture.chapter05.license.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;

@Getter
@Setter
@Builder
@ToString
@Entity
@Table(name="licenses")
public class License extends RepresentationModel<License> {
    @Id
    @Column(name="license_id", nullable=false)
    private String licenseId;
    @Column(name="description")
    private String description;
    @Column(name="organization_id", nullable=false)
    private String organizationId;
    @Column(name="product_name", nullable=false)
    private String productName;
    @Column(name="license_type", nullable=false)
    private String licenseType;
    @Column(name="comment")
    private String comment;

    public License withComment(String comment) {
        this.setComment(comment);
        return this;
    }
}
