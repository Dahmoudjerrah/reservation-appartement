package mr.iscae.security;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.http.HttpMethod;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {
    @Autowired
    private JwtAuthFilter authFilter;

    @Bean
    public UserDetailsService userDetailsService() {
        return new UserInfoUserDetailsService();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.cors().and().csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers(HttpMethod.POST, "/auth/*").permitAll()
                .requestMatchers(HttpMethod.GET, "/auth/*").permitAll()
                .requestMatchers(HttpMethod.PUT, "/auth/*").permitAll()
                .requestMatchers(HttpMethod.DELETE, "/auth/*").permitAll()
                .requestMatchers(HttpMethod.GET, "/swagger-ui/**", "v3/api-docs/**").permitAll()

                .and()
                .authorizeHttpRequests()
                .requestMatchers(HttpMethod.GET, "/admin/roles").hasAuthority("list_role")
                .requestMatchers(HttpMethod.GET, "/admin/roles/{id}").hasAuthority("view_role")
                .requestMatchers(HttpMethod.GET, "/admin/addpermisiontorole/{idrole}/{idper}").hasAuthority("add_permision_to_role")
                .requestMatchers(HttpMethod.POST, "/admin/roles").hasAuthority("create_role")
                .requestMatchers(HttpMethod.PUT, "/admin/roles").hasAuthority("update_role")
                .requestMatchers(HttpMethod.DELETE, "/admin/roles/{id}").hasAuthority("delete_role")
                
                .requestMatchers(HttpMethod.GET, "/admin/permissions").hasAuthority("list_permission")
                .requestMatchers(HttpMethod.GET, "/admin/permissions/{id}").hasAuthority("view_permission")
                .requestMatchers(HttpMethod.POST, "/admin/permissions").hasAuthority("create_permission")
                .requestMatchers(HttpMethod.PUT, "/admin/permissions/{id}").hasAuthority("update_permission")
                .requestMatchers(HttpMethod.DELETE, "/admin/permissions/{id}").hasAuthority("delete_permission")

                .requestMatchers(HttpMethod.GET, "/admin/users").hasAuthority("list_user")
                .requestMatchers(HttpMethod.POST, "/admin/update-password").hasAuthority("update_user_password")
                .requestMatchers(HttpMethod.GET, "/admin/addrole/{iduser}/{idrole}").hasAuthority("add_role_to_user")
                .requestMatchers(HttpMethod.DELETE, "/admin/users/{id}").hasAuthority("delete_user")

                .requestMatchers(HttpMethod.PUT, "/user/update-password/{id}").hasAuthority("get_profile")
                .requestMatchers(HttpMethod.POST, "/user/reset-password").hasAuthority("update_user_password")
                .requestMatchers(HttpMethod.GET, "/user/profile/{email}").hasAuthority("get_profile")
                .requestMatchers(HttpMethod.PUT, "/user/profile").hasAuthority("update_profile")

                .requestMatchers(HttpMethod.PUT, "/api/company").hasAuthority("update_company")
                .requestMatchers(HttpMethod.POST, "/api/company").hasAuthority("create_company")
                .requestMatchers(HttpMethod.GET, "/api/company/all").hasAuthority("view_company")

                .requestMatchers(HttpMethod.GET, "/api/reservation/all").hasAuthority("list_reservation")
                .requestMatchers(HttpMethod.DELETE, "/api/reservation/anuller/{id}").hasAuthority("delete_reservation")
                .requestMatchers(HttpMethod.POST, "/api/reservation/create").hasAuthority("create_reservation")


                .requestMatchers(HttpMethod.GET, "/api/appartement").hasAuthority("list_appartement")
                .requestMatchers(HttpMethod.GET, "/api/appartement/appartement-reservation/{idappartement}").hasAuthority("appartement_list_reservation")
                .requestMatchers(HttpMethod.GET, "/api/appartement/{id}").hasAuthority("get_appartement_byid")
                .requestMatchers(HttpMethod.POST, "/api/appartement").hasAuthority("create_appartement")
                .requestMatchers(HttpMethod.PUT, "/api/appartement/update/{id}").hasAuthority("update_appartement")
                .requestMatchers(HttpMethod.DELETE, "/api/appartement/{id}").hasAuthority("delete_appartement")
                 
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authenticationProvider(authenticationProvider())
                .addFilterBefore(authFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService());
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }
}
