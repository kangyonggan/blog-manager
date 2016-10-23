<tr>
    <td>${errorCode.id}</td>
    <td>${errorCode.apiCode}</td>
    <td>${errorCode.apiErrorCode}</td>
    <td>${errorCode.apiErrorDesc}</td>
    <td>${errorCode.errorCode}</td>
    <td>${errorCode.errorDesc!''}</td>
    <td>${(errorCode.isDeleted==0)?string('未删除', '已删除')}</td>
    <td>${errorCode.createdTime?datetime}</td>
    <td>
        <div class="btn-group">
            <a class="btn btn-xs btn-inverse" href="${ctx}/code/${errorCode.id}/edit">编辑</a>
            <#if errorCode.isDeleted==0>
                <a class="btn btn-xs btn-inverse" href="${ctx}/code/${errorCode.id}/delete">删除</a>
            <#else>
                <a class="btn btn-xs btn-inverse" href="${ctx}/code/${errorCode.id}/recover">恢复</a>
            </#if>
        </div>
    </td>
</tr>