package com.gzc.mapper;

import com.gzc.pojo.User;
import org.mybatis.spring.SqlSessionTemplate;

import java.util.List;

public class UserMapperImpl implements UserMapper {
    private SqlSessionTemplate sqlsession;

    public void setSqlsession(SqlSessionTemplate sqlsession) {
        this.sqlsession = sqlsession;
    }

    @Override
    public List<User> selectUser() {
        UserMapper mapper = sqlsession.getMapper(UserMapper.class);
        return mapper.selectUser();
    }
}
