package com.baizhi.service;

import com.baizhi.dao.StudentDao;
import com.baizhi.dao.StudentTagDao;
import com.baizhi.dto.StudentRequestDTO;
import com.baizhi.dto.StudentResponseDTO;
import com.baizhi.entity.Student;
import com.baizhi.entity.StudentTag;
import com.baizhi.feign.CityClient;
import com.baizhi.feign.ClazzClient;
import com.baizhi.feign.GroupClient;
import com.baizhi.feign.TagClient;
import com.baizhi.utils.DateUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

@Service("studentService")
@Transactional
public class StudentServiceImpl implements StudentService {

    private final StudentDao studentDao;

    private final CityClient cityClient;
    private final GroupClient groupClient;
    private final ClazzClient clazzClient;
    private final TagClient tagClient;

    private final StudentTagDao studentTagDao;

    @Autowired
    public StudentServiceImpl(StudentDao studentDao, CityClient cityClient, GroupClient groupClient, ClazzClient clazzClient, TagClient tagClient, StudentTagDao studentTagDao) {
        this.studentDao = studentDao;
        this.cityClient = cityClient;
        this.groupClient = groupClient;
        this.clazzClient = clazzClient;
        this.tagClient = tagClient;
        this.studentTagDao = studentTagDao;
    }

    @Override
    public StudentResponseDTO insert(StudentRequestDTO studentRequestDTO) {
        //1.转为学生对象
        Student student = new Student();
        BeanUtils.copyProperties(studentRequestDTO, student);
        //2.设置学生(年龄 属相 星座)业务属性
        student.setAge(DateUtil.getAge(student.getBir()));//年龄
        student.setAttr(DateUtil.getYear(student.getBir()));//属相
        student.setStarts(DateUtil.getConstellation(student.getBir()));//星座
        //3.保存学生
        studentDao.insert(student);  //student 存在自己id
        List<Integer> tagIds = studentRequestDTO.getTagIds();
        if (!ObjectUtils.isEmpty(tagIds)) {
            //4.保存学生标签关系
            tagIds.forEach(tagId ->
                    studentTagDao.insert(new StudentTag(student.getId(), tagId))
            );
        }
        StudentResponseDTO studentResponseDTO = new StudentResponseDTO();
        BeanUtils.copyProperties(student, studentResponseDTO);
        //TODO 处理学生班级 小组  就业城市 标签等信息
        studentResponseDTO.setClazz(clazzClient.clazz(student.getClazzId()));
        studentResponseDTO.setCity(cityClient.city(student.getCityId()));
        studentResponseDTO.setGroup(groupClient.group(student.getGroupId()));
        //根据学生id获取学生标签id集合
        tagIds.forEach(id -> {
            studentResponseDTO.getTags().add(tagClient.tag(id));
        });
        
        return studentResponseDTO;
    }

    @Override
    public List<StudentResponseDTO> queryAll() {
        //1.查询学生列表
        List<Student> students = studentDao.queryAll();
        //2.将students转为studentResponseDTO的list
        List<StudentResponseDTO> studentResponseDTOS = new ArrayList<>();
        students.forEach(student -> {
            //3.属性复制
            StudentResponseDTO studentResponseDTO = new StudentResponseDTO();
            BeanUtils.copyProperties(student, studentResponseDTO);
            //TODO 处理班级 小组  城市    标签信息  //openfeign 调用服务过程如果服务执行超过1s openfegin报错
            studentResponseDTO.setClazz(clazzClient.clazz(student.getClazzId()));
            studentResponseDTO.setCity(cityClient.city(student.getCityId()));
            studentResponseDTO.setGroup(groupClient.group(student.getGroupId()));

            //根据学生id获取学生标签id集合
            List<Integer> tagIds = studentTagDao.queryByStudentId(student.getId());
            tagIds.forEach(id -> {
                studentResponseDTO.getTags().add(tagClient.tag(id));
            });
            //4.放入集合
            studentResponseDTOS.add(studentResponseDTO);
        });
        return studentResponseDTOS;
    }
}
