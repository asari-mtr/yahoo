$ ->
    url = "http://localhost:9000/api/read"
    $.getJSON(url, (data, status) ->
        alert(data.message)
        return
    )
    return
