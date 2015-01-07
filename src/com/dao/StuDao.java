package com.dao;

import java.util.List;

import com.model.users.StuInfo;

public interface StuDao {
StuInfo get(Long id);
Long save(StuInfo stu);
List<StuInfo>findByID(Long idid);
}
