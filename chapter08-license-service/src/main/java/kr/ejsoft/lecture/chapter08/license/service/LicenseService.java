package kr.ejsoft.lecture.chapter08.license.service;

import kr.ejsoft.lecture.chapter08.license.client.OrganizationFeignClient;
import kr.ejsoft.lecture.chapter08.license.configure.ServiceConfigure;
import kr.ejsoft.lecture.chapter08.license.model.License;
import kr.ejsoft.lecture.chapter08.license.model.Organization;
import kr.ejsoft.lecture.chapter08.license.repository.LicenseRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.Locale;
import java.util.Random;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class LicenseService {
    @Qualifier("messageSource")
    private final MessageSource messages;

    private final LicenseRepository licenseRepository;

    private final ServiceConfigure serviceConfigure;

    private final OrganizationFeignClient organizationFeignClient;

    public License getLicense(String licenseId, String organizationId) {
//        return License.builder()
////                .id(new Random().nextInt(1000))
//                .licenseId(licenseId)
//                .organizationId(organizationId)
//                .description("Software product")
//                .productName("Ostock")
//                .licenseType("full")
//                .build();
        License license = licenseRepository.findByOrganizationIdAndLicenseId(organizationId, licenseId);
        if (license == null) {
            throw new IllegalArgumentException(String.format(messages.getMessage("license.search.error.message", null, null), licenseId, organizationId));
        }
        return license.withComment(serviceConfigure.getProperty());
    }

    public License getLicense(String licenseId, String organizationId, String clientType) {
        License license = licenseRepository.findByOrganizationIdAndLicenseId(organizationId, licenseId);
        if (license == null) {
            throw new IllegalArgumentException(String.format(messages.getMessage("license.search.error.message", null, null), licenseId, organizationId));
        }

        Organization organization = retrieveOrganizationInfo(organizationId, clientType);
        if( organization != null) {
            license.setOrganizationName(organization.getName());
            license.setContactName(organization.getContactName());
            license.setContactEmail(organization.getContactEmail());
            license.setContactPhone(organization.getContactPhone());
        }
        return license.withComment(serviceConfigure.getProperty());
    }

    private Organization retrieveOrganizationInfo(String organizationId, String clientType) {
        return organizationFeignClient.getOrganization(organizationId, clientType);
    }


    public License createLicense(License license, String organizationId, Locale locale) {
//        String responseMessage = null;
//        if(license != null) {
//            license.setOrganizationId(organizationId);
////            responseMessage = String.format("This is the post and the object is: %s", license.toString());
//            responseMessage = String.format(messages.getMessage("license.create.message", null, locale), license.toString());
//        }
//        return responseMessage;
        license.setLicenseId(UUID.randomUUID().toString());
        licenseRepository.save(license);
        return license.withComment(serviceConfigure.getProperty());
    }

    public License updateLicense(License license, String organizationId, Locale locale) {
//        String responseMessage = null;
//        if(license != null) {
//            license.setOrganizationId(organizationId);
//            responseMessage = String.format(messages.getMessage("license.update.message", null, locale), license.toString());
//        }
//        return responseMessage;
        licenseRepository.save(license);
        return license.withComment(serviceConfigure.getProperty());
    }

    public String deleteLicense(String licenseId, String organizationId, Locale locale) {
        String responseMessage = null;
        License license = License.builder().licenseId(licenseId).build();
        licenseRepository.delete(license);
        responseMessage = String.format(messages.getMessage("license.delete.message", null, locale), licenseId, organizationId);
        return responseMessage;
    }
}
