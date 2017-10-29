<%-- 
    Document   : my_questions
    Created on : Oct 29, 2017, 2:02:05 PM
    Author     : Feng
--%>

<%@page import="java.util.List"%>
<%@page import="vn.edu.ctu.forum.models.service.QuestionServiceImpl"%>
<%@page import="vn.edu.ctu.forum.controller.AcceptQuestion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="//template_admin/header.jsp" %>
<%@include file="//template_admin/sidebar.jsp" %>
<section id="main-content">
    <section class="wrapper">
        <div class="table-agile-info">
            <div class="panel panel-default">
                <div class="panel-heading">
                    Accept Question
                </div>
                <div>
                    <%                        QuestionServiceImpl qssv = new QuestionServiceImpl(null);
                    Integer memberid = ((Member) session.getAttribute("member")).getMemberId();
                        List<Question> list1 = qssv.findByIdMember(memberid);
                    %>
                    <table class="table">
                        <thead>
                            <tr>
                                
                                <th>Question Name</th>
                                <th>Discription</th>

                                <th>Date Register</th>
                                <th>Edit</th>
                            </tr>
                        </thead>
                        <tbody>
                            <% for (int i = 0; i < list1.size(); i++) {%>
                            <tr data-expanded="true">
                                <td><%=list1.get(i).getQuestionName()%></td>
                                <td><%= list1.get(i).getQuestionDecription()%></td>                      
                                <td><%= list1.get(i).getQuestionDate()%></td>

                                <td>
                                    <a href="delAcceptQuestion?id=<%=list1.get(i).getQuestionId()%>" class="active" ui-toggle-class=""> 
                                        <i class="fa fa-pencil-square-o"></i></a>
                                </td>
                            </tr>
                            <%}%>
                        </tbody>
                    </table>
                    <div class="row">
                        <div class="col-lg-12">
                            <section class="panel">                                        
                                <div class="panel-body">
                                    <div class="position-center ">
                                        <div class="text-center">
                                            <a href="new_question.jsp"  class="btn btn-success">
                                                New Question
                                            </a>
                                            <a href="my_questions.jsp"  class="btn btn-warning">
                                                Refresh
                                            </a>
                                            <a href="#myModal-2" data-toggle="modal" class="btn btn-danger">
                                                Form in Modal 3
                                            </a>
                                        </div>




                                    </div>
                                </div>
                            </section>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
</section>


<%@include file="//template_admin/footer.jsp" %>