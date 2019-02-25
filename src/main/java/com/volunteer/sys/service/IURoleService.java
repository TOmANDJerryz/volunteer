package com.volunteer.sys.service;

import com.volunteer.sys.entity.URole;
import com.baomidou.mybatisplus.extension.service.IService;
import com.volunteer.sys.entity.UUser;
import com.volunteer.utils.Ztree;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jobob
 * @since 2019-01-18
 */
public interface IURoleService extends IService<URole> {

    List<String> queryPermission(String rid);

    int updatePermission(String rid, String[] pidu);

    List<UUser> queryUserByRid(String rid);

}
