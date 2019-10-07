jQuery(document).ready(function($){	

	"use strict";

	// Contact Form Validation 
	if($('#contact').length){
	
		$("#contact").validate();
		
	}


	//BxSlider
	if($('.bxslider').length){
	
		$('.bxslider').bxSlider({

			mode : 'fade',

			auto:true

		});
		
	}


	//ToolTip
	if($("[data-toggle='tooltip']").length){
	
		$("[data-toggle='tooltip']").tooltip();
		
	}
	

	//Carousel
	if($('#carousel').length){
	
		$('#carousel').flexslider({

			animation: "slide",

			controlNav: false,

			animationLoop: false,

			slideshow: false,

			itemWidth: 131,

			itemMargin: 0,

			asNavFor: '#slider'

		});
		
	}



    //FlexSlider
	if($('#slider').length){
	
		$('#slider').flexslider({

			animation: "fade",

			controlNav: false,

			animationLoop: false,

			slideshow: true,

			sync: "#carousel",

			start: function(slider){

			  $('body').removeClass('loading');

			}

		});
		
	}
	

	//Accordion for Whats New page

	if($('.accordion-inner').length){

		if (!$.browser.webkit) {

		  $('.accordion-inner').jScrollPane();

		}

	}
	
	if($('#myTab').length){

		$('#myTab a').click(function (e) {

			e.preventDefault();

			$(this).tab('show');

		});

	}

});



	