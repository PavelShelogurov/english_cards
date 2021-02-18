<%@ page import="model.WordCard" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cards info of workers</title>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <!--Bootstrap-->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
</head>
<body>
<div class="container d-grid gap-3">
    <div id="header-text" class="text-center">
        <h1>Word's cards</h1>
        <p>Here cards with foreign words</p>
    </div>
    <div class="d-grid gap-2 col-6 mx-auto">
        <a href="static/addCard.html" class="btn btn-secondary btn-lg">Add new word</a>
    </div>
    <c:forEach var="card" items="${cards}">

        <div class="row justify-content-center">
            <div class="card mb-3" style="width: 30rem;">
                <img src="${card.getImgPath()}" class="card-img-top" alt="${card.getForeignLanguage()}">
                <div class="card-body">
                    <h3 class="card-title">${card.getForeignLanguage()}</h3>
                    <p id="native" class="card-text">${card.getNativeLanguage()}</p>
                    <button id="btn${card}" class="btn btn-secondary me-md-2" onclick="hideUnhideTranslate()" type="button">Показать перевод</button>
                    <button id="skipWord" class="btn btn-primary me-md-2" type="button">Запомнил</button>
                    <script>
                    //по нажатию на кнопку меняем текст на кнопку
                    function hideUnhideTranslate() {
                      let buttonText = event.target;
                      if (buttonText.innerHTML == "Показать перевод"){
                        buttonText.innerHTML = "Скрыть перевод";
                      } else {
                        buttonText.innerHTML = "Показать перевод";
                      }
                    }
                    </script>
                </div>
            </div>
        </div>
    </c:forEach>
</div>
</body>
</html>
