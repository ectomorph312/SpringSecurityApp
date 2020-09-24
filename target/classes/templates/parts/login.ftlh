<#macro login path isRegisterForm>
<form action="${path}" method="post">
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Username: </label>
        <div class="col-sm-4">
            <input type="text" name="username" class="form-control" placeholder="Username">
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label"> Password: </label>
        <div class="col-sm-4">
            <input type="password" name="password" class="form-control" placeholder="Password"/>
        </div>
    </div>
    <input type="hidden" name="_csrf" value="${_csrf.token}" />
    <button class="btn btn-dark" type="submit"><#if isRegisterForm>Create<#else>Sign In</#if></button>
    <#if !isRegisterForm><a href="/registration" class="btn btn-dark">Registration</#if></a>
</form>
</#macro>

<#macro logout>
<form action="/logout" method="post">
    <input type="hidden" name="_csrf" value="${_csrf.token}" />
    <button class="btn btn-light" type="submit">Sing Out</button>
</form>
</#macro>
