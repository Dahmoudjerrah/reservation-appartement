package mr.iscae.security;
import mr.iscae.entity.AppUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
//import com.example.bestteamproject.entity.AppUser;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.userdetails.UserDetails;

public class UserInfoUserDetails implements UserDetails {
    private String name;
    private String password;
    private List<GrantedAuthority> authorities;

    public UserInfoUserDetails(AppUser userInfo) {
        name = userInfo.getUsername();
        password = userInfo.getPassword();
        if (userInfo.getRole() != null) {
            authorities = userInfo.getRole().getPermissions()
                    .stream()
                    .map(permission -> new SimpleGrantedAuthority(permission.getName()))
                    .collect(Collectors.toList());
        } else {
            authorities = Collections.emptyList();
        }
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return name;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
