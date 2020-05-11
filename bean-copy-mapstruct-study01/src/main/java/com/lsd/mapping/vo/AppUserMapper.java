package com.lsd.mapping.vo;

import com.lsd.mapping.annotation.LsdMapper;

/**
 * @Author: nhsoft.lsd
 * @Description:
 * @Date:Create：in 2020-05-10 18:42
 * @Modified By：
 */
@LsdMapper
public interface AppUserMapper {

    AppUserDTO toDTO(AppUser model);
}
