package com.chemi.admin.service;

import com.chemi.admin.dao.AdminDao;
import com.chemi.admin.vo.AdminVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class AdminService {

    private final AdminDao dao;

    public boolean login(AdminVo adminVo) {
        AdminVo result = dao.login(adminVo);
        return result != null;
    }
}
