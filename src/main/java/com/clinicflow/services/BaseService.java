package com.clinicflow.services;

import com.clinicflow.services.interfaces.IBaseService;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public abstract class BaseService<T, ID, TRequest, TResponse> implements IBaseService<TRequest, TResponse, ID> {

    protected final JpaRepository<T, ID> repository;

    protected BaseService(JpaRepository<T, ID> repository) {
        this.repository = repository;
    }

    @Override
    public List<TResponse> findAll() {
        return repository.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    @Override
    public TResponse findById(ID id) {
        return repository.findById(id)
                .map(this::toResponse)
                .orElseThrow(() -> new RuntimeException("Entity not found"));
    }

    @Override
    public void delete(ID id) {
        repository.deleteById(id);
    }

    protected abstract T toEntity(TRequest request);
    protected abstract TResponse toResponse(T entity);
}
