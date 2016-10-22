<tr>
    <td>${api.id}</td>
    <td>${api.name}</td>
    <td>${api.url}</td>
    <td>${api.method}</td>
    <td>${api.description!''}</td>
    <td>${(api.isDeleted==0)?string('未删除', '已删除')}</td>
    <td>${api.createdTime?datetime}</td>
    <td>
        <div class="btn-group">
            <a class="btn btn-xs btn-inverse" href="${ctx}/api/${api.id}/edit">编辑</a>
            <#if api.isDeleted==0>
                <a class="btn btn-xs btn-inverse" href="${ctx}/api/${api.id}/delete">删除</a>
            <#else>
                <a class="btn btn-xs btn-inverse" href="${ctx}/api/${api.id}/recover">恢复</a>
            </#if>
        </div>
    </td>
</tr>