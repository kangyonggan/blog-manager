<#assign action="${errorCode.id???string('update','save')}"/>
<#assign pageName="${errorCode.id???string('编辑错误码','添加错误码')}"/>

<@override name="content">
<div class="col-xs-12">aaa
    <form method="post" class="form-horizontal" action="${ctx}/code/${action}">
        <#if errorCode.id??>
            <input type="hidden" name="id" value="${errorCode.id}"/>
        </#if>
        <div class="form-group">
            <label for="apiId" class="col-sm-3 control-label no-padding-right">Api Id<span class="red">*</span></label>
            <div class="col-xs-12 col-sm-5">
                <input type="text" name="apiId" value="${errorCode.apiId!''}" class="width-100"/>
            </div>
        </div>
        <div class="form-group">
            <label for="apiErrorCode" class="col-sm-3 control-label no-padding-right">Api错误码<span class="red">*</span></label>
            <div class="col-xs-12 col-sm-5">
                <input type="text" name="apiErrorCode" value="${errorCode.apiErrorCode!''}" class="width-100"/>
            </div>
        </div>
        <div class="form-group">
            <label for="apiErrorDesc" class="col-sm-3 control-label no-padding-right">Api错误描述<span class="red">*</span></label>
            <div class="col-xs-12 col-sm-5">
                <input type="text" name="apiErrorDesc" value="${errorCode.apiErrorDesc!''}" class="width-100"/>
            </div>
        </div>
        <div class="form-group">
            <label for="errorCode" class="col-sm-3 control-label no-padding-right">内部错误码<span class="red">*</span></label>
            <div class="col-xs-12 col-sm-5">
                <input type="text" name="errorCode" value="${errorCode.errorCode!''}" class="width-100"/>
            </div>
        </div>
        <div class="form-group">
            <label for="errorDesc" class="col-sm-3 control-label no-padding-right">内部错误描述<span class="red">*</span></label>
            <div class="col-xs-12 col-sm-5">
                <input type="text" name="errorDesc" value="${errorCode.errorDesc!''}" class="width-100"/>
            </div>
        </div>

        <div class="clearfix form-actions">
            <div class="text-center">
                <button class="btn btn-pink" data-toggle="form-submit" data-loading-text="正在保存...">
                    <i class="ace-icon fa fa-check bigger-110"></i>
                    提交
                </button>
            </div>
        </div>
    </form>
</div>
</@override>

<@override name="script">
<script src="${ctx}/static/app/js/code/form.js"></script>
</@override>

<@extends name="../layout.ftl"/>