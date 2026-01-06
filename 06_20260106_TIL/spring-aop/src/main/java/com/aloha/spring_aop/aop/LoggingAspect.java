package com.aloha.spring_aop.aop;

import java.time.LocalDateTime;
import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

// ⭐ Aspect
@Slf4j
@EnableAspectJAutoProxy(proxyTargetClass = true)   // AOP 활성화
@Component                // 빈 등록
@Aspect                   // AOP 클래스 지정
public class LoggingAspect {
  
  // ⭐ Advice
  // ⚡ Point Cut  : execution( 접근제한자 반환타입 패키지.클래스.메서드(파라미터) )
  // ⚡ Join Point : @Before, @After, @Around 등
  // @Before("execution(* com.aloha.spring_aop.service.BoardService*.*(..))")
  public void before(JoinPoint jp) {
    // jp.getSignature() : 타겟 메소드 시그니처 정보(반환타입, 패키지.클래스.메소드) 반환
    // jp.getArgs()      : 타겟 메소드의 매개변수를 반환
    log.info("=============================================");
    log.info("[@Before] ###################################");
    log.info("target : " + jp.getTarget().toString());
    log.info("signature : " + jp.getSignature());
    log.info("args : " + Arrays.toString(jp.getArgs()));
    // 파라미터 출력
    printParam(jp);
    log.info("=============================================");
  }


  // @After("execution(* com.aloha.spring_aop.service.BoardService*.*(..))")
  public void after(JoinPoint jp) {
    // jp.getSignature() : 타겟 메소드 시그니처 정보(반환타입, 패키지.클래스.메소드) 반환
    // jp.getArgs()      : 타겟 메소드의 매개변수를 반환
    log.info("=============================================");
    log.info("[@After] ###################################");
    log.info("target : " + jp.getTarget().toString());
    log.info("signature : " + jp.getSignature());
    log.info("args : " + Arrays.toString(jp.getArgs()));
    // 파라미터 출력
    printParam(jp);
    log.info("=============================================");
  }


  /**
   * @Around 조인포인트를 적용하면, @After 어드바이스는 실행되지 않는다.
   * (Around 에서 직접 after 를 호츨하여 실행시킨다.)
   * 
   * ProceedingJoinPoint : 어드바이스에서 타겟 메소드의 실행을 제어하고 호출하는 객체
   * - proceed()         : 타겟 메소드를 호출
   * @param jp
   * @return
   */
  @Around("execution(* com.aloha.spring_aop.service.BoardService*.*(..))")
	public Object around(ProceedingJoinPoint jp) {
		// jp.getSignature() : 타겟 메소드의 시그니처 정보(반환타입, 패키지.클래스.메소드) 반환
		// jp.getArgs()		 : 타겟 메소드의 매개변수를 반환
		log.info("==================================================");
		log.info("[@Around] ########################################");
		log.info("target : " + jp.getTarget().toString());
		log.info("signature : " + jp.getSignature());
		log.info("args : " + Arrays.toString(jp.getArgs()));
		LocalDateTime time = LocalDateTime.now();
		log.info("현재 시간 : " + time);
		
		Object result = null;
		try {
			result = jp.proceed();      // 타겟 메소드 호출
			if( result != null )
				log.info("반환값 : " + result.toString());
		} catch (Throwable e) {
			log.error("예외가 발생하였습니다.");
			e.printStackTrace();
		}
		// after(jp);                    // @After 어드바이스 직접 호출
		log.info("==================================================");
		return result;
	}


  /**
   * 파라미터 출력
   * @param jp
   */
  public void printParam(JoinPoint jp) {
    log.info("printParam()");
    Signature signature = jp.getSignature();
    // 타겟 메소드의 파라미터 이름 가져오기
    String[] parameterNames = ((MethodSignature) signature).getParameterNames();
    // 타겟 메소드의 파라미터 값 가져오기
    Object[] args = jp.getArgs();
    // 파라미터 이름과 값을 출력
    if( parameterNames != null ) {
      for (int i = 0; i < parameterNames.length; i++) {
        String paramName = parameterNames[i];
        Object paramValue = args[i];
        log.info("파라미터명 : {}, 값 : {}", paramName, paramValue);
      }
    }
  }

}