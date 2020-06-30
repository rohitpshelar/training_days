package com.riomed.portal.mapper;

import com.riomed.portal.dto.ModuleDto;
import com.riomed.portal.model.Module;
import com.riomed.portal.model.User;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-06-30T09:17:45+0530",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 11 (Oracle Corporation)"
)
@Component
public class ModuleMapperImpl implements ModuleMapper {

    @Override
    public ModuleDto moduleToDto(Module module) {
        if ( module == null ) {
            return null;
        }

        ModuleDto moduleDto = new ModuleDto();

        moduleDto.setModId( module.getModId() );
        moduleDto.setModName( module.getModName() );
        moduleDto.setModStatus( module.getModStatus() );

        return moduleDto;
    }

    @Override
    public Module mapDtoToModule(ModuleDto moduleDto, User user) {
        if ( moduleDto == null && user == null ) {
            return null;
        }

        Module module = new Module();

        if ( moduleDto != null ) {
            module.setModId( moduleDto.getModId() );
            module.setModName( moduleDto.getModName() );
            module.setModStatus( moduleDto.getModStatus() );
        }
        if ( user != null ) {
            module.setModCreatedBy( user.getUsername() );
        }
        module.setModCreated( java.time.Instant.now() );

        return module;
    }
}
