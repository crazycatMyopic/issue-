# issue-1
AOP test

Issue linked with the following Stackover flow question:

[SO Question](https://stackoverflow.com/questions/76087213/spring-aop-with-spring-webflux-after-authentication?noredirect=1#comment134190061_76087213)

curl to get the error

```
curl -L "http://localhost:8080/login" -H "Authorization: Bearer ghfjhgf"
```

-------------
Perview:

I have a Enabled Spring AOP for my logging purpose and use webflux for the API entrypoint,
things work find if I use my api does not go through `ReactiveAuthenticationManager` like my `login` api but moment It has to go through `ReactiveAuthenticationManager` it throws the bellow exception

```
java.lang.IllegalStateException: No MethodInvocation found: Check that an AOP invocation is in progress and that the ExposeInvocationInterceptor is upfront in the interceptor chain. Specifically, note that advices with order HIGHEST_PRECEDENCE will execute before ExposeInvocationInterceptor! In addition, ExposeInvocationInterceptor and ExposeInvocationInterceptor.currentInvocation() must be invoked from the same thread.
	at org.springframework.aop.interceptor.ExposeInvocationInterceptor.currentInvocation(ExposeInvocationInterceptor.java:74) ~[spring-aop-5.3.23.jar:5.3.23]
	Suppressed: reactor.core.publisher.FluxOnAssembly$OnAssemblyException: 
Error has been observed at the following site(s):
	*__checkpoint ⇢ Handler com.ums.api.contoller.Controller#getAllUser() [DispatcherHandler]
```

my AOP class
```java
public class LoggerAspect {

    @Pointcut("within(com.ums..*)")
    public void logEveryFunction() {
    }

    @Before(value = "logEveryFunction()")
    public void log(JoinPoint joinPoint) {
        log.info("Entering function {} in location {}", joinPoint.getSignature(), joinPoint.getSourceLocation());
    }

    @After(value = "logEveryFunction()")
    public void logEnd(JoinPoint joinPoint) {
        log.info("Exiting function {}", joinPoint.getSignature());
    }
}
```

authentication function
```java
    public Mono<Authentication> authenticate(Authentication authentication) {
        return Mono.justOrEmpty(authentication.getCredentials().toString())
                .map(value -> {
                    return new UsernamePasswordAuthenticationToken(
                            authentication.getName(),
                            null,
                          Arrays.asList(new SimpleGrantedAuthority("VIEW"))
                });
    }
```

how can I make my AOP work with webflux and how can I fix the issue?
