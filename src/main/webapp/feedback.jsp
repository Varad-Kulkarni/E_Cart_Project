<%@page import="java.util.*" %>
<%@page import="com.ecom.servlet.*"%>
<%@page import="com.ecome.connections.*"%>
<%@page import="com.ecome.model.*"%>
<%@page import="com.ecome.dao.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%
User auth = (User) request.getSession().getAttribute("auth");
if (auth != null) {
	request.setAttribute("auth", auth);
}

productDao pd=new productDao(DbCon.getConnectio());
List<product> prod=pd.getAllProduct();

ArrayList<Cart> cart_list=(ArrayList<Cart>) session.getAttribute("cart-list");
if(cart_list!=null){
	request.setAttribute("cart_list",cart_list);
}

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="css/feedback.css    ">
    <link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://unpkg.com/aos@2.3.1/dist/aos.css" rel="stylesheet">
<script src="https://unpkg.com/aos@2.3.1/dist/aos.js"></script>
<link href="https://fonts.googleapis.com/css2?family=Bebas+Neue&display=swap" rel="stylesheet">
<title>feedback</title>
</head>
<body>

<%@include file="includes/navbar.jsp"%>


 <div class="container beforeimg" >

    <div class="fluid-container">
      <div data-aos="fade-right"
      data-aos-offset="300"
      data-aos-easing="ease-in">
Give your valueble feedback
    </div>
</div>    </div>

  </div>
  

  <div id="grid" class="container " data-aos="fade-right"
  data-aos-offset="300"
  data-aos-easing="ease-in">
    <div  class="row">
      <div id="col1" class="col">
   <h3><center>Q&A</center></h3>
    
<div class="questions container">
    <ul>
        <li id="q1">how our service work?</li>
        <li id="a1" style="display: none;" >&#10146;Lorem ipsum dolor sit amet consectetur adipisicing elit. Libero, sed.</li>
        <li id="q2">How we provide best experience?</li>
        <li id="a2" style="display: none;">&#10146; Lorem ipsum dolor sit amet consectetur.</li>
        <li id="q3">Where you can find us?</li>
        <li id="a3" style="display: none;">&#10146; Lorem ipsum, dolor sit amet consectetur adipisicing elit. A!</li>
      

    </ul>
</div>
</div>






      <div id="col2" class="col">
     <h3><center> Feedback Form</center></h3>
     <form>
        <div class="form-group">
          <label for="exampleInputEmail1">Email address</label>
          <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email">
          <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
        </div>
        <div class="form-group">
            <label for="exampleFormControlTextarea1">Feedback</label>
            <textarea class="form-control" id="exampleFormControlTextarea1" rows="3"></textarea>
          </div>
          <button  onclick="clicked()" class="btn btn-primary">Submit</button>

      </div>
    </div>
</div>
 
  <footer class="font-weight-bold">
    <center>Contact Us</center>
    <center>
   <div class="row">
     <div class="col ml-3 col-"><a href="#"><img id="fb" src="http://www.newdesignfile.com/postpic/2009/12/download-facebook-logo-for-website_279444.jpg"></a></div>
     <div class="col"><a href="#"><img id="insta" src="https://workingwithdog.com/wp-content/uploads/2016/05/new_instagram_logo.jpg"></a></div>
     <div class="col"><a href="#"><img id="github" src="https://gh-prod-ruby-images.s3.amazonaws.com/uploads/growth_study_post/logo/10/github_logo.png"></a></div>
     <div class="col"><a href="#"><img id="linkedin" src="https://upload.wikimedia.org/wikipedia/commons/thumb/c/c9/Linkedin.svg/1200px-Linkedin.svg.png"></a></div>
     <div class="w-100"></div>
   </div>
 </center>
  
 
    <center>All rights reserved&#169;	</center>
</footer>
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script>
      AOS.init();
    </script>
    
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    <script src="../js/feedback.js"></script>
    
    <%@include file="includes/footer.jsp"%>

</body>
</html>