<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>${agencyName} - ${entityName}</title>

<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f4f4f9;
        text-align: center;
        padding: 20px;
    }

    .queue-card {
        background-color: white;
        border: 1px solid #ddd;
        border-radius: 10px;
        box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
        max-width: 500px;
        margin: 20px auto;
        padding: 20px;
        text-align: left;
    }

    h1 {
        color: #007bff;
    }

    .queue-info {
        font-size: 18px;
        line-height: 1.5;
    }

    .queue-highlight {
        font-weight: bold;
        color: #007bff;
    }
</style>

<head>
    <h1>  Bienvenue a l'agence ${agencyName} de ${entityName}</h1>

        </head>

<div class="queue-card">
    <p class="queue-info">
        Votre numéro de ticket est : <span class="queue-highlight">${eTicketNumber}</span>
    </p>
    <p class="queue-info">
        Votre position dans la file : <span class="queue-highlight">${positionInQueue}</span>
    </p>
    <p class="queue-info">
        Nombre de personnes devant : <span class="queue-highlight">${peopleAhead}</span>
    </p>
    <p class="queue-info">
        Numéro actuellement traité : <span class="queue-highlight">${currentNumber}</span>
    </p>
    <p class="queue-info">
        A la Caisse Numero : <span class="queue-highlight">${register}</span>
    </p>
</div>


</html>