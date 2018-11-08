<%--
  Created by IntelliJ IDEA.
  User: przemo
  Date: 08.11.2018
  Time: 12:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Zadanie 17</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
            integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
            crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
            integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
            crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
            integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
            crossorigin="anonymous"></script>
    <link href="http://getbootstrap.com/docs/4.1/examples/sticky-footer/sticky-footer.css" rel="stylesheet">

</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="http://localhost:8080/">Home <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown"
                   aria-haspopup="true" aria-expanded="false">
                    Wybór zadania
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item" href="http://localhost:8080/PrzelicznikMiar.html">Konwerter miar</a>
                    <a class="dropdown-item" href="http://localhost:8080/ObslugaTekstu.html">Obsługa tekstu</a>
                    <a class="dropdown-item" href="http://localhost:8080/KonwerterWalut">Konwerter walut</a>
                </div>
            </li>
        </ul>

    </div>
</nav>


<div class="jumbotron text-center">
    <h1>Konwerter walut</h1>
    <p>Zadanie domowe 17.3</p>
</div>

<div class="container">
    <div class="row">
        <div class="col-sm-12">
            <form method="get" action="KonwerterWalut">
                <div class="form-group">
                    <label for="inputCurrency">Przelicznik walut. wprowadź kwotę:</label>
                    <input type="text" class="form-control" id="inputCurrency" name="inputCurrency"
                           aria-describedby="w PLN"
                           placeholder="0">
                </div>
                <div class="form-group">
                    <label for="inputDate">Opcjonalnie podaj datę wymiany:</label>
                    <input type="text" class="form-control" id="inputDate" name="inputDate"
                           aria-describedby="data w formacie yyyy-MM-dd" placeholder="yyyy-MM-dd">
                </div>
                <div class="form-group">
                    <select class="form-control" id="currencyChoice" name="currencyChoice">
                        <option>1</option>
                        <option>2</option>
                        <option>3</option>
                        <option>4</option>
                        <option>5</option>
                    </select>
                </div>
                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
        </div>
    </div>
</div>


<footer class="footer">
    <div class="container">
        <span class="text-muted">Created by przemek</span>
    </div>
</footer>
</body>
</html>