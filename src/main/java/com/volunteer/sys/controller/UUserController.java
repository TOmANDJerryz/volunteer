package com.volunteer.sys.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.volunteer.base.ResponseTable;
import com.volunteer.base.Result;
import com.volunteer.base.ResultGenerator;
import com.volunteer.base.TableResult;
import com.volunteer.sys.entity.UUser;
import com.volunteer.sys.service.IUUserService;
import com.volunteer.sys.service.impl.UUserServiceImpl;
import com.volunteer.utils.IdGen;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  用户管理
 * </p>
 *
 * @author jobob
 * @since 2019-01-18
 */
@RestController
@RequestMapping("/sys/u-user")
public class UUserController {

    @Autowired
    IUUserService userService;
    @ApiOperation(value = "用户分页查询")
    @GetMapping("/userPage")
    public ResponseTable userPage(Integer page,Integer limit){
        IPage<UUser> list = userService.page(new Page<>(page, limit),null);
        return TableResult.success("0", "查询成功",list.getTotal(), list.getRecords());
    }
    /**
     * 根据Id查询用户信息
     */
    @GetMapping("/queryByIdUser")
    @ResponseBody
    public Result queryByIdUser(String id){
        UUser user = userService.getById(id);
        if(null!=user){
            return ResultGenerator.genSuccessResult(user);
        }else {
            return ResultGenerator.genFailResult("成功");
        }
    }

    /**
     * 根据id删除用户
     * @param id
     * @return
     */
    @PostMapping("/deleteByIdUser")
    @ResponseBody
    public Result deleteByIdUser(String id){
        boolean flag = userService.removeById(id);
        if(flag){
            return ResultGenerator.genSuccessResult("删除成功");
        }else{
            return ResultGenerator.genFailResult("删除失败");
        }
    }
    /**
     * 注册用户
     */
    @PostMapping("/addUser")
    @ResponseBody
    public Result addUser(UUser user,String rid){
        user.setId(IdGen.uuid());
        boolean flag = userService.save(user);

        if(flag){
            return ResultGenerator.genSuccessResult("添加成功");
        }else {
            return ResultGenerator.genSuccessResult("添加失败");
        }
    }

    /**
     * 登录
     */
    @PostMapping("/login")
    public Result login(String userName,String password){
        UUser user = userService.login(userName,password);
        if(user != null){
            return ResultGenerator.genSuccessResult("添加成功");
        }else {
            return ResultGenerator.genSuccessResult("用户名或者密码错误");
        }


    }
    /**
     * 修改用户信息
     * @param user
     * @return
     */
    @PostMapping("/updateByIdUser")
    @ResponseBody
    public Result updateByIdUser(UUser user){
        int flag = userService.updateByIdUser(user);
        if(flag==1){
            return ResultGenerator.genSuccessResult("修改成功");
        }else {
            return ResultGenerator.genSuccessResult("修改失败");
        }
    }
    /**
     * 修改密码
     */
    @PostMapping("/updatePwd")
    @ResponseBody
    @ApiOperation(value="修改密码", notes="修改密码")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "String", paramType = "query")
    public Result updatePwd(String id,String oldPwd,String newPwd){
        int flag = userService.updatePwd(id,oldPwd,newPwd);
        if(flag==1){
            return ResultGenerator.genSuccessResult("修改成功");
        }else {
            return ResultGenerator.genSuccessResult("修改失败");
        }
    }

    /**
     * 批量删除
     *
     */
    @PostMapping("/deleteUserByIds")
    @ResponseBody
    public Result deleteUser(@RequestBody List<String> ids){
        boolean flag = userService.removeByIds(ids);
        if(flag){
            return ResultGenerator.genSuccessResult("删除成功");
        }else {
            return ResultGenerator.genSuccessResult("删除失败");
        }
    }


    /**
     * 根据用户角色id查询用户分页查询
     *
     */
    @PostMapping("/queryUserByRoleId")
    @ResponseBody
    public Result queryUserByRoleId(Integer pageNum,Integer pageSize,String id){
        if(id!=null || !id.equals("")){
            IPage<UUser> list = userService.queryUserByRoleId(new Page<>(pageNum,pageSize),id);
            return ResultGenerator.genSuccessResult(list);
        }
        IPage<UUser> list = userService.page(new Page<>(pageNum,pageSize),null);
        return ResultGenerator.genSuccessResult(list);


    }

}
