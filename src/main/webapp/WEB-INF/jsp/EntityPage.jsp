<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <style>
        /* General styling */
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f9;
            margin: 0;
            padding: 20px;
            text-align: center;
        }

        h1 {
            background-color: #007bff;
            color: white;
            padding: 15px;
            border-radius: 5px;
            margin-bottom: 20px;
        }

        h2 {
            margin-top: 20px;
            color: #333;
        }

        /* Entity image styling */
        .entity-image {
            width: 150px;
            height: 150px;
            margin: 20px auto;
            display: block;
            border-radius: 50%;
            border: 3px solid #007bff;
        }

        /* Agencies list styling */
        ul {
            list-style-type: none;
            padding: 0;
            margin: 20px auto;
            max-width: 600px;
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
    </style>
</head>
<body>
<!-- Display the entity image -->
<img src="/images/${myEntity}.jpg" alt="${myEntity} Icon" class="entity-image" />

<h1>Bienvenue a la ${myEntity},</h1>

<h2>Laquelle de nos agences souhaitez-vous visiter ?</h2>

<!-- List of agencies -->

<div class="card-container">

    <c:forEach var="name" items="${myAgencies}">
        <div class="card">
            <!-- Replace with actual agency image -->
<%--            <img src="/images/agencies/${name}.jpg" alt="${name} Image" />--%>

            <div class="card-title">${name}</div>
            <a href="/${myEntity}/${name}" class="card-btn">Visiter l'agence</a>
        </div>
    </c:forEach>
</div>
</body>
</html>
