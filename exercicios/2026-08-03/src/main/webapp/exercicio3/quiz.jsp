<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <title>${title}</title>
        <link rel="stylesheet" href="styles.css" />
    </head>
    <body>
        <header>
            <h1>Quiz de Esportes</h1>
            <h2>${title}</h2>
            <hr />
        </header>

        <main>
            <form action="${action}" method="post">
                <%
                    String dificuldade = (String) request.getParameter("dificuldade");

                    switch (dificuldade) {
                        case "facil":
                            out.println("<div>\n" + //
                        "                    <label for=\"pergunta-1\" class=\"form-label\">\n" + //
                        "                        Pergunta 1: Quem foi o campeão da Copa do Mundo da FIFA em\n" + //
                        "                        2026?</label\n" + //
                        "                    >\n" + //
                        "                    <div>\n" + //
                        "                        <input\n" + //
                        "                            type=\"radio\"\n" + //
                        "                            name=\"pergunta-1\"\n" + //
                        "                            id=\"frança\"\n" + //
                        "                            value=\"frança\"\n" + //
                        "                            required\n" + //
                        "                        />\n" + //
                        "                        <label for=\"frança\">França</label>\n" + //
                        "                    </div>\n" + //
                        "                    <div>\n" + //
                        "                        <input\n" + //
                        "                            type=\"radio\"\n" + //
                        "                            name=\"pergunta-1\"\n" + //
                        "                            id=\"argentina\"\n" + //
                        "                            value=\"argentina\"\n" + //
                        "                        />\n" + //
                        "                        <label for=\"argentina\">Argentina</label>\n" + //
                        "                    </div>\n" + //
                        "                    <div>\n" + //
                        "                        <input\n" + //
                        "                            type=\"radio\"\n" + //
                        "                            name=\"pergunta-1\"\n" + //
                        "                            id=\"espanha\"\n" + //
                        "                            value=\"espanha\"\n" + //
                        "                        />\n" + //
                        "                        <label for=\"espanha\">Espanha</label>\n" + //
                        "                    </div>\n" + //
                        "                    <div>\n" + //
                        "                        <input\n" + //
                        "                            type=\"radio\"\n" + //
                        "                            name=\"pergunta-1\"\n" + //
                        "                            id=\"inglaterra\"\n" + //
                        "                            value=\"inglaterra\"\n" + //
                        "                        />\n" + //
                        "                        <label for=\"inglaterra\">Inglaterra</label>\n" + //
                        "                    </div>\n" + //
                        "                    <div>\n" + //
                        "                        <label for=\"pergunta-2\" class=\"form-label\">\n" + //
                        "                            Pergunta 2: Quem é o jogador considerado como \"Rei\n" + //
                        "                            do Futebol\"?</label\n" + //
                        "                        >\n" + //
                        "                        <div>\n" + //
                        "                            <input\n" + //
                        "                                type=\"radio\"\n" + //
                        "                                name=\"pergunta-2\"\n" + //
                        "                                id=\"messi\"\n" + //
                        "                                value=\"messi\"\n" + //
                        "                                required\n" + //
                        "                            />\n" + //
                        "                            <label for=\"messi\">Lionel Messi</label>\n" + //
                        "                        </div>\n" + //
                        "                        <div>\n" + //
                        "                            <input\n" + //
                        "                                type=\"radio\"\n" + //
                        "                                name=\"pergunta-2\"\n" + //
                        "                                id=\"cristiano-ronaldo\"\n" + //
                        "                                value=\"cristiano-ronaldo\"\n" + //
                        "                            />\n" + //
                        "                            <label for=\"cristiano-ronaldo\"\n" + //
                        "                                >Cristiano Ronaldo</label\n" + //
                        "                            >\n" + //
                        "                        </div>\n" + //
                        "                        <div>\n" + //
                        "                            <input\n" + //
                        "                                type=\"radio\"\n" + //
                        "                                name=\"pergunta-2\"\n" + //
                        "                                id=\"maradona\"\n" + //
                        "                                value=\"maradona\"\n" + //
                        "                            />\n" + //
                        "                            <label for=\"maradona\">Diego Maradona</label>\n" + //
                        "                        </div>\n" + //
                        "                        <div>\n" + //
                        "                            <input\n" + //
                        "                                type=\"radio\"\n" + //
                        "                                name=\"pergunta-2\"\n" + //
                        "                                id=\"pele\"\n" + //
                        "                                value=\"pele\"\n" + //
                        "                            />\n" + //
                        "                            <label for=\"pele\"\n" + //
                        "                                >Edson Arantes do Nascimento (Pelé)</label\n" + //
                        "                            >\n" + //
                        "                        </div>\n" + //
                        "                    </div>\n" + //
                        "                    <div>\n" + //
                        "                        <label for=\"pergunta-3\" class=\"form-label\">\n" + //
                        "                            Pergunta 3: Qual é o esporte mais famoso dos\n" + //
                        "                            Estados Unidos?</label\n" + //
                        "                        >\n" + //
                        "                        <div>\n" + //
                        "                            <input\n" + //
                        "                                type=\"radio\"\n" + //
                        "                                name=\"pergunta-3\"\n" + //
                        "                                id=\"futebol-americano\"\n" + //
                        "                                value=\"futebol-americano\"\n" + //
                        "                                required\n" + //
                        "                            />\n" + //
                        "                            <label for=\"futebol-americano\"\n" + //
                        "                                >Futebol Americano</label\n" + //
                        "                            >\n" + //
                        "                        </div>\n" + //
                        "                        <div>\n" + //
                        "                            <input\n" + //
                        "                                type=\"radio\"\n" + //
                        "                                name=\"pergunta-3\"\n" + //
                        "                                id=\"basquetebol-3\"\n" + //
                        "                                value=\"basquetebol-3\"\n" + //
                        "                            />\n" + //
                        "                            <label for=\"basquetebol-3\">Basquetebol</label>\n" + //
                        "                        </div>\n" + //
                        "                        <div>\n" + //
                        "                            <input\n" + //
                        "                                type=\"radio\"\n" + //
                        "                                name=\"pergunta-3\"\n" + //
                        "                                id=\"futebol-3\"\n" + //
                        "                                value=\"futebol-3\"\n" + //
                        "                            />\n" + //
                        "                            <label for=\"futebol-3\">Futebol</label>\n" + //
                        "                        </div>\n" + //
                        "                        <div>\n" + //
                        "                            <input\n" + //
                        "                                type=\"radio\"\n" + //
                        "                                name=\"pergunta-3\"\n" + //
                        "                                id=\"beisebol\"\n" + //
                        "                                value=\"beisebol\"\n" + //
                        "                            />\n" + //
                        "                            <label for=\"beisebol\">Beisebol</label>\n" + //
                        "                        </div>\n" + //
                        "                    </div>\n" + //
                        "                    <div>\n" + //
                        "                        <label for=\"pergunta-4\" class=\"form-label\">\n" + //
                        "                            Pergunta 4: Qual desses esportes surgiu\n" + //
                        "                            primeiro?</label\n" + //
                        "                        >\n" + //
                        "                        <div>\n" + //
                        "                            <input\n" + //
                        "                                type=\"radio\"\n" + //
                        "                                name=\"pergunta-4\"\n" + //
                        "                                id=\"futebol-4\"\n" + //
                        "                                value=\"futebol-4\"\n" + //
                        "                                required\n" + //
                        "                            />\n" + //
                        "                            <label for=\"futebol-4\">Futebol</label>\n" + //
                        "                        </div>\n" + //
                        "                        <div>\n" + //
                        "                            <input\n" + //
                        "                                type=\"radio\"\n" + //
                        "                                name=\"pergunta-4\"\n" + //
                        "                                id=\"voleibol\"\n" + //
                        "                                value=\"voleibol\"\n" + //
                        "                            />\n" + //
                        "                            <label for=\"voleibol\">Voleibol</label>\n" + //
                        "                        </div>\n" + //
                        "                        <div>\n" + //
                        "                            <input\n" + //
                        "                                type=\"radio\"\n" + //
                        "                                name=\"pergunta-4\"\n" + //
                        "                                id=\"basquetebol-4\"\n" + //
                        "                                value=\"basquetebol-4\"\n" + //
                        "                            />\n" + //
                        "                            <label for=\"basquetebol-4\">Basquetebol</label>\n" + //
                        "                        </div>\n" + //
                        "                        <div>\n" + //
                        "                            <input\n" + //
                        "                                type=\"radio\"\n" + //
                        "                                name=\"pergunta-4\"\n" + //
                        "                                id=\"cricket\"\n" + //
                        "                                value=\"cricket\"\n" + //
                        "                            />\n" + //
                        "                            <label for=\"cricket\">Cricket</label>\n" + //
                        "                        </div>\n" + //
                        "                    </div>\n" + //
                        "                </div>");
                            break;
                        case "dificil":
                            out.println("\n" + //
                            "                <div>\n" + //
                            "                    <label for=\"pergunta-1\" class=\"form-label\">\n" + //
                            "                        Pergunta 1: Quem foi o campeão da Liga das Nações de\n" + //
                            "                        Vôlei feminina em 2026?</label\n" + //
                            "                    >\n" + //
                            "                    <div>\n" + //
                            "                        <input\n" + //
                            "                            type=\"radio\"\n" + //
                            "                            name=\"pergunta-1\"\n" + //
                            "                            id=\"italia\"\n" + //
                            "                            value=\"italia\"\n" + //
                            "                            required\n" + //
                            "                        />\n" + //
                            "                        <label for=\"italia\">Itália</label>\n" + //
                            "                    </div>\n" + //
                            "                    <div>\n" + //
                            "                        <input\n" + //
                            "                            type=\"radio\"\n" + //
                            "                            name=\"pergunta-1\"\n" + //
                            "                            id=\"brasil\"\n" + //
                            "                            value=\"brasil\"\n" + //
                            "                        />\n" + //
                            "                        <label for=\"brasil\">Brasil </label>\n" + //
                            "                    </div>\n" + //
                            "                    <div>\n" + //
                            "                        <input\n" + //
                            "                            type=\"radio\"\n" + //
                            "                            name=\"pergunta-1\"\n" + //
                            "                            id=\"turquia\"\n" + //
                            "                            value=\"turquia\"\n" + //
                            "                        />\n" + //
                            "                        <label for=\"turquia\">Turquia</label>\n" + //
                            "                    </div>\n" + //
                            "                    <div>\n" + //
                            "                        <input\n" + //
                            "                            type=\"radio\"\n" + //
                            "                            name=\"pergunta-1\"\n" + //
                            "                            id=\"eua\"\n" + //
                            "                            value=\"eua\"\n" + //
                            "                        />\n" + //
                            "                        <label for=\"eua\">Estados Unidos</label>\n" + //
                            "                    </div>\n" + //
                            "                </div>\n" + //
                            "                <div>\n" + //
                            "                    <label for=\"pergunta-2\" class=\"form-label\">\n" + //
                            "                        Pergunta 2: Em que ano o Brasil conquistou sua primeira\n" + //
                            "                        Copa do Mundo da FIFA?</label\n" + //
                            "                    >\n" + //
                            "                    <div>\n" + //
                            "                        <input\n" + //
                            "                            type=\"radio\"\n" + //
                            "                            name=\"pergunta-2\"\n" + //
                            "                            id=\"1950\"\n" + //
                            "                            value=\"1950\"\n" + //
                            "                            required\n" + //
                            "                        />\n" + //
                            "                        <label for=\"1950\">1950</label>\n" + //
                            "                    </div>\n" + //
                            "                    <div>\n" + //
                            "                        <input\n" + //
                            "                            type=\"radio\"\n" + //
                            "                            name=\"pergunta-2\"\n" + //
                            "                            id=\"1958\"\n" + //
                            "                            value=\"1958\"\n" + //
                            "                        />\n" + //
                            "                        <label for=\"1958\">1958</label>\n" + //
                            "                    </div>\n" + //
                            "                    <div>\n" + //
                            "                        <input\n" + //
                            "                            type=\"radio\"\n" + //
                            "                            name=\"pergunta-2\"\n" + //
                            "                            id=\"1962\"\n" + //
                            "                            value=\"1962\"\n" + //
                            "                        />\n" + //
                            "                        <label for=\"1962\">1962</label>\n" + //
                            "                    </div>\n" + //
                            "                    <div>\n" + //
                            "                        <input\n" + //
                            "                            type=\"radio\"\n" + //
                            "                            name=\"pergunta-2\"\n" + //
                            "                            id=\"1970\"\n" + //
                            "                            value=\"1970\"\n" + //
                            "                        />\n" + //
                            "                        <label for=\"1970\">1970</label>\n" + //
                            "                    </div>\n" + //
                            "                </div>\n" + //
                            "                <div>\n" + //
                            "                    <label for=\"pergunta-3\" class=\"form-label\">\n" + //
                            "                        Pergunta 3: Qual desses esportes é o único que faz\n" + //
                            "                        parte das Olimpíadas de forma fixa?</label\n" + //
                            "                    >\n" + //
                            "                    <div>\n" + //
                            "                        <input\n" + //
                            "                            type=\"radio\"\n" + //
                            "                            name=\"pergunta-3\"\n" + //
                            "                            id=\"futebol-americano\"\n" + //
                            "                            value=\"futebol-americano\"\n" + //
                            "                            required\n" + //
                            "                        />\n" + //
                            "                        <label for=\"futebol-americano\">Futebol Americano</label>\n" + //
                            "                    </div>\n" + //
                            "                    <div>\n" + //
                            "                        <input\n" + //
                            "                            type=\"radio\"\n" + //
                            "                            name=\"pergunta-3\"\n" + //
                            "                            id=\"futsal\"\n" + //
                            "                            value=\"futsal\"\n" + //
                            "                        />\n" + //
                            "                        <label for=\"futsal\">Futsal</label>\n" + //
                            "                    </div>\n" + //
                            "                    <div>\n" + //
                            "                        <input\n" + //
                            "                            type=\"radio\"\n" + //
                            "                            name=\"pergunta-3\"\n" + //
                            "                            id=\"beisebol\"\n" + //
                            "                            value=\"beisebol\"\n" + //
                            "                        />\n" + //
                            "                        <label for=\"beisebol\">Beisebol</label>\n" + //
                            "                    </div>\n" + //
                            "                    <div>\n" + //
                            "                        <input\n" + //
                            "                            type=\"radio\"\n" + //
                            "                            name=\"pergunta-3\"\n" + //
                            "                            id=\"boxe\"\n" + //
                            "                            value=\"boxe\"\n" + //
                            "                        />\n" + //
                            "                        <label for=\"boxe\">Boxe</label>\n" + //
                            "                    </div>\n" + //
                            "                </div>\n" + //
                            "                <div>\n" + //
                            "                    <label for=\"pergunta-4\" class=\"form-label\">\n" + //
                            "                        Pergunta 4: Na Fórmula 1, por qual time\n" + //
                            "                        Ayrton Senna teve mais vitórias?</label\n" + //
                            "                    >\n" + //
                            "                    <div>\n" + //
                            "                        <input\n" + //
                            "                            type=\"radio\"\n" + //
                            "                            name=\"pergunta-4\"\n" + //
                            "                            id=\"mclaren\"\n" + //
                            "                            value=\"mclaren\"\n" + //
                            "                            required\n" + //
                            "                        />\n" + //
                            "                        <label for=\"mclaren\">McLaren</label>\n" + //
                            "                    </div>\n" + //
                            "                    <div>\n" + //
                            "                        <input\n" + //
                            "                            type=\"radio\"\n" + //
                            "                            name=\"pergunta-4\"\n" + //
                            "                            id=\"williams\"\n" + //
                            "                            value=\"williams\"\n" + //
                            "                        />\n" + //
                            "                        <label for=\"williams\">Williams</label>\n" + //
                            "                    </div>\n" + //
                            "                    <div>\n" + //
                            "                        <input\n" + //
                            "                            type=\"radio\"\n" + //
                            "                            name=\"pergunta-4\"\n" + //
                            "                            id=\"toleman\"\n" + //
                            "                            value=\"toleman\"\n" + //
                            "                        />\n" + //
                            "                        <label for=\"toleman\">Toleman</label>\n" + //
                            "                    </div>\n" + //
                            "                    <div>\n" + //
                            "                        <input\n" + //
                            "                            type=\"radio\"\n" + //
                            "                            name=\"pergunta-4\"\n" + //
                            "                            id=\"lotus\"\n" + //
                            "                            value=\"lotus\"\n" + //
                            "                        />\n" + //
                            "                        <label for=\"lotus\">Lotus</label>\n" + //
                            "                    </div>\n" + //
                            "                </div>");
                            break;
                    }
                %>
                <input type="hidden" name="dificuldade" value="${dificuldade}" />
                <button type="submit">Responder</button>
            </form>
        </main>
    </body>
</html>
