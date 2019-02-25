package com.volunteer.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.volunteer.sys.entity.UUser;
import com.volunteer.sys.mapper.UUserMapper;
import com.volunteer.sys.service.IUUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.volunteer.utils.IdGen;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jobob
 * @since 2019-01-18
 */
@Service
public class UUserServiceImpl extends ServiceImpl<UUserMapper, UUser> implements IUUserService {


    @Autowired
    private UUserMapper userMapper;


    @Override
    public UUser selectUser(String id) {
        return userMapper.selectUserById(id);
    }

    @Override
    public int deleteByIdUser(String id){
        //删除关联
        userMapper.deleteUserById(id);
        return userMapper.deleteUserById(id);
    }

    @Override
    public int addUser(UUser user,String rid){
        user.setId(IdGen.uuid());
        user.setCreateTime(LocalDateTime.now());
        //添加权限
        int flag =userMapper.insert(user);
        if(flag==1){
            return userMapper.insertRidByuId(rid,user.getId());
        }
        return flag;

    }

    @Override
    public int updateByIdUser(UUser user){
            return  userMapper.updateById(user);
    }
    public int updatePwd(String id,String oldPwd,String newPwd){
        //查询原密码
        String oldPwds = userMapper.queryPwd(id);
        if (oldPwds.equals(oldPwd)){
            return userMapper.updatePwd(id,newPwd);
        }else {
            return 0;
        }
    }


    /**
     * 不带分页查询所有用户

     * @return
     */
    @Override
    public List<UUser> queryList(){
        List<UUser> list = userMapper.selectList();
        return list;
    }

    @Override
    public UUser login(String username,String password){
        return userMapper.loginDao(username,password);
    }


    /**
     * 根据用户角色查询用户分页
     */
    @Override
    public IPage<UUser> queryUserByRoleId(IPage<UUser> page,String id){
        return userMapper.queryUserByRoleId(page,id);
    }
}
