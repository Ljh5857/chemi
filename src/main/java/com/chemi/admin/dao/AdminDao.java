package com.chemi.admin.dao;

import com.chemi.admin.mapper.AdminMapper;
import com.chemi.admin.vo.AdminVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.security.AuthProvider;

@Repository
@RequiredArgsConstructor
public class AdminDao {

    private final AdminMapper mapper;

    public AdminVo login(AdminVo adminVo) {

        return mapper.login(adminVo);
    }
}
