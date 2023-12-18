<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Login</title>
        <!-- Incluir Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
        <<link rel="stylesheet" href="../css/login.css"/>
    </head>
    <body>

        <div class="container mt-5">
            <div class="row justify-content-center text-center pt-4 mt-5 m-1">
                <div class="col-md-6 col-sm-8 col-xl-4 col-lg-5">
                    <div class="card formulario">
                        <div class="card-body">
                            <h2 class="card-title text-center">Iniciar Sesión</h2>
                            <form action="LoginServlet" method="post" class="mt-4">
                                <div class="d-flex justify-content-center pt-5">
                                    <img src="../img/logo_final.png" class="logo">
                                </div>
                                <div class="form-group mx-sm-3 mb-1">
                                    <input type="text" class="form-control caja" id="username" name="username" placeholder="User" required>
                                </div>
                                <div class="form-group mx-sm-3 mb-1">
                                    <input type="password" class="form-control caja" id="password" name="password" placeholder="Password" required>
                                </div>
                                <div class="form-group mx-sm-3 pb-5">
                                    <input type="submit" class="btn btn-block btn-lg boton" value="Login">
                                    <input type="button"  onclick="location.href='../';" class="btn btn-block btn-lg boton" value="Volver">
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- Incluir Bootstrap Javascript y sus dependencias -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>

    </body>
</html>
