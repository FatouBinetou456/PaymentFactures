<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f9;
            text-align: center;
            padding: 20px;
        }

        .counter {
            font-size: 24px;
            font-weight: bold;
            margin: 20px 0;
            color: #007bff;
        }

        .controls {
            display: flex;
            justify-content: center;
            gap: 20px;
            margin-top: 20px;
        }

        .control-btn {
            padding: 10px 20px;
            background-color: #007bff;
            color: white;
            text-decoration: none;
            border-radius: 5px;
            font-size: 16px;
            border: none;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        .control-btn:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
<h1>Interface Agent - Agence ${agencyName} de ${entityName}</h1>
<p class="counter">Numéro en cours : ${currentNumber} a la caisse ${registerNumber}</p>

<div class="controls">
    <form action="/agent/${entityName}/${agencyName}/previous" method="post" style="display: inline;">
        <button class="control-btn">Client précédent</button>
    </form>
    <form action="/agent/${entityName}/${agencyName}/next" method="post" style="display: inline;">
        <button class="control-btn">Client suivant</button>
    </form>
</div>
</body>
</html>
