# 🐳 Docker 기반의 Redis와 OAuth2를 활용한 소셜 로그인 프로젝트

## 📚 목차
- [📌 프로젝트 소개](#-프로젝트-소개)
- [📁 프로젝트 구조](#-프로젝트-구조)
- [🛠 기술 스택](#-기술-스택)
- [🌟 주요 기능](#-주요-기능)
- [🐳 Docker](#-docker)

## 📌 프로젝트 소개

이 프로젝트는 Docker, Redis, OAuth2를 적용한 실습 프로젝트 입니다.
Docker를 사용하여 애플리케이션을 컨테이너화하고, Redis를 이용한 캐싱으로 성능을 향상시킵니다. 
또한 OAuth2를 통한 소셜 로그인을 구현해봅니다.

---

## 📁 프로젝트 구조
```
.
├── Dockerfile
├── docker-compose.yml
├── build.gradle
├── settings.gradle
└── src
    └── main
        ├── java
        │   └── com
        │       └── yoonji
        │           └── dockermaster
        │               ├── common
        │               ├── redis
        │               ├── security
        │               ├── swagger
        │               └── user
        └── resources
            ├── application.yml
            └── application-oauth.yml
```
- `common`: 공통 응답 형식과 커스텀 예외 처리를 담당합니다.
- `redis`: Redis 관련 설정을 담당합니다.
- `security`: Spring Security 관련 설정과 구현을 담당합니다. 인증, 인가, OAuth2 설정 등 보안과 관련된 모든 로직이 이 패키지에 위치합니다.
- `swagger`: Swagger 설정과 관련된 클래스들이 위치합니다. API 문서 자동화를 위한 설정이 이 패키지에 포함됩니다.
- `user`: 사용자 관련 기능을 담당합니다. 사용자 엔티티, 레포지토리, 서비스, 컨트롤러 등 사용자와 관련된 모든 로직이 이 패키지에 위치합니다.

---

## 🛠 기술 스택
- 🐳 Docker
- 🍃 Spring Boot
- 🍅 Redis
- 🔑 OAuth2
- 🛡 Spring Security
- 🗄 JPA
- 🌐 RESTful API
- 📚 Swagger
- 🐘 Gradle

---

## 🌟 주요 기능
1. 🐳 Docker를 이용한 애플리케이션 컨테이너화
2. 💾 Redis를 이용한 캐싱 적용
3. 🔐 OAuth2를 이용한 소셜 로그인
4. 🔄 RESTful API를 통한 사용자 인증
5. 🚨 Custom Exception 처리
6. 📖 Swagger를 이용한 API 문서화

---

## 🐳 Docker
### 🚀 Docker로 실행하기
1. Docker가 설치되어 있는지 확인합니다.
2. 프로젝트 루트 디렉토리에서 다음 명령어를 실행합니다:
   ```
   docker compose up --build
   ```
3. 브라우저에서 `http://localhost:8080/swagger-ui/index.html`으로 접속해 API 문서를 확인합니다.

## 📖 더 자세한 내용은...
프로젝트에 적용된 [Docker](https://ijnooyah.github.io/docker/docker-spring-boot), [OAuth2](https://ijnooyah.github.io/spring-security/jwt-series-intro), [Redis](https://ijnooyah.github.io/redis/learn-redis)에 대한 자세한 설명과 구현 과정은 블로그에서 확인할 수 있습니다.   
각 기술의 적용 방법대해 상세히 다루고 있으니, 관심 있는 부분을 참고해 주세요!

