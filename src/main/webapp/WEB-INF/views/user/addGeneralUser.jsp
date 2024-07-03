<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <jsp:include page="/resources/commonLib.jsp"></jsp:include>
    <title>회원가입</title>
    <style>
        .time {
            display: flex;
        }

        .form-group .btn {
            height: 26px;
            padding-top: 0;
            padding-bottom: 0;
            margin: auto 10px;
            color: blue;
        }

        .form-group label {
            width: 140px;
        }

        #checkMailAuthNum {
            margin: 14px;
        }

        #checkPhoneAuthNum {
            margin: 14px;
        }

        .container .add_user_btn_btn {
            position: relative;
            bottom: 10%;
            right: 7%;
            margin-top: 15px;
        }

        .checkFont {
            font-size: 12px;
            padding-left: 28px;
        }
    </style>
    <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
</head>

<body data-spy="scroll" data-target=".onpage-navigation" data-offset="60">
    <main>

        <jsp:include page="../common/header.jsp"></jsp:include>
        <div class="main">
            <div class="container" style="padding-top: 72px;">
                <img src="../../resources/images/addGeneralUserImg.png" alt="">
            </div>
            <section class="module" style="padding-top:0;">
                <div class="container">
                    <div class="col-sm-8 col-sm-offset-2">
                        <hr class="divider-w mt-10 mb-20">
                        <form id="add_g_form" class="form" role="form" action="${pageContext.request.contextPath}/user/addUser" method="POST">
                            <div id="email" class="form-group row">
                                <div><input id="role" name="role" value="GENERAL" hidden="hidden"></div>
                                <label for="addGeneralId" class="col-sm-offset-1 col-sm-3 control-label"><strong>아이디</strong></label>
                                <div class="col-sm-6">
                                    <input id="addGeneralId" name="id" class="form-control " type="text" placeholder="아이디를 입력해주십시요" />
                                </div>
                            </div>
                            <div class="form-group row">
                                <label for="password" class="col-sm-offset-1 col-sm-3 control-label"><strong>비밀번호</strong></label>
                                <div class="col-sm-6">
                                    <input id="addGeneralPassword" name="pwd" class="form-control " type="password" placeholder="비밀번호는 8~15자까지 입력 가능합니다." maxlength="15" />
                                </div>
                                <div></div>
                            </div>
                            <div class="form-group row">
                                <label for="confirmPassword" class="col-sm-offset-1 col-sm-3 control-label"><strong>비밀번호 재확인</strong></label>
                                <div class="col-sm-6">
                                    <input id="addConfirmPassword" name="pwd2" class="form-control" type="password" placeholder="비밀번호를 입력해 주세요." maxlength="15" />
                                </div>
                                <div></div>
                                <div id="check-pwd" class='col-sm-offset-3 col-sm-6 checkFont'></div>
                            </div>
                            <div id="nick-name" class="form-group row">
                                <label for="nickName" class="col-sm-offset-1 col-sm-3 control-label"><strong>닉네임</strong></label>
                                <div class="col-sm-6">
                                    <input id="nickName" name="nick" class="form-control" type="text" placeholder="닉네임을 입력해 주세요." />
                                </div>
                                <div></div>
                                <div id="check-nickName" class='col-sm-offset-3 col-sm-6 checkFont'></div>
                            </div>
                            <div class="form-group row">
                                <label for="name" class="col-sm-offset-1 col-sm-3 control-label"><strong>이름</strong></label>
                                <div class="col-sm-6">
                                    <input id="addGeneralname" name="name" class="form-control" type="text" placeholder="이름을 입력하세요" />
                                </div>
                                <div></div>
                            </div>
                            <div class="form-group row">
                                <label for="phone" class="col-sm-offset-1 col-sm-3 control-label"><strong>휴대폰번호</strong></label>
                                <div class="col-sm-6">
                                    <input id="addGeneralPhone" name="phone" class="form-control " type="text" placeholder="숫자만 입력해주세요" maxlength="11" />
                                </div>
                                <div id="phoneAuthNum_btn" style="display:none;">
                                    <button id="phoneAuthNum" class="btn btn-circle btn-xs" type="button">인증번호 받기</button>
                                </div>
                                <div id="check-phone" class='col-sm-offset-3 col-sm-6 checkFont'></div>
                                <div id="check-phone-auth" class='col-sm-offset-3 col-sm-6 checkFont'></div>
                            </div>
                            <div class="form-group row">
                                <label for="addr" class="col-sm-offset-1 col-sm-3 control-label"><strong>주소</strong></label>
                                <div class="col-sm-6">
                                    <input id="add_g_addr" name="address" class="form-control" type="text" placeholder="주소를 입력하세요." />
                                </div>
                            </div>
                            <div class="form-group row">
                                <label for="detailedAddr" class="col-sm-offset-1 col-sm-3 control-label"><strong>상세주소</strong></label>
                                <div class="col-sm-6">
                                    <input id="add_g_detailedAddr" name="detailedAddr" class="form-control" type="text" placeholder="상세주소를 입력하세요." />
                                    <input type="hidden" name="allAddr" />
                                </div>
                            </div>
                            <div class="form-group row">
                                <label for="email" class="col-sm-offset-1 col-sm-3 control-label"><strong>이메일</strong></label>
                                <div class="col-sm-6">
                                    <input id="add_g_email" name="email" class="form-control" type="email" placeholder="이메일을 입력하세요." />
                                </div>
                            </div>
                            <div class="form-group row">
                                <label for="zipCode" class="col-sm-offset-1 col-sm-3 control-label"><strong>우편번호</strong></label>
                                <div class="col-sm-6">
                                    <input id="zipCode" name="zipCode" class="form-control" type="text" placeholder="우편번호를 입력하세요">
                                </div>
                            </div>
                            <div class="col-sm-3 col-sm-offset-2"></div>
                            <div class="col-sm-3 col-sm-offset-2">
                                <div class="add_user_btn_btn row">
                                    <button id="get_g_cancel" class="btn btn-border-d btn-circle" type="button">취소</button>
                                    <button id="joinAddUser" class="btn btn-border-d btn-circle" type="submit">가입하기</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </section>
        </div>
    </main>
</body>

</html>
