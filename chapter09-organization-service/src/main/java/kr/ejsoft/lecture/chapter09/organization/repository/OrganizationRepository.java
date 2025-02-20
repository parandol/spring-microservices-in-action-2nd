package kr.ejsoft.lecture.chapter09.organization.repository;

import kr.ejsoft.lecture.chapter09.organization.model.Organization;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizationRepository extends CrudRepository<Organization, String> {

    public Organization findByOrganizationIdAndClientType(String organizationId, String clientType);
}
