package pt.colegio.colibri.model.mapper;

import org.mapstruct.Mapper;
import pt.colegio.colibri.business.core.Nota;
import pt.colegio.colibri.model.entity.NotaEntity;

import java.util.List;

@Mapper(componentModel = "spring")
public interface NotaModelMapper {

    NotaEntity convertToNotaEntity(Nota nota);
    Nota convertToNota(NotaEntity notaEntity);
    List<Nota> convertToNotaList(List<NotaEntity> notaEntities);
}
