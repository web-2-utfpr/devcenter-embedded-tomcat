<%@ tag description="Image Wrapper Tag" pageEncoding="UTF-8" %>
<%@ attribute name="url" %>
<%@ attribute name="create_time" %>
<%@ attribute name="nome" %>

<div class="card white-text light-blue">

    <div class="card-image">
        <img src="${url}" width="400px">
    </div>
    <div class="row">
        <div class="col left">
            ${nome}
        </div>
        <div class="col right">
            ${create_time}
        </div>
    </div>
</div>