package bank.ma.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter  {



  @Override
  public void configure(AuthenticationManagerBuilder auth) throws Exception {
     PasswordEncoder passwordEncoder=passwordEncoder();
      auth.inMemoryAuthentication().withUser("user").password(passwordEncoder.encode("1234")).roles("USER");
      auth.inMemoryAuthentication().withUser("admin").password(passwordEncoder.encode("1234")).roles("ADMIN","USER");

  }
  @Override
  protected void configure(HttpSecurity http) throws Exception {
   //http.formLogin().loginPage("/login");
  http.authorizeRequests().antMatchers("/comptes**/**,/clients**/**").permitAll();
   http.authorizeRequests().antMatchers("/operations/,/comptes/{code},/clients/{cin}","/virement/").hasRole("USER");
   http.authorizeRequests().antMatchers("/user**/**", "/login", "/webjars/**").permitAll();
  // http.authorizeRequests().anyRequest().authenticated();
   http.csrf();
   http.exceptionHandling().accessDeniedPage("/notAuthorized");


  }
  @Bean
  public PasswordEncoder passwordEncoder(){
      return new BCryptPasswordEncoder();
  }




	
}
