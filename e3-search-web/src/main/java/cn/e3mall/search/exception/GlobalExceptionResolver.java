package cn.e3mall.search.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * @ClassName: GlobalExceptionResolver
 * @Description: 全局异常处理器
 * @author 王铁臻
 * @date 2017年8月14日 下午9:30:56
 * @version V1.0
 */
public class GlobalExceptionResolver implements HandlerExceptionResolver {

	private static Logger logger = LoggerFactory.getLogger(GlobalExceptionResolver.class);

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception e) {
		// 1）写日志文件
		logger.error("系统发生异常", e);
		// 2）给相关责任人发送邮件、或者发送短信。
		// 3）跳转到错误页面
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("error/exception");
		return modelAndView;
	}

}
