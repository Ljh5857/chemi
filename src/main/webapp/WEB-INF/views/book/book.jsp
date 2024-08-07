<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>

        .verticality {
            display: flex;
            flex-direction: column;
        }

        .day {
         padding: 10px;
         text-align: center;
         border-radius: 5px;
         background-color: lightgreen; 
}
        .sub_btn {
            display: inline-block;
            padding: 10px 20px;
            background-color: #007BFF;
            color: white;
            text-align: center;
            text-decoration: none;
            border-radius: 4px;
            border: 1px solid #007BFF;
            cursor: pointer;
        }

        .sub_btn:hover {
            background-color: #0056b3;
            border-color: #004085;
        }
    </style>
</head>
<body>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script>
   $(document).ready(function () {
      $(".nav-item:nth-child(5)").attr('class', 'nav-item active');
      $(".notactive:nth-child(5)").attr('class', 'active');


      var bookFrom = $("#bookForm");
      $("#pay_btn_make").click(function () {
         if ('[[${session.user}]]' == null || '[[${session.user}]]' == '') {
            alert("로그인 후 사용해 주세요.")
            document.getElementById("modal").style.display = "flex";
            document.body.style = "overflow: hidden";
         } else {
            bookFrom.submit();
         }
      });


   });
</script>

<script type="text/javascript">
   var selectDate1 = null;
   var selectDate2 = null;
   var checkInYear = null;
   var checkOutYear = null;
   var checkInMonth = null;
   var checkOutMonth = null;
   var checkInDate = null;
   var checkOutdDate = null;
   var today = null;
   var realToday = null;
   const ABLEDAYS = 55;
   var clickedSiteCode = null;

   function number() {
      checkInYear -= 0;
      checkOutYear -= 0;
      checkInDate -= 0;
      checkOutdDate -= 0;
      checkInMonth -= 0;
      checkOutMonth -= 0;
   };

   function change3() {
      var t = checkInYear;
      checkInYear = checkOutYear;
      checkOutYear = t;
      t = checkInDate;
      checkInDate = checkOutdDate;
      checkOutdDate = t;
      t = checkInMonth;
      checkInMonth = checkOutMonth;
      checkOutMonth = t;
   };

   function bookPointOn() {
      number();
      if (checkInYear && checkOutYear) {
         if ((checkInYear * 10000 + checkInMonth * 100 + checkInDate)
            > (checkOutYear * 10000 + checkOutMonth * 100 + checkOutdDate)) {
            change3();
         }

         var startDay = checkInDate;
         var endDay = checkOutdDate;

         if ((today.getFullYear() * 100 + today.getMonth() + 1) < (checkInYear * 100 + checkInMonth)) {
            startDay = 32;
         } else if ((today.getFullYear() * 100 + today.getMonth() + 1) > (checkInYear * 100 + checkInMonth)) {
            startDay = 0;
         }
         if ((today.getFullYear() * 100 + today.getMonth() + 1) < (checkOutYear * 100 + checkOutMonth)) {
            endDay = 32;
         } else if ((today.getFullYear() * 100 + today.getMonth() + 1) > (checkOutYear * 100 + checkOutMonth)) {
            endDay = 0;

         }
         for (var i = startDay; i <= endDay; i++) {
            $('#' + i + '').attr('style', 'background-color: rgb(247,233,231);');
         }
      }
   };

   function OneClickPointOn() {
      let clickYMD = selectDate1.split('-');
      let clickYM = Number(clickYMD[0]) * 100 + Number(clickYMD[1]);
      let todayYM = today.getFullYear() * 100 + (today.getMonth() + 1);
      if (clickYM === todayYM) {
         $('#' + Number(clickYMD[2]) + '').attr('style', 'background-color: rgb(247,233,231);');
      }
   }

   function bookPointOff() {
      checkInYear = null;
      checkOutYear = null;
      checkInMonth = null;
      checkOutMonth = null;
      checkInDate = null;
      checkOutdDate = null;
      for (var i = 1; i <= 31; i++) {
         $('#' + i + '').attr('style', 'background-color: while;');
      }
   };

   function buildCalendar() {
      if (today == null) {
         today = new Date();
      }
      var row = null
      var cnt = 0;
      var calendarTable = document.getElementById("calendar");
      var calendarTableTitle = document.getElementById("calendarTitle");
      calendarTableTitle.innerHTML = today.getFullYear() + "년" + (today.getMonth() + 1) + "월";

      var firstDate = new Date(today.getFullYear(), today.getMonth(), 1);
      var lastDate = new Date(today.getFullYear(), today.getMonth() + 1, 0);
      while (calendarTable.rows.length > 2) {
         calendarTable.deleteRow(calendarTable.rows.length - 1);
      }

      row = calendarTable.insertRow();
      for (i = 0; i < firstDate.getDay(); i++) {
         cell = row.insertCell();
         cnt += 1;
      }

      for (i = 1; i <= lastDate.getDate(); i++) {

         cell = row.insertCell();
         cnt += 1;

         cell.setAttribute('id', i);
         cell.innerHTML = "<a href='#check'>" + i + "</a>";
         cell.align = "center";


         cell.onclick = function () {
            clickedYear = today.getFullYear();
            clickedMonth = (1 + today.getMonth());
            clickedDate = this.getAttribute('id');
            let clickedYMDDate = new Date(clickedYear, clickedMonth - 1, clickedDate);
            clickedDate = clickedDate >= 10 ? clickedDate : '0' + clickedDate;
            clickedMonth = clickedMonth >= 10 ? clickedMonth : '0' + clickedMonth;
            clickedYMD = clickedYear + "-" + clickedMonth + "-" + clickedDate;
            if (isDisabledDate(clickedYMDDate) !== 0) {
               if (isDisabledDate(clickedYMDDate) === 1) {
                  alert("아직 활성화 되지 않은 예약입니다.")
               } else {
                  alert("오늘 이후 날짜를 선택해주세요.")
               }
               return;
            }
            if (selectDate1 == null) {
               selectDate1 = clickedYMD;

               bookPointOff();
               OneClickPointOn();
               checkInYear = clickedYear;
               checkInMonth = clickedMonth;
               checkInDate = clickedDate;

            } else if (selectDate1 == clickedYMD) {
               alert("최소 1박이상을 선택해주세요.")
               return;
            } else if (selectDate1 != null) {
               selectDate2 = clickedYMD;
               checkOutYear = clickedYear;
               checkOutMonth = clickedMonth;
               checkOutdDate = clickedDate;

               bookPointOn();

               $.ajax({
                  url: '/selectDate',
                  type: 'post',
                  data: { 'selectDate1': selectDate1, 'selectDate2': selectDate2, 'company_code': '[[${session.company.company_code}]]' },
                  success: function (result) {
                     $('#bookForm>div>input[name=book_checkin]').val(result.book_checkin);
                     $('#bookForm>div>input[name=book_checkout]').val(result.book_checkout);
                     for (var i = 0; i < result.zoneList.length; i++) {
                        var siteList = "";
                        var zoneList = "";
                        var rate = 100 / result.zoneList.length + "%";
                        zoneList += result.zoneList[i].zone_name;

                        document.getElementById("zone" + (i + 1) + "").innerText = zoneList;
                        for (var j = 0; j < result.availableSite.length; j++) {
                           if (result.zoneList[i].zone_code == result.availableSite[j].zone_code) {
                              siteList += "<a id='insitezone" + result.availableSite[j].site_code + "' href='#check' onclick='insitezone(" + result.availableSite[j].site_code + ")' alt='N'>" + result.availableSite[j].site_name + "</a><br>";
                           }
                        }
                        document.getElementById("site" + (i + 1) + "").innerHTML = siteList;
                     }

                     $('#bookForm li').attr({ 'style': 'width: ' + rate + ';' });
                     selectDate1 = null;
                     selectDate2 = null;
                  }
               })
               let paybtn = "";
               paybtn += '<a id="paymentGo" class="sub_btn">결제하기</a>';
               document.getElementById("pay_btn_make").innerHTML = paybtn;
            }
         }
         if (cnt % 7 == 1) {
            cell.innerHTML = "<a href='#check' style='color:#F79DC2;'>" + i + "</a>";
         }

         if (cnt % 7 == 0) {
            cell.innerHTML = "<a href='#check' style='color:skyblue;'>" + i + "</a>";
            row = calendar.insertRow();
         }
      }
      if (cnt % 7 != 0) {
         for (i = 0; i < 7 - (cnt % 7); i++) {
            cell = row.insertCell();
         }
      }
      disabledDate();
   }

   function prevCalendar() {
      today = new Date(today.getFullYear(), today.getMonth() - 1, today.getDate());
      buildCalendar();
      bookPointOn();
   }

   function nextCalendar() {
      today = new Date(today.getFullYear(), today.getMonth() + 1, today.getDate());
      buildCalendar();
      bookPointOn();
   }


   function insitezone(sitecode) {
      offPointSite();
      $("#bookForm>div>input[name='book_sitecode']").val(sitecode);
      clickedSiteCode = sitecode;
      onPointSite();
   }
   function isDisabledDate(testDate) {
      realToday = new Date();
      const compareDate = (date1, date2) => {
         let numDate1 = date1.getFullYear() * 10000 + date1.getMonth() * 100 + date1.getDate();
         let numDate2 = date2.getFullYear() * 10000 + date2.getMonth() * 100 + date2.getDate();

         if (numDate1 > numDate2) {
            return 1;
         }
         else if (numDate1 < numDate2) {
            return -1;
         }

         return 0;
      }

      if (compareDate(testDate, realToday) < 1) {
         return -1;
      }
      realToday = new Date(realToday.getFullYear(), realToday.getMonth(), realToday.getDate() + ABLEDAYS - 1)

      if (compareDate(testDate, realToday) > 0) {
         return 1;
      }

      return 0;
   }
   function disabledDate() {
      realToday = new Date();
      let startDay;
      let endDay;
      const compareYearAndMonth = (date1, date2) => {
         let numDate1 = date1.getFullYear() * 10000 + date1.getMonth() * 100;
         let numDate2 = date2.getFullYear() * 10000 + date2.getMonth() * 100;

         if (numDate1 > numDate2) {
            return 1;
         }

         else if (numDate1 < numDate2) {
            return -1;
         }

         return 0;
      }

      if (compareYearAndMonth(today, realToday) === 0) {
         startDay = 0;
         endDay = today.getDate();
      }

      else if (compareYearAndMonth(today, realToday) === -1) {
         startDay = 0;
         endDay = 32;
      }

      else {
         realToday = new Date(realToday.getFullYear(), realToday.getMonth(), realToday.getDate() + ABLEDAYS)
         if (compareYearAndMonth(today, realToday) === 0) {
            startDay = realToday.getDate();
            endDay = 32;
         } else if (compareYearAndMonth(today, realToday) === -1) {
            startDay = 32;
            endDay = 32;
         }
         else {
            startDay = 0;
            endDay = 32;
         }

      }
      for (var i = startDay; i <= endDay; i++) {
         $('#' + i + '').children().css("color", '#F0F0F0');
      }

   }
   function onPointSite() {
      $('#insitezone' + clickedSiteCode + '').css("background-color", 'rgb(247,233,231)');
   }
   function offPointSite() {
      $('#insitezone' + clickedSiteCode + '').css("background-color", 'white');
   }

