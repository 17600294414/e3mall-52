package cn.e3mall.content.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.e3mall.common.pojo.DataGridResult;
import cn.e3mall.common.pojo.E3Result;
import cn.e3mall.content.service.ContentService;
import cn.e3mall.mapper.TbContentMapper;
import cn.e3mall.pojo.TbContent;
import cn.e3mall.pojo.TbContentExample;
import cn.e3mall.pojo.TbContentExample.Criteria;

/**
 * 
 * @ClassName: ContentServiceImpl
 * @Description: 内容管理Service
 * @author 王铁臻
 * @date 2017年8月10日 下午10:13:05
 * @version V1.0
 */
@Service
public class ContentServiceImpl implements ContentService {

	@Autowired
	private TbContentMapper contentMapper;

	@Override
	public DataGridResult getContentList(Long categoryId, int page, int rows) {
		// 1、设置分页信息。使用Mybatis的分页插件
		PageHelper.startPage(page, rows);
		// 2、执行查询，根据分类id查询
		TbContentExample example = new TbContentExample();
		Criteria criteria = example.createCriteria();
		criteria.andCategoryIdEqualTo(categoryId);
		// 执行查询
		List<TbContent> list = contentMapper.selectByExample(example);
		// 3、取分页结果total
		PageInfo<TbContent> pageInfo = new PageInfo<>(list);
		long total = pageInfo.getTotal();
		// 4、封装到DataGridResult对象中
		DataGridResult result = new DataGridResult();
		result.setTotal(total);
		result.setRows(list);
		// 5、返回DataGridResult
		return result;
	}

	@Override
	public E3Result addContent(TbContent content) {
		// 1、补全pojo对象的属性
		content.setCreated(new Date());
		content.setUpdated(new Date());
		// 2、插入到数据库中
		contentMapper.insert(content);
		// 3、返回成功
		return E3Result.ok();
	}

}
