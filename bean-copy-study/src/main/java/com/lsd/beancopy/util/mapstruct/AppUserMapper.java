package com.lsd.beancopy.util.mapstruct;

import com.lsd.beancopy.dto.AppUserDTO;
import com.lsd.beancopy.model.AppUser;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @Author: lsd
 * @Description:
 * @Date:Create：in 2020-05-01 23:18
 * @Modified By：
 */
@Mapper
public interface AppUserMapper {

    AppUserMapper INSTANCE = Mappers.getMapper(AppUserMapper.class);

    AppUserDTO toDTO(AppUser source);

    List<AppUserDTO> toDTOs(List<AppUser> sources);

    AppUser to(AppUserDTO source);

}