</script>
<link rel="stylesheet" th:href="@{/css/book.css}">
<style>
   #calendar {
      width: 80%;
   }

   #calendar tr {
      height: 50px;
   }

   #bookForm li {
      float: left;
      /*width: 25%;*/
      text-align: center;
   }
</style>
<div class="back_re">
   <div class="container">
      <div class="row">
         <div class="col-md-12">
            <div class="title">
               <h2>예약하기</h2>
            </div>
         </div>
      </div>
   </div>
</div>
<div class="row">
   <div class="col-md-7">
      <table id="calendar" align="center">
         <tr>
            <td align="center"><label onclick="prevCalendar()"> ◀ </label></td>
            <td colspan="5" align="center" id="calendarTitle">yyyy년 m월</td>
            <td align="center"><label onclick="nextCalendar()"> ▶ </label></td>
         </tr>
         <br>
         <tr>
            <td align="center">
               <font color="#F79DC2">일
            </td>
            <td align="center">월</td>
            <td align="center">화</td>
            <td align="center">수</td>
            <td align="center">목</td>
            <td align="center">금</td>
            <td align="center">
               <font color="skyblue">토
            </td>
         </tr>
         <script type="text/javascript">buildCalendar();</script>
      </table>
   </div>
   <div class="col-md-5">
      <form id="bookForm" action="/book/bookdetail.html" method="post">
         <div>
            <input type="hidden" name="book_checkin" />
            <input type="hidden" name="book_checkout" />
            <input type="hidden" name="book_sitecode" />
            <br>
            <br>
         </div>
         <div id="booktest">
            <ul>
               <li id="zone1"></li>
               <li id="zone2"></li>
               <li id="zone3"></li>
               <li id="zone4"></li>
            </ul>
            <ul>
               <li id="site1"></li>
               <li id="site2"></li>
               <li id="site3"></li>
               <li id="site4"></li>
            </ul>
         </div>
         <div id="pay_btn_make"></div>
      </form>
   </div>
</div>