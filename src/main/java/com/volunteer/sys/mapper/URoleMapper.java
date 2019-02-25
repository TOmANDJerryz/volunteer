package com.volunteer.sys.mapper;

import com.volunteer.sys.entity.URole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.volunteer.sys.entity.UUser;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author jobob
 * @since 2019-01-18
 */
public interface URoleMapper extends BaseMapper<URole> {

    @Select("SELECT * FROM s_role limit #{currPage},#{pageSize}")
    List<URole> queryRolePage(URole roles);

    @Select("select u_permission.url from u_role_permission LEFT JOIN u_permission  on u_role_permission.pid= u_permission.id WHERE u_role_permission.rid = #{rid}")
    List<String> queryPermiss(String rid);

    @Delete("delete FROM u_role_permission where rid = #{rid}")
    int deletePermiss(String rid);

    @Insert("INSERT INTO u_role_permission(rid,pid) VALUES (#{rid},#{pid})")
    int updatePermiss(@Param("rid") String rid,@Param("pid") String pid);

    @Select("select id FROM u_permission where url = #{pidu}")
    String queryPermissionByid(String pidu);

    @Select("SELECT u_user.* FROM u_user_role LEFT JOIN u_user ON u_user_role.uid = u_user.id WHERE u_user_role.rid = #{rid}")
    List<UUser> queryUserByRid(String rid);

}
