# 📝 메모장 프로젝트
Java 언어로 CRUD 기능을 수행하는 간단한 메모장 프로젝트를 진행했습니다.

## 개발 기간
23.06.05 단 하루!

## 팀원 소개
|이름|역할|
|---|-------|
|송이삭 (팀장)|패키지 구조 설계, 클래스 뼈대 작성|
|최혁진|메모 Create 기능 구현|
|조해나|메모 Read 기능 구현|
|김은비|메모 Update 기능 구현|
|김진희|메모 Read 기능 구현|

## 주요 기능

- **필수 요구 사항**

    - 메모장 프로그램은 1. 입력 2. 목록 보기 3. 수정 4. 삭제 5. 종료 메뉴로 구성되어 있다.
    - 입력 기능
        - 이름, 비밀번호, 메모를 스캐너를 통해 입력 받는다.
        - 1건의 글을 생성 및 메모 리스트에 저장한다.
    - 수정 기능
        - 수정할 글 번호를 입력 받는다.
        - 수정할 글이 존재하면 글을 수정하고 존재하지 않으면 존재하지 않는다고 메시지를 출력한다.
        - 수정할 글의 비밀번호를 입력 받는다.
        - 글을 수정하기 위해 입력한 비밀번호와 수정할 글의 비밀번호가 일치하면 글을 수정하고 일치하지 않으면 비밀번호가 일치하지 않는다는 메시지를 출력한다.
            - 비밀번호가 일치할 시 : 수정 내용 업데이트
            - 비밀번호 불일치 시 : 비밀번호가 일치하지 않는다는 메시지 출력
    - 삭제 기능
        - 삭제할 글 번호를 입력 받는다
        - 삭제할 글이 존재하면 글을 삭제하고 존재하지 않으면 존재하지 않는다는 메시지를 출력한다.
        - 삭제할 글의 비밀번호를 입력 받고 비밀번호 일치 여부를 판단한다.
    - 메모 클래스 (MemoVO, Memo)
        - 메모 한 건에 대한 정보를 가진 클래스
        - 메모는 글 번호, 작성자 이름, 비밀번호, 게시글, 작성일(컴퓨터 시스템의 날짜와 시간을 자동으로 저장) 가지고 있다.
        - 글의 수정 시, 수정 시간으로 시간이 변경된다.
    - 메모 리스트 (MemoList)
        - 여러 건의 메모를 저장하는 클래스 이다.
        - 메모 전체를 조회할 수 있다. (Getter 존재)
        - 1건의 글을 메모 리스트에 추가할 수 있다.
        - 글의 수정 또는 삭제 시 글 번호를 넘겨 받고 리스트에서 글 번호에 해당하는 메모 1건을 얻어와 리턴 시키는 메소드가 있다.
        - 글 1건을 삭제하는 메소드가 있다.
        - 글 삭제 후 글 번호를 다시 붙여준다.
        - 글이 삭제된 후 새 글이 입력될 때 idx가 기존 idx값에 이어서 1씩 증가할 수 있도록 count의 값을 수정한다.
    - 콘솔 (Console)
        - 사용자 UI에 해당하는 클래스이다.
        - Scanner를 통해 사용자로부터 값을 입력받아 메모를 생성, 조회, 수정, 삭제한다.