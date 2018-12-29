package com.sinuonan.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;

@Component("loggerAspect")
@Aspect
public class loggerAspect {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Pointcut(value = "execution(* com.sinuonan.dao.impl.*(..))")
    public void pointCut() {
    }


    @AfterReturning(pointcut = "pointCut()", argNames = "joinPoint, retVal", returning = "retVal")
    public void afterReturn(JoinPoint joinPoint, Object retVal) {
        String className = joinPoint.getSignature().getName();
        className = className.substring(className.lastIndexOf(".") + 1);
        className = getMethodChineseName(className);
        //日志记录连接点方法签名
        log.info(className+":"+joinPoint.getSignature().toString());
        //判断参数
        if (null == joinPoint.getArgs()) {
            log.info("没有参数!");
            return;
        }

        StringBuilder rs = new StringBuilder();
        for (Object arg : joinPoint.getArgs()) {
            if (arg instanceof Object[]){
                rs.append(Arrays.toString(((Object[]) arg))).append(", ");
            }else {
                rs.append(arg.toString()).append(", ");
            }
        }
        String s = rs.toString().substring(0, rs.toString().length() - 2);

        log.info("参数：[{}]", s);

    }

    //https://blog.csdn.net/weixin_39936341/article/details/79226182

    /**
     * 使用Java反射来获取被拦截方法(insert、update)的参数值， 将参数值拼接为操作内容
     *
     * @param args
     * @param mName
     * @return
     */
    public String optionContent(Object[] args, String mName) {
        if (args == null) {
            return null;
        }
        StringBuilder rs = new StringBuilder();
        rs.append(mName);
        String className = null;
        int index = 1;
        // 遍历参数对象
        for (Object info : args) {
            // 获取对象类型
            className = info.getClass().getName();
            className = className.substring(className.lastIndexOf(".") + 1);
            rs.append("[参数").append(index).append("，类型:").append(className).append("，值:");
            // 获取对象的所有方法
            Method[] methods = info.getClass().getDeclaredMethods();
            // 遍历方法，判断get方法
            for (Method method : methods) {
                String methodName = method.getName();
                // 判断是不是get方法
                if (!methodName.contains("get")) {
                    continue;
                }
                Object rsValue = null;
                try {
                    // 调用get方法，获取返回值
                    rsValue = method.invoke(info);
                } catch (Exception e) {
                    continue;
                }
                // 将值加入内容中
                rs.append("(").append(methodName).append(":").append(rsValue).append(")");
            }
            rs.append("]");
            index++;
        }
        return rs.toString();
    }

    /**
     * 判断操作的中文名（根据自己项目而定）
     *
     * @param methodName
     * @return
     */
    private String getMethodChineseName(String methodName) {
        if (methodName.endsWith("find")) {
            return "查找数据";
        }else {
            return "";
        }
    }

}
