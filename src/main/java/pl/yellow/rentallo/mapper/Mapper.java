package pl.yellow.rentallo.mapper;


public interface Mapper<E, D> {

    D fromEntityToDto(E entity);
    E fromDtoToEntity(D dto);
}
