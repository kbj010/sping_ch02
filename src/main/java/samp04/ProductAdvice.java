package samp04;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
@Aspect     // 공통관심사항을 처리하는 클래스
@Component  // 객체를 생성
public class ProductAdvice {
	@Pointcut("execution(* getProduct(String))")
	private void helloPointcut() {}
	@Before("helloPointcut()")   // 본작업 실행전
	public void before() {
		System.out.println("before");
	}
	@Around("helloPointcut()") // 본작업 앞뒤로 실핼
	public Object around(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("작업전 around");
		Object obj = pjp.proceed();
		System.out.println("작업후 around");
		return obj;
	}
	@After("helloPointcut()")  // 본 작업 후에 실행
	public void after() {
		System.out.println("after");
	}
	// 본작업 후에 결과 값을 받아올 때, returning = "product"이름과 매개변수 객체명이 일치
	@AfterReturning(pointcut = "helloPointcut()", returning = "product") 
	public void afterReturn(Product product) {
		System.out.println("after_return : "+product);
	}
	// 실행할 떼 에러가 발생, throwing = "ex"이름과 매개변수 객체명이 일치
	@AfterThrowing(pointcut = "helloPointcut()", throwing = "ex") 
	public void afterThrow(Throwable ex) {
		System.out.println(ex.getMessage());
	}
}