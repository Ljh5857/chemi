<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="KR">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>예약 페이지</title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"
        integrity="sha256-LI5Kb6V0a6Gkp6Oz0C2XG9zP1OdF8Z3zNpKt+CZB8F0=" crossorigin="anonymous"></script>
    <style>
        .bg {
            background-color: #f2f2f2;
            min-height: 100%;
        }

        .page-container>section {
            padding-left: 2rem;
            padding-right: 2rem;
        }

        .reservation-main {
            max-width: 768px;
            margin-left: auto;
            margin-right: auto;
            background-color: #fff;
            height: 100%;
            padding-top: 15px;
            padding-bottom: 30px;
        }

        .zone-content {
            padding-top: 2rem;
        }

        .zone-container {
            min-height: 10rem;
            position: relative;
        }

        .zone-image {
            display: inline-block;
            position: absolute;
            width: 9rem;
            height: 9rem;
        }

        .zone-image>img {
            border-radius: 1em;
            width: 9rem;
            height: 9rem;
        }

        .zone-info {
            padding-top: 2rem;
            margin-left: 10.2rem;
            font-size: 1.0rem;
            line-height: 2rem;
        }

        .zone-name {
            font-weight: bold;
            font-size: 1.6rem;
            line-height: 2rem;
            max-height: 4rem;
        }

        .period-container {
            padding-top: 2rem;
        }

        .checkinout-box {
            border-radius: 1em;
            background-color: #f2f2f2;
            padding: 1rem 1.5rem;
        }

        .checkinout {
            font-size: 1.5rem;
            line-height: 2.8rem;
            display: flex;
        }

        .checkinout>span:nth-child(1) {
            color: #666;
            flex: 0 0 10rem;
        }

        .checkinout>span:nth-child(2) {
            flex: 1;
            color: #333;
            text-align: right;
        }

        .customer-container {
            padding-top: 2rem;
        }

        .customer-container>div {
            padding: 1rem 0 1rem 0;
            display: flex;
        }

        .section-title {
            font-weight: bold;
            font-size: 1.5rem;
            line-height: 2rem;
        }

        .customer-container>div>span:nth-child(1) {
            flex: 0 0 10rem;
        }

        .customer-container>div>span:nth-child(2) {
            flex: 1;
            text-align: right
        }

        .customer-count>span {
            padding: 0 5px 0 5px;
        }

        .customer-count-result {
            background-color: #f2f2f2;
            padding: 1rem 1.5rem;
            border-radius: 1em;
        }

        #over-count {
            display: none;
        }

        .car-info-container {
            padding-top: 2em;
        }

        .car-info {
            border-style: 1px solid black;
        }

        .car-title {
            padding: 8px 0 8px 0;
            border-bottom: thin black solid;
        }

        .form-container {
            display: flex;
            padding: 15px 0 8px 0;
        }

        .car-num {
            flex: 0 0 10rem;
        }

        .addition-container {
            padding: 10px 0 10px 0;
        }

        .addition-container>div {
            padding: 1rem 0rem;
        }

        .addition-container>div:nth-child(1) {
            font-weight: bold;
            font-size: 1.5rem;
            line-height: 2rem;
        }

        .reservation-cost-container {
            padding: 10px 0 10px 0;
        }

        .reservation-cost-container>div {
            padding: 1rem 0rem;
        }

        .reservation-cost-container>div:nth-child(1) {
            font-weight: bold;
            font-size: 1.5rem;
            line-height: 2rem;
        }

        .customer-container>div>span>span {
            padding: 0 9px 0 9px;
        }

        .bord-line {
            border-bottom: 1px solid #f2f2f2;
        }

        .verticality {
            display: flex;
            flex-direction: column;
        }

        .verticality>span:nth-child(2) {
            font-family: Noto Sans CJK KR;
            font-weight: 900;
        }

        .addition-item>span:nth-child(2) {
            font-weight: bold;
        }

        .reservation-cost-container-total>div:nth-child(n+3):nth-child(-n+6) {
            display: none;
        }

        .total-result-container>span {
            font-size: large;
            font-weight: bold;
        }

        .total-result-container>span>span {
            color: green;
        }

        .pay-go {
            display: block;
            text-align: center;
            width: 100%;
            height: 60px;
        }

        .footer {
            margin-top: 0px;
        }

        .reservation-customerinfo-container {
            padding: 10px 0 10px 0;
        }

        .btn {
            font-weight: bold;
        }
    </style>
