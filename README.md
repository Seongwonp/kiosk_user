# ☕ Cafe Kiosk

<p>실제 매장 키오스크 사용 경험을 반영하여 구현한 카페 주문/결제 시스템입니다. Spring Boot와 React를 활용한 풀스택 웹 애플리케이션으로, 프론트엔드와 백엔드를 분리하여 API 기반의 통신 구조를 설계하였습니다.
  키오스크와 관리자는 별도로 분리하여 프로젝트를 만들었고, 해당 프로젝트는 키오스크 프로젝트 입니다. 사용자는 직관적인 UI를 통해 메뉴를 선택하고 옵션을 설정해 주문할 수 있으며, 관리자는 메뉴 관리와 주문 내역, 매출 확인이 가능합니다.
</p>

<br />

## 🗓 프로젝트 개요

- 프로젝트명 : BEANS COFFEE KIOSK
- 키오스크 개발인원 : 2명
- 프로젝트 기간: 2025.07.25 ~ 2025.08.02 (9일)
- 개발 목적 : 실제 카페 키오스크 UX 분석 및 기능 구현을 통한 풀스택 개발 역량 강화
- 특징 : 실제 매장에서 사용되는 키오스크 UI를 참고하여, 사용자 친화적인 인터페이스를 구현했습니다.	장바구니 기능과 옵션별 가격 계산 로직을 서버에서 처리하여 정확한 결제 금액을 계산할 수 있도록 설계했습니다.주문 요청 시 프론트엔드에서 DTO를 통해 백엔드로 전달, DB에 저장되며 관리자 페이지에서 확인 가능하도록 구현했습니다.
<br />

## 👥 역할 분담

| 이름 | 담당 역할 |
|------|------------|
| Rachel (Seojeong Yun) | 풀스택, UI 설계, 결제 기능 연동 |
| seolhyeono | 백엔드, DB 설계, API 개발 |
<br />

## 🛠️ Tech Stack

- **Frontend**: React, JavaScript, Tailwind CSS
- **Backend**: Java, Spring Boot
- **Database**: MariaDB
- **ORM**: JPA 
- **Tools**: Git, GitHub, Notion, Swagger

<br />

## 🚀 주요 기능

### 초기 화면

- 버튼 클릭 시 메인 화면으로 이동
<img width="1000"  alt="초기화면_wide" src="https://github.com/user-attachments/assets/435f02c8-52c1-4935-89e4-a89415eb4fba" />


### 메인 키오스크 화면


- 메뉴 조회 및 선택
<img width="550" alt="키오스크" src="https://github.com/user-attachments/assets/3953ef4f-9607-4c4f-8f5d-971b5c64226d" />
<br />

- 옵션 선택 및 장바구니 담기
  
<img width="550"  alt="커피옵션" src="https://github.com/user-attachments/assets/c4def2e6-9d7d-4a3a-ad5e-f7853e03ff6d" />
<br />

- 커피, 버블티, 스무디, 에이드 등 음료에 따라 다른 옵션 추가
  
<img width="550"  alt="옵션창2" src="https://github.com/user-attachments/assets/c6e55d57-7986-4099-a517-829b40eac446" />
<br />

- 관리자가 30일이내 등록한 메뉴는 신메뉴로 분류 
- 장바구니 수량 변경 및 삭제, 재고 기반 주문 제한
  
<img width="550"  alt="신메뉴" src="https://github.com/user-attachments/assets/d95640bc-4a88-484b-ab15-dc4b070b6e12" />
<br />

- 타이머 설정 : 제한 시간 2분 뒤 주문 결제를 하지 않는 경우 주문 유무 확인
  
<img width="550"  alt="타이머" src="https://github.com/user-attachments/assets/ed384d4d-fcd2-4e92-99b0-bc09478b83f8" />
<br />

### 주문 및 결제

- 휴대폰 번호 입력으로 포인트 적립 및 사용
  
<img width="550" alt="포인트" src="https://github.com/user-attachments/assets/b561c492-8a17-405d-b48c-b109d309553a" />
<br />

- 결제 기능 (토스 연동)
  
<img width="550" alt="결제" src="https://github.com/user-attachments/assets/ac21b582-1439-4e84-a985-367c4b3b28e6" />
<br />


### 주문 내역 확인

- 결제 성공 화면 : 금액, 주문번호, 주문날짜 확인 후 초기화면으로 이동
  
<img width="550"  alt="결제완료 " src="https://github.com/user-attachments/assets/a65d9415-5a39-4d02-a131-3ebb97f5776f" />

<br />

### 📌 시스템 아키텍처
- 3-Tier 구조
- Restful API 기반 클라이언트-서버 통신

<br />

## 📸 기능 시연
<p>직관적인 UI와 실제 키오스크 동작을 모방한 커피 주문 웹앱입니다. 반응형 UI 적용으로 다양한 디바이스 대응가능합니다.</p>

![cafe Kiosk](https://github.com/user-attachments/assets/d67d104d-82b1-4a33-8009-1868ddc295f8)


<br />

## 🧠 프로젝트 회고

- React와 Spring Boot를 활용한 풀스택 개발 경험을 통해 프론트엔드 컴포넌트 구조화, 백엔드 API 설계, DB 연동까지 전반적인 개발 흐름을 익혔습니다.
- 장바구니, 옵션 선택, 주문 금액 계산 등 실서비스에 가까운 기능들을 구현하며 프론트-백엔드 간 데이터 처리 방식과 역할 분리의 중요성을 체감했습니다.
- API 통신 오류, DTO 설계 미흡, 옵션 처리 로직 등에서 시행착오를 겪으며 문제 해결 역량을 키울 수 있었습니다.
- Git 브랜치 전략을 바탕으로 팀 협업 상황을 가정한 개발 프로세스를 구성했고, 실무에서도 적용 가능한 워크플로우를 연습했습니다.
- 특히 이번 프로젝트를 통해 DB 설계의 중요성을 깊이 체감했으며, 엔티티 간 관계 정의와 테이블 구조가 전체 시스템의 안정성과 유지보수성에 큰 영향을 준다는 점을 배웠습니다.

<br/>
