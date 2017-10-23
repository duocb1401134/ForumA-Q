<%-- 
    Document   : acceptmember
    Created on : Oct 21, 2017, 1:37:39 PM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="//template_admin/header.jsp" %>
<%@include file="//template_admin/sidebar.jsp" %>
<section id="main-content">
    <section class="wrapper">
        <div class="table-agile-info">
            <div class="panel panel-default">
                <div class="panel-heading">
                    Accept Member
                </div>
                <div>
                    <table class="table">
                        <thead>
                            <tr>
                                <th data-breakpoints="xs">ID</th>
                                <th>Name</th>
                                <th>Email</th>
                                <th>Sex</th>
                                <th>Password</th>
                                <th>BirthDay</th>
                                <th>Admin</th>
                                <th>Date Register</th>
                                <th data-breakpoints="xs">Intruduce/th>

                                <th data-breakpoints="xs sm md" data-title="DOB">Accepted</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr data-expanded="true">
                                <td>1</td>
                                <td>Dennise</td>
                                <td>Fuhrman</td>
                                <td>High School History Teacher</td>

                                <td>July 25th 1960</td>
                            </tr>
                          
                        </tbody>
                    </table>
                    <div class="row">
                        <div class="col-lg-12">
                            <section class="panel">                                        
                                <div class="panel-body">
                                    <div class="position-center ">
                                        <div class="text-center">
                                            <a href="#myModal" data-toggle="modal" class="btn btn-success">
                                                Form in Modal
                                            </a>
                                            <a href="#myModal-1" data-toggle="modal" class="btn btn-warning">
                                                Form in Modal 2
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
