<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>회원가입</title>
    <link rel="stylesheet" type="text/css" href="/WEB-INF/resources/css/join.css">
    <script src="/WEB-INF/resources/js/join.js"></script>
</head>
<body>
    <h2>회원가입</h2>
    <form action="/member/join" method="post">
        <label for="id">아이디:</label>
        <input type="text" id="id" name="id" required><br>
        
        <label for="pwd">비밀번호:</label>
        <input type="password" id="pwd" name="pwd" required><br>
        
        <label for="nick">닉네임:</label>
        <input type="text" id="nick" name="nick" required><br>
        
        <label for="name">이름:</label>
        <input type="text" id="name" name="name" required><br>
        
        <label for="email">이메일:</label>
        <input type="email" id="email" name="email" required><br>
        
        <label for="phone">전화번호:</label>
        <input type="text" id="phone" name="phone" required><br>
        
        <label for="address">주소:</label>
        <input type="text" id="address" name="address"><br>
        
        <label for="zipCode">우편번호:</label>
        <input type="text" id="zipCode" name="zipCode"><br>
        
        <label for="campingCoupon">캠핑 쿠폰:</label>
        <input type="text" id="campingCoupon" name="campingCoupon"><br>
        
        <label for="productCoupon">상품 쿠폰:</label>
        <input type="text" id="productCoupon" name="productCoupon"><br>
        
        <input type="hidden" id="delYn" name="delYn" value="N">
        
        <button type="submit">가입하기</button>
    </form>
</body>
</html>
