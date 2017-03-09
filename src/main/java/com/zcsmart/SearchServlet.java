package com.zcsmart;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangchong on 2017/3/9.
 */
public class SearchServlet extends HttpServlet {

	private static final long serialVersion = 1L;

	static List<String> datas = new ArrayList<String>();
	static{

		datas.add("ajax");
		datas.add("ajax post");
		datas.add("ajax bill");
		datas.add("post");
		datas.add("james");
		datas.add("jerry");
	}


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(123);
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		//获得关键字
		String keyword = req.getParameter("keyword");

		List<String> listData = getData(keyword);
		//返回Json格式(此处使用GSON转换)
		Gson gson = new Gson();
		JsonArray jsonArray = new JsonParser().parse(gson.toJson(listData)).getAsJsonArray();
		System.out.println(jsonArray);
		resp.getWriter().write(jsonArray.toString());
	}

	//获得关联数据
	public List<String> getData(String keyword){
		List<String> list = new ArrayList<String>();
		for(String data:datas){
			if(data.contains(keyword)){
				list.add(data);
			}
		}

		return list;
	}
}
