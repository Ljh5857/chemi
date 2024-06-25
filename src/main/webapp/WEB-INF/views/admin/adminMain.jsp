<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<!doctype html>
<html class="fixed">
	<head>

		<!-- Basic -->
		<meta charset="UTF-8">

		<title>관리자메인</title>
		<meta name="keywords" content="HTML5 Admin Template" />
		<meta name="description" content="JSOFT Admin - Responsive HTML5 Template">
		<meta name="author" content="JSOFT.net">
       <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
		<jsp:include page="/resources/commonCssAdmin.jsp"/>

	</head>
	<body >
		<section class="body">

			<!-- start: header -->

			<jsp:include page="../common/adminHeader.jsp"/>
			<!-- end: header -->

			<div class="inner-wrapper">
				<!-- start: sidebar -->
				<jsp:include page="../common/adminSidebar.jsp"/>
				<!-- end: sidebar -->

				<section role="main" class="content-body" style="padding-top: 0px;">

					<h3><strong>캠팟 사이트 통계</strong></h3>

						<div class="row">

							<div class="col-md-3">
								<section class="panel panel-featured-left panel-featured-quartenary">
									<div class="panel-body">
										<div class="widget-summary">
											<div class="widget-summary-col widget-summary-col-icon">
												<div class="summary-icon bg-quartenary">
													<i class="fa fa-user"></i>
												</div>
											</div>
											<div class="widget-summary-col">
												<div class="summary">
													<h4 class="title">예약자 수</h4>
													<div class="info">
														<!-- <strong class="amount">${reservationStatistics.dayCount} 건</strong> -->
													</div>
												</div>
												<div class="summary-footer">
													<a class="text-muted text-uppercase">금일 총 예약자 수</a>
												</div>
											</div>
										</div>
									</div>
								</section>
							</div>

							<div class="col-md-3">
								<section class="panel panel-featured-left panel-featured-primary">
									<div class="panel-body">
										<div class="widget-summary">
											<div class="widget-summary-col widget-summary-col-icon">
												<div class="summary-icon bg-primary">
													<i class="fa fa-life-ring"></i>
												</div>
											</div>
											<div class="widget-summary-col">
												<div class="summary">
													<h4 class="title">처리되지 않은 신고 수</h4>
													<div class="info">
														<strong class="amount report-count"></strong>
														<span class="text-primary"></span>
													</div>
												</div>
												<div class="summary-footer">
													<a class="text-muted text-uppercase" href="/servicecenter/listReport">신고 내역 바로가기</a>
												</div>
											</div>
										</div>
									</div>
								</section>
							</div>
							<div class="col-md-3">
								<section class="panel panel-featured-left panel-featured-secondary">
									<div class="panel-body">
										<div class="widget-summary">
											<div class="widget-summary-col widget-summary-col-icon">
												<div class="summary-icon bg-secondary">
													<i class="fa fa-usd"></i>
												</div>
											</div>
											<div class="widget-summary-col">
												<div class="summary">
													<h4 class="title">미답변 Q&A 수</h4>
													<div class="info">
														<strong class="amount qna-count"></strong>
													</div>
												</div>
												<div class="summary-footer">
													<a class="text-muted text-uppercase" href="/servicecenter/listQna" >Q&A 바로 가기</a>
												</div>
											</div>
										</div>
									</div>
								</section>
							</div>


							<div class="col-md-3">
								<section class="panel panel-featured-left panel-featured-secondary">
									<div class="panel-body">
										<div class="widget-summary">
											<div class="widget-summary-col widget-summary-col-icon">
												<div class="summary-icon bg-secondary">
													<i class="fa fa-usd"></i>
												</div>
											</div>
											<div class="widget-summary-col">
												<div class="summary">
													<h4 class="title">사이트수익</h4>
													<div class="info">
														<!-- <strong class="amount">${siteProfitStatistics.profitAllPayment} ₩</strong> -->
													</div>
												</div>
												<div class="summary-footer">
													<!-- <a class="text-muted text-uppercase">${siteProfitStatistics.profitRegDate}</a> -->
												</div>
											</div>
										</div>
									</div>
								</section>
							</div>

						</div>



						<div class="row">
							<div class="col-md-6">
								<h3><strong>전년 대비 예약자 수</strong></h3>
								<!--차트가 그려질 부분-->
								<canvas id="reservation_chart"></canvas>
								<div style="text-align: center; padding: 10px;">
									<span>일/주/월/년 예약자수 비교</span>
								</div>
								<!-- <input type="hidden" id="reservation_statistics_data"
										day="${reservationStatistics.dayCount}"
										week="${reservationStatistics.weekCount}"
										month="${reservationStatistics.monthCount}"
										year="${reservationStatistics.yearCount}"
										beforeday="${reservationStatistics.beforeYearDayCount}"
										beforeweek="${reservationStatistics.beforeYearWeekCount}"
										beforemonth= "${reservationStatistics.beforeYearMonthCount}"
										beforeyear="${reservationStatistics.beforeYearYearCount}"> -->

							</div>

							<div class="col-md-6">
								<h3><strong>사이트 거래액</strong></h3>
								<!--차트가 그려질 부분-->
								<canvas id="siteProfit_chart"></canvas>
								<div style="text-align: center; padding: 10px;">
									<!-- <span>${siteProfitStatistics.profitRegDate}</span> -->
								</div>
							</div>
						</div>

					</section>
				</div>

		</section>



	</body>
</html>