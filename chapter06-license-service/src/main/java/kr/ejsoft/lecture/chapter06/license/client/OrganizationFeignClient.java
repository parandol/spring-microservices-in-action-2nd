package kr.ejsoft.lecture.chapter06.license.client;

import kr.ejsoft.lecture.chapter06.license.model.Organization;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("organization-service")
public interface OrganizationFeignClient {
    @GetMapping("/v1/organization/{organizationId}")
    Organization getOrganization(@PathVariable String organizationId);

    @GetMapping("/v1/organization/{organizationId}/{clientType}")
    Organization getOrganization(@PathVariable String organizationId, @PathVariable String clientType);
}
