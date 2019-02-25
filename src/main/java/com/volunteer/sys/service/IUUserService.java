package com.volunteer.sys.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.volunteer.sys.entity.UUser;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jobob
 * @since 2019-01-18
 */
public interface IUUserService extends IService<UUser> {
    UUser selectUser(String id);

    int deleteByIdUser(String id);

    int addUser(UUser user,String rid);

    int updateByIdUser(UUser user);

    int updatePwd(String id,String oldPwd,String newPwd);


    List<UUser> queryList();

    UUser login(String username, String password);


    IPage<UUser> queryUserByRoleId(IPage<UUser> page,String id);

}
