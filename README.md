# 🧠 스터디 시스템 (StudySystem)

> 사용자가 스터디를 생성하고, 신청하고, 관리할 수 있는 Spring Boot 기반의 웹 애플리케이션입니다.

## 📌 주요 기능

- 회원가입 및 로그인 (Spring Security)
- 스터디 생성 및 조회
- 스터디 신청 및 관리 (마이페이지)
- 사용자별 생성/신청한 스터디 목록 조회

---

## 🛠️ 기술 스택

- **Backend**: Java 17, Spring Boot 3.x
- **ORM/Mapper**: MyBatis
- **DB**: MySQL
- **Template Engine**: Thymeleaf
- **Security**: Spring Security
- **Build Tool**: Gradle
- **IDE**: IntelliJ IDEA

---


## 실행 방법

**의존성 설치 및 빌드**
   ```bash
   ./gradlew build
   ```
**애플리케이션 실행**
   ```bash
   ./gradlew bootRun
   ```
**접속**
   - 회원가입/로그인: `http://localhost:8080/login`
   - 스터디 목록: `http://localhost:8080/studies`
   - 스터디 생성: `http://localhost:8080/studies/new`
   - 마이페이지: `http://localhost:8080/mypage`


