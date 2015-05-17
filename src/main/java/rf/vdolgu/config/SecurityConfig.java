package rf.vdolgu.config;

/**
 * Created by mil on 30.04.15.
 */

/*@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("user").password("12").roles("ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/main*").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
                .and().formLogin();
    }
}*/
