<!Doctype html>
<html>
<head>
	 <link rel="icon" href="images/pinfavicon.ico" />
	 <link rel="stylesheet" href="stylesheet.css"/>
	  <script src="js/jquery-1.12.1.min.js"></script>
    <title>Pin Me</title>
</head>
<body class="padding">
<header>
<div class="icon">
<img src="images/icon.png" alt="pin image">
</div>
<h1 class="header">Pin Me!</h1>
<a href="signup.html">
<div class="buttons">
<button class="button">Sign Up</button></a>
</div>
</header>
<section class="divider">
</section>
<section class="login">

<form action="LoginServlet" method="Post" onsubmit="return validateForm()" >
<div>
<label>User Name<sup>*</sup>:<input type="text" name="userName" id="userName" placeholder="John" required></label>
</div><div>
<label>Password<sup>*</sup>:<input type="password" name="Password" id="Password" placeholder="XXXX" required></label>
</div><div>
<button type="submit" class="button">Login</button>
</div>
</form>
<section>
<ul>
<li>h1</li>
<li>h2</li>
</ul>
</section>
</section>
<footer>
@CopyRights:Pin Me <br>
 developed by Prathyusha Rani,Prathyusha,Shiva & Divya
</footer>
<script type="text/javascript" src="js/app.js"></script>
</body>
</html>