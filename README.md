# 소개

---

최근 핫하게 상용화가 되어있는 Chat GPT를 접목하여 서비스를 런칭하는 사례가 증가되고 있다.

해당 부분에 대해 흥미를 가지게 되었고 이 중 현재 스타 2.5K를 받고있는 가장 핫한 서드파티 라이브러리를 활용해 이에 대한 예제를 구현해 보았다.

사용 라이브러리  : [https://github.com/TheoKanning/openai-java](https://github.com/TheoKanning/openai-java)

예제를 구현하게된 계기는 다음과 같은 이유로 작성하게 되었다.

- 해당 서비스가 현재 나온지 얼마 안된 시점에서 레퍼런스를 찾는것에 대한 어려움
- 조금 더 직관적으로 어떻게 사용할 수 있는지를 소개하기 위해

# 구현기능

---

Open Ai가 제공하는 서비스 중, 메인 기능이라고 생각하는 채팅에 대해서 구현을 진행하였다. ( 추후 추가 예정 )

2023.04.15 기준 현재 구현한 요소는 다음과 같다.

- **REST API**
  - Completion
  - Chat Completion
- **Socket**
  - Completion

Socket 에서 Completion 하나만 구현한 이유는 Handler내 서드파티에서 제공하는 OpenAiService 에서 요청 요소만 다르게 적용해주면 되기에 해당 부분에 대해서는 따로 구현을 두진 않았다. ( 비슷한 요소가 있기에 )

# 사용 방법

---

먼저 `docker compose` 를 활용해 서비스 DB 컨테이너를 실행합니다.

```java
$ docker-compose up --build 
```

컨테이너가 준비되었다면 스프링 애플리케이션을 빌드한 이후 실행합니다.

```java
$ ./gradlew build && java -jar build/libs/chatgpt-0.0.1-SNAPSHOT.jar
```

만약 `zsh:permission denied: ./gradlew` 와 같은 이슈가 발생된다면 아래를 먼저 실행 후 재실행해 주세요

```java
$ chmod +x gradlew
```

# 사용 기술

---

| 내용 | stack  |
| --- | --- |
| Language | Java 11  |
| Framework | Spring Boot 2.7.1 |
| Persistence Framework | JPA/Hibernate , Querydsl  |
| Third Party Library  | OpenAi Service  |
| Data  | MySQL 8.0.19 |
| Build | Gradle 7.6 |
| etc | Docker, Docker-compose  |

