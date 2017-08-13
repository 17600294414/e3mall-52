package cn.e3mall.portal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.e3mall.content.service.ContentService;
import cn.e3mall.pojo.TbContent;

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
	
	@Autowired
	private ContentService contentService;
	
	@Value("${index.slider.cid}")
	private Long indexSliderCid;

	@RequestMapping("/default")
	public String showIndex(Model model) {
		//展示页面之前查询内容列表
		List<TbContent> ad1List = contentService.getContentListByCid(indexSliderCid);
		//把结果传递给jsp
		model.addAttribute("ad1List",ad1List);
		//返回逻辑视图
		
		return "index";
	}
}
