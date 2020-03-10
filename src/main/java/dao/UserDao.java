package dao;

/**
 * @ProjectName: com.sm.api
 * @Package: dao
 * @ClassName: UserDao
 * @Author: Administrator
 * @Description:
 * @Date: 2020/3/9 17:25
 * @Version: 1.0
 */
import bean.User;

import java.util.List;
import java.util.Map;

public interface UserDao {

    List<User> getByMap(Map<String, Object> map);
    List<User> getByRoleId(Map<String, Object> map);
    User getById(Integer id);
    Integer create(User user);
    int update(User user);
    User getByUserName(String userName);
}
