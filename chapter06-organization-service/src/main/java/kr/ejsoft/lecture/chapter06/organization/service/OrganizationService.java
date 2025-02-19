package kr.ejsoft.lecture.chapter06.organization.service;

import kr.ejsoft.lecture.chapter06.organization.model.Organization;
import kr.ejsoft.lecture.chapter06.organization.repository.OrganizationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrganizationService {
    @Qualifier("messageSource")
    private final MessageSource messages;

    private final OrganizationRepository organizationRepository;

    public Organization getOrganization(String organizationId, String clientType) {
        Organization organization = organizationRepository.findByOrganizationIdAndClientType(organizationId, clientType);
        if (organization == null) {
            throw new IllegalArgumentException(String.format(messages.getMessage("organization.search.error.message", null, null), organizationId, clientType));
        }
        return organization;
    }
}
