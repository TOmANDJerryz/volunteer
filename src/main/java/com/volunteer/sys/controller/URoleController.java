package com.volunteer.sys.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.volunteer.base.ResponseTable;
import com.volunteer.base.Result;
import com.volunteer.base.ResultGenerator;
import com.volunteer.base.TableResult;
import com.volunteer.sys.entity.URole;
import com.volunteer.sys.entity.UUser;
import com.volunteer.sys.service.IURoleService;
import com.volunteer.utils.IdGen;
import com.volunteer.utils.Ztree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jobob
 * @since 2019-01-18
 */
@RestController
@RequestMapping("/sys/u-role")
public class URoleController {

    @Autowired
    IURoleService roleService;
    /**
     * 分页查询角色
     */
    @RequestMapping(value = "/listRole", method = RequestMethod.GET)
    @ResponseBody
    public ResponseTable queryRolePage(Integer page,Integer limit){
        IPage<URole> roleList = roleService.page(new Page<>(page,limit),null);
        return TableResult.success("0", "查询成功",roleList.getTotal(), roleList.getRecords());
    };


    /**
     * 查询角色ztree
     */
    @GetMapping("/selectRoel")
    @ResponseBody
    public Result selectRoel(){
        List<URole> list = roleService.list(null);
        List<Ztree> lists = new ArrayList<>();
        for(URole str:list){
            Ztree ztree = new Ztree();
            ztree.setId(str.getId());
            ztree.setName(str.getName());;
//            ztree.setPid("0");
//            ztree.setIsParent(true);
            lists.add(ztree);
        }
        return ResultGenerator.genSuccessResult(list);
    }

    /**
     * 添加角色
     */
    @PostMapping("/addRole")
    @ResponseBody
    public Result addRole(String name){
        URole role = new URole();
        role.setId(IdGen.uuid());
        role.setName(name);
        //添加角色
        boolean flag = roleService.save(role);
        if(flag){
            return ResultGenerator.genSuccessResult("添加成功");
        }
        return ResultGenerator.genFailResult("添加失败");
    }

    /**
     * 根据角色id查询权限
     */
    @GetMapping("/queryQuanxian")
    public Result queryQuanxian(String rid){
        List<String> ridList = roleService.queryPermission(rid);
        return ResultGenerator.genSuccessResult(ridList);
    }

    /**
     * 编辑权限
     */
    @GetMapping("/updateQuanxian")
    public Result updateQuanxian(String rid,String[] pidu){
        int reslet = roleService.updatePermission(rid,pidu);
        return ResultGenerator.genSuccessResult(reslet);
    }

    /**
     * 通过角色id查询用户
     */
    @GetMapping("/queryUserByRid")
    public Result queryUserByRid(String rid){
        List<UUser> list = roleService.queryUserByRid(rid);
        return ResultGenerator.genSuccessResult(list);
    }

}
