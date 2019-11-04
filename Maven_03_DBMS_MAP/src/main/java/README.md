# JDBC, DBMS, MyBatis, Maven Project

## Maven Build Tool 기반의 JDBC Project
## Oracle과 Mybatis를 연동한 JDBC Project

* 생성된 maven 프로젝트의 JRE 버전이 1.5이므로 버전 변경을 실행

* Orale은 mvn을 사용하여 local repository에 설정이 되어있다.
* mybatis.jar maven repository에서 설정값을 가져와서 설정
* lombok.jar maven repository에서 설정값을 가져와서 설정

* 매입매출관리2의 iolist2/iolist2의 접속을 위한 mybatis-config.xml을 생성
* DBConnection 클래스를 생성하여 SqlSessionFactory를 생성