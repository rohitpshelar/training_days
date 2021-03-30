// JavaScript Document
//Scrolltop page
$(document).ready(function(){
     $(window).scroll(function () {
            if ($(this).scrollTop() > 50) {
                $('#scrollBtn').fadeIn();
            } else {
                $('#scrollBtn').fadeOut();
            }
        });
        // scroll body to 0px on click
        $('#scrollBtn').click(function () {
            $('body,html').animate({
                scrollTop: 0
            }, 800);
            return false;
        });
});


//Navigation hide and show
$(document).on('click','.navbar-collapse.in',function(e) {
    if( $(e.target).is('a') && $(e.target).attr('class') !== 'dropdown-toggle' ) {
        $(this).collapse('hide');
    }
}); 

//Loading the Html Pages.
function load(fileName){
	$("#content").load(fileName);
	$('html,body').animate({scrollTop:0},600);
}

function showhide(showID){
	$(".panel-success").hide();
	$(".mainContent").hide();
	$("#"+showID).hide();
	$(".panel-content").hide();
	$("#"+showID).show();
}

// Social Icon hide.
$(document).ready(function(){
    $("#shareIt").click(function(){
	$("#socialIconHide").toggle();
});
});

//Contact Form

$(document).ready(function(){
     $(window).scroll(function () {
            if ($(this).scrollTop() > 50) {
              //  $('#contact').fadeIn();
            } else {
              //  $('#contact').fadeOut();
            }
        });
});
 
$(document).ready(function() {
    $("#contact").click(function(){
		$(this).find('img').toggle();
	$("#contactForm").toggle( "slide" );
	});
	$("#contactClose").click(function(){
		$("#contact").find('img').toggle();
	$("#contactForm").toggle( "slide" );
	});
});

// validation for username and password.
function validate(){
var username = document.getElementById("username").value;
var password = document.getElementById("password").value;

if(username === "" && password === ""){
	alert ("Username and Password is required");
	return;
}
if(username === ""){
	alert ("Username is required");
	return;
}
if(password === ""){
	alert ("Password is required");
	return;
}

var isValidEmail = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/; 
if((document.getElementById("username").value.match (isValidEmail)) || username === "ashwini.designer")
{
	var isValidPassword = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,20}$/;
	if(document.getElementById("password").value.match (isValidPassword)) 
	{
		alert ("Login Sucessfully.");
		window.location = "http://10.0.0.2:8080/cellmaWEB";
		return true;
	}
	else{
		alert ("Your username/password combination has not been recognised. Please try again");
		return false;
	}
 }
 else{
	 alert ("Username is not correct. Please try again");
	 return false;
 }
}

$('.carousel[data-type="multi"] .item').each(function(){
  var next = $(this).next();
  if (!next.length) {
    next = $(this).siblings(':first');
  }
  next.children(':first-child').clone().appendTo($(this));
  
  for (var i=0;i<2;i++) {
    next=next.next();
    if (!next.length) {
    	next = $(this).siblings(':first');
  	}
    
    next.children(':first-child').clone().appendTo($(this));
  }
});

$(document).ready(function(){
    $("#myBtn").click(function(){
        $("#myModal").modal();
		document.location.href="continue_to_checkout.html";
    });
});

 function valchk() 
 {
    var x = document.getElementById("pincode").value;
	if(x==='')
	{
	 var z = document.getElementById("error");
      	 document.getElementById("error").style.display = "block";
		 		   var b = document.getElementById("alertmsg");
               document.getElementById("alertmsg").style.display = "none";

	}
	 else
	   {
		   var a = document.getElementById("error");
               document.getElementById("error").style.display = "none";
		   var y = document.getElementById("alertmsg");
               document.getElementById("alertmsg").style.display = "block";
			
   
	   }
}

function myFunction() {
    var k=document.getElementById("sel1").value;
	if(k==='>10')
	 {
		 var t = document.getElementById("other");
             t.style.display = "block";
     }
}

function myDeleteFunction(removeTable) {
	confirm("Are you sure you would like to remove this item from your shopping cart?");
    $("#"+removeTable).remove();
}



function CalculateItemsValue(value) {
	var total_items = value;
	var total = 0;
	var Shipping_charges = 0;
	var Net_Amount_Payable = 0;
	for (i=1; i<=total_items; i++) {
		
		itemID = document.getElementById("qnt_"+i);
		if (typeof itemID === 'undefined' || itemID === null) {
			alert("No such item - " + "qnt_"+i);
		} else {
			total = total + parseInt(itemID.getAttribute("data-price"));
			Shipping_charges = 0.25*total;
			Net_Amount_Payable = total + Shipping_charges;
		}
		
	}
	document.getElementById("ItemsTotal").innerHTML = "$" + total;
	document.getElementById("Shippingcharges").innerHTML = "$" + Shipping_charges;
	document.getElementById("NetAmountPayable").innerHTML = "$" + Net_Amount_Payable;
}



    
  function requestTestt(url){
  	document.redirectForm.submit();
  }
  
$(document).ready(function(){
$('input.check').on('change', function() {
    $('input.check').not(this).prop('checked', false); 
                $('#loc').hide();
                $('#sp').hide();
     $('.check:checked').each(function(){
            $('#'+$(this).attr('data-ptag')).show();
        });
});
});


//hide and show password
$(document).ready(function(){
$(".toggle-password").click(function() {

  $(this).toggleClass("fa-eye fa-eye-slash");
  var input = $($(this).attr("toggle"));
  if (input.attr("type") == "password") {
    input.attr("type", "text");
  } else {
    input.attr("type", "password");
  }
});
});


$(document).ready(function(){
    $('[data-toggle="tooltip"]').tooltip();   
});

    
    
    
    
    