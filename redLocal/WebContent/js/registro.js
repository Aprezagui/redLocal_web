/**
 * @Autor Antonio Pérez Aguilera
 */
    window.onload = function () {
    	document.formulario.nombre.focus();
    	document.formulario.addEventListener('submit', validarFormulario);
    }

    function validarFormulario(evObject) {
        evObject.preventDefault();
        var todoCorrecto = true;
        /*
        //Comprueba el campo Nombre
        if ((isNaN(formulario.nombre.value) == false || formulario.nombre.value.length == 0) && todoCorrecto) {
        alert('El campo \"Nombre\" no esta completo o no es correcto');
        todoCorrecto = false;
        }
        
        //Comprueba el campo Apellidos
        if ((isNaN(formulario.apellido1.value) == false || formulario.apellido1.value.length == 0) && todoCorrecto) {
        alert('El campo \"Primer apellidos\" no esta completo o no es correcto');
        todoCorrecto = false;
        }
        
        /*Comprueba el campo Apellidos
        if ((isNaN(formulario.apellido2.value) == false || formulario.apellido2.value.length == 0) && todoCorrecto) {
        alert('El campo \"Segundo apellidos\" no esta completo o no es correcto');
        todoCorrecto = false;
        }
        
        //Comprueba el campo Nombre usuario
        if (!validar_username() && todoCorrecto) {
        	alert('El campo \"Nombre Usuario\" no esta completo o no es correcto');
        	todoCorrecto = false;
        }
    
        //Comprueba el campo email
        if ((!(/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,4})+$/.test(formulario.email.value)) && todoCorrecto)) {
            alert('El campo \"Email\" no esta completo o no es correcto');
            todoCorrecto = false;
        }
        
        if(!validar_segunda_clave() && todoCorrecto){
           	   alert('El campo \"Contraseña\" no esta completo o no es correcto');
               todoCorrecto = false;
        }
        
    */
        if (todoCorrecto == true) {
            formulario.submit();
            formulario.reset();
            
        }
    }
       
    function validar_clave(){
		var espacios = false
		var mayuscula = false;
		var minuscula = false;
		var numero = false;
		var caracter_raro = false;
		
		var pass1 = document.getElementById("pass1").value;
		
		if(pass1.length > 0){
	
			 document.getElementById("autov_pass1_img").hidden=false;
		 
				
			 for(var i = 0;i<pass1.length;i++){
				//Espacio en blanco
				if(pass1.charCodeAt(i) == 32){
					espacios=true;
					document.getElementById("mensaje2").innerHTML="La contraseña no puede tener espacio";
					break;
				}
				
				//Tamaño minimo
				if(pass1.length >=6){
					
					if(pass1.charCodeAt(i) >= 65 && pass1.charCodeAt(i) <= 90){
						mayuscula = true;
					}
					else if(pass1.charCodeAt(i) >= 97 && pass1.charCodeAt(i) <= 122){
						minuscula = true;
					}
					else if(pass1.charCodeAt(i) >= 48 && pass1.charCodeAt(i) <= 57){
						numero = true;
					}
					else{
						caracter_raro = true;
					}
				}	
			}
		 
		
			if(mayuscula == true && minuscula == true && caracter_raro == true && numero == true && espacios == false){
				document.getElementById("autov_pass1_img").src="img/field_valid.gif";
				document.getElementById("autov_pass1_img").title="Contraseña fuerte";
				return true;
			}
		
		}else{
			document.getElementById("autov_pass1_img").hidden=true;
		}	
	
	document.getElementById("autov_pass1_img").src="img/field_invalid.gif";
	document.getElementById("autov_pass1_img").title="Contraseña demasiado debil";
	return false;
} 

    function validar_segunda_clave(){
    	
    	var pass2 = document.getElementById("pass2").value;
    	
    	if(pass2.length > 0){
    		 document.getElementById("autov_pass2_img").hidden=false;
    	
    		if(validar_clave()){
    			var pass1 = document.getElementById("pass1").value;
    			if(pass1==pass2){
    				document.getElementById("autov_pass2_img").src="img/field_valid.gif";
    				document.getElementById("autov_pass2_img").title="La contraseña coinciden";
    				return true;
    			}
    		}
    	
    	}else{
    		document.getElementById("autov_pass2_img").hidden=true;
    	}
    	document.getElementById("autov_pass2_img").src="img/field_invalid.gif";
    	document.getElementById("autov_pass2_img").title="La contraseña no coinciden";
    	return false;
    } 
    
    function validar_username(){
    	document.getElementById("autov_username_img").hidden=false;
    	document.getElementById("autov_username_img").src="img/field_valid.gif";
    	document.getElementById("autov_username_img").title="Usuario valido";
    	return true;
    	
    }