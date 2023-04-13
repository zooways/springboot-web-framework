package cn.zooways.app.config;

import cn.zooways.app.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@Slf4j
public class AppExceptionResolver implements HandlerExceptionResolver {

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
      log.error("{} occurred error:{}",request.getRequestURI(),ex);
        ModelAndView mv = new ModelAndView();
        MappingJackson2JsonView view = new MappingJackson2JsonView();
        mv.setView(view);
        if (ex instanceof BusinessException) {
            BusinessException exx = (BusinessException) ex;
            return mv;
        }else {

            mv.addObject("code", 500);
            mv.addObject("msg", ex.getMessage());
            mv.setStatus(HttpStatus.resolve(500));
        }
        return mv;
    }
}
