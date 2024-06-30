<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>




    <!-- admin Sidebar -->
    <aside id="sidebar-left" class="sidebar-left">

        <!-- 상단 Start -->
        <div class="sidebar-header">
            <div class="sidebar-title">
                <div class="logo" style="margin-left: 35px;">

                </div>
            </div>
            <div class="sidebar-toggle hidden-xs" data-toggle-class="sidebar-left-collapsed" data-target="html"
                data-fire-event="sidebar-left-toggle">
                <i class="fa fa-bars" aria-label="Toggle sidebar"></i>
            </div>
        </div>
        <!-- 상단 End -->

        <!-- 사이드 Start -->
        <div class="nano">
            <div class="nano-content">
                <nav id="menu" class="nav-main" role="navigation">
                    <ul class="nav nav-main">
                        <li class="nav-active">
                            <a href="/owner/main">
                                <i class="fa fa-home" aria-hidden="true"></i>
                                <span>메인화면</span>
                            </a>
                        </li>
                        <li class="nav-parent">
                            <a>
                                <i class="fa fa-tree"></i>
                                <span>캠핑장관리</span>
                            </a>
                            <ul class="nav nav-children">

                                <li>
                                    <a href="/campBusiness/campCalender">캠핑장 정보</a>
                                </li>

                                <li>
                                    <a href="/campBusiness/campCalender">캠핑장-일정 관리</a>
                                </li>

                                <li>
                                    <a href="/campBusiness/listCamp">캠핑존 목록</a>
                                </li>

                                <li>
                                    <a href="/campBusiness/listMainSite">캠핑장-주요시설 목록</a>
                                </li>

                                <li>
                                    <a href="/owner/camp/insert">캠핑장 등록하기</a>
                                </li>

                                <li>
                                    <a href="/owner/zone/insert">캠핑존 등록하기</a>
                                </li>
                            </ul>
                        </li>
                        <li class="nav-parent">
                            <a>
                                <i class="fa fa-align-left" aria-hidden="true"></i>
                                <span>공지사항 바로가기</span>
                            </a>
                            <ul class="nav nav-children">
                                <li>
                                    <a href="/owner/notice/list">공지사항 목록</a>
                                </li>
                                <li>
                                    <a href="/owner/notice/insert">공지사항 등록</a>
                                </li>
                            </ul>
                        </li>
                        <li class="nav-parent">
                            <a>
                                <i class="fa fa-tree"></i>
                                <span>내 예약보기</span>
                            </a>
                            <ul class="nav nav-children">
                                <li>
                                    <a href="/campBusiness/listCamp">예약 확인하기</a>
                                </li>
                                <li>
                                    <a href="/campBusiness/listMainSite">내 수익 보기</a>
                                </li>

                            </ul>
                        </li>

                    </ul>
                </nav>
                <!-- 하단 정보 -->
                <div class="sidebar-widget widget-stats">
                    <div class="widget-content">
                        <div><a href="https://goai.co.kr/">© 2022 AiA AIACADEMY</a></div>
                        <div>Team : 잘하고있어</div>
                        <div>주소: 서울특별시 종로구 종로 69 YMCA 7층</div>
                        <div>전화: 080 - 861 - 0909</div>
                    </div>
                </div>
            </div>
        </div>

        <!-- 사이드 End -->

    </aside>

    <script>
    document.addEventListener('DOMContentLoaded', (event) => {
        const navParents = document.querySelectorAll('.nav-parent > a');

        navParents.forEach(parent => {
            parent.addEventListener('click', function() {
                const navChildren = this.nextElementSibling;

                if (navChildren.style.display === "block") {
                    navChildren.style.display = "none";
                } else {
                    navChildren.style.display = "block";
                }
            });
        });
    });

    </script>