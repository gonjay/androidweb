$(document).ready(function(){
  $("#hide").click(function(){
  $("p").hide();
  });
  $("#show").click(function(){
  $("p").show();
  });
});



$(document).ready(function(){
  $("a").click(function(event){
    alert("start english!");
  });
});



$(document).ready(function(){
  $("a").click(function(event){
    alert("as you can see");
    event.preventdefault();
  });
});


$(document).ready(function(){
  $(".flip").click(function(){
    $(".panel").slidedown("slow");
  });
});


$(document).ready(function(){
   $("button").click(function(){
  $("div").fadeTo("slow",0.25)
  });
});






















