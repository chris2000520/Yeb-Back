package com.awei.server.controller;

import com.awei.server.pojo.Admin;
import com.awei.server.pojo.RespBean;
import com.awei.server.service.IAdminService;
//import com.awei.server.utils.FastDFSUtils;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;


/**
 * 个人中心
 */

@RestController
public class AdminInfoController {
    @Autowired
    private IAdminService adminService;

    @ApiOperation(value = "更新当前用户信息")
    @PutMapping("/admin/info")
    public RespBean updateAdmin(@RequestBody Admin admin, Authentication authentication) {
        //更新成功,重新构建Authentication对象
        if (adminService.updateById(admin)) {
            /*
             * 1.用户对象
             * 2.凭证（密码）
             * 3.用户角色
             */
            SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(admin, null, authentication.getAuthorities()));
            return RespBean.success("更新成功");
        }
        return RespBean.error("更新失败");
    }

    @ApiOperation(value = "更新用户密码")
    @PutMapping("/admin/pass")
    public RespBean updateAdminPassword(@RequestBody Map<String, Object> info) {
        String oldPass = (String) info.get("oldPass");
        String pass = (String) info.get("pass");
        Integer adminId = (Integer) info.get("adminId");
        return adminService.updatePassword(oldPass, pass, adminId);
    }

//    @ApiOperation(value = "更新用户头像")
//    @ApiImplicitParams({@ApiImplicitParam(name = "file", value = "头像", dataType = "MultipartFile")})
//    @PutMapping("/admin/userface")
//    public RespBean updateUserFace(MultipartFile file, Integer id, Authentication authentication) {
//        //获取文件上传地址
//        String[] uploadPath = FastDFSUtils.upload(file);
//        String url = FastDFSUtils.getTrackerUrl() + uploadPath[0] + "/" + uploadPath[1];
//        return adminService.updateAdminUserFace(url,id,authentication);
//    }
}