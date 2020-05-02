package com.lsd.beancopy;


import com.lsd.beancopy.dto.AppUserDTO;
import com.lsd.beancopy.model.AppUser;
import com.lsd.beancopy.util.cglib.CopyUtil;
import com.lsd.beancopy.util.mapstruct.AppUserMapper;

import java.util.Calendar;
import java.util.List;

public class BeanCopyApplication {

    public static void main(String[] args) {


        List<AppUser> appUsers = ModelGenetator.createAppusers(100);

        long startTime1 = Calendar.getInstance().getTimeInMillis();
        AppUserMapper.INSTANCE.toDTOs(appUsers);
        long endTime1 = Calendar.getInstance().getTimeInMillis();

        System.out.println((endTime1 - startTime1) + "毫秒");


        long startTime2 = Calendar.getInstance().getTimeInMillis();
        CopyUtil.toList(appUsers, AppUserDTO.class);
        long endTime2 = Calendar.getInstance().getTimeInMillis();

        System.out.println((endTime2 - startTime2) + "毫秒");


        long startTime3 = Calendar.getInstance().getTimeInMillis();
        com.lsd.beancopy.util.beanutils.CopyUtil.toList(appUsers, AppUserDTO.class);
        long endTime3 = Calendar.getInstance().getTimeInMillis();

        System.out.println((endTime3 - startTime3) + "毫秒");
    }

}
