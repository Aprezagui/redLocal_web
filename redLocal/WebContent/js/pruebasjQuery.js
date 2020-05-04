"use strict";

$("document").ready(function() {
	
	var boton = $("#alternar");
	
	boton.on("click", function() {
		
		var descripciones = $(".desc");
		
		descripciones.toggle(500);
		
		if (boton.text() === "Ocultar descripciones") {
			
			boton.text("Mostrar descripciones");
			
		} else {
			
			boton.text("Ocultar descripciones");
		}
	});
	
	$("#resaltar").on("click", function() {
		
		$(".desc").css("border", "solid 2px red");
	});
});