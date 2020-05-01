package com.lsd.beancopy;


import com.lsd.beancopy.dto.AppUserDTO;
import com.lsd.beancopy.model.AppUser;
import com.lsd.beancopy.util.mapstruct.AppUserMapper;

public class BeanCopyApplication {

    public static void main(String[] args) {


       AppUser appUser = ModelGenetator.creatAppUser(0);
       System.out.println(appUser.toString());

       AppUserDTO appUserDTO =  AppUserMapper.INSTANCE.toDTO(appUser);
       System.out.println(appUserDTO.toString());
    }

}
