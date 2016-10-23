<#assign pageName="指令管理"/>
<#assign apiCode = RequestParameters.apiCode!'' />

<@override name="content">
<div class="col-xs-12">
    <form class="form-inline" method="get" novalidate>
        <div class="form-group">
            <input type="text" class="form-control" name="apiCode" placeholder="api代码" value="${apiCode}"/>
        </div>

        <button class="btn btn-pink btn-sm">
            搜索
            <span class="ace-icon fa fa-search icon-on-right bigger-110"></span>
        </button>
    </form>
</div>

<div class="space-24"></div>

<div class="col-xs-12">
    <table class="table table-striped table-bordered table-hover">
        <thead>
        <tr>
            <th>ID</th>
            <th>api代码</th>
            <th>参数串</th>
            <th>指令状态</th>
            <th>响应结果</th>
            <th>是否删除</th>
            <th>创建时间</th>
        </tr>
        </thead>
        <tbody>
            <#if (page.list)?size gt 0>
                <#list page.list as command>
                    <#include "command-tr.ftl"/>
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
    <@c.pagination url="command" param="apiCode=${apiCode}"/>
</div>
</@override>

<@override name="script">
<script src="${ctx}/static/app/js/command/list.js"></script>
</@override>

<@extends name="../layout.ftl"/>