<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ tag body-content="scriptless" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<html>

<head>
    <style type="text/css">
        body {
            background: #CCC;
            font-family: sans-serif;
            font-size: 11pt;
            color: #00C;
        }
        a {
            color: #00C;
        }

        a:hover {
            text-decoration: none;

        }

        h1 {
            color: #00C;
            margin: 0;
            border-bottom: 1px solid #00C;
            font-size: 17pt;
            font-weight: bold;
        }

        h2 {
            color: #77C;
            margin: 0;
            border-bottom: 1px solid #77C;
            font-size: 14pt;
        }

        .menuframe {
            margin: 15px;
            padding: 0;
            background: white;
            border: 1px solid #FC3;
        }

        #menubar {
            width: 250px;
            float: left;
        }

        .menuframe  li {
            list-style: none;
            margin: 0;
            background: #FC3;
            color: #00C;
            font-size: 11pt;
        }

        .menuframe li ul {
            margin: 0;
            padding-left: 0;
        }

        .menuframe li ul li {
            background: white;
            text-decoration: none;
        }

        .menuframe li ul li a {
            display: block;
            margin: 0;
            background: white;
            text-decoration: none;
        }

        .menuframe li ul li a:hover {
            display: block;
            margin: 0;
            color: white;
            background: #00C;
        }

        #content {
            background: white;
            border: 1px solid #FC3;
            margin-left: 250px;
            clear: none;
            padding: 15px;

        }

        input[type=submit] {
            background: #FC3;
            border: 1px solid #00C;
            color: #00C;
        }
    </style>
</head>

<body>
<div id="menubar">
    <ul class="menuframe">
        <li>Itempje 1
            <ul>
                <li><a href="#">Subitem 1</a></li>
                <li><a href="#">Subitem 2</a></li>
                <li><a href="#">Subitem 3</a></li>
            </ul>
        </li>
        <li>Itempje 2
            <ul>
                <li><a href="#">Subitem 1</a></li>
                <li><a href="#">Subitem 2</a></li>
                <li><a href="#">Subitem 3</a></li>
            </ul>
        </li>
        <li>Inloggen
            <ul>
                <li>
                    <form action="/action/user.Login" method="POST">
                        <label for="email">E-mail:</label><br/>
                        <input type="text" id="email" name="email"/><br/>
                        <label for="password">Wachtwoord:</label><br/>
                        <input type="password" id="password" name="password"/><br/>
                        <input type="submit" value="Inloggen"/>
                    </form>
                </li>
            </ul>
        </li>
    </ul>


</div>

<div id="content">
    <jsp:doBody/>

</div>

</body>


</html>