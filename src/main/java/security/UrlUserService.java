package security;

import bean.Permission;
import bean.User;
import dao.PermissionDao;
import dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: com.sm.api
 * @Package: security
 * @ClassName: UrlUserService
 * @Author: Administrator
 * @Description:
 * @Date: 2020/3/9 17:24
 * @Version: 1.0
 */
@Service
public class UrlUserService implements UserDetailsService {
    @Autowired
    UserDao userDao;
    @Autowired
    PermissionDao permissionDao;
    @Override
    public UserDetails loadUserByUsername(String userName) { //重写loadUserByUsername 方法获得 userdetails 类型用户

        User user = userDao.getByUserName(userName);
        if (user != null) {
            List<Permission> permissions = permissionDao.getByUserId(user.getId());
            List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
            for (Permission permission : permissions) {
                if (permission != null && permission.getName()!=null) {
                    GrantedAuthority grantedAuthority = new UrlGrantedAuthority(permission.getPermissionUrl(),permission.getMethod());
                    grantedAuthorities.add(grantedAuthority);
                }
            }
            user.setGrantedAuthorities(grantedAuthorities);
            return user;
        } else {
            throw new UsernameNotFoundException("admin: " + userName + " do not exist!");
        }
    }
}
