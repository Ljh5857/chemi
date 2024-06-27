package com.chemi.admin.service;

import com.chemi.admin.dao.AdminDao;
import com.chemi.admin.vo.AdminVo;
import com.chemi.owner.vo.OwnerVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class AdminService {

    private final AdminDao dao;

    public boolean login(AdminVo adminVo) {
        AdminVo result = dao.login(adminVo);
        return result != null;
    }

    public boolean approveOwner(OwnerVo ownerVo) {
        return dao.updateJoinApproval(ownerVo);
    }

    public List<OwnerVo> getOwnerList() {
        return dao.getOwnerList();
    }

}
