package com.awei.server.mapper;

import com.awei.server.pojo.Menu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author chris
 * @since 2022-03-09
 */
public interface MenuMapper extends BaseMapper<Menu> {

    /**
     * 通过用户查询菜单列表
     * @
     * @param id
     * @return List<Menu>
     */
    List<Menu> getMenusByAdminId(Integer id);

    List<Menu> getMenusWithROle();

    List<Menu> getAllMenus();
}
