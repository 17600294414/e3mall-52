package cn.e3mall.portal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
* @ClassName: IndexController 
* @Description: 商城页面处理Controller
* @author 王铁臻
* @date 2017年8月10日 下午8:01:47 
* @version V1.0
 */
@Controller
public class IndexController {

	@RequestMapping("/default")
	public String showIndex() {
		
		return "index";
	}
}
