<%-- 
    Document   : index
    Created on : Oct 20, 2017, 1:12:52 PM
    Author     : NTD
--%>



<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="vn.edu.ctu.forum.models.service.QuestionServiceImpl"%>
<%@page import="vn.edu.ctu.forum.models.service.QuestionService"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="vn.edu.ctu.forum.models.pojos.Question"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="//template/header.jsp" %>
<%@include file="//template/modall.jsp" %>
<%    int limit = 4;
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    List<Question> listQuestion;
    QuestionService questionService = new QuestionServiceImpl(null);

    String queryStringCurrentPage = request.getParameter("page");
    int total = questionService.totalQuestion();

    int totalPage = total / limit;
    if (total % limit > 0) {
        totalPage += 1;
    }
    int currentpage;
    if (queryStringCurrentPage == null) {
        currentpage = 1;
        listQuestion = questionService.find(limit, currentpage - 1);
    } else {
        int intqueryStringCurrentPage = Integer.parseInt(queryStringCurrentPage);
        currentpage = intqueryStringCurrentPage;
        listQuestion = questionService.find(limit, (currentpage - 1) * limit);

    }
%>
<div class="agile_inner_banner_info">
    <h2>AA</h2>
    <p>Add Some Short Description</p>
</div>
<div class="services">
    <div class="container">
        <div class="col-md-8 event-left w3-agile-event-left">

            <% if (listQuestion.size() > 0)
                    for (int i = 0; i < listQuestion.size(); i++) {%>
            <div class="event-left1">
                <div class="col-xs-6 event-left1-left">
                    <a href="detailQuestion?questionId=<%=listQuestion.get(i).getQuestionId()%>">
                        <img src="<%=listQuestion.get(i).getSubject().getImage().getImageSrc()%>" alt="<%=listQuestion.get(i).getSubject().getImage().getImageAlt()%>" class="img-responsive" /></a>
                    <div class="event-left1-left-pos">
                        <ul>                           
                            <li><a href="#"><span class="fa fa-user" aria-hidden="true"></span><%=listQuestion.get(i).getMember().getMemberName()%></a></li>
                        </ul>
                    </div>
                </div>
                <div class="col-xs-6 event-left1-right">
                    <h4><%=dateFormat.format(listQuestion.get(i).getQuestionDate())%></h4>
                    <h5><a href="detailQuestion?questionId=<%=listQuestion.get(i).getQuestionId()%>"><%=listQuestion.get(i).getQuestionName()%></a></h5>
                    <p><%=listQuestion.get(i).getQuestionDecription()%></p>
                </div>
                <div class="clearfix"> </div>
            </div>
            <%}%>           
            <nav class="paging1">
                <ul class="pagination paging">
                    <li>
                        <a href="#" aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                        </a>
                    </li>
                    <% for (int i = 1; i <= totalPage; i++) {%>
                    <li><a href="index.jsp?page=<%=i%>"><%=i%></a></li>                    
                        <%}%>
                    <li>
                        <a href="#" aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                        </a>
                    </li>
                </ul>
            </nav>
        </div>
        <div class="col-md-4 event-right wthree-event-right">
            <div class="">                      
                <div class="tags tags1">
                    <h3>Recent Tags</h3>
                    <ul>
                        <li><a href="single.html">Designs</a></li>
                        <li><a href="single.html">Growth</a></li>
                        <li><a href="single.html">Latest</a></li>
                        <li><a href="single.html">Price</a></li>
                        <li><a href="single.html">Tools</a></li>
                        <li><a href="single.html">Agile</a></li>
                        <li><a href="single.html">Category</a></li>
                        <li><a href="single.html">Themes</a></li>
                        <li><a href="single.html">Growth</a></li>
                        <li><a href="single.html">Agile</a></li>
                        <li><a href="single.html">Price</a></li>
                        <li><a href="single.html">Tools</a></li>
                        <li><a href="single.html">Business</a></li>
                        <li><a href="single.html">Category</a></li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="clearfix"> </div>
    </div>
</div>
<%@include file="//template/footer.jsp" %>