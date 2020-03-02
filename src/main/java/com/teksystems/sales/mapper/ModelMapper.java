package com.teksystems.sales.mapper;

public interface ModelMapper<E, D> {
	
	public D mapToDTO(E dao);
	public E mapToEntity(D dto);

}
