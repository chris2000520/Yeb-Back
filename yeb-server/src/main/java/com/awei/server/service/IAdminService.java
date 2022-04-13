package com.awei.server.service;

import com.awei.server.pojo.Admin;
import com.awei.server.pojo.RespBean;
import com.awei.server.pojo.Role;
import com.baomidou.mybatisplus.extension.service.IService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author shizuwei
 * @since 2021-03-09
 */
public interface IAdminService extends IService<Admin> {


    RespBean login(String username, String password,String code, HttpServletRequest request);

    Admin getAdminByUsername(String username);

    List<Role> getRoles(Integer adminId);

    /**
     * 获取所有操作员
     * @param keyword
     * @return
     */
    List<Admin> getAllAdmins(String keyword);

    /**
     * 更新操作员角色
     * @param adminId
     * @param rids
     * @return
     */
    RespBean addAdminRole(Integer adminId, Integer[] rids);

    /**
     * 更新用户密码
     * @param oldPass
     * @param pass
     * @param adminId
     * @return
     */
    RespBean updatePassword(String oldPass, String pass, Integer adminId);
}
