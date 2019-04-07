package eu.smallAllegro.springmvcfirst.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class ProductAop {

    Logger logger = Logger.getRootLogger();

//    public ProductAop() {
//        logger.debug("ProductAOP działa");
//    }

    @Before("execution(* eu.smallAllegro.springmvcfirst.services.ProductService.deleteProduct(..))")
    public void BeforeDeleteProduct(JoinPoint joinPoint) {
//        logger.info("ProductController.deleteProduct() : " + joinPoint.getSignature().getName());
//        Arrays.stream(joinPoint.getArgs()).forEach(logger::info);
        logger.info("Someone is entering this web page");
    }
}
