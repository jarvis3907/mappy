package com.mappy.fizzbuzz.service;

import com.mappy.fizzbuzz.AuditRepository;
import com.mappy.fizzbuzz.entity.Audit;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

/**
 * The type Audit repo parameter resolver.
 */
public class AuditRepoParameterResolver implements ParameterResolver {

    @Override
    public Object resolveParameter(ParameterContext parameterContext,
                                   ExtensionContext extensionContext) throws ParameterResolutionException {
        return new AuditRepository() {
            @Override
            public List<Object[]> findAllControlRunAfterDate() {
                return null;
            }

            @Override
            public List<Audit> findAll() {
                return null;
            }

            @Override
            public List<Audit> findAll(Sort sort) {
                return null;
            }

            @Override
            public List<Audit> findAllById(Iterable<Integer> iterable) {
                return null;
            }

            @Override
            public <S extends Audit> List<S> saveAll(Iterable<S> iterable) {
                return null;
            }

            @Override
            public void flush() {

            }

            @Override
            public <S extends Audit> S saveAndFlush(S s) {
                return null;
            }

            @Override
            public <S extends Audit> List<S> saveAllAndFlush(Iterable<S> iterable) {
                return null;
            }

            @Override
            public void deleteAllInBatch(Iterable<Audit> iterable) {

            }

            @Override
            public void deleteAllByIdInBatch(Iterable<Integer> iterable) {

            }

            @Override
            public void deleteAllInBatch() {

            }

            @Override
            public Audit getOne(Integer integer) {
                return null;
            }

            @Override
            public Audit getById(Integer integer) {
                return null;
            }

            @Override
            public <S extends Audit> List<S> findAll(Example<S> example) {
                return null;
            }

            @Override
            public <S extends Audit> List<S> findAll(Example<S> example, Sort sort) {
                return null;
            }

            @Override
            public Page<Audit> findAll(Pageable pageable) {
                return null;
            }

            @Override
            public <S extends Audit> S save(S s) {
                return null;
            }

            @Override
            public Optional<Audit> findById(Integer integer) {
                return Optional.empty();
            }

            @Override
            public boolean existsById(Integer integer) {
                return false;
            }

            @Override
            public long count() {
                return 0;
            }

            @Override
            public void deleteById(Integer integer) {

            }

            @Override
            public void delete(Audit audit) {

            }

            @Override
            public void deleteAllById(Iterable<? extends Integer> iterable) {

            }

            @Override
            public void deleteAll(Iterable<? extends Audit> iterable) {

            }

            @Override
            public void deleteAll() {

            }

            @Override
            public <S extends Audit> Optional<S> findOne(Example<S> example) {
                return Optional.empty();
            }

            @Override
            public <S extends Audit> Page<S> findAll(Example<S> example, Pageable pageable) {
                return null;
            }

            @Override
            public <S extends Audit> long count(Example<S> example) {
                return 0;
            }

            @Override
            public <S extends Audit> boolean exists(Example<S> example) {
                return false;
            }
        };
    }

    @Override
    public boolean supportsParameter(ParameterContext parameterContext,
                                     ExtensionContext extensionContext) throws ParameterResolutionException {
        return (parameterContext.getParameter().getType() == AuditRepository.class);
    }

}
