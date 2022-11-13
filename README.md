
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
