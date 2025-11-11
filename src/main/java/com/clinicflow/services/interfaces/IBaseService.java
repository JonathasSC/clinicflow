package com.clinicflow.services.interfaces;

import java.util.List;

public interface IBaseService<TRequest, TResponse, ID> {

    TResponse create(TRequest request);

    List<TResponse> findAll();

    TResponse findById(ID id);

    TResponse update(ID id, TRequest request);

    void delete(ID id);
}
