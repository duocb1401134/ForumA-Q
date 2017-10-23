<%-- 
    Document   : main
    Created on : Oct 19, 2017, 9:00:25 PM
    Author     : feng
--%>
<a href="template_admin/header.jsp"></a>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"  %>
<%@include file="//template_admin/header.jsp" %>
<%@include file="//template_admin/sidebar.jsp" %>
<section id="main-content">
    <section class="wrapper">
        <div class="form-w3layouts">
            <!-- page start-->
            <!-- page start-->
            <div class="row">
                <div class="row">
                    <div class="col-lg-12">
                        <section class="panel">
                            <header class="panel-heading">
                                Form Elements
                            </header>
                            <div class="panel-body">
                                <form class="form-horizontal bucket-form" method="get">
                                    <div class="form-group">
                                        <label class="col-sm-3 control-label">Question Name</label>
                                        <div class="col-sm-6">
                                            <input name="" type="text" class="form-control">
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="col-sm-3 control-label col-lg-3" for="inputSuccess">Selection Subject</label>
                                        <div class="col-lg-6">                                           

                                            <select class="form-control input-lg m-bot15">
                                                <option>Option 1</option>
                                                <option>Option 2</option>
                                                <option>Option 3</option>
                                            </select>

                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="col-sm-3 control-label">Question Description</label>
                                        <div class="col-sm-6">
                                            <textarea name="" type="text" class="form-control"></textarea>

                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="col-sm-3 control-label">Question Content</label>
                                        <div class="col-sm-6">
                                            <textarea id="editor1" name="" type="text" class="form-control"></textarea>
                                            <script>

                                                var editor = CKEDITOR.replace('editor1');
                                                CKFinder.setupCKEditor(editor, '<%=request.getContextPath()%>/ckfinder/');

                                            </script>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <div class="col-lg-offset-3 col-lg-6">
                                            <button class="btn btn-primary" type="submit">Make Question</button>
                                            <button class="btn btn-success" type="submit">Refresh</button>
                                            <button class="btn btn-danger" type="submit">Cancel</button>
                                        </div>
                                    </div>


                                </form>                                
                            </div>
                        </section>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <%@include file="//template_admin/footer.jsp" %>