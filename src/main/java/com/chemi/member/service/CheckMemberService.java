package com.chemi.member.service;

import com.chemi.member.dao.CheckMemberDao;
import com.chemi.member.vo.MemberVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CheckMemberService {

    private final CheckMemberDao chdao;

    public String checkId(MemberVo vo) {

        return chdao.checkId(vo);

    }
}
