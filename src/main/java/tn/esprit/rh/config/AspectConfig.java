package tn.esprit.rh.config;

import org.apache.logging.log4j.LogManager;

import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.rh.*;

@Aspect
@Component
@Slf4j
public class AspectConfig {
	
	 Logger log = LogManager.getLogger(Controller.class);
	@After("execution(*  tn.esprit.spring.Controller.Controller.get*(..))")
	public void logMethodEntry() {
	log.info("Bon Courage"); }
	
	@Around("execution(* tn.esprit.spring.Controller.Controller.*(..))")
	public Object profile(ProceedingJoinPoint pjp) throws Throwable {
	long start = System.currentTimeMillis();
	Object obj = pjp.proceed();
	long elapsedTime = System.currentTimeMillis() - start;
	log.info("Method execution time: " + elapsedTime + " milliseconds.");
	return obj;
	}
}
