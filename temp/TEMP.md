<img width="556" height="286" alt="image" src="https://github.com/user-attachments/assets/d1664459-479b-4217-b1a6-b00475ef7ff1" />
<img width="990" height="155" alt="image" src="https://github.com/user-attachments/assets/086684db-ae2f-4ff8-846e-6006efd16e7a" />



### 메일 발송 구조 개선 (동기 처리 -> 이벤트 기반 비동기 처리)
**개요**
- 메일링이 필요한 비지니스 로직에서 메일 서비스를 호출하는 mailService.send(...)가 트랜잭션 내부에서 동기 호출
- 메일 서비스 지연 시 트랜잭션이 길어져 응답 시간 지연 발생
- 트랜잭션은 실패 했으나 메일만 발송하는 경우 발생
- 메일링의 경우 필수가 아닌 부가 기능일 경우가 많아 비동기 처리 후 실패 시 재전송 아키텍처 설계

**개선**
- 비지니스 로직 내 이벤트 발행하여 메일 서비스 호출
  - @Async 기반 비동기 처리
  - @TransactionalEventListener(AFTER_COMMIT) 이용하여 트랜잭션 커밋 이후 실행
- 메일 발송 실패 처리 로직 설계
  - 메일 발송 이력 테이블에 실패 횟수 컬럼 추가하여 실패 마다 카운팅
  - 1~2회 실패 메일 건을 재전송 / 3회 실패 메일 건은 운영자 알람 담당 스케줄러 추가

**결과**

<img width="465" height="186" alt="image" src="https://github.com/user-attachments/assets/2ea8e3d9-bd2d-43b9-b240-3f5925c77f37" />
