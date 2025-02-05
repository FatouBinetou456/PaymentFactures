<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>

        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>Admin - ${entityName}</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f9;
            margin: 0;
            padding: 0;
            text-align: center;
            color: #333;
        }

        h1 {
            color: #4CAF50;
            margin-top: 20px;
        }

        .container {
            max-width: 900px;
            margin: 0 auto;
            padding: 20px;
        }

        .ticketDisplay {
            background: #ffffff;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            border-radius: 8px;
            margin: 20px auto;
            padding: 15px;
            text-align: left;
        }

        .ticketDisplay h2 {
            margin: 0;
            font-size: 1.5rem;
            color: #333;
        }

        .ticketDisplay p {
            font-size: 1.2rem;
            margin: 5px 0;
            color: #555;
        }

        ul {
            list-style-type: none;
            padding: 0;
        }

        li {
            margin: 10px 0;
        }

        .footer {
            margin-top: 20px;
            font-size: 0.9rem;
            color: #777;
        }

        @media (max-width: 600px) {
            body {
                font-size: 0.9rem;
            }

            .ticketDisplay {
                padding: 10px;
            }
        }
    </style>
</head>
<body>

<div class="container">
    <h1>Bienvenue Admin de ${entityName}</h1>

    <ul>
        <!-- JSP forEach to iterate over the tickets -->
        <c:forEach var="myTicket" items="${myBusinessTickets}">
            <div class="ticketDisplay">
                <h2>File de l'Agence ${myTicket.getAgency().getLocation()}</h2>
                <p>Numéro en cours : <strong>${myTicket.getCurrentNumber()}</strong> à la caisse <strong>${myTicket.getRegisterNumber()}</strong></p>
                <p>Taille de la file  <strong>${myTicket.getQueueSize()}</strong></p>
            </div>
        </c:forEach>
    </ul>
</div>

<div class="footer">
    © 2025 - Gestion des Tickets
</div>

</body>
</html>
