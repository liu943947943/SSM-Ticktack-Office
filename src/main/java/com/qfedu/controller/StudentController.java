package com.qfedu.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qfedu.pojo.Student;
import com.qfedu.service.StudentService;
import com.qfedu.utils.ExcelUtils;
import com.qfedu.utils.LayuiUtil;
import com.qfedu.utils.ResultUtil;
import com.qfedu.vo.JsonBean;
import com.qfedu.vo.LayuiVo;
import com.qfedu.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.Map;


/**
 * Created by Administrator on 2019/6/19.
 */
@RestController
@RequestMapping("/student")
public class StudentController {
	@Autowired
	private StudentService studentService;

	//学生列表分页查询
	@RequestMapping("/studentpage.do")
	LayuiVo findAllCourseByPage(Integer page, Integer limit) {
		return LayuiUtil.execERROR(studentService.selectStudentNum(),studentService.selectStudentByPage(page, limit));
	}
	//学生删除
	@RequestMapping("/studentdelete.do")
	ResultVo studentDel(String no){
		Student s = new Student();
		s.setNo(no);
		s.setFlag(0);
		return ResultUtil.execOk(studentService.studentEdit(s));
	}
	//学生新增
	@RequestMapping("/studentadd.do")
	ResultVo studentAdd(String no,String name,String sex,@DateTimeFormat(pattern = "yyyy-MM-dd") Date birthday,
						String cardno, String school,String education,Integer gid,String email,
						String qq, String phone,String introno,@DateTimeFormat(pattern = "yyyy-MM-dd") Date createdate){
		Student student = new Student();
		student.setNo(no);
		student.setName(name);
		student.setSex(sex);
		student.setBirthday(birthday);
		student.setCardno(cardno);
		student.setSchool(school);
		student.setEducation(education);
		student.setGid(gid);
		student.setEmail(email);
		student.setQq(qq);
		student.setPhone(phone);
		student.setIntrono(introno);
		student.setCreatedate(createdate);
		student.setFlag(1);
		return ResultUtil.execOk(studentService.studentAdd(student));
	}

	//批量导入

	@RequestMapping("studentbatch.do")
	@ResponseBody
	public JsonBean importExcel(@RequestParam MultipartFile mFile){
		System.out.println("进入批量上传");
		// 获取上传文件的文件名
		String fileName = mFile.getOriginalFilename();

		// 获取上传文件的输入流
		try {
			InputStream inputStream = mFile.getInputStream();
			// 读取excel内容
			List<Map<String, Object>> maps = ExcelUtils.readExcel(fileName, inputStream);
			// 通过jackson进行操作
			ObjectMapper objectMapper = new ObjectMapper();
			// 将对象转为json格式字符串
			String jsonStr = objectMapper.writeValueAsString(maps);
			// 将json字符串转为指定类型的对象
			List<Student> studentsList = objectMapper.readValue(jsonStr, new TypeReference<List<Student>>() {});
			System.out.println("++++++++++"+studentsList);
			// 批量插入
			//studentService.addstudent(studentsList);
			studentService.addBatchStudent(studentsList);
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonBean(0, e.getMessage());
		}

		return new JsonBean(1, null);
	}

}
