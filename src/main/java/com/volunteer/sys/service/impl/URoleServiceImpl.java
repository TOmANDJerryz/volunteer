package com.volunteer.sys.service.impl;

import com.volunteer.sys.entity.URole;
import com.volunteer.sys.entity.UUser;
import com.volunteer.sys.mapper.URoleMapper;
import com.volunteer.sys.service.IURoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.volunteer.utils.IdGen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jobob
 * @since 2019-01-18
 */
@Service
public class URoleServiceImpl extends ServiceImpl<URoleMapper, URole> implements IURoleService {

    @Autowired
    private URoleMapper roleMapper;





    @Override
    public List<String> queryPermission(String rid){
        return roleMapper.queryPermiss(rid);

    }


    /**
     * 编辑权限
     * 1.删除所有权限
     * 2.添加权限
     */
    @Override
    public int updatePermission(String rid,String[] pidu){
        int flag =0;
        int result = roleMapper.deletePermiss(rid);
        for(int i=0;i<pidu.length;i++){
            String  pid = roleMapper.queryPermissionByid(pidu[i]);
            flag = roleMapper.updatePermiss(rid,pid);
        }

        return flag;
    }



    /**
     * 通过角色id查询用户
     */
    @Override
    public List<UUser> queryUserByRid(String rid){
        return roleMapper.queryUserByRid(rid);
    }
}
