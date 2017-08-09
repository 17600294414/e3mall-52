package cn.e3mall.controller;
/**
 * 
* @ClassName: ItemCatController 
* @Description: 商品分类管理Controller
* @author 王铁臻
* @date 2017年8月7日 上午9:51:13 
* @version V1.0
 */

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.e3mall.common.pojo.TreeNode;
import cn.e3mall.service.ItemCatService;
import cn.e3mall.service.ItemService;

@Controller
public class ItemCatController {

	@Autowired
	private ItemCatService itemCatService;
	
	@RequestMapping("/item/cat/list")
	@ResponseBody
	public List<TreeNode> getItemCatList(@RequestParam(value="id", defaultValue="0")long parentId){
		
		List<TreeNode> list = itemCatService.getItemCatList(parentId);
		return list;
		
	}
}
