package cn.e3mall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.e3mall.common.pojo.E3Result;
import cn.e3mall.common.pojo.TreeNode;
import cn.e3mall.content.service.ContentCatService;

/**
 * 
 * @ClassName: ContentCatController
 * @Description: 内容分类管理Controller
 * @author 王铁臻
 * @date 2017年8月10日 下午9:04:33
 * @version V1.0
 */
@Controller
public class ContentCatController {

	@Autowired
	private ContentCatService contentCatService;

	@RequestMapping("/content/category/list")
	@ResponseBody
	public List<TreeNode> getContentCatList(@RequestParam(value = "id", defaultValue = "0") long parentId) {

		List<TreeNode> list = contentCatService.getContentCatList(parentId);
		return list;
	}

	@RequestMapping("/content/category/create")
	@ResponseBody
	public E3Result addContentCategory(long parentId, String name) {
		E3Result e3Result = contentCatService.addContentCategory(parentId, name);

		return e3Result;
	}

}
