<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html >
    <head>
        <meta charset="UTF-8">
        <title>Form that looks like JSON.</title>
        <link rel="stylesheet" href="css/normalize.css">
        <link rel='stylesheet prefetch' href='http://fonts.googleapis.com/css?family=Source+Code+Pro'>
        <link rel="stylesheet" href="css/style.css">
    </head>
    <body>
        <h1>This looks like JSON, but it is a form!</h1>
        <form class="json complex-keys">
            <fieldset class="json__object">

                <label class="json__pair"><span class="json__key">album_type</span><input disabled class="json__value--string" name="foo" value="${album.getAlbum_type()}"></label>

                <fieldset class="json__array">
                    <legend class="json__key--nested">artists</legend>
                    <fieldset class="json__object">
                        <c:forEach items="${album.getArtists()}" var="artista">
                            <fieldset class="json__object">
                                <legend class="json__key--nested">external_urls</legend>
                                <label class="json__pair"><span class="json__key">spotify</span><input disabled class="json__value--string" name="nested[abc]" value="${artista.getExternal_urls().getSpotify()}"></label>
                            </fieldset>
                            <label class="json__pair"><span class="json__key">href</span><input disabled class="json__value--string" name="foo" value="${artista.getHref()}"></label>
                            <label class="json__pair"><span class="json__key">id</span><input disabled class="json__value--string" name="foo" value="${artista.getId()}"></label>
                            <label class="json__pair"><span class="json__key">name</span><input disabled class="json__value--string" name="foo" value="${artista.getName()}"></label>
                            <label class="json__pair"><span class="json__key">type</span><input disabled class="json__value--string" name="foo" value="${artista.getType()}"></label>
                            <label class="json__pair"><span class="json__key">uri</span><input disabled class="json__value--string" name="foo" value="${artista.getUri()}"></label>
                            </c:forEach>
                    </fieldset>
                </fieldset>

                <fieldset class="json__array">
                    <legend class="json__key--nested">available_markets</legend>
                    <c:forEach items="${album.getAvailable_markets()}" var="avaiable_market">
                        <input disabled class="json__value--string" name="arrays[0]" value="${avaiable_market}">
                    </c:forEach>
                </fieldset>

                <fieldset class="json__array">
                    <legend class="json__key--nested">copyrights</legend>
                    <c:forEach items="${album.getCopyrights()}" var="copyright">
                        <fieldset class="json__object">
                            <label class="json__pair"><span class="json__key">text</span><input disabled class="json__value--string" name="foo" value="${copyright.getText()}"></label>
                            <label class="json__pair"><span class="json__key">type</span><input disabled class="json__value--string" name="foo" value="${copyright.getType()}"></label>
                        </fieldset>
                    </c:forEach>
                </fieldset>

                <fieldset class="json__object">
                    <legend class="json__key--nested">external_ids</legend>
                    <label class="json__pair"><span class="json__key">upc</span><input disabled class="json__value--string" name="nested[abc]" value="${album.getExternal_ids().getUpc()}"></label>
                </fieldset>

                <fieldset class="json__object">
                    <legend class="json__key--nested">external_urls</legend>
                    <label class="json__pair"><span class="json__key">spotify</span><input disabled class="json__value--string" name="nested[abc]" value="${album.getExternal_urls().getSpotify()}"style="width:80%;"></label>
                </fieldset>

                <fieldset class="json__array">
                    <legend class="json__key--nested">genres</legend>
                    <input disabled class="json__value--string" name="arrays[0]" value="${genres}">
                </fieldset>

                <label class="json__pair"><span class="json__key">href</span><input disabled class="json__value--string" name="foo" value="${album.getHref()}"></label>
                <label class="json__pair"><span class="json__key">id</span><input disabled class="json__value--string" name="foo" value="${album.getId()}"></label>

                <fieldset class="json__array">
                    <legend class="json__key--nested">images</legend>
                    <c:forEach items="${album.getImages()}" var="image">
                        <fieldset class="json__object">
                            <label class="json__pair"><span class="json__key">height</span><input disabled class="json__value--number" name="foo" value="${image.getHeight()}"></label>
                            <label class="json__pair"><span class="json__key">url</span><input disabled class="json__value--string" name="foo" value="${image.getUrl()}"></label>
                            <label class="json__pair"><span class="json__key">width</span><input disabled class="json__value--number" name="foo" value="${image.getWidth()}"></label>
                        </fieldset>
                    </c:forEach>
                </fieldset>

                <label class="json__pair"><span class="json__key">name</span><input disabled class="json__value--string" name="foo" value="${album.getName()}"></label>
                <label class="json__pair"><span class="json__key">popularity</span><input disabled class="json__value--number" name="foo" value="${album.getPopularity()}"></label>
                <label class="json__pair"><span class="json__key">release_date</span><input disabled class="json__value--string" name="foo" value="${album.getRelease_date()}"></label>
                <label class="json__pair"><span class="json__key">release_date_precision</span><input disabled class="json__value--string" name="foo" value="${album.getRelease_date_precision()}"></label>

                <fieldset class="json__object">
                    <legend class="json__key--nested">tracks</legend>
                    <c:set var="track" scope="session" value="${album.getTracks()}"/>
                    <label class="json__pair"><span class="json__key">href</span><input disabled class="json__value--string" name="nested[abc]" value="${track.getHref()}" style="width:105%;"></label>
                        <c:set var="item" scope="session" value="${track.getItems()}"/>
                    <fieldset class="json__array">
                        <legend class="json__key--nested">items</legend>
                        <c:forEach items="${sessionScope.item}" var="item2">
                            <fieldset class="json__object">
                                <fieldset class="json__array">
                                    <legend class="json__key--nested">artists</legend>
                                    <fieldset class="json__object">
                                        <c:forEach begin="0" end="${item2.getArtists().size()-1}" var="i">
                                            <fieldset class="json__object">
                                                <legend class="json__key--nested">external_urls</legend>
                                                <label class="json__pair"><span class="json__key">spotify</span><input disabled class="json__value--string" name="nested[abc]" value="${item2.getArtists().get(i).getExternal_urls().getSpotify()}"></label>
                                            </fieldset>
                                            <label class="json__pair"><span class="json__key">href</span><input disabled class="json__value--string" name="foo" value="${item2.getArtists().get(i).getHref()}"></label>
                                            <label class="json__pair"><span class="json__key">id</span><input disabled class="json__value--string" name="foo" value="${item2.getArtists().get(i).getId()}"></label>
                                            <label class="json__pair"><span class="json__key">name</span><input disabled class="json__value--string" name="foo" value="${item2.getArtists().get(i).getName()}"></label>
                                            <label class="json__pair"><span class="json__key">type</span><input disabled class="json__value--string" name="foo" value="${item2.getArtists().get(i).getType()}"></label>
                                            <label class="json__pair"><span class="json__key">uri</span><input disabled class="json__value--string" name="foo" value="${item2.getArtists().get(i).getUri()}"></label>
                                            </c:forEach>
                                    </fieldset>
                                </fieldset>
                                <fieldset class="json__array">
                                    <legend class="json__key--nested">available_markets</legend>                                    
                                    <c:forEach items=" ${item2.getAvaiable_markets()}" var="avaiable_marketItem">
                                        <input disabled class="json__value--string" name="arrays[0]" value="${avaiable_marketItem.replace('[',' ').replace(']',' ').trim()}">
                                    </c:forEach>
                                </fieldset> 
                                <label class="json__pair"><span class="json__key">disc_number</span><input disabled class="json__value--number" name="foo" value="${item2.getDisc_number()}"></label>
                                <label class="json__pair"><span class="json__key">duration_ms</span><input disabled class="json__value--number" name="foo" value="${item2.getDuration_ms()}"></label>
                                <label class="json__pair"><span class="json__key">explicit</span><input disabled class="json__value--boolean" name="foo" value="${item2.isExplicit()}"></label>
                                <fieldset class="json__object">
                                    <legend class="json__key--nested">external_urls</legend>
                                    <label class="json__pair"><span class="json__key">spotify</span><input disabled class="json__value--string" name="nested[abc]" value="${item2.getExternal_urls().getSpotify()}"></label>
                                </fieldset>
                                <label class="json__pair"><span class="json__key">href</span><input disabled class="json__value--string" name="foo" value="${item2.getHref()}"></label>
                                <label class="json__pair"><span class="json__key">id</span><input disabled class="json__value--string" name="foo" value="${item2.getId()}"></label>
                                <label class="json__pair"><span class="json__key">name</span><input disabled class="json__value--string" name="foo" value="${item2.getName()}"></label>
                                <label class="json__pair"><span class="json__key">preview_url</span><input disabled class="json__value--string" name="foo" value="${item2.getPreview_url()}"></label>
                                <label class="json__pair"><span class="json__key">track_number</span><input disabled class="json__value--number" name="foo" value="${item2.getTrack_number()}"></label>
                                <label class="json__pair"><span class="json__key">type</span><input disabled class="json__value--string" name="foo" value="${item2.getType()}"></label>
                                <label class="json__pair"><span class="json__key">uri</span><input disabled class="json__value--string" name="foo" value="${item2.getUri()}"></label>
                            </fieldset>
                        </c:forEach>
                    </fieldset>
                    <label class="json__pair"><span class="json__key">limit</span><input disabled class="json__value--number" name="nested[abc]" value="${album.getTracks().getLimit()}"></label>
                    <label class="json__pair"><span class="json__key">next</span><input disabled class="json__value--string" name="nested[abc]" value="${album.getTracks().getNext()}"></label>
                    <label class="json__pair"><span class="json__key">offset</span><input disabled class="json__value--number" name="nested[abc]" value="${album.getTracks().getOffset()}"></label>
                    <label class="json__pair"><span class="json__key">previous</span><input disabled class="json__value--string" name="nested[abc]" value="${album.getTracks().getPrevious()}"></label>
                    <label class="json__pair"><span class="json__key">total</span><input disabled class="json__value--number" name="nested[abc]" value="${album.getTracks().getTotal()}"></label>
                </fieldset>

                <label class="json__pair"><span class="json__key">type</span><input disabled class="json__value--string" name="nested[abc]" value="${album.getType()}"></label>
                <label class="json__pair"><span class="json__key">uri</span><input disabled class="json__value--string" name="nested[abc]" value="${album.getUri()}"></label>
            </fieldset>
        </form>
        <script src="js/index.js"></script>
    </body>
</html>