<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
    <!-- Define an HTTP/1.1 Connector on port 8443, JSSE NIO implementation -->
    
	<link rel="stylesheet" type="text/css" href="css/estiloRegistro.css" />
        <title>Login</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>

    </head>
 <body>
	  <div class="registro" >
        <form name ="formulario" method="post"  action ="Registro.jsp">
            
            <div class="titulo">
               ¡Login!
            </div>
            <div class="campo">
                <label for="usuario">Nombre usuario:</label>
                <input type="text" name="username" />
            </div>
            <div class="campo">
                <label for="pass1">Contraseña:</label>
                <input type="password" name="pass1" id="pass1" />
            </div>
            <div class="campo">
            <p><a href="#showForm" data-toggle="collapse" aria-expanded="false" aria-controls="collapse">¿Perdistes tu contraseña?</a></p>	
							<div class="collapse" id="showForm">
								<div class='well'>
									<form action="password-recovery.php" method="post">
										<div class="form-group">										
											<input type="email" class="form-control" name="email" placeholder="Enter the email associated with the password." required>
										</div>
										<button type="submit" class="btn btn-dark">Recover Password</button>
									</form>								
								</div>
							</div>
			</div>				
   	    
            <div class="boton">
                <input type="submit" value="Login"/>
            </div>
            
        </form>
    </div> 
	
</body>
</html>