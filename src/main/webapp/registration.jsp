<%@ page contentType="text/html;charset=UTF-8" language="java" %>
=<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->
<body>
<div id="login">
    <h3 class="text-center text-black pt-5">Login to your account</h3>
    <div class="container">
        <div id="login-row" class="row justify-content-center align-items-center">
            <div id="login-column" class="col-md-6">
                <div id="login-box" class="col-md-12">
                    <form id="login-form" class="form" action="/registrationServlet" method="post">
                        <h3 class="text-center text-info">Please enter your data</h3>
                        <div class="form-group">
                            <label for="firstname" class="text-info">First name:</label><br>
                            <input type="text" name="firstname" id="firstname" class="form-control">
                        </div>
                        <div class="form-group">
                            <label for="lastname" class="text-info">Last name:</label><br>
                            <input type="text" name="lastname" id="lastname" class="form-control">
                        </div>
                        <div class="form-group">
                            <label for="email" class="text-info">Email:</label><br>
                            <input type="text" name="email" id="email" class="form-control">
                        </div>
                        <div class="form-group">
                            <label for="password" class="text-info">Password:</label><br>
                            <input type="password" name="password" id="password" class="form-control">
                        </div>
                        <div class="form-group">
                            <input type="submit" name="register" class="btn btn-info btn-md" value="Register me">
                        </div>
                        <div id="register-link" class="text-right">
                            <a href="index.jsp" class="text-info">Go back</a>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>

