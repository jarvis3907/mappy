package com.mappy.fizzbuzz;

import com.mappy.fizzbuzz.entity.Audit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * The interface Audit repository.
 */
public interface AuditRepository extends JpaRepository<Audit, Integer> {

    /**
     * Find all control run after date list.
     *
     * @return the list
     */
    @Query(nativeQuery = true, value = "SELECT payload,count(id) as controlRunCount from FIZZ.AUDIT  group by payload order by controlRunCount desc limit 1 ")
    List<Object[]> findAllControlRunAfterDate();
}
