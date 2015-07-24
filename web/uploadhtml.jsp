<html>
<head>

    <title>DOC bestand als WIKI-pagina</title>
</head>

<style type="text/css">
    .theform {
        background: #6699ff;
        border-top: 2px solid black;
        border-bottom: 2px solid black;
        margin-top: 20px;
        font-family: Helvetica;
    }

    label {
        float: left;
        width: 250px;
        font-size: 75%;
    }

    #title {
        width: 450px;
        font-size: 14pt;
    }

    input {

    }

    #progress {
        display: none;
        position: absolute;
        left: 50%;
        top: 50%;
        margin-left: -225px;
        margin-top: -37px;
        border: 2px solid black;
        z-index: 101;
    }

    #mask {
        display: none;
        background: black;
        position: absolute;
        left: 0;
        top: 0;
        width: 100%;
        height: 100%;
        opacity: 0.5;
        z-index: 100;

    }
</style>

<script type="text/javascript">
    function showProgress() {
        document.getElementById("progress").style.display = "block";
        document.getElementById("mask").style.display = "block";
        return true;
    }
</script>

<body>

<img src="../web/logo.png" alt="FogBugz to HTML"/>

<div class="theform">
    <form action="UploadHTMLAction" method="post" enctype="multipart/form-data" onsubmit="return showProgress()">
        <label for="file">Bestand:</label>
        <input type="file" name="file" id="file"/> <br/>
        <label for="title">Titel:</label>
        <input type="text" name="title" id="title"/> <br/>
        <label for="wiki">Wiki:</label>
        <select name="wiki" id="wiki">
            <option value="5">Nestor Kenniscentrum</option>
            <option value="6">Nestor Knowledge Base</option>
            <option value="1">Wiki</option>
        </select>
        <br/>

        <br/>


        <label for="email">Fogbugz e-mail:</label>
        <input type="text" name="email" id="email"/> <br/>
        <label for="password">Wachtwoord:</label>
        <input type="password" name="password" id="password"/> <br/>
        <input type="submit" value="OK"/>

    </form>
</div>
<div id="mask">&nbsp;</div>
<div id="progress">
    <img src="../web/progress.gif" alt="Bezig met het uploaden van het bestand"/>
</div>

</body>
</html>