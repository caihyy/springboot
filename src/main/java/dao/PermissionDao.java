package dao;

/**
 * @ProjectName: com.sm.api
 * @Package: dao
 * @ClassName: PermissionDao
 * @Author: Administrator
 * @Description:
 * @Date: 2020/3/9 17:28
 * @Version: 1.0
 */
import bean.Permission;

import java.util.List;
import java.util.Map;

public interface PermissionDao {

    List<Permission> getByMap(Map<String, Object> map);

    Permission getById(Integer id);

    Integer create(Permission permission);

    int update(Permission permission);

    List<Permission> getByUserId(Integer userId);

}