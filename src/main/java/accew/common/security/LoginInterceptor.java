package accew.common.security;

import accew.common.constant.SysConstants;
import accew.modules.security.AntUrlPathMatcher;
import accew.modules.security.UrlMatcher;
import accew.modules.utils.LoginSession;
import org.slf4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by acc on 2017/3/9.
 */
public class LoginInterceptor extends BaseInterceptor implements HandlerInterceptor {


    private static Logger logger = accew.modules.logger.Logger.getLog(LoginInterceptor.class);

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        String servletPath = request.getServletPath();
        if (checkAction(servletPath)){
            return true;
        }
        LoginSession loginSession = (LoginSession) request.getSession().getAttribute(SysConstants.LOGIN_ADMIN_SESSION);
        if (loginSession == null){
            response.sendRedirect("/in/loginForm");
            return false;
        }else {
            return true;
        }
    }



    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }


}
