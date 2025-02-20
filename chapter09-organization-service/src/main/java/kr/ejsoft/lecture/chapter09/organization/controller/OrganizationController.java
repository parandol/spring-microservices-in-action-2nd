package kr.ejsoft.lecture.chapter09.organization.controller;

import kr.ejsoft.lecture.chapter09.organization.model.License;
import kr.ejsoft.lecture.chapter09.organization.model.Organization;
import kr.ejsoft.lecture.chapter09.organization.service.OrganizationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/organization/{organizationId}")
public class OrganizationController {
    private final OrganizationService organizationService;

    @GetMapping("/{clientType}")
    public ResponseEntity<Organization> getOrganization(
            @PathVariable String organizationId,
            @PathVariable String clientType
    ) {
        Organization organization = organizationService.getOrganization(organizationId, clientType);

//        license.add(
//                linkTo(methodOn(OrganizationController.class)
//                        .getLicense(organizationId, license.getLicenseId()))
//                        .withSelfRel(),
//                linkTo(methodOn(OrganizationController.class)
//                        .createLicense(organizationId, license, null))
//                        .withRel("createLicense"),
//                linkTo(methodOn(OrganizationController.class)
//                        .updateLicense(organizationId, license, null))
//                        .withRel("updateLicense"),
//                linkTo(methodOn(OrganizationController.class)
//                        .deleteLicense(organizationId, license.getLicenseId(), null))
//                        .withRel("deleteLicense")
//                );


        return ResponseEntity.ok(organization);
    }

//    @PostMapping
//    public ResponseEntity<License> createLicense(
//            @PathVariable String organizationId,
//            @RequestBody License license,
//            @RequestHeader(value="Accept-Language", required = false) Locale locale
//    ) {
//        return ResponseEntity.ok(licenseService.createLicense(license, organizationId, locale));
//    }
//
//    @PutMapping
//    public ResponseEntity<License> updateLicense(
//            @PathVariable String organizationId,
//            @RequestBody License license,
//            @RequestHeader(value="Accept-Language", required = false) Locale locale
//    ) {
//        return ResponseEntity.ok(licenseService.updateLicense(license, organizationId, locale));
//    }
//
//    @DeleteMapping("/{licenseId}")
//    public ResponseEntity<String> deleteLicense(@PathVariable String organizationId, @PathVariable String licenseId, @RequestHeader(value="Accept-Language", required = false) Locale locale) {
//        return ResponseEntity.ok(licenseService.deleteLicense(licenseId, organizationId, locale));
//    }
//
//    @GetMapping("/{licenseId}/{clientType}")
//    public License getLicensesWithClient(
//            @PathVariable String organizationId,
//            @PathVariable String licenseId,
//            @PathVariable String clientType
//    ) {
//        return licenseService.getLicense(licenseId, organizationId, clientType);
//    }
}
