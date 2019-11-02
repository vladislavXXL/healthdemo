<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js" type="text/javascript"></script>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"/>
</head>
<script>
    var service = 'http://localhost:8080/horse';
    var RestGetAll = function () {
        $.ajax({
            type: 'GET',
            url: service + '/all',
            dataType: 'json',
            accept: 'json',
            contentType: 'application/json;utf-8',
            async: false,
            success: function (result) {
                $('#response').html(JSON.stringify(result))
            },
            error: function (jqXHR, testStatus, errorThrown) {
                $('#response').html(JSON.stringify(jqXHR))
            }
        });
    };

    var RestGet = function (id) {
        $.ajax({
            type: 'GET',
            url: service + '/get/' + id,
            dataType: 'json',
            accept: 'json',
            contentType: 'application/json;utf-8',
            async: false,
            success: function (result) {
                $('#response').html(JSON.stringify(result))
            },
            error: function (jqXHR, testStatus, errorThrown) {
                $('#response').html(JSON.stringify(jqXHR))
            }
        });
    };

    var RestPost = function (name, description) {
        var JSONObject = {
            'name': name,
            'description': description
        };
        $.ajax({
            type: 'POST',
            url: service + '/add',
            dataType: 'json',
            data: JSON.stringify(JSONObject),
            accept: 'json',
            contentType: 'application/json;utf-8',
            async: false,
            success: function (result) {
                $('#response').html(JSON.stringify(result))
            },
            error: function (jqXHR, testStatus, errorThrown) {
                $('#response').html(JSON.stringify(jqXHR))
            }
        });
    };

    var RestDelete = function (id) {
        $.ajax({
            type: 'DELETE',
            url: service + '/delete/' + id,
            dataType: 'json',
            accept: 'json',
            contentType: 'application/json;utf-8',
            async: false,
            success: function (result) {
                $('#response').html(JSON.stringify(result))
            },
            error: function (jqXHR, testStatus, errorThrown) {
                $('#response').html(JSON.stringify(jqXHR))
            }
        });
    };

    var RestPut = function (id, name, description) {
        var JSONObject = {
            'id': id,
            'name': name,
            'description': description
        };
        $.ajax({
            type: 'PUT',
            url: service + '/update',
            dataType: 'json',
            data: JSON.stringify(JSONObject),
            accept: 'json',
            contentType: 'application/json;utf-8',
            async: false,
            success: function (result) {
                $('#response').html(JSON.stringify(result))
            },
            error: function (jqXHR, testStatus, errorThrown) {
                $('#response').html(JSON.stringify(jqXHR))
            }
        });
    };
</script>
<body>
    <h1>Horse API</h1>
    <h2>${user} logged in</h2>
    <table class="table">
        <tr>
            <th>Request Type</th>
            <th>URL</th>
            <th>Value</th>
        </tr>
        <tr>
            <td>Get all horses -  <code><strong>GET</strong></code></td>
            <td>/horse/all</td>
            <td><button type="button" onclick="RestGetAll()">Try</button></td>
        </tr>
        <tr>
            <td>Get horse by id -  <code><strong>GET/{id}</strong></code></td>
            <td>/horse/get/{id}</td>
            <td>
                id: <input id="getHorseId" value="1"/>
                <button type="button" onclick="RestGet($('#getHorseId').val())">Try</button>
            </td>
        </tr>
        <tr>
            <td>Add new horse -  <code><strong>POST</strong></code></td>
            <td>/horse/add</td>
            <td>
                name: <input id="horseNameForAdd" value=""/>
                description: <input id="horseDescriptionForAdd" value=""/>
                <button type="button" onclick="RestPost($('#horseNameForAdd').val(), $('#horseDescriptionForAdd').val())">Try</button>
            </td>
        </tr>
        <tr>
            <td>Update the horse -  <code><strong>PUT</strong></code></td>
            <td>/horse/update</td>
            <td>
                id: <input id="horseIdForUpdate"/>
                name: <input id="horseNameForUpdate"/>
                description: <input id="horseDescriptionForUpdate"/>
                <button type="button" onclick="RestPut($('#horseIdForUpdate').val(), $('#horseNameForUpdate').val(), $('#horseDescriptionForUpdate').val())">Try</button>
            </td>
        </tr>
        <tr>
            <td>Delete horse by id -  <code><strong>DELETE/{id}</strong></code></td>
            <td>/horse/get/{id}</td>
            <td>
                id: <input id="deleteHorseId" value="1"/>
                <button type="button" onclick="RestDelete($('#deleteHorseId').val())">Try</button>
            </td>
        </tr>

    </table>
<div class="panel panel-default2">
    <div class="page-heading">
        <b>RESPONSE</b>
    </div>
    <div class="panel-body" id="response"></div>
</div>
</body>
</html>
