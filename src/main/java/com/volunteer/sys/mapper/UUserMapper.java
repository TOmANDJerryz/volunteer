package com.volunteer.sys.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.volunteer.sys.entity.UUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author jobob
 * @since 2019-01-18
 */
public interface UUserMapper extends BaseMapper<UUser> {

    @Select("SELECT * FROM u_user where id=#{id}")
    UUser selectUserById(String id);

    @Select("SELECT * FROM u_user WHERE email=#{username} AND pswd=#{password}")
    UUser loginDao(@Param("username") String username,@Param("password") String password);

    @Select("SELECT * FROM u_user")
    List<UUser> selectList();

    @Update("UPDATE u_user SET pswd = #{newPwd} WHERE id = #{id}")
    int updatePwd(@Param("id") String id,@Param("newPwd") String newPwd);

    @Select("SELECT pswd FROM u_user WHERE id = #{id}")
    String queryPwd(String id);

    @Insert("INSERT INTO u_user_role(uid,rid) VALUES(#{uid},#{rid})")
    int insertRidByuId(@Param("rid") String rid,@Param("uid") String uid);

    /**
     * 通过角色id关联查询用户信息
     */
    @Select("SELECT u.* from u_user_role ur LEFT JOIN u_user u ON ur.uid = u.id WHERE ur.rid = #{id}")
    IPage<UUser> queryUserByRoleId(IPage<UUser> page, String id);

    /**
     * 通过用户id
     * 删除用户管理角色表
     */
    @Delete("DELETE FROM u_user_role WHERE uid = #{id}")
    int deleteUserById(String id);
}
