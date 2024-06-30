package com.chemi.owner.service;


import com.chemi.owner.dao.OwnerDao;
import com.chemi.owner.vo.OwnerVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class OwnerService {


    private final OwnerDao dao;

    public OwnerVo login(OwnerVo vo) {
        return dao.login(vo);
    }

    public int join(OwnerVo vo) throws Exception {
//        if(vo.getId().length() < 4){
//            throw new Exception("아이디가 너무 짧습니다.");
//        }
//        if(vo.getPwd().length() < 3){
//            throw new Exception("비밀번호가 너무 짧습니다.");
//        }
//        if(vo.getPwd().equals(vo.getPwd2())){
//            throw new Exception("비밀번호가 일치하지 않습니다.");
//        }
        return dao.join(vo);
    }

    public int pwdEdit(OwnerVo vo) throws Exception {

        if(vo.getPwd().length() < 3){
            throw new Exception("비밀번호가 너무 짧습니다.");
        }

        return dao.pwdEdit(vo);
    }
}
