$ ->
    url = "http://localhost:9000/api/read"
    $.getJSON(url, (data, status) ->
        $("#rss").append("<ul></ul>")
        for item in data.items
            $("#rss>ul").append("""<li><a href="#{item.link}">#{item.title}</a></li>""")
        return
    )
    return
