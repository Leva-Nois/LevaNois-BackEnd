package com.levanois.levanoisAPI.converters;

import com.levanois.levanoisAPI.models.usuario.Usuario;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class StatusUsuarioConverter implements AttributeConverter<Usuario.StatusUsuario, String> {

    @Override
    public String convertToDatabaseColumn(Usuario.StatusUsuario statusUsuario) {
        if (statusUsuario == null) {
            return null;
        }
        return statusUsuario.getValue();
    }

    @Override
    public Usuario.StatusUsuario convertToEntityAttribute(String dbData) {
        if (dbData == null) {
            return null;
        }
        return Usuario.StatusUsuario.fromValue(dbData);
    }
}
