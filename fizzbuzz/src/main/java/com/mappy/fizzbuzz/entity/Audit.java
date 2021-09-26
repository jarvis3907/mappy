package com.mappy.fizzbuzz.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

/**
 * The type Audit.
 */
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "AUDIT", schema = "FIZZ")
public class Audit {

    /**
     * The Id.
     */
    @Id
    @Column(name = "id", unique = true, nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    /**
     * The Payload.
     */
    @Column(name = "PAYLOAD", nullable = false)
    protected String payload;

    /**
     * The Created date.
     */
    @Column(name = "CREATED_DATE", nullable = false)
    @CreationTimestamp
    protected LocalDateTime createdDate;

    /**
     * The Updated date.
     */
    @Column(name = "UPDATED_DATE", nullable = false)
    @UpdateTimestamp
    protected LocalDateTime updatedDate;

    /**
     * The Created by.
     */
    @Column(name = "CREATED_BY", nullable = false)
    @Size(max = 100)
    protected String createdBy = "FIZZBUZZ";

    /**
     * The Updated by.
     */
    @Column(name = "UPDATED_BY", nullable = false)
    @Size(max = 100)
    protected String updatedBy = "FIZZBUZZ";

}
