package com.xiaoshu.service;

import java.util.Date;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xiaoshu.dao.CompanyMapper;
import com.xiaoshu.dao.PersonMapper;
import com.xiaoshu.entity.Company;
import com.xiaoshu.entity.Person;
import com.xiaoshu.entity.PersonVo;

@Service
public class PersonService {
	@Autowired
	PersonMapper personMapper;
	@Autowired
	CompanyMapper companyMapper;

	
	
	
	public List<Company> findCompany(){
		return companyMapper.selectAll();
	}
	
	
	public PageInfo<PersonVo> findPage(PersonVo personVo , Integer pageNum , Integer pageSize){
		PageHelper.startPage(pageNum, pageSize);
		List<PersonVo> list = personMapper.findList(personVo);
		return new PageInfo<PersonVo>(list);
	}
	
	public Person findByName(String name){
		Person p = new Person();
		p.setExpressName(name);
		return personMapper.selectOne(p);
	}
	
	public void addPerson(Person person){
		person.setCreateTime(new Date());
		personMapper.insert(person);
	}
	
	public void updatePerson(Person person){
		personMapper.updateByPrimaryKeySelective(person);
	}
	public void deletePerson(Integer id){
		personMapper.deleteByPrimaryKey(id);
	}
	
}
