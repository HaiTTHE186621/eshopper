<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
        <link rel="stylesheet" href="css/style.css">
        <title>Bootstrap 4 Login/Register Form</title>
    </head>
    <body>
        <div id="logreg-forms">
            <form class="form-signin" action="login" method="post">
                <h1 class="h3 mb-3 font-weight-normal" style="text-align: center"> Sign in</h1>
                <div class="social-login">
                    <button class="btn facebook-btn social-btn" type="button"><span><i class="fab fa-facebook-f"></i> Sign in with Facebook</span> </button>
                    <button class="btn google-btn social-btn" type="button"><span><i class="fab fa-google-plus-g"></i> Sign in with Google+</span> </button>
                </div>
                <p style="text-align:center"> OR  </p>
                <div style="color: red">
                    ${error}
                    ${exist}
                    ${notmatch}
                </div>
                <div style="color: green">
                    ${success}
                </div>
                <input type="text" id="username" name="username" class="form-control" placeholder="Username" required="" autofocus="">
                <input type="password" id="inputPassword" name="password" class="form-control" placeholder="Password" required="">

                <input class="btn btn-success btn-block" type="submit" value="Sign in"> 
                <a href="#" id="forgot_pswd">Forgot password?</a>
                <hr>
                
                
               
                <button class="btn btn-primary btn-block" type="button" id="btn-signup"><i class="fas fa-user-plus"></i> Sign up New Account</button>
            </form>

            <form action="/reset/password/" class="form-reset">
                <input type="email" id="resetEmail" class="form-control" placeholder="Email address" required="" autofocus="">
                <button class="btn btn-primary btn-block" type="submit">Reset Password</button>
                <a href="#" id="cancel_reset"><i class="fas fa-angle-left"></i> Back</a>
            </form>

            <form action="signup" class="form-signup">
                <div class="social-login">
                    <button class="btn facebook-btn social-btn" type="button"><span><i class="fab fa-facebook-f"></i> Sign up with Facebook</span> </button>
                </div>
                <div class="social-login">
                    <button class="btn google-btn social-btn" type="button"><span><i class="fab fa-google-plus-g"></i> Sign up with Google+</span> </button>
                </div>

                <p style="text-align:center">OR</p>
                <input type="text" id="user-username" name="susername" class="form-control" placeholder="Username" required autofocus="">
                <input type="password" id="user-pass" name="spassword" class="form-control" placeholder="Password" required autofocus="">
                <input type="password" id="user-repeatpass" name="srepassword" class="form-control" placeholder="Repeat Password" required autofocus="">

                <input class="btn btn-primary btn-block" type="submit" value="Sign Up"> 
                <a href="#" id="cancel_signup"><i class="fas fa-angle-left"></i> Back</a>
            </form>
            <br>

        </div>
        <p style="text-align:center">
            <a href="http://bit.ly/2RjWFMfunction toggleResetPswd(e){
               e.preventDefault();
               $('#logreg-forms .form-signin').toggle() // display:block or none
               $('#logreg-forms .form-reset').toggle() // display:block or none
               }

               function toggleSignUp(e){
               e.preventDefault();
               $('#logreg-forms .form-signin').toggle(); // display:block or none
               $('#logreg-forms .form-signup').toggle(); // display:block or none
               }

               $(()=>{
               // Login Register Form
               $('#logreg-forms #forgot_pswd').click(toggleResetPswd);
               $('#logreg-forms #cancel_reset').click(toggleResetPswd);
               $('#logreg-forms #btn-signup').click(toggleSignUp);
               $('#logreg-forms #cancel_signup').click(toggleSignUp);
               })g" target="_blank" style="color:black"></a>
        </p>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <script src="js/script.js"></script>
    </body>
</html>
