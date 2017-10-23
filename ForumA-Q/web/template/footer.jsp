<%-- 
    Document   : footer
    Created on : Oct 20, 2017, 1:10:04 PM
    Author     : NTD
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
 <!-- footer -->
        <div class="footer">
            <div class="container">
                <div class="">
                    <div class="col-md-4 w3_agile_footer_grid">
                        <h3>Latest Tweets</h3>
                        <ul class="agile_footer_grid_list">
                            <li><i class="fa fa-twitter" aria-hidden="true"></i>Nam libero tempore, cum soluta nobis est eligendi optio 
                                cumque nihil impedit. <span>1 day ago</span></li>
                            <li><i class="fa fa-twitter" aria-hidden="true"></i>Itaque earum rerum hic tenetur a sapiente delectus <a href="mailto:info@mail.com">info@mail.com</a>
                                cumque nihil impedit. <span>2 days ago</span></li>
                        </ul>
                    </div>
                    <div class="col-md-4 w3_agile_footer_grid">
                        <h3>Navigation</h3>
                        <ul class="agileits_w3layouts_footer_grid_list">
                            <li><i class="fa fa-angle-double-right" aria-hidden="true"></i><a href="index_admin.html">Home</a></li>
                            <li><i class="fa fa-angle-double-right" aria-hidden="true"></i><a href="about.html">About</a></li>
                            <li><i class="fa fa-angle-double-right" aria-hidden="true"></i><a href="portfolio.html">Portfolio</a></li>
                            <li><i class="fa fa-angle-double-right" aria-hidden="true"></i><a href="contact.html">Mail Us</a></li>
                        </ul>
                    </div>
                    <div class="col-md-4 w3_agile_footer_grid">
                        <h3>Instagram Posts</h3>
                        <div class="w3_agileits_footer_grid_left">
                            <a href="single.html">
                                <img src="images/f1.jpg" alt=" " class="img-responsive" />
                            </a>
                        </div>
                        <div class="w3_agileits_footer_grid_left">
                            <a href="single.html">
                                <img src="images/f2.jpg" alt=" " class="img-responsive" />
                            </a>
                        </div>
                        <div class="w3_agileits_footer_grid_left">
                            <a href="single.html">
                                <img src="images/f4.jpg" alt=" " class="img-responsive" />
                            </a>
                        </div>
                        <div class="w3_agileits_footer_grid_left">
                            <a href="single.html">
                                <img src="images/f3.jpg" alt=" " class="img-responsive" />
                            </a>
                        </div>
                        <div class="w3_agileits_footer_grid_left">
                            <a href="single.html">
                                <img src="images/f1.jpg" alt=" " class="img-responsive" />
                            </a>
                        </div>
                        <div class="w3_agileits_footer_grid_left">
                            <a href="single.html">
                                <img src="images/f2.jpg" alt=" " class="img-responsive" />
                            </a>
                        </div>
                        <div class="clearfix"> </div>
                    </div>
                    <div class="clearfix"> </div>
                </div>
                <div class="w3ls_address_mail_footer_grids">
                    <div class="col-md-4 w3ls_footer_grid_left">
                        <div class="wthree_footer_grid_left">
                            <i class="fa fa-map-marker" aria-hidden="true"></i>
                        </div>
                        <p>3481 Melrose Place, Beverly Hills, <span>New York City 90210.</span></p>
                    </div>
                    <div class="col-md-4 w3ls_footer_grid_left">
                        <div class="wthree_footer_grid_left">
                            <i class="fa fa-phone" aria-hidden="true"></i>
                        </div>
                        <p>+(000) 123 4565 32 <span>+(010) 123 4565 35</span></p>
                    </div>
                    <div class="col-md-4 w3ls_footer_grid_left">
                        <div class="wthree_footer_grid_left">
                            <i class="fa fa-envelope-o" aria-hidden="true"></i>
                        </div>
                        <p><a href="mailto:info@example.com">info@example1.com</a> 
                            <span><a href="mailto:info@example.com">info@example2.com</a></span></p>
                    </div>
                    <div class="clearfix"> </div>
                </div>
                <div class="agileinfo_copyright">
                    <p>© 2017 Treasurer. All Rights Reserved | Design by <a href="https://w3layouts.com/">W3layouts</a></p>
                </div>
            </div>
        </div>
        <!-- //footer -->
        <!-- menu -->
        <!-- js -->
        <script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>
        <script type="text/javascript" src="js/modernizr.custom.46884.js"></script>
        <!-- //js -->
        <!-- password-script -->
        <script type="text/javascript">
            window.onload = function () {
                document.getElementById("password1").onchange = validatePassword;
                document.getElementById("password2").onchange = validatePassword;
            }

            function validatePassword() {
                var pass2 = document.getElementById("password2").value;
                var pass1 = document.getElementById("password1").value;
                if (pass1 !== pass2)
                    document.getElementById("password2").setCustomValidity("Passwords Don't Match");
                else
                    document.getElementById("password2").setCustomValidity('');
                //empty string means no validation error
            }
        </script>
        <!-- //password-script -->

        <script src="js/bars.js"></script>
        <!-- pop-up-box -->    
        <link href="css/popuo-box.css" rel="stylesheet" type="text/css" property="" media="all" />
        <script src="js/jquery.magnific-popup.js" type="text/javascript"></script>
        <!--//pop-up-box -->
        <div id="small-dialog" class="mfp-hide">
            <iframe src="https://player.vimeo.com/video/67001156"></iframe>
        </div>
        <script>
            $(document).ready(function () {
                $('.popup-with-zoom-anim').magnificPopup({
                    type: 'inline',
                    fixedContentPos: false,
                    fixedBgPos: true,
                    overflowY: 'auto',
                    closeBtnInside: true,
                    preloader: false,
                    midClick: true,
                    removalDelay: 300,
                    mainClass: 'my-mfp-zoom-in'
                });

            });
        </script>

        <!-- for bootstrap working -->
        <script src="js/bootstrap.js"></script>
        <!-- //for bootstrap working -->
        <!-- start-smoth-scrolling -->
        <script type="text/javascript" src="js/move-top.js"></script>
        <script type="text/javascript" src="js/easing.js"></script>
        <script type="text/javascript">
            jQuery(document).ready(function ($) {
                $(".scroll").click(function (event) {
                    event.preventDefault();
                    $('html,body').animate({scrollTop: $(this.hash).offset().top}, 1000);
                });
            });
        </script>
        <!-- start-smoth-scrolling -->
        <!-- here stars scrolling icon -->
        <script type="text/javascript">
            $(document).ready(function () {
                /*
                 var defaults = {
                 containerID: 'toTop', // fading element id
                 containerHoverID: 'toTopHover', // fading element hover id
                 scrollSpeed: 1200,
                 easingType: 'linear' 
                 };
                 */

                $().UItoTop({easingType: 'easeOutQuart'});

            });
        </script>
        <!-- //here ends scrolling icon -->
    </body>
</html>