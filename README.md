# Jub-Jub
개발 기간 : 2020.12.13 ~ ing 

### 📖  프로젝트 소개

줍줍은 **교내 기자재 관리 서비스**입니다.
학교에서 학생들에게 대여해주기 위해 구매한 기자재(태블릿이나 아이맥, 휴대용 모니터 등) 대여 장부를 수기로 기록, 관리하시는 모습을 보고 
담당 선생님의 업무와 부담을 줄이고, 학생들은 조금 더 빠르고 편리하게 학교의 기자재를 대여할 수 있게 하도록 제작하게 되었습니다.
학생은 `기자재 대여 신청`과 `대여 현황`, `공지사항 확인` 등의 기능을,
선생님은 `기자재 관리(현황,추가 수정)`, `대여 신청 승인`, `학생 대여 기록 확인`, `공지사항 등록` 등의 기능을 사용할 수 있습니다.

### 👨‍💻  맡은 역할 & 한 일

Kotlin을 사용한 Android 앱 개발을 담당했습니다. 

`Retrofit2`를 활용해 서버와 통신하고, 효율적인 검색을 위해 `Room`을 사용했습니다.

`SharedPreferences`를 사용해서 자동 로그인 기능을 구현했고, 효율적이고 안전한 데이터 관리를 위해 `AAC ViewModel`과 `MutableLiveData`, `DataBinding`을 사용했습니다.
