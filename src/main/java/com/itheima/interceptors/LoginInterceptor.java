package com.itheima.interceptors;

import com.itheima.pojo.Result;
import com.itheima.utils.JwtUtil;
import com.itheima.utils.ThreadLocalUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Map;

@Component
public class LoginInterceptor implements HandlerInterceptor{
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 令牌校验
        String token = request.getHeader("Authorization");
        // 验证token
        try {
            Map<String, Object> claims = JwtUtil.parseToken(token);

            // 把业务数据存储到ThreadLocal中
            ThreadLocalUtil.set(claims);
            // 放行
            return true;
        } catch (Exception e) {
            // http状态码：401
            response.setStatus(401);
            // 不放行
            return false;
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        // 业务处理完毕，清除ThreadLocal中的数据
        ThreadLocalUtil.remove();
    }
}
