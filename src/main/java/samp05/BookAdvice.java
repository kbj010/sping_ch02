package samp05;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
@Aspect
@Component
public class BookAdvice {
	@Pointcut("execution(* getBook(String))")
	private void getBookPointCut() {}
	@Before("getBookPointCut()")
	public void befoer() {
		System.out.println("before");
	}
	@Around("getBookPointCut()")
	public Object around(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("작업전 around");
		Object obj = pjp.proceed();
		System.out.println("작업후 around");
		return obj;
	}
	@After("getBookPointCut()")
	public void after() {
		System.out.println("after");
	}
	@AfterReturning(value ="getBookPointCut()", returning = "book" )
	public void after_return(Book book) {
		System.out.println("after return : "+ book);
	}
	@AfterThrowing(value ="getBookPointCut()", throwing = "e" )
	public void after_throw(Throwable e) {
		System.out.println("에러 : " + e.getMessage());
	}
}
