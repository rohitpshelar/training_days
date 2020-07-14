package com.riomed.portal.mapper;


import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.riomed.portal.dto.ModuleDto;
import com.riomed.portal.model.Module;
import com.riomed.portal.model.User;


@Mapper(componentModel = "spring")
public interface  ModuleMapper {
	
	ModuleDto moduleToDto(Module module);
	
	@InheritInverseConfiguration
	@Mapping(target = "modCreated", expression = "java(java.time.Instant.now())")
	@Mapping(target = "modCreatedBy", source = "user.username")
	Module mapDtoToModule(ModuleDto moduleDto, User user);
	
	@Mapping(target = "modCreated", expression = "java(java.time.Instant.now())")
	@Mapping(target = "modCreatedBy", source = "user")
	Module mapDtoToModule(ModuleDto moduleDto, String user);

}
