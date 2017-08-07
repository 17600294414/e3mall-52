package cn.e3mall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.e3mall.common.pojo.DataGridResult;
import cn.e3mall.pojo.TbItem;
import cn.e3mall.service.ItemService;


/**
 * 
 * @ClassName: ItemController
 * @Description: 商品管理Controller
 * @author 王铁臻
 * @date 2017年8月5日 下午5:40:38
 *
 */
@Controller
public class ItemController {

	@Autowired
	private ItemService itemService;

	@RequestMapping("/item/{itemid}")
	@ResponseBody
	public TbItem getItemById(@PathVariable long itemid) {
		TbItem item = itemService.getItemById(itemid);
		return item;
	}
	@RequestMapping("/item/list")
	@ResponseBody
	public DataGridResult getItemList(Integer page,Integer rows) {
		DataGridResult dataGridResult = itemService.getItemList(page, rows);
		return dataGridResult;
	}
}
