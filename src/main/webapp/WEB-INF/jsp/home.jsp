<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>Paiement Factures</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f4f4f9;
        margin: 0;
        padding: 0;
        text-align: center;
        overflow: hidden;
    }

    h1 {
        background-color: #007bff;
        color: white;
        padding: 15px 0;
    }

    h2 {
        margin-top: 20px;
        color: #333;
    }

    ul {
        list-style-type: none;
        padding: 0;
    }

    ul li {
        margin: 15px 0;
    }

    .entity-btn {
        display: inline-block;
        padding: 10px 20px;
        margin: 10px;
        background-color: #007bff;
        color: white;
        text-decoration: none;
        border: none;
        border-radius: 5px;
        cursor: pointer;
        font-size: 16px;
        box-shadow: 0px 4px 6px rgba(0, 0, 0, 0.1);
        transition: background-color 0.3s ease;
    }

    .entity-btn:hover {
        background-color: #0056b3;
    }

    .entity-btn img {
        width: 20px;
        height: 20px;
        vertical-align: middle;
        margin-right: 10px;
    }
</style>
<body >


<h1>Bienvenue sur votre site de Paiement de Factures

</h1>
<h2>
    Quelle Service souhaitez vous visiter aujourd'hui?
</h2>
<h1>Entities</h1>
<ul>
    <!-- JSP forEach to iterate over the entity names -->
    <c:forEach var="name" items="${myEntities}">
        <li>
            <a href="/${name}" class="entity-btn">
                <img src="/images/${name}.jpg" alt="${name} Icon" />
                    ${name}
            </a>
        </li>
    </c:forEach>

</ul>
</body>
</html>