<#assign action="${api.id???string('update','save')}"/>
<#assign pageName="${api.id???string('编辑Api','添加Api')}"/>

<@override name="content">
<div class="col-xs-12">
    <form method="post" class="form-horizontal" action="${ctx}/api/${action}">
        <#if api.id??>
            <input type="hidden" name="id" value="${api.id}"/>
        </#if>
        <div class="form-group">
            <label for="name" class="col-sm-3 control-label no-padding-right">名称<span class="red">*</span></label>
            <div class="col-xs-12 col-sm-5">
                <input type="text" name="name" value="${api.name!''}" class="width-100"/>
            </div>
        </div>
        <div class="form-group">
            <label for="url" class="col-sm-3 control-label no-padding-right">地址<span class="red">*</span></label>
            <div class="col-xs-12 col-sm-5">
                <input type="text" name="url" value="${api.url!''}" class="width-100"/>
            </div>
        </div>
        <div class="form-group">
            <label for="method" class="col-sm-3 control-label no-padding-right">方法<span class="red">*</span></label>
            <div class="col-xs-12 col-sm-5">
                <input type="text" name="method" value="${api.method!''}" class="width-100"/>
            </div>
        </div>
        <div class="form-group">
            <label for="errorName" class="col-sm-3 control-label no-padding-right">错误码字段名称<span class="red">*</span></label>
            <div class="col-xs-12 col-sm-5">
                <input type="text" name="errorName" value="${api.errorName!''}" class="width-100"/>
            </div>
        </div>
        <div class="form-group">
            <label for="errorMsgName" class="col-sm-3 control-label no-padding-right">错误码描述字段名称<span class="red">*</span></label>
            <div class="col-xs-12 col-sm-5">
                <input type="text" name="errorMsgName" value="${api.errorMsgName!''}" class="width-100"/>
            </div>
        </div>
        <div class="form-group">
            <label for="dataName" class="col-sm-3 control-label no-padding-right">数据名称<span class="red">*</span></label>
            <div class="col-xs-12 col-sm-5">
                <input type="text" name="dataName" value="${api.dataName!''}" class="width-100"/>
            </div>
        </div>
        <div class="form-group">
            <label for="dataDesc" class="col-sm-3 control-label no-padding-right">字段描述<span class="red">*</span></label>
            <div class="col-xs-12 col-sm-5">
                <input type="text" name="dataDesc" value="${api.dataDesc!''}" class="width-100"/>
            </div>
        </div>
        <div class="form-group">
            <label for="data" class="col-sm-3 control-label no-padding-right">字段<span class="red">*</span></label>
            <div class="col-xs-12 col-sm-5">
                <input type="text" name="data" value="${api.data!''}" class="width-100"/>
            </div>
        </div>
        <div class="form-group">
            <label for="description" class="col-sm-3 control-label no-padding-right">描述<span class="red">*</span></label>
            <div class="col-xs-12 col-sm-5">
                <input type="text" name="description" value="${api.description!''}" class="width-100"/>
            </div>
        </div>
        <div class="form-group">
            <label for="body" class="col-sm-3 control-label no-padding-right">内容<span class="red">*</span></label>
            <div class="col-xs-12 col-sm-5">
                <textarea name="body" rows="10" class="width-100">${api.body!''}</textarea>
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
<script src="${ctx}/static/app/js/api/form.js"></script>
</@override>

<@extends name="../layout.ftl"/>