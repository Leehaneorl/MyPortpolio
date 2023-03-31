package com.pettaming;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

//프로젝트의 시작점. 스프링부트, Bean 읽기/생성 등 자동으로 설정해주는 어노테이션
@SpringBootApplication
//프로젝트에서 사용될 패키지 선언
@EntityScan({"com.pettaming.entity", "com.pettaming.home","com.pettaming.post"})
//JPA Auditing 기능을 활성화하기 위해 main 메소드가 있는 클래스에 @EnableJpaAuditing 어노테이션 선언
@EnableJpaAuditing
public class PetTamingBackendApplication {

	public static void main(String[] args) {
		//부트스트랩 실행 메서드
		SpringApplication.run(PetTamingBackendApplication.class, args);
	}

}
