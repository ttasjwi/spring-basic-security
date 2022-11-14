
# Core Spring Security
- BasicSecurity : 기본 시큐리티 학습

---

## 취급상 주의점
- Spring Boot 2.7 이후 기존 방식이 Deprecated됨.
- 원활한 강의의 진행을 위해 Spring Boot 2.6버전대로 조정을 하는 것이 좋음

---

## 상속 계층도
```shell
SecurityBuilder <- SecurityConfigurer <- WebSecurityConfigurer <- WebSecurityConfigurerAdapter
```
- 대부분의 기본 보안 기능은 WebSecurityConfigurerAdapter를 통해 구현되어 있고, 이를 상속하여 커스텀한 인증 로직을 구현하는 방식

---

## Form 인증

- 사용자가 웹 페이지로 접근
- 인증이 안 되면, 로그인 페이지로 Redirect
  - 스프링 시큐리티가 제공하는 기본 로그인 페이지 또는, 사용자 정의 로그인 페이지 사용 가능
- POST 방식으로 form data를 전송하여, username + password를 전달
- Session 및 인증토큰 생성, 저장
- Session에 저장된 인증 토큰으로 접근/인증 유지


### Form Login 인증 API
```java
protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
            .loginPage("/login.html") // 사용자 정의 로그인 페이지
            .defaultSuccessUrl("/home") // 로그인성공후이동페이지
            .failureUrl("/login.html?error=true")// 로그인 실패 후 이동페이지
            .usernameParameter("username")// 아이디 파라미터명 설정
            .passwordParameter("password")// 패스워드 파라미터명 설정
            .loginProcessingUrl("/login")// 로그인 Form Action Url
            .successHandler(loginSuccessHandler())// 로그인 성공 후 핸들러
            .failureHandler(loginFailureHandler())// 로그인 실패 후 핸들러
}
```
- `loginPage(...)` : 로그인 페이지 지정
  - 지정하지 않으면 스프링 시큐리티가 제공하는 기본 로그인 페이지를 사용한다.
- `defaultSuccessUrl(...)` :  로그인 성공 후 이동 페이지
- `failureUrl(...)` : 로그인 실패 후 이동페이지
- `usernameParameter(...)` : 아이디 파라미터명 설정(html 문서에서 지정한 이름과 일치시키면 됨)
  - 디폴트 : username
- `passwordParameter(...)` : 패스워드 파라미터명 설정(html 문서에서 지정한 이름과 일치시키면 됨)
  - 디폴트 : password
- `loginProcessingUrl(...)` : 로그인 Form Action Url(html 문서에서 지정한 action 값과 일치시키면 됨)
- `successHandler(loginSuccessHandler())` : 로그인 성공 후 핸들러
- `failureHandler(loginFailureHandler())` : 로그인 실패 후 핸들러

---
