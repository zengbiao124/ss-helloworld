package cn.com.taiji.learn.sshelloworld.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .passwordEncoder(passwordEncoder())
                .withUser("zb")
                .password(passwordEncoder().encode("123456"))//encode加密
                .roles("USER")
                .and().withUser("zb1")
                .password(passwordEncoder().encode("1234567"))
                .roles("ADMIN");
    }

    /**
     * BCryptPasswordEncoder方式可以对密码进行加密(encode)与密码匹配(matches)
     *
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * 动态配置权限
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/user/test/bar").permitAll()//配置某个接口不登录也可以访问
                .antMatchers("/login").permitAll()
                .antMatchers("/user/test/only-user").hasRole("USER")
                .antMatchers("/user/test/foo").hasRole("ADMIN")
                .anyRequest().authenticated();//配置其他所有接口必须登录才能访问
        http.formLogin().loginPage("/login")
                .loginProcessingUrl("/doLogin");
        http.logout().permitAll().logoutUrl("/logout");
        http.csrf().disable();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/images/**","/css/**","/js/**","/favicon.ico");
    }
}
