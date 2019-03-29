package xyz.berby.im.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import xyz.berby.im.annotation.Integrity;
import xyz.berby.im.exception.HttpException;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


/**
 * 数据完整性检验
 * @author  LTF
 * Created on 2019/3/29
 */
@Component
@Aspect
@Slf4j
@Lazy
public class DataIntegrityAspect {

    private Validator validator;

    public DataIntegrityAspect() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        this.validator = factory.getValidator();
        log.info("数据完整性验证器初始化完成......");
    }

    @Pointcut(value = "@annotation(integrity)", argNames = "integrity")
    public void pointCut(Integrity integrity) { }


    /**
     * 通过切面验证数据的完整性
     * @param joinPoint
     * @param integrity
     * @return
     */
    @Around(value = "pointCut(integrity)", argNames = "joinPoint, integrity")
    public Object valid(ProceedingJoinPoint joinPoint, Integrity integrity) throws HttpException, Throwable {
        Set<ConstraintViolation<Object>> set = null;
        Object[] args = joinPoint.getArgs();
        for (int i = 0; i < args.length; i++) {
            set = this.validator.validate(args[i]);
            for (ConstraintViolation<Object> constraintViolation: set) {
                throw new HttpException(constraintViolation.getPropertyPath() + constraintViolation.getMessage(), 422);
            }
        }

        return joinPoint.proceed(args);
    }

}
