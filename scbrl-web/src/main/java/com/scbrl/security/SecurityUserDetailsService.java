package com.scbrl.security;

import com.scbrl.dto.SysRoleDTO;
import com.scbrl.dto.SysUserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * 模块:【Spring Secutity 自定义用户信息获取】
 *
 * 时间: Bruce.Liu By 2017/10/29 下午8:54 Create
 */
@Service("securityUserDetailsImpl")
public class SecurityUserDetailsService implements UserDetailsService {

//    @Autowired
//    private SysUserService sysUserService;
//
//    @Autowired
//    private SysRoleService sysRoleService;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        SysUserDTO user;
        try {
            user = restTemplate.getForObject("http://provider-service/user/"+userName,SysUserDTO.class);
        } catch (Exception e) {
            throw new UsernameNotFoundException("user select fail. 登录用户数据异常！");
        }
        if(user == null){
            // throw new UsernameNotFoundException("No user found. 登录用户不存在！");
            throw new UsernameNotFoundException("Wrong password. 账户或密码不正确！");
        } else {
            try {
                SysRoleDTO role = restTemplate.getForObject("http://provider-service/role/"+user.getRoleId(),SysRoleDTO.class);
                return new SecurityUserDetails(user, role);
            } catch (Exception e) {
                throw new UsernameNotFoundException("user role select fail. 登录用户角色组异常！");
            }
        }
    }
}
