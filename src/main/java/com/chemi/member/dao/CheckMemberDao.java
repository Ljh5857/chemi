package com.chemi.member.dao;


import com.chemi.member.mapper.CheckMemberMapper;
import com.chemi.member.vo.MemberVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class CheckMemberDao {

    private final CheckMemberMapper chMapper;

    public String checkId(MemberVo vo) {

        return chMapper.checkId(vo);
    }
}
