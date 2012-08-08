$ ->
    ###
    url = "http://localhost:9000/api/read"
    $.getJSON(url, (data, status) ->
        $("#rss").append("<ul></ul>")
        for item in data.items
            $("#rss>ul").append("""<li><a href="#{item.link}">#{item.title}</a></li>""")
        return
    )
    ###

    $("span#update").bind("click", () ->
        url = "http://localhost:9000/api/read"
        $.getJSON(url, (data, status) ->
            $("#rss").empty()
            $("#rss").append("<ul></ul>")
            for item in data.items
                $("#rss>ul").append("""<li><a href="#{item.link}">#{item.title}</a></li>""")
            return
        )
        return
    )
    return
return
