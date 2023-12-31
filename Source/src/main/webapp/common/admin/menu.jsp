<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div id="sidebar" class="sidebar                  responsive                    ace-save-state">
    <script type="text/javascript">
        try {
            ace.settings.loadState('sidebar')
        } catch (e) {
        }
    </script>
    <div class="sidebar-shortcuts">
        <div class="sidebar-shortcuts-large">
            <button class="btn btn-success">
                <i class="ace-icon fa fa-signal"></i>
            </button>

            <button class="btn btn-info">
                <i class="ace-icon fa fa-pencil"></i>
            </button>

            <button class="btn btn-warning">
                <i class="ace-icon fa fa-users"></i>
            </button>

            <button class="btn btn-danger">
                <i class="ace-icon fa fa-cogs"></i>
            </button>
        </div>
        <div class="sidebar-shortcuts-mini">
            <span class="btn btn-success"></span>

            <span class="btn btn-info"></span>

            <span class="btn btn-warning"></span>

            <span class="btn btn-danger"></span>
        </div>
    </div>
    <ul class="nav nav-list">
        <li class="">
            <a href="#" class="dropdown-toggle">
                <i class="menu-icon fa fa-book"></i>
                <span class="menu-text">Quản lý tiểu thuyết</span>
                <b class="arrow fa fa-angle-down"></b>
            </a>
            <b class="arrow"></b>
            <ul class="submenu">
                <li class="">
                    <a href='<c:url value="/admin/post/list"/>'>
                        <i class="menu-icon fa fa-caret-right"></i>
                        Danh sách tiểu thuyết
                    </a>
                    <b class="arrow"></b>
                </li>
            </ul>
        </li>
        <li class="">
            <a href="#" class="dropdown-toggle">
                <i class="menu-icon fa fa-bookmark"></i>
                <span class="menu-text">Quản lý chương</span>
                <b class="arrow fa fa-angle-down"></b>
            </a>
            <b class="arrow"></b>
            <ul class="submenu">
                <li class="">
                    <a href='<c:url value="/admin/chapter/list"/>'>
                        <i class="menu-icon fa fa-caret-right"></i>
                        Danh sách chương
                    </a>
                    <b class="arrow"></b>
                </li>
            </ul>
        </li>
        <li class="">
            <a href="#" class="dropdown-toggle">
                <i class="menu-icon fa fa-user"></i>
                <span class="menu-text">Quản lý tác giả</span>
                <b class="arrow fa fa-angle-down"></b>
            </a>
            <b class="arrow"></b>
            <ul class="submenu">
                <li class="">
                    <a href='<c:url value="/admin/author/list"/>'>
                        <i class="menu-icon fa fa-caret-right"></i>
                        Danh sách tác giả
                    </a>
                    <b class="arrow"></b>
                </li>
            </ul>
        </li>
        <c:if test="${SecurityUtils.isAdmin()}">
            <li class="">
                <a href="#" class="dropdown-toggle">
                    <i class="menu-icon fa fa-bars"></i>
                    <span class="menu-text">Quản lý thể loại</span>
                    <b class="arrow fa fa-angle-down"></b>
                </a>
                <b class="arrow"></b>
                <ul class="submenu">
                    <li class="">
                        <a href='<c:url value="/admin/tag/list"/>'>
                            <i class="menu-icon fa fa-caret-right"></i>
                            Danh sách thể loại
                        </a>
                        <b class="arrow"></b>
                    </li>
                </ul>
            </li>
            <li class="">
                <a href="#" class="dropdown-toggle">
                    <i class="menu-icon fa fa-users"></i>
                    <span class="menu-text">Quản lý nhóm dịch</span>
                    <b class="arrow fa fa-angle-down"></b>
                </a>
                <b class="arrow"></b>
                <ul class="submenu">
                    <li class="">
                        <a href='<c:url value="/admin/category/list"/>'>
                            <i class="menu-icon fa fa-caret-right"></i>
                            Danh sách nhóm dịch
                        </a>
                        <b class="arrow"></b>
                    </li>
                </ul>
            </li>
            <li>
                <a href="#" class="dropdown-toggle">
                    <i class="menu-icon fa fa-building"></i>
                    <span class="menu-text">Quản lý giao diện</span>
                    <b class="arrow fa fa-angle-down"></b>
                </a>
                <b class="arrow"></b>
                <ul class="submenu">
                    <li class="">
                        <a href='<c:url value='/admin/menu-page/list'/>'>
                            <i class="menu-icon fa fa-caret-right"></i>
                            Menu
                        </a>
                        <b class="arrow"></b>
                    </li>
                    <li class="">
                        <a href="<c:url value="/admin/configuration/theme/default/home-page"/>">
                            <i class="menu-icon fa fa-home"></i>
                            <span class="menu-text">Page trang chủ </span>
                        </a>
                        <b class="arrow"></b>
                    </li>
                </ul>
            </li>
            <li class="">
                <a href="#" class="dropdown-toggle">
                    <i class="menu-icon fa fas fa-cog"></i>
                    <span class="menu-text">Quản lý tài khoản</span>
                    <b class="arrow fa fa-angle-down"></b>
                </a>
                <b class="arrow"></b>
                <ul class="submenu">
                    <li class="">
                        <a href='<c:url value='/admin/user/list'/>'>
                            <i class="menu-icon fa fa-caret-right"></i>
                            List
                        </a>
                        <b class="arrow"></b>
                    </li>
                </ul>
            </li>
        </c:if>
    </ul>
    <div class="sidebar-toggle sidebar-collapse" id="sidebar-collapse">
        <i class="ace-icon fa fa-angle-double-left" data-icon1="ace-icon fa fa-angle-double-left"
           data-icon2="ace-icon fa fa-angle-double-right"></i>
    </div>

    <script type="text/javascript">
        try {
            ace.settings.check('sidebar', 'collapsed')
        } catch (e) {
        }
    </script>
</div>
