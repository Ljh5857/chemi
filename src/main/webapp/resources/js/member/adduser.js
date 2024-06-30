//document.addEventListener("DOMContentLoaded", function() {
//    // 1. 아이디 입력창 정보 가져오기
//    let elInputUserid = document.querySelector('#userid');
//    // 3. 실패 메시지 정보 가져오기 (글자수 제한 4~12글자)
//    let elFailureMessage = document.querySelector('.failure-message');
//    // 4. 실패 메시지2 정보 가져오기 (영어 또는 숫자)
//    let elFailureMessageTwo = document.querySelector('.failure-message2');
//
//    function idLength(value) {
//        return value.length >= 4 && value.length <= 12;
//    }
//
//    function onlyNumberAndEnglish(str) {
//        return /^[A-Za-z0-9]+$/.test(str); // 간소화된 정규 표현식
//    }
//
//    elInputUserid.onkeyup = function() {
//        // 입력 값을 변수에 저장
//        let inputVal = elInputUserid.value;
//
//        // 값을 입력한 경우
//        if (inputVal.length !== 0) {
//            let isLengthValid = idLength(inputVal);
//            let isContentValid = onlyNumberAndEnglish(inputVal);
//
//            // 글자 수와 내용 유효성 검사 결과에 따라 메시지와 버튼 표시 제어
//            elFailureMessage.classList.toggle('hide', isLengthValid);
//            elFailureMessageTwo.classList.toggle('hide', isContentValid);
//        } else {
//            // 값을 입력하지 않은 경우 (지웠을 때) 모든 메시지와 버튼을 가림
//            elFailureMessage.classList.add('hide');
//            elFailureMessageTwo.classList.add('hide');
//        }
//    }
//
//    // 비밀번호 유효성 검사
//    // 1. 비밀번호 입력창 정보 가져오기
//    let elInputPassword = document.querySelector('#password'); // input#password
//    // 2. 비밀번호 확인 입력창 정보 가져오기
//    let elInputPasswordRetype = document.querySelector('#password-retype'); // input#password-retype
//    // 3. 실패 메시지 정보 가져오기 (비밀번호 불일치)
//    let elMismatchMessage = document.querySelector('.mismatch-message'); // div.mismatch-message.hide
//    // 4. 실패 메시지 정보 가져오기 (8글자 이상, 영문, 숫자, 특수문자 미사용)
//    let elStrongPasswordMessage = document.querySelector('.strongPassword-message'); // div.strongPassword-message.hide
//
//    function strongPassword(str) {
//        return /^(?=.*[A-Za-z])(?=.*\d)(?=.*[@$!%*#?&])[A-Za-z\d@$!%*#?&]{8,}$/.test(str);
//    }
//
//    function isMatch(password1, password2) {
//        return password1 === password2;
//    }
//
//    //비밀번호 입력 이벤트
//    elInputPassword.onkeyup = function() {
//        if (elInputPassword.value.length !== 0) {
//            if (strongPassword(elInputPassword.value)) {
//                elStrongPasswordMessage.classList.add('hide'); // 실패 메시지가 가려져야 함
//            } else {
//                elStrongPasswordMessage.classList.remove('hide'); // 실패 메시지가 보여야 함
//            }
//        } else {
//            // 값을 입력하지 않은 경우 (지웠을 때)
//            // 모든 메시지를 가린다.
//            elStrongPasswordMessage.classList.add('hide');
//        }
//    };
//
//    //비밀번호 확인 이벤트
//    elInputPasswordRetype.onkeyup = function() {
//        if (elInputPasswordRetype.value.length !== 0) {
//            if (isMatch(elInputPassword.value, elInputPasswordRetype.value)) {
//                elMismatchMessage.classList.add('hide'); // 실패 메시지가 가려져야 함
//            } else {
//                elMismatchMessage.classList.remove('hide'); // 실패 메시지가 보여야 함
//            }
//        } else {
//            elMismatchMessage.classList.add('hide'); // 실패 메시지가 가려져야 함
//        }
//    };
//
//    // 이름 유효성 검사
//    //이름입력창 가져오기
//    let elInputUsername = document.querySelector('#username'); // input#userid
//    // 실패 메시지 정보 가져오기 (특수문자,숫자 x)
//    let elnameerror = document.querySelector('.nameerror-message'); // div.nameerror-message.hide
//
//    function onlynamekr(str) {
//        return /^[가-힣]*$/.test(str);
//    }
//
//    //이름체크
//    elInputUsername.onkeyup = function() {
//        if (elInputUsername.value.length !== 0) {
//            if (onlynamekr(elInputUsername.value)) {
//                elnameerror.classList.add('hide'); // 실패 메시지가 가려져야 함
//            } else {
//                elnameerror.classList.remove('hide'); // 실패 메시지가 보여야 함
//            }
//        } else {
//            // 값을 입력하지 않은 경우 (지웠을 때)
//            // 모든 메시지를 가린다.
//            elnameerror.classList.add('hide');
//        }
//    };
//
//    //생년월일 입력창 가져오기
//    let elInputbith = document.querySelector('#bith');
//    // 실패 메시지 정보 가져오기 (생년월일 양식)
//    let elbitherror = document.querySelector('.bitherror-massage');
//
//    //생년월일 양식체크
//    function onlybith(str) {
//        const regex = new RegExp(`^(19\\d{2}|20[0-1][0-9]|202[0-3])-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])$`);
//        return regex.test(str);
//    }
//
//    elInputbith.onkeyup = function() {
//        if (elInputbith.value.length !== 0) {
//            if (onlybith(elInputbith.value)) {
//                elbitherror.classList.add('hide'); // 실패 메시지가 가려져야 함
//            } else {
//                elbitherror.classList.remove('hide'); // 실패 메시지가 보여야 함
//            }
//        } else {
//            elbitherror.classList.add('hide'); // 모든 메시지를 가림
//        }
//    };
//
//    //휴대폰 번호 유효성 검사
//    let elInputphone = document.querySelector('#phone');
//    let elphoneerr = document.querySelector('.phoneerr-massage');
//
//    function onlyphone(str) {
//        return /^\d{3}-\d{3,4}-\d{4}$/.test(str);
//    }
//
//    elInputphone.onkeyup = function() {
//        if (elInputphone.value.length !== 0) {
//            if (onlyphone(elInputphone.value)) {
//                elphoneerr.classList.add('hide'); // 실패 메시지가 가려져야 함
//            } else {
//                elphoneerr.classList.remove('hide'); // 실패 메시지가 보여야 함
//            }
//        } else {
//            elphoneerr.classList.add('hide'); // 모든 메시지를 가림
//        }
//    };
//
//    // 이메일 유효성 검사
//    let elInputemail = document.querySelector('#email');
//    let elemailerr = document.querySelector('.emailerr-massage');
//
//    function onlyemail(str) {
//        return /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i.test(str);
//    }
//
//    elInputemail.onkeyup = function() {
//        if (elInputemail.value.length !== 0) {
//            if (onlyemail(elInputemail.value)) {
//                elemailerr.classList.add('hide'); // 실패메시지가 가려지게
//            } else {
//                elemailerr.classList.remove('hide'); // 실패메시지가 보여야 함
//            }
//        } else {
//            elemailerr.classList.add('hide'); // 모든 메시지를 가려지게
//        }
//    };
//
//    // 아이디 중복 확인
//    document.querySelector("#checkDupBtn").addEventListener("click", function() {
//        const id = document.querySelector("#userid").value;
//        $.ajax({
//            url: "/LoveDiary/member/id-dup",
//            type: "get",
//            data: { "id": id },
//            success: function(x) {
//                if (x === "good") {
//                    alert("사용 가능한 아이디 입니다.");
//                } else {
//                    alert("사용 불가능한 아이디 입니다.");
//                }
//            },
//            error: function() {
//                console.log("통신 실패입니다.");
//            }
//        });
//    });
//
//    // 회원가입 버튼 클릭 이벤트
//    document.querySelector("#joinAddUser").addEventListener("click", function() {
//        fncAddUser();
//    });
//
//    // 회원가입 폼 검증 및 제출 함수
//    function fncAddUser() {
//        var id = $("#userid").val();
//        var pw = $("#password").val();
//        var pw_confirm = $("input[name='confirmPassword']").val();
//        var name = $("#username").val();
//        var phone = $("#phone").val();
//        var email = $("#email").val();
//
//        if (id == null || id.length < 1) {
//            alert("아이디는 반드시 입력하셔야 합니다.");
//            return;
//        }
//
//        if (pw == null || pw.length < 1) {
//            alert("패스워드는 반드시 입력하셔야 합니다.");
//            return;
//        }
//
//        if (pw.length < 8) {
//            alert("패스워드는 8자 이상이어야 합니다.");
//            return;
//        }
//
//        if (pw_confirm == null || pw_confirm.length < 1) {
//            alert("패스워드 확인은 반드시 입력하셔야 합니다.");
//            return;
//        }
//
//        if (name == null || name.length < 1) {
//            alert("이름은 반드시 입력하셔야 합니다.");
//            return;
//        }
//
//        if (pw != pw_confirm) {
//            alert("비밀번호 확인이 일치하지 않습니다.");
//            $("input:text[name='confirmPassword']").focus();
//            return;
//        }
//
//        if (phone == null || phone.length < 1) {
//            alert("휴대폰번호는 반드시 입력하셔야 합니다.");
//            return;
//        }
//
//        if (!onlyphone(phone)) {
//            alert("휴대폰번호 형식이 올바르지 않습니다.");
//            return;
//        }
//
//        if (email == null || email.length < 1) {
//            alert("이메일은 반드시 입력하셔야 합니다.");
//            return;
//        }
//
//        if (!onlyemail(email)) {
//            alert("이메일 형식이 올바르지 않습니다.");
//            return;
//        }
//
//        Swal.fire({
//            icon: 'success',
//            title: '가입완료',
//            html: '회원가입이 완료되었습니다.<br>로그인 후 이용 가능합니다:)'
//        }).then(() => {
//            $("#add_g_form").attr("method", "POST").attr("action", "/user/addUser").attr("enctype", "multipart/form-data").submit();
//        });
//    }
//});
