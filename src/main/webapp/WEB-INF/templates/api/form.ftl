<#assign action="${api.id???string('update','save')}"/>
<#assign pageName="${api.id???string('编辑Api','添加Api')}"/>

<@override name="content">
<div class="col-xs-12">
    <form method="post" class="form-horizontal" action="${ctx}/api/${action}">
        <#if api.id??>
            <input type="hidden" name="id" value="${api.id}"/>
        </#if>
        <div class="form-group">
            <label for="code" class="col-sm-3 control-label no-padding-right">代码<span class="red">*</span></label>
            <div class="col-xs-12 col-sm-5">
                <input type="text" name="code" value="${api.code!''}" class="width-100"/>
            </div>
        </div>
        <div class="form-group">
            <label for="name" class="col-sm-3 control-label no-padding-right">名称<span class="red">*</span></label>
            <div class="col-xs-12 col-sm-5">
                <input type="text" name="name" value="${api.name!''}" class="width-100"/>
            </div>
        </div>
        <div class="form-group">
            <label for="description" class="col-sm-3 control-label no-padding-right">描述<span class="red">*</span></label>
            <div class="col-xs-12 col-sm-5">
                <input type="text" name="description" value="${api.description!''}" class="width-100"/>
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