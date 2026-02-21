# 📑 Sailorham Homepage Backend

본 프로젝트는 **Java 21** 및 **Spring Boot 4.0.3** 기반으로 개발된 Sailorham 홈페이지의 MSA 기반 백엔드 서버입니다.<br>
단순한 기능 구현을 넘어 **클린 코드, TDD, 확장 가능한 아키텍처**를 지향하며, 개발자들이 유지보수하기 쉽고 확장하기 용이한 코드를 작성하는 것을 목표로 합니다.

---

## 🏗 아키텍처

계층형 멀티 모듈 구조를 채택하여 도메인 간 결합도를 낮추고 재사용성을 극대화했습니다.

- `common:core`: 전역 예외 처리, 공통 응답 규격, TSID 등 모든 모듈의 기반 라이브러리
- `infrastructure`: API 라우팅 및 전역 인증/인가 처리
- `services:*`: 독립적으로 실행 및 배포되는 마이크로서비스 (`Article`, `Member`, `Auth`, etc.)

---

## 🤝 컨벤션

### 🚀 커밋 메시지 컨벤션

효율적인 코드 리뷰와 이력을 위해 **Google Commit Style**에 **Gitmoji**를 결합한 커밋 메시지 형식을 사용합니다.

#### ✅ 커밋 형식

```text
<이모지> <type>(<scope>): <명령형 제목> (50자 이내, 마침표 ❌)

[본문 설명 - 변경 이유(Why) 및 주요 변경사항(How) (72자 이내 줄바꿈)]

Issue: #이슈번호
```

#### 🎯 Type & Emoji

변경 사항의 성격에 따라 아래 타입을 사용합니다.

| 타입           | 이모지 | 설명           | 사용 예시                                      |
|:-------------|:---:|:-------------|:-------------------------------------------|
| **feat**     |  ✨  | 새로운 기능 추가    | `feat(auth): 로그인 기능 구현`                    |
| **fix**      | 🐛  | 버그 수정        | `fix(article): 게시글 조회 버그 수정`               |
| **refactor** | ♻️  | 코드 리팩토링      | `refactor(common): ApiResponse 레코드로 전환`    |
| **chore**    | 🚀	 | 빌드/설정/의존성    | 	`🚀 chore(gradle): MySQL 8.4 LTS 버전 업데이트` |
| **docs**     | 📝	 | 문서 수정	       | `📝 docs(readme): 테스트 컨벤션 섹션 추가`           |
| **test**     |  ✅  | 테스트 코드 작성/수정 | `✅ test(auth): 로그인 서비스 단위 테스트 추가`          |

---

### ✅ 테스트 코드 컨벤션

검증하려는 의도를 명확히 하고 **Given-When-Then** 패턴을 활용하여 테스트 코드를 작성합니다.

1. `@DisplayName` **작성 규칙**
    - 사용자(리뷰어)가 테스트 목적을 한눈에 파악할 수 있도록 **"~하면 ~합니다."** 형식의 문장형으로 작성합니다.
        - Good: `@DisplayName("유효한 아이디로 로그인하면 토큰을 발급합니다.")`
        - Bad: `@DisplayName("로그인 테스트")`
2. **테스트 메서드 네이밍**
    - `메서드명_should_기대행위_when_조건` 형식을 사용합니다.
        - e.g., `login_should_returnToken_when_validCredentials()`
3. **Given-When-Then 패턴 활용**
    ```java
    @Test
    @DisplayName("유효한 아이디로 로그인하면 토큰을 발급합니다.")
    void login_should_returnToken_when_validCredentials() {
        
        // given (준비): 테스트에 필요한 데이터 및 환경 설정
   
        // when (실행): 실제 검증하려는 로직 호출
   
        // then (검증): 예상 결과와 실제 결과 비교        
    }
    ```

---

## 🛠 기술 스택

- **언어**: Java 21
- **프레임워크**: Spring Boot 4.0.3
- **데이터베이스**: MySQL, Redis, JPA/Hibernate, QueryDSL
- **메시징 시스템**: Kafka
- **테스트**: JUnit 5, Mockito
- **빌드 도구**: Gradle
- **CI/CD**: GitHub Actions
- **버전 관리**: Git (GitHub)

---

## 🔥 핵심 기술적 의사결정

- **TSID (Time Sorted ID) 도입:** 분산 환경에서 UUID의 성능 저하와 Auto-increment의 충돌 문제를 해결하기 위해 시계열 기반의 정렬 가능한
  고유 식별자 전략을 채택했습니다.
- **Kafka 이벤트 설계:** 서비스 간 비동기 통신을 위해 Kafka를 활용하여 이벤트 기반 아키텍처를 구현했습니다. 각 서비스는 독립적으로 이벤트를 발행하고 구독할 수
  있습니다.
- **i18n 기반 전역 예외 처리:** `ErrorCode`와 다국어 메시지 소스를 연동하여 글로벌 서비스 확장이 용이한 예외 처리 시스템을 구축했습니다.
