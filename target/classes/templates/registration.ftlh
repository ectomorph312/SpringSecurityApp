<#import "parts/common.ftlh" as c>
<#import "parts/login.ftlh" as l>

<@c.page>
<form method="post">
<div class="mb-1"> <h5>Registration</h5>
    ${message!}
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">ФИО: </label>
        <div class="col-sm-4">
            <input type="text" name="surname" class="form-control" placeholder="Surname">
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label"></label>
        <div class="col-sm-4">
            <input type="text" name="name" class="form-control" placeholder="Name">
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label"></label>
        <div class="col-sm-4">
            <input type="text" name="patronymic" class="form-control" placeholder="Patronymic">
        </div>
    </div>
</div>
<@l.login "/registration" true/>
</@c.page>
