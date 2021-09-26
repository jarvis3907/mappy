package com.mappy.fizzbuzz.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mappy.fizzbuzz.AuditRepository;
import com.mappy.fizzbuzz.entity.Audit;
import com.mappy.fizzbuzz.service.ILoggingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

/**
 * The type Logging service.
 */
@Service
@Slf4j
public class LoggingService implements ILoggingService {

    private AuditRepository auditRepository;

    /**
     * Instantiates a new Logging service.
     *
     * @param auditRepository the audit repository
     */
    public LoggingService(AuditRepository auditRepository) {
        this.auditRepository = auditRepository;
    }

    @Override
    public void logRequest(HttpServletRequest httpServletRequest, Object body) {
        persistAudit(asJsonString(body));
        log.info("Size of the audit log {}", auditRepository.findAll().size());
    }


    private void persistAudit(String payload) {
        LocalDateTime localDateTime = LocalDateTime.now();
        Audit audit = Audit.builder().payload(payload).createdDate(localDateTime).updatedDate(localDateTime).createdBy("FIZZ").updatedBy("FIZZ").build();
        auditRepository.save(audit);
    }

    private String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
