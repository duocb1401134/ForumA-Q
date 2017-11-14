<%-- 
    Document   : banner_authentication
    Created on : Oct 20, 2017, 1:17:29 PM
    Author     : NTD
--%>

<%@page import="vn.edu.ctu.forum.models.pojos.Member"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- banner authentication -->
<div class="agileits_w3layouts_banner_nav">
    <nav class="navbar navbar-default">
        <div class="navbar-header navbar-left">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <h1><a class="navbar-brand" href="view"><i class="fa fa-crosshairs" aria-hidden="true"></i> Forum A&Q</a></h1>

        </div>
        <ul class="agile_forms">                    
            <li><a class="active" href="logout"><span class="fa fa-sign-out"></span> Logout</a> </li>
        </ul>
        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse navbar-right" id="bs-example-navbar-collapse-1">
            <nav>
                <ul class="nav navbar-nav">
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle hvr-underline-from-center" data-toggle="dropdown"><b class="fa fa-caret-down"></b></a>
                        <ul class="dropdown-menu agile_short_dropdown">                           
                            <li><a href="profileMember.jsp">Profile</a></li>
                        </ul>
                    </li>                            
                </ul>
            </nav>
        </div>
    </nav>
    <div class="clearfix"> </div> 
</div>
<!-- //banner authentication -->