</head>

<body>
    <div class="bg">
        <div class="container reservation-main">
            <section class="page-container">
                <section class="zone-content">
                    <section class="zone-container">
                        <div class="zone-image">
                            <img alt="구역이미지" th:src="'/images/' + ${book.book_site_image}">
                        </div>
                        <div class="zone-info">
                            <div class="zone-name" th:text="${book.site_name}"></div>
                            <div class="zone-total">기준인원2명</div>
                            <div class="zone-car">기준차량1대</div>
                        </div>
                    </section>
                </section>
                <section class="period-content">
                    <section class="period-container">
                        <div class="checkinout-box">
                            <div class="checkinout">
                                <span>체크인</span>
                                <span th:text="${book.book_checkin}" class="checkin_result"></span>
                            </div>
                            <div class="checkinout">
                                <span>체크아웃</span>
                                <span th:text="${book.book_checkout}" class="checkout_result"></span>
                            </div>
                        </div>
                    </section>
                </section>
                <section class="customer-content">
                    <section class="customer-container">
                        <div class="customer-total section-title">전체인원정보</div>
                        <div>
                            <span>성인</span>
                            <span class="customer-count">
                                <button type="button" onclick='count("minus",1)' class="btn btn-outline-danger">-</button>
                                <span id="result1">2</span>
                                <button type="button" onclick='count("plus",1)' class="btn btn-outline-primary">+</button>
                            </span>
                        </div>
                        <div>
                            <span>미성년자</span>
                            <span class="customer-count">
                                <button type="button" onclick='count("minus",2)' class="btn btn-outline-danger">-</button>
                                <span id="result2">0</span>
                                <button type="button" onclick='count("plus",2)' class="btn btn-outline-primary">+</button>
                            </span>
                        </div>
                        <section class="customer-count-result customer-container">
                            <div>
                                <span>기준인원</span>
                                <span id="basic-count">2</span>명
                            </div>
                            <div>
                                <span>추가 가능인원</span>
                                <span>2명</span>
                            </div>
                            <div>
                                <span>총인원제한</span>
                                <span id="limit-count">4</span>명
                            </div>
                            <div id="over-count">
                                <span>인원초과요금</span>
                                <span id="over-count-num">0</span>명
                            </div>
                        </section>
                    </section>
                </section>
                <section>
                    <section>
                        <div>*잠시 방문하는 게스트도 인원 정보에 포함해야 합니다.</div>
                    </section>
                </section>
                <section class="car-info-content">
                    <section class="car-info-container">
                        <div class="car-title section-title">차량정보</div>
                        <div class="form-container">
                            <div class="car-num">차량번호</div>
                            <input class="car-input" type="text" id="car_num" name="car_num" th:value="${book.book_car_num}">
                        </div>
                    </section>
                </section>
                <section class="addition-content">
                    <section class="addition-container">
                        <div class="section-title">추가옵션</div>
                        <div>
                            <span class="addition-item">
                                <span>배드</span>
                                <span>20000원</span>
                            </span>
                            <span class="customer-count">
                                <button type="button" onclick='addition_count("minus", 4)' class="btn btn-outline-danger">-</button>
                                <span id="result4">0</span>
                                <button type="button" onclick='addition_count("plus", 4)' class="btn btn-outline-primary">+</button>
                            </span>
                        </div>
                        <div>
                            <span class="addition-item">
                                <span>바베큐그릴</span>
                                <span>20000원</span>
                            </span>
                            <span class="customer-count">
                                <button type="button" onclick='addition_count("minus", 5)' class="btn btn-outline-danger">-</button>
                                <span id="result5">0</span>
                                <button type="button" onclick='addition_count("plus", 5)' class="btn btn-outline-primary">+</button>
                            </span>
                        </div>
                        <div>
                            <span class="addition-item">
                                <span>침낭</span>
                                <span>20000원</span>
                            </span>
                            <span class="customer-count">
                                <button type="button" onclick='addition_count("minus", 6)' class="btn btn-outline-danger">-</button>
                                <span id="result6">0</span>
                                <button type="button" onclick='addition_count("plus", 6)' class="btn btn-outline-primary">+</button>
                            </span>
                        </div>
                    </section>
                </section>
                <section class="reservation-cost-content">
                    <section class="reservation-cost-container">
                        <div class="section-title">결제 정보</div>
                        <div class="bord-line">
                            <span>기본요금</span>
                            <span id="result7">0</span>원
                        </div>
                        <div class="bord-line">
                            <span>추가요금</span>
                            <span id="result3">0</span>원
                        </div>
                        <div class="bord-line">
                            <span>배드</span>
                            <span id="result4">0</span>개
                        </div>
                        <div class="bord-line">
                            <span>바베큐그릴</span>
                            <span id="result5">0</span>개
                        </div>
                        <div class="bord-line">
                            <span>침낭</span>
                            <span id="result6">0</span>개
                        </div>
                    </section>
                </section>
                <section class="reservation-total-cost-content">
                    <section class="reservation-cost-container-total">
                        <div class="total-result-container">
                            총 금액<span><span id="total_result">0</span>원</span>
                        </div>
                    </section>
                </section>
                <section class="pay-content">
                    <button class="pay-go btn btn-outline-success">결제하기</button>
                </section>
            </section>
        </div>
    </div>

	<script>
		$(document).ready(function () {
			$(".nav-item:nth-child(5)").attr('class', 'nav-item active');
			$(".notactive:nth-child(5)").attr('class', 'active');
		});
	
		function count(type, num) {
			const resultElement = document.getElementById('result' + num);
			const resultElement1 = document.getElementById('result1');
			const resultElement2 = document.getElementById('result2');
			const over = document.getElementById('over-count-num');
			const basic = document.getElementById('basic-count');
			let number = parseInt(resultElement.textContent);
			let num1 = parseInt(resultElement1.textContent);
			let num2 = parseInt(resultElement2.textContent);
			let basic_num = parseInt(basic.textContent);
			let over_number = parseInt(over.textContent);
			let hap = num1 + num2;
	
			if (type === 'plus') {
				if (hap < 4) {
					number = number + 1;
					resultElement.textContent = number;  // 여기에 추가
					hap++;
					if (hap > basic_num) {
						over_number = hap - basic_num;
						over.textContent = over_number;
					}
					overchange(over_number);
				}
			} else if (type === 'minus') {
				if (hap > 1) {
					number = number - 1;
					resultElement.textContent = number;  // 여기에 추가
					hap--;
					if (hap >= basic_num) {
						over_number = hap - basic_num;
						over.textContent = over_number;
					} else {
						over_number = 0;
						over.textContent = over_number;
					}
					overchange(over_number);
				}
			}
		}
	
		function overchange(over_num) {
			if (over_num > 0) {
				$("#over-count").css("display", "flex");
				$(".reservation-cost-container-total>div:nth-child(3)").css("display", "flex");
			} else {
				$("#over-count").css("display", "none");
				$(".reservation-cost-container-total>div:nth-child(3)").css("display", "none");
			}
			let over_cost = over_num * 10000;
			$("#result3").html(priceToString(over_cost));
			total_count();
		}
	
		function addition_count(type, num) {
			const resultElement = document.getElementById('result' + num);
			let number = parseInt(resultElement.textContent);
			if (type === 'plus') {
				number = number + 1;
			} else if (type === 'minus' && number > 0) {
				number = number - 1;
			}
			resultElement.textContent = number;
			total_count();
		}
	
		function total_count() {
			let result7 = StringToprice($('#result7').text());
			let result3 = StringToprice($('#result3').text());
			let result4 = parseInt($('#result4').text());
			let result5 = parseInt($('#result5').text());
			let result6 = parseInt($('#result6').text());
			let total_result = result7 + result3 + (result4 * 20000) + (result5 * 20000) + (result6 * 20000);
			$('#total_result').html(priceToString(total_result));
		}
	
		function priceToString(price) {
			return price.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ',');
		}
	
		function StringToprice(price) {
			return parseInt(price.toString().replace(/,/g, ''));
		}
	</script>
	</script>
</body>

</html>