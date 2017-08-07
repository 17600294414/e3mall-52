package cn.e3mall.controller;
/**
 * 
* @ClassName: PageController 
* @Description:页面跳转Controller
* @author 王铁臻
* @date 2017年8月6日 下午6:39:06 
*
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class PageController {

	@RequestMapping("/")
	public String showIndex() {
		return "index";
	} 
	@RequestMapping("/{page}")
	public String showPages(@PathVariable String page) {
		return page;
	}
	
	
}
