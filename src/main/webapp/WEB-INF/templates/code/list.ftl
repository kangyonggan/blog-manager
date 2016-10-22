<#assign pageName="错误码管理"/>
<#assign name = RequestParameters.name!'' />

<@override name="buttons">
<a href="${ctx}/code/create" class="btn btn-pink btn-sm">添加</a>
</@override>

<@override name="content">

<div class="col-xs-12">
    <table class="table table-striped table-bordered table-hover">
        <thead>
        <tr>
            <th>ID</th>
            <th>Api Id</th>
            <th>Api错误码</th>
            <th>Api错误描述</th>
            <th>内部错误码</th>
            <th>内部错误描述</th>
            <th>是否删除</th>
            <th>创建时间</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
            <#if (page.list)?size gt 0>
                <#list page.list as errorCode>
                    <#include "error-code-tr.ftl"/>
                </#list>
            <#else>
            <tr>
                <td colspan="20">
                    <div class="empty">暂无查询记录</div>
                </td>
            </tr>
            </#if>
        </tbody>
    </table>
    <@c.pagination url="code"/>
</div>
</@override>

<@override name="script">
<script src="${ctx}/static/app/js/code/list.js"></script>
</@override>

<@extends name="../layout.ftl"/>